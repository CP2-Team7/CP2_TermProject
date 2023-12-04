package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UI extends JFrame {
	private JPanel mainPanel, startPanel, categoryPanel, qPanel, endPanel, rankingPanel, markingPanel;
	private JTextField nametxt, qtxt, answertxt;
	private JButton capitalb, connectionb, fourletterb, nextb1, nextb2, nextb3, backb, toRankingb, toFirstb, toMarkingb;
	
	public UI() {
		setSize(1200,800);
		CardLayout card = new CardLayout(0,0);
		mainPanel = new JPanel(card);
		CardLayout cl = (CardLayout)mainPanel.getLayout();
		add(mainPanel);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 설정
		
		startPanel = new JPanel();
		nametxt = new JTextField(20);
		nextb1 = new JButton("다음");
		JLabel namel = new JLabel("이름을 입력해 주세요.");
		startPanel.setLayout(null);
		namel.setBounds(400, 200, 800, 100);
		namel.setFont(new Font("PLAIN",Font.BOLD,35));
		nextb1.setFont(new Font("PLAIN",Font.ITALIC,25));
		nametxt.setFont(new Font("PLAIN",Font.ITALIC,25));
		nametxt.setBounds(250, 300, 700, 100);
		nextb1.setBounds(450, 500, 300, 100);
		startPanel.add(namel);
		startPanel.add(nametxt);
		startPanel.add(nextb1);
		//add(startPanel);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		mainPanel.add(startPanel,"p1");//start패널 레이아웃
		nextb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(nametxt.getText());
				cl.next(mainPanel);
			}
		});//nextb1이벤트처리
		
		categoryPanel = new JPanel();
		capitalb = new JButton("수도 맞추기");
		connectionb = new JButton("이어말하기");
		fourletterb = new JButton("사자성어");
		nextb2 = new JButton("다음");
		JLabel selectcatl = new JLabel("< 게임 카테고리를 선택하세요 >");
		categoryPanel.setLayout(null);
		selectcatl.setFont(new Font("PLAIN",Font.BOLD,35));
		capitalb.setFont(new Font("PLAIN",Font.BOLD,25));
		connectionb.setFont(new Font("PLAIN",Font.BOLD,25));
		fourletterb.setFont(new Font("PLAIN",Font.BOLD,25));
		nextb2.setFont(new Font("PLAIN",Font.ITALIC,25));
		selectcatl.setBounds(300, 100, 600, 100);
		capitalb.setBounds(150, 300, 200, 200);
		connectionb.setBounds(500, 300, 200, 200);
		fourletterb.setBounds(850, 300, 200, 200);
		nextb2.setBounds(450, 600, 300, 100);
		categoryPanel.add(selectcatl);
		categoryPanel.add(capitalb);
		categoryPanel.add(connectionb);
		categoryPanel.add(fourletterb);
		categoryPanel.add(nextb2);
		mainPanel.add(categoryPanel,"p2");//카테고리 패널 레이아웃
		nextb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.next(mainPanel);
			}
		});//nextb2이벤트처리
		
		endPanel = new JPanel();
		toRankingb = new JButton("랭킹 보러가기");
		toMarkingb = new JButton("내 정답 보러가기");
		toFirstb = new JButton("처음 화면으로 가기");
		JLabel scorel = new JLabel("get username"+" 님의 "+"get category"+" 점수는 "+"get score"+"점 입니다!");
		scorel.setFont(new Font("PLAIN",Font.BOLD,35));
		toRankingb.setFont(new Font("PLAIN",Font.ITALIC,25));
		toMarkingb.setFont(new Font("PLAIN",Font.ITALIC,25));
		toFirstb.setFont(new Font("PLAIN",Font.ITALIC,25));
		toRankingb.setBounds(75, 500, 300, 100);
		toMarkingb.setBounds(450, 500, 300, 100);
		toFirstb.setBounds(825, 500, 300, 100);
		scorel.setBounds(100, 200, 1000, 200);
		endPanel.setLayout(null);
		endPanel.add(scorel);
		endPanel.add(toRankingb);
		endPanel.add(toMarkingb);
		endPanel.add(toFirstb);
		add(endPanel);
		mainPanel.add(endPanel,"p4");//endPanel 레이아웃
		toFirstb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.first(mainPanel);
			}
		});//처음화면으로 버튼 이벤트 처리
	}
	
	public static void main(String arg[]) {
		UI p = new UI();
	}
}