package GUI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import Class.*;

public class Submit extends JPanel {
    JPanel questionPanel, answerPanel, bottomPanel, panel;
    JTextField answer;
    JTextArea questionArea;
    List<Question> questionList;
    int currentQuestionIndex;
    ArrayList<String> userAnswers = new ArrayList<>();
    UI ui;
    public int score = 0;

    public Submit(UI ui) {
        panel = ui.mainPanel;
        this.ui = ui;
        setLayout(new BorderLayout());

        setBackground(ui.mainBlue);

        JLabel logoLabel = new JLabel(ui.smallIconImg);
        logoLabel.setBounds(10, 30, 200, 100);
        add(logoLabel);

        // mainPanel에 좌우 여백을 추가
        setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));

        // 중앙 부분 (문제를 표시할 패널)
        questionPanel = new JPanel(new BorderLayout());
        questionArea = new JTextArea(30, 100);
        questionArea.setEnabled(false);
        questionArea.setFont(ui.titleFont);
        questionArea.setForeground(ui.mainBlue);
        questionArea.setLineWrap(true);
        questionArea.setBorder(BorderFactory.createEmptyBorder(80, 40, 20, 0));

        answerPanel = new JPanel();

        answer = new JTextField(20);
        answer.setPreferredSize(new Dimension(350, 50));
        answer.setFont(ui.inputFont);
        answer.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
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
        questionPanel.add(answerPanel, BorderLayout.SOUTH);
        answerPanel.add(answer);

        add(questionPanel, BorderLayout.CENTER);

        bottomPanel = new JPanel();
        bottomPanel.setBackground(ui.mainBlue);

        JButton nextButton = new JButton("다음");
        nextButton.setPreferredSize(new Dimension(350, 60));
        nextButton.setBackground(ui.mainYellow);
        nextButton.setFont(ui.buttonFont);
        nextButton.setForeground(ui.mainBlue);

        bottomPanel.add(nextButton);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(60 , 0 , 0 , 0));
        add(bottomPanel, BorderLayout.SOUTH);

        // 다음 버튼의 ActionListener를 람다식으로 변경
        nextButton.addActionListener(e -> {
            System.out.println("입력 값:" + answer.getText());
            userAnswers.add(answer.getText());
            showNextQuestion();
            if (currentQuestionIndex == questionList.size() + 1) {
                CardLayout card = (CardLayout)panel.getLayout();
                card.show(panel, "p4");
                currentQuestionIndex = 0;
            }
        });
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
            score = ui.gameRound.checkAnswer(userAnswers);
            ui.endPanel.setGameResult(ui, ui.gameRound.currentUser.name, ui.gameRound.currentCategory.getName(), String.valueOf(score));
            ui.user.setScore(ui.gameRound.currentCategory, score);
        }
    }
}