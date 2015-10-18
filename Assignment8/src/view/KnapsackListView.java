package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Adventure;
import model.TravelObserver;

public class KnapsackListView extends JPanel implements listUpdate {

	Adventure a;
	
	public KnapsackListView(Adventure a, PlaceOrderView f){
		f.addObserver(this);
		
		setLayout(new GridLayout(0, 1));
		JLabel label = new JLabel("Knapsack: ");
		add(label);
		
		
		for (int i = 0; i < a.getSquad().getKnapsack().getEdibleSupplies().length; i++){
			JLabel item = new JLabel(Integer.toString(a.getSquad().getKnapsack().getEdibleSupplies()[i].getAmount()) + 
					" of " + a.getSquad().getKnapsack().getEdibleSupplies()[i].getName() + "(expires in " + 
					Integer.toString(a.getSquad().getKnapsack().getEdibleSupplies()[i].getDaysTillExpiration()) + 
					" days)" );
			add(item);
		}
	
		revalidate();
	}

	@Override
	public void listUpdate(Adventure a) {
		removeAll();
		
		//setLayout(new GridLayout(a.getSquad().getKnapsack().getEdibleSupplies().length+1, 1));
		JLabel label = new JLabel("Knapsack: ");
		add(label);
		
		for (int i = 0; i < a.getSquad().getKnapsack().getEdibleSupplies().length; i++){
			JLabel item = new JLabel(Integer.toString(a.getSquad().getKnapsack().getEdibleSupplies()[i].getAmount()) + 
					" of " + a.getSquad().getKnapsack().getEdibleSupplies()[i].getName() + "(expires in " + 
					Integer.toString(a.getSquad().getKnapsack().getEdibleSupplies()[i].getDaysTillExpiration()) + 
					" days)" );
			add(item);
		}
		
		for (int i = 0; i < a.getSquad().getKnapsack().getNonEdibleSupplies().length; i++){
			JLabel item = new JLabel(Integer.toString(a.getSquad().getKnapsack().getNonEdibleSupplies()[i].getAmount()) + 
					" of " + a.getSquad().getKnapsack().getNonEdibleSupplies()[i].getName());
			add(item);
		}
	
		revalidate();
		
	}
	
	

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		removeAll();
//		
//		//setLayout(new GridLayout(a.getSquad().getKnapsack().getEdibleSupplies().length+1, 1));
//		JLabel label = new JLabel("Knapsack: ");
//		add(label);
//		
//		for (int i = 0; i < a.getSquad().getKnapsack().getEdibleSupplies().length; i++){
//			JLabel item = new JLabel(Integer.toString(a.getSquad().getKnapsack().getEdibleSupplies()[i].getAmount()) + 
//					" of " + a.getSquad().getKnapsack().getEdibleSupplies()[i].getName() + "(expires in " + 
//					Integer.toString(a.getSquad().getKnapsack().getEdibleSupplies()[i].getDaysTillExpiration()) + 
//					" days)" );
//			add(item);
//		}
//	
//		revalidate();
		
	}

