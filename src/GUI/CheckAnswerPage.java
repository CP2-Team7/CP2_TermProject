package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class CheckAnswerPage extends JFrame {

    private final int questionNumber = 10;
    private JPanel CheckAnswerPanel, buttonPanel;

    // dummy data
    List<String> question = new ArrayList<>(List.of("중국의 수도는?", "인도의 수도는?", "라오스의 수도는?", "이스라엘의 수도는?", "필리핀의 수도는?", "말레이시아의 수도는?", "요르단의 수도는?", "오스트리아의 수도는?", "러시아의 수도는?", "이탈리아의 수도는?"));
    List<String> userAnswer = new ArrayList<>(List.of("베이징", "뉴델리", "비엔티안", "예루살렘", "마닐라", "쿠알라룸푸트", "암만", "비엔나", "모스크바", "로마"));
    List<String> correctAnswer = new ArrayList<>(List.of("빅토리아", "베이징", "비엔티안", "예루살렘", "몰라", "쿠알라룸푸트", "암만", "몰라", "모스크바", "로마"));
    List<Integer> scoreList = new ArrayList<>(List.of(0, 0, 1, 1, 0, 1, 1, 0, 1, 1));

    public CheckAnswerPage() {
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("정답 확인");
        setLayout(new BorderLayout());

        CheckAnswerPanel = new CheckAnswerPanel();
        buttonPanel = new ButtonPanel();

        add(CheckAnswerPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
    class CheckAnswerPanel extends JPanel {
        private JLabel questionTitle, userAnswerTitle, correctAnswerTitle;
        private JLabel questionLabel, userAnswerLabel, correctAnswerLabel;

        public CheckAnswerPanel() {

            setLayout(new GridLayout(questionNumber+1, 3));

            questionTitle = new JLabel("문제");
            userAnswerTitle = new JLabel("나의 답");
            correctAnswerTitle = new JLabel("정답");

            add(questionTitle);
            add(userAnswerTitle);
            add(correctAnswerTitle);

            for(int i = 0; i < questionNumber; i++) {
                questionLabel = new JLabel(question.get(i));
                ;
                userAnswerLabel = new JLabel(userAnswer.get(i));
                correctAnswerLabel = new JLabel(correctAnswer.get(i));

                if (scoreList.get(i) == 0) {
                    questionLabel.setForeground(Color.red);
                    userAnswerLabel.setForeground(Color.red);
                    correctAnswerLabel.setForeground(Color.red);
                }
                add(questionLabel);
                add(userAnswerLabel);
                add(correctAnswerLabel);
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

            if(btnText.equals("뒤로 가기")) {
                // 뒤 페이지로 이동
                System.out.println("뒤로 가기");
            }else if(btnText.equals("처음 화면으로 가기")) {
                // 처음 페이지로 이동
                System.out.println("처음 화면으로 가기");
            }

        }

    }

    public static void main(String[] args) {
        new CheckAnswerPage();
    }
}
