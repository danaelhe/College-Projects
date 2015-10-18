package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import supplies.Supplies;
import model.Adventure;
import model.City;
import model.InTransitException;
import model.ItemNotForSaleException;
import model.StoreImpl;

public class PurchaseListView extends JPanel implements ActionListener {

	Adventure a;
	
	public PurchaseListView(Adventure a) throws InTransitException, ItemNotForSaleException {
		
		this.a = a;
		String[] items = new String[a.getCurrentCity().getStore().getItemNames().length];
		double[] prices = new double[a.getCurrentCity().getStore().getItemNames().length];
		String[] itemsWPrices = new String[a.getCurrentCity().getStore().getItemNames().length];

		
	for (int i = 0; i < a.getCurrentCity().getStore().getItemNames().length; i++){
			items[i] = a.getCurrentCity().getStore().getItemNames()[i];
			prices[i] = a.getCurrentCity().getStore().getPrice(items[i]);
			itemsWPrices[i] = items[i] + " $" + prices[i];
			System.out.println(itemsWPrices[i]);
		}

	JComboBox itemList = new JComboBox(itemsWPrices);
	add(itemList);
	
	String i = (String) itemList.getSelectedItem();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
