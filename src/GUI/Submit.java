package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import Class.*;

public class Submit extends JFrame {
    JPanel mainPanel, questionPanel, bottomPanel;
    JTextField answer;
    JTextArea questionArea;
    List<Question> questionL;
    int currentQuestionIndex = 0;
    List<String> userAnswers;

    public Submit(UI ui) {
        //GameRound 불러오기
        questionL = ui.gameRound.getQuestionList();
        userAnswers = new ArrayList<>();

        setTitle("QUIZZ ME!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);

        mainPanel = new JPanel(new BorderLayout());

        // mainPanel에 좌우 여백을 추가
        mainPanel.setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));

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
                    showNextQuestion(questionL, userAnswers, ui);
                }
            }
        });

        questionPanel.add(questionArea, BorderLayout.CENTER);
        questionPanel.add(answer, BorderLayout.SOUTH);

        mainPanel.add(questionPanel, BorderLayout.CENTER);

        bottomPanel = new JPanel();
        JButton nextButton = new JButton("다음");
        nextButton.setPreferredSize(new Dimension(200, 30));
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("입력 값:" + answer.getText());
                showNextQuestion(questionL, userAnswers, ui);
            }
        });
        bottomPanel.add(nextButton);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);
        showNextQuestion(questionL, userAnswers, ui);
        setVisible(true);
    }
    public void showNextQuestion(List<Question> q, List<String> a, UI ui) {
        if (currentQuestionIndex < q.size()) {
            questionArea.setText(q.get(currentQuestionIndex).getContent());

            userAnswers.add(answer.getText());

            currentQuestionIndex++;

            answer.setText(""); // 이전 답 초기화
            answer.requestFocus(); // 텍스트 필드에 포커스
        } else {
            // 모든 문제를 풀었을 때
            answer.setText("");
            answer.setEnabled(false);
            ui.gameRound.checkAnswer(a);
        }
    }


    public static void main(String[] args) {
        new Submit(new UI());
    }
}
