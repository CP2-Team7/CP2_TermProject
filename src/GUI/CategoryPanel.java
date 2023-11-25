package GUI;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CategoryPanel extends JPanel {

    JPanel panel;

    CategoryPanel(JPanel pn) {
        super();
        panel = pn;
        JButton capitalb = new JButton("수도 맞추기");
        JButton connectionb = new JButton("이어말하기");
        JButton fourletterb = new JButton("사자성어");
        JButton nextb2 = new JButton("다음");
        JLabel selectcatl = new JLabel("< 게임 카테고리를 선택하세요 >");
        selectcatl.setFont(new Font("PLAIN",Font.BOLD,35));
        capitalb.setFont(new Font("PLAIN",Font.BOLD,25));
        connectionb.setFont(new Font("PLAIN",Font.BOLD,25));
        fourletterb.setFont(new Font("PLAIN",Font.BOLD,25));
        nextb2.setFont(new Font("PLAIN",Font.ITALIC,25));
        selectcatl.setBounds(300, 100, 600, 100);
        capitalb.setBounds(150, 300, 200, 200);
        connectionb.setBounds(500, 300, 200, 200);
        fourletterb.setBounds(850, 300, 200, 200);
        nextb2.setBounds(450, 600, 300, 100);
        setLayout(null);
        add(selectcatl);
        add(capitalb);
        add(connectionb);
        add(fourletterb);
        add(nextb2);
        nextb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout card = (CardLayout)panel.getLayout();
                card.next(panel);
            }
        });
    }

}
