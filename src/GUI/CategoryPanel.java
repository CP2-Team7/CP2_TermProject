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
        JButton capitalb = new JButton("수도 맞추기");
        JButton connectionb = new JButton("이어말하기");
        JButton fourletterb = new JButton("사자성어");
        JButton nextb2 = new JButton("다음");
        JLabel selectcatl = new JLabel("< 게임 카테고리를 선택하세요 >");
        
        Color blue = new Color(0x393E64);
        Color yellow = new Color(0xF1C832);
        
        selectcatl.setFont(new Font("PLAIN",Font.BOLD,35));
        capitalb.setFont(new Font("PLAIN",Font.BOLD,25));
        connectionb.setFont(new Font("PLAIN",Font.BOLD,25));
        fourletterb.setFont(new Font("PLAIN",Font.BOLD,25));
        nextb2.setFont(new Font("PLAIN",Font.ITALIC,25));
        
        setBackground(blue);
        capitalb.setBackground(yellow);
        capitalb.setForeground(blue);
        connectionb.setBackground(yellow);
        connectionb.setForeground(blue);
        fourletterb.setBackground(yellow);
        fourletterb.setForeground(blue);
        selectcatl.setForeground(Color.WHITE);
        
        selectcatl.setBounds(330, 100, 600, 100);
        capitalb.setBounds(150, 300, 200, 200);
        connectionb.setBounds(500, 300, 200, 200);
        fourletterb.setBounds(850, 300, 200, 200);
        nextb2.setBounds(450, 600, 300, 100);
        setLayout(null);
        add(selectcatl);
        add(capitalb);
        add(connectionb);
        add(fourletterb);
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
                	fourletterb.setBackground(yellow);
        			connectionb.setBackground(yellow);
        			capitalb.setBackground(yellow);
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
        			fourletterb.setBackground(Color.WHITE);
        			connectionb.setBackground(yellow);
        			capitalb.setBackground(yellow);
        		}
        		else if(e.getSource().equals(connectionb)) {
        			setcategory = "CONNECTION";
        			fourletterb.setBackground(yellow);
        			connectionb.setBackground(Color.WHITE);
        			capitalb.setBackground(yellow);
        		}
        		else if(e.getSource().equals(capitalb)) {
        			setcategory = "CAPITAL";
        			fourletterb.setBackground(yellow);
        			connectionb.setBackground(yellow);
        			capitalb.setBackground(Color.WHITE);
        		}
        	}
        }
        
        fourletterb.addActionListener(new CategoryListener());
        capitalb.addActionListener(new CategoryListener());
        connectionb.addActionListener(new CategoryListener());
        
    }

}
