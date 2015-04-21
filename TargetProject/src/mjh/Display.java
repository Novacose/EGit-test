package mjh;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Display extends JPanel {

	JLabel lblRings = new JLabel("Number of Rings");
	JTextField txtRings = new JTextField();
	JLabel lblBrightness = new JLabel("Brightness 0-255");
	JTextField txtBrightness = new JTextField("0");
	JButton btnDraw = new JButton("Draw");
	Canvas cnvTarget = new Canvas();
	
	
	
	public Display() {
		
		setLayout(null);
		
		lblRings.setBounds(20, 20, 100, 20);
		add(lblRings);
		
		txtRings.setBounds(20, 60, 100, 20);
		add(txtRings);
		
		lblBrightness.setBounds(20, 100, 100, 20);
		add(lblBrightness);
		
		txtBrightness.setBounds(20, 140, 100, 20);
		add(txtBrightness);
		
		btnDraw.setBounds(20+12, 180, 75, 20);
		btnDraw.addActionListener(new DrawEvent());
		add(btnDraw);
		
		cnvTarget.setBounds(160, 20, 300, 300);
		cnvTarget.setBackground(new Color(255,255,255));
		add(cnvTarget);
		
		
		
	}
	
	private class DrawEvent implements ActionListener {
		
		
		
		
		
		
		
		public void actionPerformed(ActionEvent arg0) {
			int numRings;
			int color = 1;
			int xyloc = 0;
			int size = 300;
			int change;
			int c1, c2, c3;
			int brightness;
			
			//Get the Data
			
			numRings = Integer.parseInt(txtRings.getText());
			if(numRings > 150){
				
				numRings = 150;
				
			}
			String ringstext = "" + numRings;
			txtRings.setText(ringstext);
			change = 300/numRings;
			
			brightness = Integer.parseInt(txtBrightness.getText());
			
			if(brightness >= 255){
				
				brightness = 250;
				
			}
			
			Graphics g = cnvTarget.getGraphics();
			g.setColor(Color.white);
			g.drawRect(0, 0, 300, 300);
			
			Random gen = new Random();
			
			
			for(int i = 0; i < numRings; i++){
				
				c1 = gen.nextInt(255-brightness);
				c2 = gen.nextInt(255-brightness);
				c3 = gen.nextInt(255-brightness);
				
				if(color == 1){
					
					g.setColor(new Color(brightness+c1,brightness+c2,brightness+c3));
					
				} else {
					
					g.setColor(Color.white);
					
				}
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				g.fillOval(xyloc, xyloc, size, size);
				
				color *= -1;
				
				size -= change;
				xyloc += change/2;
				
				
			}
			
		}
		
	}
	
}
