package GUI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class StartPanel extends JPanel {
	JPanel panel;

	StartPanel(UI ui) {
		super();
		panel = ui.mainPanel;

		setBackground(ui.mainBlue);
		setLayout(null);
		// logo 넣기
		JLabel logoLabel = new JLabel(ui.resizedIcon);
		logoLabel.setBounds(200, 280, 300, 200);
		// name Label 넣기
		JLabel nameLabel = new JLabel("이름을 입력해 주세요.");
		nameLabel.setFont(ui.titleFont);
		nameLabel.setForeground(Color.white);
		nameLabel.setBounds(680, 180, 400, 200);
		// TextField
		JTextField nameField = new JTextField(20);
		nameField.setFont(ui.inputFont);
		nameField.setBounds(650, 330, 350, 60);
		// Button
		JButton nextButton = new JButton("다음");
		nextButton.setFont(ui.buttonFont);
		nextButton.setBackground(ui.mainYellow);
		nextButton.setForeground(ui.mainBlue);
		nextButton.setBounds(650, 430, 350, 60);

		add(logoLabel);
		add(nameLabel);
		add(nameField);
		add(nextButton);

		nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout)panel.getLayout();

				if(nameField.getText().equals("")) {
					nameField.setText("이름을 입력해주세요");
					nameField.setForeground(ui.mainYellow);
				}else {
					ui.user.setName(nameField.getText());
					System.out.println("입력된 문자열 : " + nameField.getText()); //디버깅
					System.out.println("저장된 유저 이름 : " + ui.user.getName()); //디버깅
					card.next(panel);
				}
            }
		});
		nameField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nameField.setText("");
				nameField.setForeground(Color.BLACK);
			}
		});

	}

}