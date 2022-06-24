package janela;

import javax.swing.JButton;
import javax.swing.JFrame;

public class corpo extends JFrame{
    public void corpo() {
    	setTitle("corpo");
    	setExtendedState(JFrame.MAXIMIZED_BOTH);
    	setResizable(false);
    	setVisible(true);
    	setLayout(null);
    	setLocationRelativeTo(null);
    }
    public void botoes() {
    	
    }
	public static void main(String[] args) {
		corpo co=new corpo();
		co.corpo();
		co.botoes();
	}
}
