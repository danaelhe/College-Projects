package view;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Adventure;
import model.InTransitException;
import model.ItemNotForSaleException;

public class BalanceView extends JPanel implements listUpdate {

	Adventure a;
	
	public BalanceView(Adventure a, PlaceOrderView f){
		f.addObserver(this);
		this.a = a;
		double bal = a.getSquad().getBalance();
		JLabel label = new JLabel("Balance: $" + Double.toString(bal));
		add(label);
		
	}
	
	@Override
	public void listUpdate(Adventure a) throws ItemNotForSaleException, InTransitException {
		removeAll();
		double balance = a.getSquad().getBalance();
		double total = 0.0;
		double newBalance;
		for (int i = 0; i < a.getSquad().getKnapsack().getSupplies().length; i++){
			total += a.getCurrentCity().getStore().getPrice(a.getSquad().getKnapsack().getSupplies()[i].getName()) * (a.getSquad().getKnapsack().getSupplies()[i].getAmount());

		}
		
		newBalance = balance - total;
		JLabel label = new JLabel("Balance: $" + Double.toString(newBalance) + "      ");
		add(label);
	}

}
