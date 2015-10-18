package view;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Adventure;
import model.City;
import model.InTransitException;
import model.TravelObserver;

public class DestReachedView extends JPanel implements TravelObserver {

	Adventure a;
	City d;
	
	public DestReachedView(Adventure a) throws InTransitException{
		a.addTravelObserver(this);
		
		this.a = a;
		//this.d = a.getCurrentCity();
		//a.addTravelObserver(this);
		
//		JLabel label = new JLabel("Arrived at " );
//		add(label);
		
	}
	@Override
	public void travelUpdate(Adventure adventure, int distance_to_destination,
			City destination) {
		
		if (distance_to_destination <= 0){
			
			removeAll();
			
			JLabel label = new JLabel("Arrived at " + destination.getName() + "            " ); //because it won't cover up all the letters
			add(label);
			revalidate();
			
		}
		revalidate();
		
//		this.d = destination;
//		JLabel label = new JLabel(destination.getName());
//		add(label);
		//add(destination);

	}
	
	
	
	

}
