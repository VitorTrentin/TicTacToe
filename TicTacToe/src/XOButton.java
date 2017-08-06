import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;

public class XOButton extends JButton implements ActionListener {

	
	private static final long serialVersionUID = 1L;
	ImageIcon X, O,BG;
	byte value = 0;// 1=X,2=O
	Board board;
	AI ai;
	int buttonNumber;

	public XOButton(int bNumber, Board mesa, AI a) {
		X = new ImageIcon(this.getClass().getResource("X.jpg"));
		O = new ImageIcon(this.getClass().getResource("O.jpg"));
		BG = new ImageIcon(this.getClass().getResource("bg_main.jpg"));
		this.addActionListener(this);
		setIcon(BG);
		board = mesa;
		ai = a;
		buttonNumber = bNumber;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// check who's turn is and if the button hasn't been clicked yet 
		try {
			if(board.whosTurn == 1 && board.emptySlots.contains(buttonNumber)){
				setIcon(X);
				board.setCasa(1, buttonNumber);
				board.setWhosTurn(2);
				ai.choseSlot();
			}
			if(board.whosTurn == 2 && board.emptySlots.contains(buttonNumber)){
				if(!ai.live){
					setIcon(O);
					board.setCasa(2, buttonNumber);

					board.setWhosTurn(1);	
				}
			}
		} catch (FontFormatException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		
	}

}
