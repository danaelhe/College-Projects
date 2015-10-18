package view;

import model.Adventure;
import model.InTransitException;
import model.ItemNotForSaleException;

public interface listUpdate {

	public void listUpdate(Adventure a) throws ItemNotForSaleException, InTransitException;
}
