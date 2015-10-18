package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import person.Person;
import model.Adventure;
import model.InTransitException;
import model.ItemNotForSaleException;
import model.Squad;

public class AdventureView extends JPanel {

	private Adventure adventure;
	
	public AdventureView(Adventure adventure) throws InTransitException, ItemNotForSaleException {
		this.adventure = adventure;
		
		//setLayout(new BorderLayout());
		this.setLayout(new GridLayout(2,1));
		
		Squad s = adventure.getSquad();
		Person p = s.getPlayer(0);
		
		
		
		JPanel grid = new JPanel(new GridLayout(2,2)); 
		
		TravelControlView tcv = new TravelControlView(adventure);
		//PersonView pv = new PersonView(p);
		
		grid.add(tcv);
		//grid.add(pv);
		add(grid);
	
		
		DestReachedView drv = new DestReachedView(adventure);
		StatusInfoView sif = new StatusInfoView(adventure);
		PlaceOrderView pov = new PlaceOrderView(adventure);
		KnapsackListView klv = new KnapsackListView(adventure, pov);
		BalanceView bv = new BalanceView(adventure, pov);
		//PurchaseListView plv = new PurchaseListView(adventure);
		//BuyView bv = new BuyView(adventure);		
		UglyView uv = new UglyView();
		//BalanceView bv = new BalanceView(adventure);
		
		add(uv);
		add(klv);
		add(tcv);		
		add(drv);
		add(sif);	
		//add(bv);
		//add(plv);
		add(pov);
		add(bv);
		
		
		revalidate();
	}
}
