import java.awt.FontFormatException;
import java.io.IOException;
import java.util.ArrayList;

public class Board {
	int positions[] = new int[9];// 0-nenhum,1-X,2- O
	int whosTurn;
	boolean gameLive;
	GameOver gO;
	boolean draw;
	TicTacToe game;

	ArrayList<Integer> emptySlots = new ArrayList<Integer>(9);

	// construtor
	public Board(TicTacToe game) {
		for (int i = 0; i < positions.length; i++) {
			positions[i] = 0;
		}
		whosTurn = 1;
		for (int i = 0; i < 9; i++) {
			emptySlots.add(i);
		}
		gameLive = true;
		this.game= game;
	}



	public void removeFromList(int button, ArrayList<Integer> emptySlots) {
		for (int i = 0; i < emptySlots.size(); i++) {
			if (button == emptySlots.get(i)) {
				emptySlots.remove(i);
			}
		}
	}

	public boolean checkWin() {
		// check line
		for (int j = 0; j < 9; j += 3) {
			if (positions[j] == positions[j + 1] && positions[j] == positions[j + 2] && positions[j] != 0) {
				// nao pode ser zero, pois zero eh caso base
				return true;
			}
		}
		// check columns
		for (int j = 0; j < 3; j++) {
			if (positions[j] == positions[j + 3] && positions[j] == positions[j + 6] && positions[j] != 0) {
				return true;
			}
		}
		// check diagonal 1
		if (positions[0] == positions[4] && positions[0] == positions[8] && positions[0] != 0) {
			return true;
		}
		// check diagonal 2
		if (positions[2] == positions[4] && positions[2] == positions[6] && positions[2] != 0) {
			return true;
		}
		// check draw
		if (this.emptySlots.isEmpty()) {
			draw = true;
			return true;
		}
		return false;

	}

	public void callWinner() throws FontFormatException, IOException {
		if (checkWin()) {
			if (draw!=true) {
				if (whosTurn == 1) {
					gO.xScore++;
				} else {
					gO.oScore++;
				}
				//create new gameOver tab
				
			}
			gO = new GameOver(game);
			gO.setVisible(true);
			this.gameLive = false;
		}
	}

	public int[] getCasas() {
		return positions;
	}

	public void setCasas(int[] casas) {
		this.positions = casas;
	}

	public int getWhosTurn() {
		return whosTurn;
	}

	public void setWhosTurn(int whosTurn) {
		this.whosTurn = whosTurn;

	}

	public void setCasa(int player, int button) throws FontFormatException, IOException {
		this.positions[button] = player;
		this.removeFromList(button, emptySlots);
		callWinner();
	}

	public ArrayList<Integer> getEmptySlots() {
		return emptySlots;
	}

}
