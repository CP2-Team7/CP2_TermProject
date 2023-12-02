package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
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
        
        Color blue = new Color(0x393E64);
        Color yellow = new Color(0xF1C832);
        setBackground(blue);
        
        
        gameServer.checkLeaderboard(gameRound.checkAnswer(gameRound.answerList), gameRound.currentUser, category);

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
        //QuestionName category = QuestionName.FOURLETTERS;

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
        //폰트 및 색 지정
        bBack.setFont(new Font("PLAIN",Font.ITALIC,25));
        bMain.setFont(new Font("PLAIN",Font.ITALIC,25));
        bBack.setForeground(blue);
        bBack.setBackground(yellow);
        bMain.setForeground(blue);
        bMain.setBackground(yellow);
        rankings.setForeground(Color.GRAY);
        rankings.setFont(new Font("PLAIN",Font.BOLD,35));
        
        //글자 나오는거 보고 rankings 사이즈 조절(좌우 여백 동일하게 맞추기)
        add(rankings);
        rankings.setBounds(250, 125, 700, 400);
        add(bBack);
        bBack.setBounds(200, 600, 300, 100);
        add(bMain);
        bMain.setBounds(700, 600, 300, 100);

    }

    public static void main(String[] args) {
    }
}