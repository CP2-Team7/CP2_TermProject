package GUI;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Class.GameRepository;
import Class.GameRound;
import Class.GameServer;
import Class.QuestionName;
import Class.User;

public class RankingPanel extends JPanel {
    JPanel panel;

    public RankingPanel(UI ui) {
        super();
        panel = ui.mainPanel;
        setLayout(null);
        JTextArea rankings = new JTextArea(9, 20);
        rankings.setEditable(false);
        rankings.append("리더보드\n");
        GameRound gameRound = ui.gameRound;
        GameServer gameServer = ui.gameServer;
        QuestionName category = gameRound.currentCategory;
        java.util.List<User> ranking = null;

        gameServer.checkLeaderboard(gameRound.checkAnswer(gameRound.answerList), gameRound.currentUser, category);

        switch (category) {
            case CAPITAL:
                ranking = gameServer.rankingCapital;
                break;
            case CONNECTION:
                ranking = gameServer.rankingConnection;
                break;
            case FOURLETTERS:
                ranking = gameServer.rankingFourLetters;
            default:
                break;
        }

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
        
        for(int i = 0; i < ranking.size(); i++) {
            User u = ranking.get(i);
            rankings.append(i + "위\t" + u.name + "\t" + u.score[cat] + "\n");
        }

        JButton bBack = new JButton("뒤로가기");
        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout card = (CardLayout)panel.getLayout();
                card.show(panel, "p4");
            }
        });
        JButton bMain = new JButton("처음 화면으로 가기");
        bMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout card = (CardLayout)panel.getLayout();
                card.show(panel, "p1");
            }
        });

        //위치는 나중에 조율
        add(rankings);
        rankings.setBounds(500, 0, 200, 230);
        add(bBack);
        bBack.setBounds(300, 400, 150, 30);
        add(bMain);
        bMain.setBounds(750, 400, 150, 30);
    }

    public static void main(String[] args) {
    }
}