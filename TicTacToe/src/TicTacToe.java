import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TicTacToe extends JFrame {

	private static final long serialVersionUID = 1L;
	JPanel p = new JPanel();
	XOButton buttons[] = new XOButton[9];
	GameOver go;
	Board board;
	AI ai;
	Menu menu;

	public static void main(String args[]) throws FontFormatException, IOException {

		TicTacToe game = new TicTacToe();

	}

	public TicTacToe() throws FontFormatException, IOException {
		// Swing Related
		super("Jogo da Velha");
		setSize(400, 400);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Game Logic Related
		//go = new GameOver(this);
		board = new Board(this);
		ai = new AI(board);
		this.setBoard(board);
		this.setAi(ai);
		ai.setButtons(this.buttons);
		Menu menu = new Menu(ai);
		menu.setGame(this);

		// Swing Related, creates all board buttons
		p.setLayout(new GridLayout(3, 3));
		for (int i = 0; i < 9; i++) {
			buttons[i] = new XOButton(i, board, ai);
			p.add(buttons[i]);

		}
		// add buttons to JPanel
		add(p);
		setLocationRelativeTo(null);// Centralize Screen

	}

	private void setAi(AI ai2) {
		this.ai = ai2;

	}

	private void setBoard(Board board) {
		this.board = board;

	}

}
