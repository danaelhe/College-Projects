package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Adventure;

public class BuyView extends JPanel implements ActionListener {

	Adventure a;
	
	public BuyView(Adventure a){
		this.a = a;
		JLabel label = new JLabel("Buy: ");
		JTextField amount = new JTextField(6);
		JLabel of = new JLabel("    of:    ");
		add(label);
		add(amount);
		add(of);
		
		amount.getInputContext();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
