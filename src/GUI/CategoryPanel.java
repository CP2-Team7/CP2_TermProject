package GUI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Class.*;


public class CategoryPanel extends JPanel {

    JPanel panel;
    String setcategory="none";

    CategoryPanel(UI ui) {
        super();
        panel = ui.mainPanel;

        setBackground(ui.mainBlue);
        setLayout(null);

        JButton capitalb = new JButton("수도 맞추기");
        JButton connectionb = new JButton("이어말하기");
        JButton fourletterb = new JButton("사자성어");
        JButton nextb2 = new JButton("다음");
        JLabel selectcatl = new JLabel("< 게임 카테고리를 선택하세요 >");

        JLabel logoLabel = new JLabel(ui.smallIconImg);
        logoLabel.setBounds(10, 30, 200, 100);

        selectcatl.setFont(ui.titleFont);
        selectcatl.setForeground(Color.WHITE);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 100, 30));

        capitalb.setFont(ui.buttonFont);
        capitalb.setForeground(ui.mainBlue);
        capitalb.setBackground(Color.white);

        connectionb.setFont(ui.buttonFont);
        connectionb.setForeground(ui.mainBlue);
        connectionb.setBackground(Color.white);

        fourletterb.setFont(ui.buttonFont);
        fourletterb.setForeground(ui.mainBlue);
        fourletterb.setBackground(Color.white);


        buttonPanel.setBackground(ui.mainBlue);
        buttonPanel.add(capitalb);
        buttonPanel.add(connectionb);
        buttonPanel.add(fourletterb);

        nextb2.setFont(ui.buttonFont);
        nextb2.setBackground(ui.mainYellow);
        nextb2.setForeground(ui.mainBlue);
        
        selectcatl.setBounds(400, 100, 600, 100);
        buttonPanel.setBounds(200, 250, 800, 200);
        nextb2.setBounds(420, 550, 350, 60);

        add(logoLabel);
        add(selectcatl);
        add(buttonPanel);
        add(nextb2);
        
        nextb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout card = (CardLayout)panel.getLayout();

                if(setcategory.equals("none")) {
                	selectcatl.setForeground(Color.RED);
                }
                else {
                	selectcatl.setForeground(Color.WHITE);
                	fourletterb.setBackground(Color.WHITE);
        			connectionb.setBackground(Color.WHITE);
        			capitalb.setBackground(Color.WHITE);
                	QuestionName qn = QuestionName.valueOf(setcategory);
                    ui.gameRound.initGameRound(qn,ui.user);
                    System.out.println(setcategory); //디버깅
                    ui.gameRound.printAllItem(); // 디버깅

                    // Submit 클래스의 questionList 초기화
                    ui.submit.questionList = ui.gameRound.questionList;
                    ui.submit.showNextQuestion();

                    card.show(panel, "p3");
                    setcategory="none";
                }
            }
        });
        
        class CategoryListener implements ActionListener {
        	public void actionPerformed(ActionEvent e) {
        		if(e.getSource().equals(fourletterb)) {
        			setcategory = "FOURLETTERS";
        			fourletterb.setBackground(ui.mainYellow);
        			connectionb.setBackground(Color.WHITE);
        			capitalb.setBackground(Color.WHITE);
        		}
        		else if(e.getSource().equals(connectionb)) {
        			setcategory = "CONNECTION";
        			fourletterb.setBackground(Color.WHITE);
        			connectionb.setBackground(ui.mainYellow);
        			capitalb.setBackground(Color.WHITE);
        		}
        		else if(e.getSource().equals(capitalb)) {
        			setcategory = "CAPITAL";
        			fourletterb.setBackground(Color.WHITE);
        			connectionb.setBackground(Color.WHITE);
        			capitalb.setBackground(ui.mainYellow);
        		}
        	}
        }

        fourletterb.addActionListener(new CategoryListener());
        capitalb.addActionListener(new CategoryListener());
        connectionb.addActionListener(new CategoryListener());
    }
}
