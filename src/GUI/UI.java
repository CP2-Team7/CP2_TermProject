package GUI;

import java.awt.*;
import javax.swing.*;

import Class.GameRound;
import Class.GameServer;


public class UI extends JFrame {
	public JPanel mainPanel;
	public GameServer gameServer; // Server
	public GameRound gameRound; // Controller

	public UI() {
		gameServer = new GameServer(); // Server
		gameRound = new GameRound(); // Controller

		setSize(1200,800);
		CardLayout card = new CardLayout(0,0);
		mainPanel = new JPanel(card);
		add(mainPanel);
		setResizable(false);

		mainPanel.add(new StartPanel(mainPanel),"p1");//start패널 레이아웃
		mainPanel.add(new CategoryPanel(mainPanel),"p2");//카테고리 패널 레이아웃
		mainPanel.add(new Submit(), "p3");
		mainPanel.add(new EndPanel(mainPanel), "p4");//endPanel 레이아웃
		mainPanel.add(new RankingPanel(mainPanel),"p5");
		mainPanel.add(new CheckAnswerPage(), "p6");

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 설정
	}
}