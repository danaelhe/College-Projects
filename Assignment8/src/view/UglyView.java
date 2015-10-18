package view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UglyView extends JPanel {
	private ImageIcon image;
	private JLabel label;
	private ImageIcon icon;
	
	public UglyView(){
		image = new ImageIcon(getClass().getResource("u2.jpg"));
		label = new JLabel(image);
		add(label);
	}
}

