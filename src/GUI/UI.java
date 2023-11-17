package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Class.QuestionName;
import Class.User;

import java.util.*;

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
		//add(startPanel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//add(startPanel,"p1");//start패널 레이아웃
		
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
		//add(categoryPanel,"p2");//카테고리 패널 레이아웃
		
		//랭킹
		rankingPanel = new JPanel();
		rankingPanel.setLayout(null);
		JTextArea rankings = new JTextArea(9, 20);
		rankings.setEditable(false);
		rankings.append("리더보드\n");
		//test
		java.util.List<User> testRanking = new ArrayList<User>();
		testRanking.add(new User("a"));
		testRanking.add(new User("b"));
		testRanking.add(new User("c"));
		testRanking.add(new User("d"));
		testRanking.add(new User("e"));
		testRanking.add(new User("f"));
		testRanking.add(new User("g"));
		testRanking.add(new User("h"));
		testRanking.add(new User("i"));
		testRanking.add(new User("j"));
		testRanking.add(new User("k"));
		QuestionName category = QuestionName.FOURLETTERS;
		//test
		int cat = 0;
		switch (category) {
			case CAPITAL:
				cat = 0;
				break;
			case CONNECTION:
				cat = 1;
				break;
			case FOURLETTERS:
				cat = 2;
				break;
			default:
				break;
		}
		for(int i = 0; i < testRanking.size(); i++) {
			User u = testRanking.get(i);
			rankings.append(i + "위\t" + u.name + "\t" + u.score[cat] + "\n");
		}

		JButton bBack = new JButton("뒤로가기");
		bBack.addActionListener(e->System.out.println("뒤로 감"));	//cardlayout 제대로 되면 바꾸기
		JButton bMain = new JButton("처음 화면으로 가기");
		bBack.addActionListener(e->System.out.println("처음 화면으로 감"));	//cardlayout 제대로 되면 바꾸기
		bBack.addActionListener(null);
		//위치는 나중에 조율
		rankingPanel.add(rankings);
		rankings.setBounds(500, 0, 200, 230);
		rankingPanel.add(bBack);
		bBack.setBounds(300, 400, 150, 30);
		rankingPanel.add(bMain);
		bMain.setBounds(750, 400, 150, 30);
		add(rankingPanel);

		//맨 마지막에 있어야만 패널이 제대로 업데이트됨
		setVisible(true);
	}
	
	public static void main(String arg[]) {
		UI p = new UI();
	}
}