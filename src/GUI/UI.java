ackage GUI;

import java.awt.*;
import javax.swing.*;

import Class.*;

public class UI extends JFrame {
	public JPanel mainPanel;
	public GameServer gameServer; // Server
	public GameRound gameRound; // Controller
	public User user;
	// page
	public Submit submit;
	public EndPanel endPanel;
	public CheckAnswerPage checkAnswerPage;
	public RankingPanel rankingPage;
	ImageIcon resizedIcon, smallIconImg;
	Font titleFont, inputFont, buttonFont;
	Color mainBlue, mainYellow;

	public UI() {
		gameServer = new GameServer();
		gameRound = new GameRound();
		user = new User();

		ImageIcon imageIcon = new ImageIcon(System.getProperty("user.dir")+"/asset/logo.png");
		Image resizedImage = imageIcon.getImage().getScaledInstance(300, 180, Image.SCALE_SMOOTH);
		resizedIcon = new ImageIcon(resizedImage);

		Image smallIconImage = imageIcon.getImage().getScaledInstance(150, 80, Image.SCALE_SMOOTH);
		smallIconImg = new ImageIcon(smallIconImage);

		String fontPath = System.getProperty("user.dir")+"/asset/Giants-Regular.ttf";
		titleFont = loadFont(fontPath, Font.PLAIN, 30);
		inputFont = loadFont(fontPath, Font.ITALIC, 20);
		buttonFont = loadFont(fontPath, Font.PLAIN, 20);

		mainBlue = new Color(0x393E64);
		mainYellow = new Color(0xF1C832);

		setSize(1200,800);
		CardLayout card = new CardLayout(0,0);
		mainPanel = new JPanel(card);
		add(mainPanel);
		setResizable(false);

		submit = new Submit(this);
		endPanel = new EndPanel(this);
		checkAnswerPage = new CheckAnswerPage(this);
		rankingPage = new RankingPanel(this);

		mainPanel.add(new StartPanel(this),"p1");//start패널 레이아웃
		mainPanel.add(new CategoryPanel(this),"p2");//카테고리 패널 레이아웃
		mainPanel.add(submit, "p3");
		mainPanel.add(endPanel, "p4");//endPanel 레이아웃
		mainPanel.add(rankingPage,"p5");
		mainPanel.add(checkAnswerPage, "p6");

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 설정
	}
	// 폰트를 로드하고 생성하는 메서드
	private static Font loadFont(String fontPath, int style, int size) {
		try {
			// 폰트 파일로부터 폰트를 읽어옴
			Font font = Font.createFont(Font.TRUETYPE_FONT, new java.io.File(fontPath));

			// 스타일과 크기 설정
			font = font.deriveFont(style, size);

			return font;
		} catch (Exception e) {
			e.printStackTrace();
			// 폰트를 로드할 수 없는 경우 기본 폰트를 반환하거나 적절한 예외 처리를 수행할 수 있습니다.
			return new Font("SansSerif", Font.PLAIN, size);
		}
	}
}