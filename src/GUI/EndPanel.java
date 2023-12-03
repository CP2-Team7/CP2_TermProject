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
	JLabel resultl;

	public EndPanel(UI ui) {
		super();
		panel =  ui.mainPanel;
		
		Color blue = new Color(0x393E64);
        Color yellow = new Color(0xF1C832);
        
		JButton toRankingb = new JButton("랭킹 보러가기");
		JButton toMarkingb = new JButton("내 정답 보러가기");
		JButton toFirstb = new JButton("처음 화면으로 가기");

		resultl = new JLabel();
		
		resultl.setFont(new Font("PLAIN",Font.BOLD,35));
		toRankingb.setFont(new Font("PLAIN",Font.ITALIC,25));
		toMarkingb.setFont(new Font("PLAIN",Font.ITALIC,25));
		toFirstb.setFont(new Font("PLAIN",Font.ITALIC,25));
		resultl.setBounds(200, 300, 800, 100);
		toRankingb.setBounds(75, 500, 300, 100);
		toMarkingb.setBounds(450, 500, 300, 100);
		toFirstb.setBounds(825, 500, 300, 100);
		setBackground(blue);
		resultl.setForeground(Color.WHITE);
		toRankingb.setForeground(blue);
		toFirstb.setForeground(blue);
		toMarkingb.setForeground(blue);
		toRankingb.setBackground(yellow);
		toFirstb.setBackground(yellow);
		toMarkingb.setBackground(yellow);
		
		setLayout(null);
		add(resultl);
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
		toMarkingb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout)panel.getLayout();
				card.show(panel, "p6"); // 정답 확인 페이지로 이동
				ui.checkAnswerPage.setList();
			}
		});
		toRankingb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout)panel.getLayout();
				card.show(panel, "p5");
			}
		});//처음으로 버튼 액션리스너 등록(카드레이아웃 사용)

	}
	public void setGameResult(String userName, String category, String score) {
		resultl.setText(userName+"님의 "+category+" 점수는 "+score+"점 입니다!");
	}
}
