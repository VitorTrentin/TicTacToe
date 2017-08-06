import java.awt.FontFormatException;
import java.io.IOException;

public class AI {
	 Board board;
	 XOButton buttons[];
	 boolean live;
	public AI(Board board){
		this.board = board;
		
	}
	
	public void choseSlot() throws FontFormatException, IOException{
		if(board.gameLive && this.live){
			//chose a random index from the available positions 
			int randomSlot =  (int) (Math.random() * board.getEmptySlots().size());
			buttons[board.emptySlots.get(randomSlot)].setIcon(buttons[0].O);
			board.setCasa(2,board.emptySlots.get(randomSlot));
			board.setWhosTurn(1);
		
		}
		
	}
	public boolean getLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	
	public void setButtons(XOButton buttons[]) {
		this.buttons = buttons;
	}

}
