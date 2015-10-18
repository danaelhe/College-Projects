package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Adventure;
import model.City;

public class TravelControlView extends JPanel implements ActionListener {

	private Adventure a;
	private JComboBox cityList;
	
	public TravelControlView(Adventure a){
		
		this.a = a;
		City[] cityArray = a.getCities();
		
		JLabel label = new JLabel("Travel to:");
		cityList = new JComboBox(cityArray);
		cityList.addActionListener(this);
		add(label);
		add(cityList);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//get selected city and travel to that city
		a.travel((City) cityList.getSelectedItem());

	}

}
