package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class EndPanel extends JPanel {
	JPanel panel;

	EndPanel(JPanel cl) {
		super();
		panel =  cl;
		
		Color blue = new Color(0x393E64);
        Color yellow = new Color(0xF1C832);
        
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
		setBackground(blue);
		scorel.setForeground(Color.WHITE);
		toRankingb.setForeground(blue);
		toFirstb.setForeground(blue);
		toMarkingb.setForeground(blue);
		toRankingb.setBackground(yellow);
		toFirstb.setBackground(yellow);
		toMarkingb.setBackground(yellow);
		
		setLayout(null);
		add(scorel);
		add(toRankingb);
		add(toMarkingb);
		add(toFirstb);
		toFirstb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout)panel.getLayout();
				card.first(panel);
			}
		});//처음으로 버튼 액션리스너 등록(카드레이아웃 사용)
	}
}
