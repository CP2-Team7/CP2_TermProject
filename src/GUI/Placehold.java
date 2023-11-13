package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Placehold extends JFrame {
	private JPanel startPanel, categoryPanel, qPanel, endPanel, rankingPanel, markingPanel;
	private JTextField nametxt, qtxt, answertxt;
	private JButton capitalb, connectionb, fourletterb, nextb1, nextb2, nextb3, backb, toRankingb, toFirstb, toMarkingb;
	
	public Placehold() {
		setSize(300,400);
		CardLayout card = new CardLayout(0,0);
		setLayout(card);//������ ����
		
		startPanel = new JPanel();
		nametxt = new JTextField(10);
		nextb1 = new JButton("����");
		JPanel s1 = new JPanel();
		JPanel s2 = new JPanel();
		s1.add(new JLabel("�̸�: "));
		s1.add(nametxt);
		s2.add(nextb1);
		startPanel.setLayout(new BorderLayout());
		startPanel.add(s1, BorderLayout.CENTER);
		startPanel.add(s2, BorderLayout.SOUTH);
		add(startPanel);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(startPanel,"p1");//start�г� ���̾ƿ�
		
		nextb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//card.show("p2");
			}
		});
		
		categoryPanel = new JPanel();
		JPanel c1 = new JPanel();
		JPanel c2 = new JPanel();
		JPanel c3 = new JPanel();
		capitalb = new JButton();
		connectionb = new JButton();
		fourletterb = new JButton();
		nextb2 = new JButton();
		c1.add(new JLabel("< ���� ī�װ��� �����ϼ��� >"));
		c2.add(capitalb);
		c2.add(connectionb);
		c2.add(fourletterb);
		c3.add(nextb2);
		categoryPanel.add(c1);
		categoryPanel.add(c2);
		categoryPanel.add(c3);
		add(categoryPanel,"p2");//ī�װ� �г� ���̾ƿ�
		
		
	}
	
	public static void main(String arg[]) {
		Placehold p = new Placehold();
	}
}