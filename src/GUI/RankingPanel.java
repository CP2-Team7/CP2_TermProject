package GUI;

import java.awt.CardLayout;
import java.util.ArrayList;

import javax.smartcardio.Card;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Class.QuestionName;
import Class.User;

public class RankingPanel extends JPanel {
    JPanel panel;

    RankingPanel(JPanel cl) {
        super();
        panel = cl;
        setLayout(null);
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
        bBack.addActionListener(e -> System.out.println("뒤로 감"));	//cardlayout 제대로 되면 바꾸기
        JButton bMain = new JButton("처음 화면으로 가기");
        bMain.addActionListener(e -> System.out.println("처음 화면으로 감"));	//cardlayout 제대로 되면 바꾸기

        //위치는 나중에 조율
        add(rankings);
        rankings.setBounds(500, 0, 200, 230);
        add(bBack);
        bBack.setBounds(300, 400, 150, 30);
        add(bMain);
        bMain.setBounds(750, 400, 150, 30);
    }
}