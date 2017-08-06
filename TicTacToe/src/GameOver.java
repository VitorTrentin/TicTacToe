import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;

public class GameOver extends JFrame {

	private JPanel contentPane;
	static int xScore = 0;
	static int oScore = 0;

	public GameOver(TicTacToe game) throws FontFormatException, IOException {
		super("Game Over");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		// Button Section
		try {
			//Getting font
			java.net.URL url = getClass().getResource("fonte.ttf");
			   Font f = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File(url.getPath())))
			     .deriveFont(Font.PLAIN, 45);
			contentPane.setLayout(null);
			JButton btnRestart = new JButton("");
			btnRestart.setBounds(106, 259, 190, 53);
			btnRestart.setIcon((new ImageIcon(getClass().getResource("Game_Over_btn_08.png"))));
			// Makes border invisible
			btnRestart.setBorderPainted(false);
			btnRestart.setContentAreaFilled(false);
			btnRestart.setFocusPainted(false);
			btnRestart.setOpaque(false);

			btnRestart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						TicTacToe newGame = new TicTacToe();
					} catch (FontFormatException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();

					}
					game.setVisible(false);
					game.dispose();
					setVisible(false);
					dispose();
				}
			});
			contentPane.add(btnRestart);
			// Score JLabel Section
			JLabel lblNewLabel = new JLabel(xScore + "X" + oScore);
			lblNewLabel.setForeground(Color.BLACK);
			lblNewLabel.setBounds(160, 180, 117, 94);
			lblNewLabel.setFont(f);
			contentPane.add(lblNewLabel);
			//Background JLabel Section
			JLabel lblNewLabel_1 = new JLabel("New label");
			lblNewLabel_1.setIcon((new ImageIcon(getClass().getResource("Game_Over_bg .jpg"))));
			lblNewLabel_1.setBounds(0, 0, 400, 400);
			contentPane.add(lblNewLabel_1);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		setLocationRelativeTo(null);// Centralize Screen

	}
}
