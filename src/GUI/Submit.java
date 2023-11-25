package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Submit extends JFrame {
    JPanel mainPanel, questionPanel, bottomPanel;
    JTextField answer;
    JTextArea questionArea;
    String questionContent;

    public Submit() {
        // 문제 아직 불러오지 않아 임의로 설정
        questionContent = "\n" + "일본의 수도는?";

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
        questionArea.append(questionContent);
        questionArea.setFont(new Font("", 0, 50));

        questionArea.setEditable(false);
        questionArea.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        answer = new JTextField(20);
        answer.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Enter 키를 누르면 다음 버튼 누른 것과 동일한 효과
                    System.out.println("입력 값: " + answer.getText());
                    answer.setText("");
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
                // 다음 버튼을 누를 때 answer의 값을 터미널에 출력
                System.out.println("입력한 값: " + answer.getText());
                answer.setText("");
            }
        });
        bottomPanel.add(nextButton);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Submit();
    }
}
