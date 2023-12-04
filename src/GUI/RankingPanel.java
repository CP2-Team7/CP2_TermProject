package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import java.util.jar.JarEntry;

import javax.swing.*;

import Class.GameRepository;
import Class.GameRound;
import Class.GameServer;
import Class.QuestionName;
import Class.User;

public class RankingPanel extends JPanel {
    JPanel panel;
    JLabel categoryLabel;
    GameServer gameServer;
    GameRound gameRound;
    JTextArea rankings;


    public RankingPanel(UI ui) {
        super();
        panel = ui.mainPanel;
        setLayout(new BorderLayout());
        setBackground(ui.mainBlue);

        JLabel logoLabel = new JLabel(ui.smallIconImg);
        logoLabel.setBounds(10, 30, 200, 100);
        add(logoLabel);

        JPanel rankingP = new JPanel();
        rankingP.setLayout(new BorderLayout());

        JPanel titleP = new JPanel();
        categoryLabel = new JLabel("default");
        JLabel title = new JLabel("   랭킹");
        categoryLabel.setFont(ui.titleFont);
        title.setFont(ui.titleFont);
        categoryLabel.setForeground(ui.mainBlue);
        title.setForeground(ui.mainBlue);
        titleP.add(categoryLabel);
        titleP.add(title);


        rankings = new JTextArea(10, 20);

        rankings.setEditable(false);
        rankings.setFont(ui.buttonFont);
        rankings.setBorder(BorderFactory.createEmptyBorder(20, 300, 20, 0));

        JScrollPane scrollPane = new JScrollPane(rankings);

        rankingP.add(titleP, BorderLayout.NORTH);
        rankingP.add(scrollPane, BorderLayout.CENTER);

        setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));

        add(rankingP, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        JButton bBack = new JButton("뒤로가기");
        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout card = (CardLayout)panel.getLayout();
                card.previous(panel);
            }
        });
        JButton bMain = new JButton("처음 화면으로 가기");
        bMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout card = (CardLayout)panel.getLayout();
                card.first(panel);
            }
        });

        bBack.setPreferredSize(new Dimension(250, 60));
        bMain.setPreferredSize(new Dimension(250, 60));
        bBack.setFont(ui.buttonFont);
        bMain.setFont(ui.buttonFont);
        bBack.setBackground(ui.mainYellow);
        bMain.setBackground(ui.mainYellow);
        bBack.setForeground(ui.mainBlue);
        bMain.setForeground(ui.mainBlue);
        buttonPanel.setLayout(new GridLayout(1, 2, 10, 10));
        buttonPanel.add(bBack);
        buttonPanel.add(bMain);
        buttonPanel.setBackground(ui.mainBlue);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(60 , 0 , 0 , 0));
        add(buttonPanel, BorderLayout.SOUTH);

    }
    public void drawRaking(UI uui) {

        QuestionName category = uui.gameRound.currentCategory;
        categoryLabel.setText(category.getName());


        String userList = uui.gameServer.checkLeaderboard(uui);

        rankings.setText(userList.toString());



//        JButton bBack = new JButton("뒤로가기");
//        bBack.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//            }
//        });
//        JButton bMain = new JButton("처음 화면으로 가기");
//        bMain.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                CardLayout card = (CardLayout)panel.getLayout();
//                card.show(panel, "p1");
//            }
//        });
//        //폰트 및 색 지정
//        bBack.setFont(new Font("PLAIN",Font.ITALIC,25));
//        bMain.setFont(new Font("PLAIN",Font.ITALIC,25));
//        bBack.setForeground(ui.mainBlue);
//        bBack.setBackground(ui.mainYellow);
//        bMain.setForeground(ui.mainBlue);
//        bMain.setBackground(ui.mainYellow);
//        rankings.setForeground(Color.GRAY);
//        rankings.setFont(new Font("PLAIN",Font.BOLD,35));
//
//        //글자 나오는거 보고 rankings 사이즈 조절(좌우 여백 동일하게 맞추기)
//        add(rankings);
//        rankings.setBounds(250, 125, 700, 400);
//        add(bBack);
//        bBack.setBounds(200, 600, 300, 100);
//        add(bMain);
//        bMain.setBounds(700, 600, 300, 100);
    }
}