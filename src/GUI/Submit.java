package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
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

        // mainPanel에 좌우 여백을 추가
        setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));

        // 중앙 부분 (문제를 표시할 패널)
        questionPanel = new JPanel(new BorderLayout());
        questionArea = new JTextArea("Question", 30, 100);
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
                }
            }
        });

        questionPanel.add(questionArea, BorderLayout.CENTER);
        questionPanel.add(answer, BorderLayout.SOUTH);

        add(questionPanel, BorderLayout.CENTER);

        bottomPanel = new JPanel();
        JButton nextButton = new JButton("다음");
        nextButton.setPreferredSize(new Dimension(200, 30));
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("입력 값:" + answer.getText());
                userAnswers.add(answer.getText());
                showNextQuestion();
            }
        });
        bottomPanel.add(nextButton);
        add(bottomPanel, BorderLayout.SOUTH);

        currentQuestionIndex = 0;
    }

    public void showNextQuestion() {
        if (currentQuestionIndex < questionList.size()) {
            questionArea.setText(questionList.get(currentQuestionIndex).getContent());

            currentQuestionIndex++;

            answer.setText(""); // 이전 답 초기화
            answer.requestFocus(); // 텍스트 필드에 포커스

        } else {
            // 모든 문제를 풀었을 때
            answer.setText("");
            answer.setEnabled(false);
            System.out.println("문제 풀이 완료"); // 디버깅
            System.out.println(userAnswers.toString()); // 디버깅
            CardLayout card = (CardLayout)panel.getLayout();
            int score = ui.gameRound.checkAnswer(userAnswers);
            ui.endPanel.setGameResult(ui.gameRound.currentUser.name, ui.gameRound.currentCategory.getName(), String.valueOf(score));
            ui.user.setScore(ui.gameRound.currentCategory, score);
            card.show(panel, "p4");

        }
    }
}