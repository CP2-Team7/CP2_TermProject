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

		JLabel logoLabel = new JLabel(ui.smallIconImg);
		logoLabel.setBounds(10, 30, 200, 100);
		add(logoLabel);

		JButton toRankingb = new JButton("랭킹 보러가기");
		JButton toMarkingb = new JButton("내 정답 보러가기");
		JButton toFirstb = new JButton("처음 화면으로 가기");

		resultl = new JLabel();
		
		resultl.setFont(ui.titleFont);
		toRankingb.setFont(ui.buttonFont);
		toMarkingb.setFont(ui.buttonFont);
		toFirstb.setFont(ui.buttonFont);
		resultl.setBounds(300, 300, 800, 60);
		toRankingb.setBounds(75, 500, 250, 60);
		toMarkingb.setBounds(450, 500, 250, 60);
		toFirstb.setBounds(825, 500, 250, 60);
		setBackground(ui.mainBlue);
		resultl.setForeground(Color.WHITE);
		toRankingb.setForeground(ui.mainBlue);
		toFirstb.setForeground(ui.mainBlue);
		toMarkingb.setForeground(ui.mainBlue);
		toRankingb.setBackground(ui.mainYellow);
		toFirstb.setBackground(ui.mainYellow);
		toMarkingb.setBackground(ui.mainYellow);
		
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
				ui.rankingPage.drawRaking(ui);
			}
		});//처음으로 버튼 액션리스너 등록(카드레이아웃 사용)

	}
	public void setGameResult(UI uui, String userName, String category, String score) {
		resultl.setText(userName+"님의 "+category+" 점수는 "+score+"점 입니다!");
		//랭킹 업데이트
		uui.gameServer.checkLeaderboard(uui);
	}
}
