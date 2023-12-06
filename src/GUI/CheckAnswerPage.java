package GUI;

import Class.*;
import GUI.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class CheckAnswerPage extends JPanel {

    private final int questionNumber = 10;
    private JPanel CheckAnswerPanel, buttonPanel, panel;
    public JLabel label;
    Font font;
    

    List<Question> question;
    List<String> userAnswer;
    List<String> correctAnswer;
    List<Integer> scoreList;
    List<JLabel> questionLabelList, userAnswerLabelList, correctAnswerLabelList;
    UI ui;
    Color blue;
    Color yellow;

    public CheckAnswerPage(UI ui) {
        panel = ui.mainPanel;
        this.ui = ui;
        questionLabelList= new ArrayList<>();
        userAnswerLabelList= new ArrayList<>();
        correctAnswerLabelList= new ArrayList<>();

        setLayout(null);
        font = new Font("PLAIN", Font.PLAIN, 20);

        CheckAnswerPanel = new CheckAnswerPanel();
        buttonPanel = new ButtonPanel();

        add(CheckAnswerPanel);
        CheckAnswerPanel.setBounds(100, 30, 1000, 600);
        add(buttonPanel);
        buttonPanel.setBounds(100, 640, 1000, 150);

        blue = new Color(0x393E64);
        yellow = new Color(0xF1C832);
        setBackground(blue);

        setVisible(true);
    }

    class CheckAnswerPanel extends JPanel {
        private JLabel questionTitle, userAnswerTitle, correctAnswerTitle;

        public CheckAnswerPanel() {

            setLayout(null);
            setBackground(Color.WHITE);

            questionTitle = new JLabel("문제", SwingConstants.CENTER);
            userAnswerTitle = new JLabel("나의 답", SwingConstants.CENTER);
            correctAnswerTitle = new JLabel("정답", SwingConstants.CENTER);

            add(questionTitle);
            questionTitle.setBounds(0, 10, 600, 20);
            questionTitle.setFont(font);
            add(userAnswerTitle);
            userAnswerTitle.setBounds(650, 10, 175, 20);
            userAnswerTitle.setFont(font);
            add(correctAnswerTitle);
            correctAnswerTitle.setBounds(825, 10, 175, 20);
            correctAnswerTitle.setFont(font);

            // 초기화 세팅
            for(int i = 0; i < questionNumber; i++) {
                label = new JLabel("default", SwingConstants.CENTER);
                label.setFont(font);
                add(label);
                label.setBounds(0, 65 + (50 * i), 600, 20);
                questionLabelList.add(label);

                label = new JLabel("default", SwingConstants.CENTER);
                label.setFont(font);
                add(label);
                label.setBounds(650, 65 + (50 * i), 175, 20);
                userAnswerLabelList.add(label);

                label = new JLabel("default", SwingConstants.CENTER);
                label.setFont(font);
                add(label);
                label.setBounds(825, 65 + (50 * i), 175, 20);
                correctAnswerLabelList.add(label);
            }
        }
    }

    class ButtonPanel extends JPanel implements ActionListener {
        private JButton backButton, goToFirstButton;

        public ButtonPanel() {
            setLayout(null);
            backButton = new JButton("뒤로 가기");
            goToFirstButton = new JButton("처음 화면으로 가기");
            Color yellow = new Color(0xF1C832);
            setBackground(blue);

            backButton.addActionListener(this);
            backButton.setFont(font);
            backButton.setBackground(yellow);
            goToFirstButton.addActionListener(this);
            goToFirstButton.setFont(font);
            goToFirstButton.setBackground(yellow);

            add(backButton);
            backButton.setBounds(100, 20, 300, 80);
            add(goToFirstButton);
            goToFirstButton.setBounds(600, 20, 300, 80);
        }
        public void actionPerformed(ActionEvent e) {
            JButton srcButton = (JButton) e.getSource();
            String btnText = srcButton.getText();
            CardLayout card = (CardLayout)panel.getLayout();
            if(btnText.equals("뒤로 가기")) {
                // 뒤 페이지로 이동
                card.show(panel, "p4");

            }else if(btnText.equals("처음 화면으로 가기")) {
                // 처음 페이지로 이동
                card.first(panel);
            }

        }

    }
    public void setList() {
        question = ui.gameRound.getQuestionList();
        correctAnswer = ui.gameRound.getAnswerList();
        scoreList = ui.gameRound.getScoreList();
        userAnswer = ui.submit.userAnswers;

        for(int i = 0; i < questionNumber; i++) {
            questionLabelList.get(i).setText(question.get(i).content);
            userAnswerLabelList.get(i).setText(userAnswer.get(i));
            correctAnswerLabelList.get(i).setText(correctAnswer.get(i));

            if(scoreList.get(i) == 0) {
                questionLabelList.get(i).setForeground(Color.red);
                userAnswerLabelList.get(i).setForeground(Color.red);
                correctAnswerLabelList.get(i).setForeground(Color.red);
            }

        }
    }
}
