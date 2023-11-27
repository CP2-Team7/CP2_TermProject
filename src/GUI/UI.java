package GUI;

import java.awt.*;
import javax.swing.*;

import Class.*;
import GUI.*;


public class UI extends JFrame {
	public JPanel mainPanel;
	public GameServer gameServer; // Server
	public GameRound gameRound; // Controller
	public User user;

	public UI() {
		gameServer = new GameServer(); // Server
		gameRound = new GameRound(); // Controller
		user = new User();

		setSize(1200,800);
		CardLayout card = new CardLayout(0,0);
		mainPanel = new JPanel(card);
		add(mainPanel);
		setResizable(false);

		mainPanel.add(new StartPanel(this),"p1");//start패널 레이아웃
		mainPanel.add(new CategoryPanel(this),"p2");//카테고리 패널 레이아웃
		mainPanel.add(new Submit(this), "p3");
		mainPanel.add(new EndPanel(this), "p4");//endPanel 레이아웃
		mainPanel.add(new RankingPanel(this),"p5");
		mainPanel.add(new CheckAnswerPage(this), "p6");

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 설정
	}
}