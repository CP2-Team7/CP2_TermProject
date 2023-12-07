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

    List<Question> question;
    List<String> userAnswer, correctAnswer;
    List<Integer> scoreList;
    List<JLabel> questionLabelList, userAnswerLabelList, correctAnswerLabelList;
    UI ui;

    public CheckAnswerPage(UI ui) {
        panel = ui.mainPanel;
        this.ui = ui;

        setLayout(null);

        questionLabelList= new ArrayList<>();
        userAnswerLabelList= new ArrayList<>();
        correctAnswerLabelList= new ArrayList<>();

        // logo 설정
        JLabel logoLabel = new JLabel(ui.smallIconImg);
        logoLabel.setBounds(10, 30, 200, 100);
        add(logoLabel);

        JPanel titlePanel = new JPanel();

        JLabel questionTitle = new JLabel(" ".repeat(30)+"문제");
        JLabel userAnswerTitle = new JLabel(" ".repeat(30)+"나의 답");
        JLabel correctAnswerTitle = new JLabel(" ".repeat(20)+"정답");

        questionTitle.setFont(ui.titleFont);
        userAnswerTitle.setFont(ui.titleFont);
        correctAnswerTitle.setFont(ui.titleFont);

        titlePanel.add(questionTitle);
        titlePanel.add(userAnswerTitle);
        titlePanel.add(correctAnswerTitle);

        add(titlePanel);
        titlePanel.setBounds(100, 150, 1000, 50);

        CheckAnswerPanel = new CheckAnswerPanel(ui);
        CheckAnswerPanel.setPreferredSize(new Dimension(900, 550));

        buttonPanel = new ButtonPanel(ui);
        JScrollPane scrollPane = new JScrollPane(CheckAnswerPanel);

        add(scrollPane);
        scrollPane.setBounds(100, 200, 1000, 400);
        add(buttonPanel);
        buttonPanel.setBounds(100, 640, 1000, 150);

        setBackground(ui.mainBlue);

        setVisible(true);
    }

    class CheckAnswerPanel extends JPanel {

        public CheckAnswerPanel(UI ui) {

            setLayout(null);
            setBackground(Color.WHITE);

            // 초기화 세팅
            for(int i = 0; i < questionNumber; i++) {
                label = new JLabel("default", SwingConstants.CENTER);
                label.setFont(ui.buttonFont);
                add(label);

                label.setBounds(0, 30 + (50 * i), 600, 20);

                questionLabelList.add(label);

                label = new JLabel("default", SwingConstants.CENTER);
                label.setFont(ui.buttonFont);
                add(label);

                label.setBounds(650, 30 + (50 * i), 175, 20);
                userAnswerLabelList.add(label);

                label = new JLabel("default", SwingConstants.CENTER);
                label.setFont(ui.buttonFont);
                add(label);

                label.setBounds(825, 30 + (50 * i), 175, 20);
                correctAnswerLabelList.add(label);
            }
        }
    }

    class ButtonPanel extends JPanel implements ActionListener {
        private JButton backButton, goToFirstButton;

        public ButtonPanel(UI ui) {
            setLayout(null);

            backButton = new JButton("뒤로 가기");
            goToFirstButton = new JButton("처음 화면으로 가기");
            setBackground(ui.mainBlue);

            backButton.addActionListener(this);
            backButton.setFont(ui.buttonFont);
            backButton.setBackground(ui.mainYellow);
            goToFirstButton.addActionListener(this);
            goToFirstButton.setFont(ui.buttonFont);
            goToFirstButton.setBackground(ui.mainYellow);

            add(backButton);
            backButton.setBounds(100, 20, 250, 60);
            add(goToFirstButton);
            goToFirstButton.setBounds(600, 20, 250, 60);
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
