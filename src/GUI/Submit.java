package GUI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import Class.*;

public class Submit extends JPanel {
    JPanel questionPanel, bottomPanel, panel;
    JTextField answer;
    JTextArea questionArea;
    List<Question> questionList;
    int currentQuestionIndex;
    ArrayList<String> userAnswers = new ArrayList<>();
    UI ui;

    public Submit(UI ui) {
        panel = ui.mainPanel;
        this.ui = ui;
        setLayout(new BorderLayout());

        Color blue = new Color(0x393E64);
        Color yellow = new Color(0xF1C832);

        setBackground(blue);

        // mainPanel에 좌우 여백을 추가
        setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));

        // 중앙 부분 (문제를 표시할 패널)
        questionPanel = new JPanel(new BorderLayout());
        questionArea = new JTextArea(30, 100);
        questionArea.setEnabled(false);
        questionArea.setFont(new Font("", 0, 50));

        questionArea.setEditable(false);
        questionArea.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        answer = new JTextField(20);
        answer.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    System.out.println("입력 값:" + answer.getText());
                    userAnswers.add(answer.getText());
                    showNextQuestion();
                    if (currentQuestionIndex == questionList.size() + 1) {
                        CardLayout card = (CardLayout)panel.getLayout();
                        card.show(panel, "p4");
                        currentQuestionIndex = 0;
                    }
                }
            }
        });

        questionPanel.add(questionArea, BorderLayout.CENTER);
        questionPanel.add(answer, BorderLayout.SOUTH);

        add(questionPanel, BorderLayout.CENTER);

        bottomPanel = new JPanel();
        bottomPanel.setBackground(blue);
        JButton nextButton = new JButton("다음");
        nextButton.setBackground(yellow);
        nextButton.setPreferredSize(new Dimension(200, 30));

        // 다음 버튼의 ActionListener를 람다식으로 변경
        nextButton.addActionListener(e -> {
            System.out.println("입력 값:" + answer.getText());
            if (currentQuestionIndex == questionList.size() + 1) {
                CardLayout card = (CardLayout)panel.getLayout();
                card.show(panel, "p4");
                currentQuestionIndex = 0;
            }
        });

        bottomPanel.add(nextButton);
        add(bottomPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    // showNextQuestion 메서드를 스트림과 람다식을 사용하여 변경
    public void showNextQuestion() {
        currentQuestionIndex = Math.min(currentQuestionIndex + 1, questionList.size() + 1);

        questionList.stream()
                .limit(currentQuestionIndex)
                .forEach(question -> {
                    questionArea.setText(question.getContent());
                    answer.setText(""); // 이전 답 초기화
                    answer.requestFocus(); // 텍스트 필드에 포커스
                });

        // 모든 문제를 풀었을 때
        if (currentQuestionIndex == questionList.size() + 1) {
            answer.setText("");
            ui.gameRound.checkAnswer(userAnswers);
        }
    }

    public static void main(String[] args) {
        new Submit(new UI());
    }
}
