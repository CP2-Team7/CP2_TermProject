package GUI;

import java.awt.*;
import javax.swing.*;


public class UI extends JFrame {
	private JPanel mainPanel;

	public UI() {
		setSize(1200,800);
		CardLayout card = new CardLayout(0,0);
		mainPanel = new JPanel(card);
		add(mainPanel);
		setResizable(false);
<<<<<<< HEAD
		
=======

>>>>>>> 47197b1d06957eada96f1fbd05514cf1b79969fe
		mainPanel.add(new StartPanel(mainPanel),"p1");//start패널 레이아웃
		mainPanel.add(new CategoryPanel(mainPanel),"p2");//카테고리 패널 레이아웃
		mainPanel.add(new EndPanel(mainPanel), "p3");
		mainPanel.add(new RankingPanel(mainPanel),"p4");//endPanel 레이아웃


		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 설정
	}
}