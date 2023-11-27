package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import Class.*;

import static Class.QuestionName.CAPITAL;

public class Submit extends JFrame {
    JPanel mainPanel, questionPanel, bottomPanel;
    JTextField answer;
    JTextArea questionArea;
    ArrayList<Question> questionList;
    int currentQuestionIndex;
    ArrayList<String> userAnswers = new ArrayList<>();

    public Submit() {
        setTitle("QUIZZ ME!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);

        mainPanel = new JPanel(new BorderLayout());

        // mainPanel에 좌우 여백을 추가
        mainPanel.setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));

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
                    showNextQuestion();
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
                showNextQuestion();
            }
        });
        bottomPanel.add(nextButton);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);
        //dummy 데이터 설정
        setDummyData();

        currentQuestionIndex = 0;
        showNextQuestion();

        setVisible(true);
    }

    public void setDummyData() {
        QuestionName ca = CAPITAL;
        String[] dummyQ = {"인도네시아의 수도는?", "중국의 수도는?", "인도의 수도는?", "요르단의 수도는?", "말레이시아의 수도는?"
                , "필리핀의 수도는?", "이스라엘의 수도는?", "라오스의 수도는?", "러시아의 수도는?", "오스트리아의 수도는?"};
        String[] dummyA = {"자카르타", "베이징", "뉴델리", "암만", "쿠알라룸푸르", "마닐라", "예루살렘", "비엔티안", "모스크바", "비엔나"};
        questionList = new ArrayList<>();
        for(int i = 0; i < dummyQ.length; i++){
            String c = dummyQ[i];
            String a = dummyA[i];
            Question q = new Question(ca, c, a);
            questionList.add(q);
        }
    }
    public void showNextQuestion() {
        if (currentQuestionIndex < questionList.size()) {
            questionArea.setText(questionList.get(currentQuestionIndex).getContent());

            userAnswers.add(answer.getText());

            currentQuestionIndex++;

            answer.setText(""); // 이전 답 초기화
            answer.requestFocus(); // 텍스트 필드에 포커스
        } else {
            // 모든 문제를 풀었을 때
            answer.setText("");
            answer.setEnabled(false);

        }
    }


    public static void main(String[] args) {
        new Submit();
    }
}
