package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UI extends JFrame {
	private JPanel startPanel, categoryPanel, qPanel, endPanel, rankingPanel, markingPanel;
	private JTextField nametxt, qtxt, answertxt;
	private JButton capitalb, connectionb, fourletterb, nextb1, nextb2, nextb3, backb, toRankingb, toFirstb, toMarkingb;
	
	public UI() {
		setSize(1200,800);
		CardLayout card = new CardLayout(0,0);
		setLayout(card);//프레임 설정
		
		startPanel = new JPanel();
		nametxt = new JTextField(10);
		nextb1 = new JButton("다음");
		JPanel s1 = new JPanel();
		JPanel s2 = new JPanel();
		s1.add(new JLabel("이름: "));
		s1.add(nametxt);
		s2.add(nextb1);
		startPanel.setLayout(new BorderLayout());
		startPanel.add(s1, BorderLayout.CENTER);
		startPanel.add(s2, BorderLayout.SOUTH);
		add(startPanel);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(startPanel,"p1");//start패널 레이아웃
		
		nextb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//card.show("p2");
			}
		});
		
		categoryPanel = new JPanel();
		JPanel c1 = new JPanel();
		JPanel c2 = new JPanel();
		JPanel c3 = new JPanel();
		capitalb = new JButton("수도 맞추기");
		connectionb = new JButton("이어말하기");
		fourletterb = new JButton("사자성어");
		nextb2 = new JButton("다음");
		categoryPanel.setLayout(new GridLayout(3,1));
		c1.add(new JLabel("< 게임 카테고리를 선택하세요 >"));
		c2.add(capitalb);
		c2.add(connectionb);
		c2.add(fourletterb);
		c3.add(nextb2);
		categoryPanel.add(c1);
		categoryPanel.add(c2);
		categoryPanel.add(c3);
		add(categoryPanel,"p2");//카테고리 패널 레이아웃
		
		
	}
	
	public static void main(String arg[]) {
		UI p = new UI();
	}
}