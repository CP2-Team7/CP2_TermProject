package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import Class.*;


public class StartPanel extends JPanel {
	JPanel panel;

	StartPanel(UI ui) {
		super();
		panel = ui.mainPanel;
		Color blue = new Color(0x393E64);
        Color yellow = new Color(0xF1C832);
		setBackground(blue);
		JTextField nametxt = new JTextField(20);
		JButton nextb1 = new JButton("다음");
		JLabel namel = new JLabel("이름을 입력해 주세요.");
		setLayout(null);
		namel.setBounds(400, 200, 800, 100);
		namel.setFont(new Font("PLAIN",Font.BOLD,35));
		nextb1.setFont(new Font("PLAIN",Font.ITALIC,25));
		nametxt.setFont(new Font("PLAIN",Font.ITALIC,40));
		nametxt.setBounds(250, 300, 700, 100);
		nextb1.setBounds(450, 500, 300, 100);
		namel.setForeground(Color.WHITE);
		add(namel);
		add(nametxt);
		add(nextb1);
		nextb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout card = (CardLayout)panel.getLayout();
                ui.user.setName(nametxt.getText()); //입력받은 닉네임으로 User 클래스 user생성

				System.out.println("입력된 문자열 : " + nametxt.getText()); //디버깅
				System.out.println("저장된 유저 이름 : 깅" + ui.user.getName()); //디버깅

                card.next(panel);
            }
		});
		//nextb1이벤트처리 
	}
}