package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import supplies.BisonJerky;
import supplies.Burrito;
import supplies.ButtonUp;
import supplies.Coffee;
import supplies.Fleece;
import supplies.Ramen;
import supplies.RedBison;
import supplies.Supplies;
import supplies.Sushi;
import supplies.TShirt;
import model.Adventure;
import model.InTransitException;
import model.ItemNotForSaleException;
import model.TravelObserver;

public class PlaceOrderView extends JPanel implements ActionListener{

	private Adventure a;
	private JButton b;
	private Integer number;
	private String supply;
	private JComboBox itemList;
	private Supplies supp;
	private JTextField amount;
	List<listUpdate> list;
	
	public PlaceOrderView(Adventure a) throws InTransitException, ItemNotForSaleException{
		
		this.a = a;
		JLabel label = new JLabel("Buy: ");
		amount = new JTextField(6);
		JLabel of = new JLabel("    of:    ");
		add(label);
		add(amount);
		add(of);
	
		list = new ArrayList<listUpdate>();
		//number = Integer.parseInt(amount.getText());
		
	
		String[] items = new String[a.getCurrentCity().getStore().getItemNames().length];
		double[] prices = new double[a.getCurrentCity().getStore().getItemNames().length];
		String[] itemsWPrices = new String[a.getCurrentCity().getStore().getItemNames().length];

		
		for (int i = 0; i < a.getCurrentCity().getStore().getItemNames().length; i++){
			items[i] = a.getCurrentCity().getStore().getItemNames()[i];
			prices[i] = a.getCurrentCity().getStore().getPrice(items[i]);
			itemsWPrices[i] = items[i] + " $" + prices[i];
			System.out.println(itemsWPrices[i]);
		}

		//JComboBox you 
		itemList = new JComboBox(itemsWPrices);
		add(itemList);
		
		//itemList.addActionListener(this);
		
		supply = (String) itemList.getSelectedItem();
		
//		if (supply.equals("burrito")){
//			Supplies supp = new Burrito(Integer.parseInt(amount.getText()));
//		}
//		else if (supply.equals("bison jerky")){
//			Supplies supp = new BisonJerky(Integer.parseInt(amount.getText()));
//		}
//		
		
		b = new JButton("Place Order");
		b.addActionListener(this);
		add(b);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
						
		supply = itemList.getSelectedItem().toString();
		System.out.println(supply);
		
		if (supply.equals("burrito $4.0")){
			supp = new Burrito(Integer.parseInt(amount.getText()));
		}
		else if (supply.equals("bison jerky $2.0")){
			supp = new BisonJerky(Integer.parseInt(amount.getText()));
		}
		else if (supply.contains("coffee")){
			supp = new Coffee(Integer.parseInt(amount.getText()));
		}
		else if (supply.contains("fleece")){
			supp = new Fleece(Integer.parseInt(amount.getText()));
		}
		else if (supply.contains("button-up")){
			supp = new ButtonUp(Integer.parseInt(amount.getText()));
		}
		else if (supply.contains("ramen")){
			supp = new Ramen(Integer.parseInt(amount.getText()));
		}
		else if (supply.contains("sushi")){
			supp = new Sushi(Integer.parseInt(amount.getText()));
		}
		else if (supply.contains("Red")){
			supp = new RedBison(Integer.parseInt(amount.getText()));
		}
		else if (supply.contains("t-shirt")){
			supp = new TShirt(Integer.parseInt(amount.getText()));
		}
		a.getSquad().getKnapsack().add(supp);
		System.out.println(supp.getName());
		System.out.println(a.getSquad().getKnapsack().getEdibleSupplies().length);
		
		for (listUpdate o : list) {
			try {
				o.listUpdate(a);
			} catch (ItemNotForSaleException | InTransitException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public Supplies getSelectedItem(){
		return supp;
	}
	
	public void addObserver(listUpdate observer) {
		list.add(observer);
	}
}
