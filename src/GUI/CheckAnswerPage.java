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
    List<String> userAnswer;
    List<String> correctAnswer;
    List<Integer> scoreList;
    List<JLabel> questionLabelList, userAnswerLabelList, correctAnswerLabelList;
    UI ui;

    public CheckAnswerPage(UI ui) {
        panel = ui.mainPanel;
        this.ui = ui;
        questionLabelList= new ArrayList<>();
        userAnswerLabelList= new ArrayList<>();
        correctAnswerLabelList= new ArrayList<>();

        setLayout(new BorderLayout());

        CheckAnswerPanel = new CheckAnswerPanel();
        buttonPanel = new ButtonPanel();

        add(CheckAnswerPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    class CheckAnswerPanel extends JPanel {
        private JLabel questionTitle, userAnswerTitle, correctAnswerTitle;

        public CheckAnswerPanel() {

            setLayout(new GridLayout(questionNumber+1, 3));

            questionTitle = new JLabel("문제");
            userAnswerTitle = new JLabel("나의 답");
            correctAnswerTitle = new JLabel("정답");

            add(questionTitle);
            add(userAnswerTitle);
            add(correctAnswerTitle);

            // 초기화 세팅
            for(int i = 0; i < questionNumber; i++) {
                label = new JLabel("default");
                add(label);
                questionLabelList.add(label);
                label = new JLabel("default");
                add(label);
                userAnswerLabelList.add(label);
                label = new JLabel("default");
                add(label);
                correctAnswerLabelList.add(label);
            }
        }
    }

    class ButtonPanel extends JPanel implements ActionListener {
        private JButton backButton, goToFirstButton;

        public ButtonPanel() {
            setLayout(new GridLayout(1, 2));
            backButton = new JButton("뒤로 가기");
            goToFirstButton = new JButton("처음 화면으로 가기");

            backButton.addActionListener(this);
            goToFirstButton.addActionListener(this);
            add(backButton);
            add(goToFirstButton);
        }
        public void actionPerformed(ActionEvent e) {
            JButton srcButton = (JButton) e.getSource();
            String btnText = srcButton.getText();
            CardLayout card = (CardLayout)panel.getLayout();
            if(btnText.equals("뒤로 가기")) {
                // 뒤 페이지로 이동
                card.previous(panel);

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
