package mjh;

import javax.swing.JFrame;

public class Main extends JFrame {

	public Main() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,500);
		add(new Display());
		setVisible(true);
		
	}
	
	public static void main(String[] args) {

		Main window = new Main();
		
	}

}
