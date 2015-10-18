package a8;

import javax.swing.JFrame;

import view.AdventureConsole;
import view.AdventureView;
import model.Adventure;
import model.InTransitException;
import model.ItemNotForSaleException;
import model.Squad;
import model.SquadImpl;


public class Main {

	//you added itemnotforsaleexcpetion
	public static void main(String[] args) throws InTransitException, ItemNotForSaleException {
		JFrame main_frame = new JFrame();
		main_frame.setTitle("Adventure");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Squad s = SquadImpl.generateSquad(5);		
		Adventure a = new Adventure(Adventure.Difficulty.HARD, s);

		AdventureConsole c = new AdventureConsole(a);
		c.start();

		AdventureView v = new AdventureView(a);
		main_frame.setContentPane(v);

		main_frame.pack();
		main_frame.setVisible(true);	
		
		try {
			c.join();
		} catch (InterruptedException e) {
		}
		System.exit(0);
	}
}
