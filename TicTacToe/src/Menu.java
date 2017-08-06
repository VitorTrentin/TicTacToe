import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SpringLayout;

public class Menu extends JFrame implements ActionListener {

	private JPanel contentPane;
	TicTacToe game;

	public Menu(AI ai) {
		super("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);
		// JPanel Section
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//Ai game JButton Section
		JButton btnNewButton = new JButton("");
		btnNewButton.setLocation(110, 200);
		btnNewButton.setIcon(new ImageIcon(getClass().getResource("btn_menu_01.png")));
		btnNewButton.setSize(190, 44);
		// Makes border invisable
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setOpaque(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ai.setLive(true);
				setVisible(false);
				game.setVisible(true);

			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		//Local game JButton Section
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setLocation(110, 250);
		btnNewButton_1.setSize(190, 44);
		btnNewButton_1.setIcon(new ImageIcon(getClass().getResource("btn_menu_02.png")));
		// Makes border invisable
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				game.setVisible(true);

			}
		});
		contentPane.add(btnNewButton_1);
		//Background JLabel Section
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("jogo_da_velha_bg.jpg")));
		lblNewLabel.setBounds(0, 0, 400, 400);
		contentPane.add(lblNewLabel);
		setLocationRelativeTo(null);// Centralize Screen
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void setGame(TicTacToe gam) {
		this.game = gam;
	}
}
