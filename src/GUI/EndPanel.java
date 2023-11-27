package GUI;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EndPanel extends JPanel {
	JPanel panel, mainPanel;

	public EndPanel(JPanel cl) {
		super();
		panel =  cl;
		JButton toRankingb = new JButton("랭킹 보러가기");
		JButton toMarkingb = new JButton("내 정답 보러가기");
		JButton toFirstb = new JButton("처음 화면으로 가기");
		JLabel scorel = new JLabel("get username"+" 님의 "+"get category"+" 점수는 "+"get score"+"점 입니다!");
		scorel.setFont(new Font("PLAIN",Font.BOLD,35));
		toRankingb.setFont(new Font("PLAIN",Font.ITALIC,25));
		toMarkingb.setFont(new Font("PLAIN",Font.ITALIC,25));
		toFirstb.setFont(new Font("PLAIN",Font.ITALIC,25));
		toRankingb.setBounds(75, 500, 300, 100);
		toMarkingb.setBounds(450, 500, 300, 100);
		toFirstb.setBounds(825, 500, 300, 100);
		scorel.setBounds(100, 200, 1000, 200);
		setLayout(null);
		add(scorel);
		add(toRankingb);
		add(toMarkingb);
		add(toFirstb);
		toMarkingb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				CardLayout card = new CardLayout(0,0);
//				mainPanel = new JPanel(card);
//				add(mainPanel);
//				mainPanel.add(new CheckAnswerPage(mainPanel));
			}
		});
	}
}
