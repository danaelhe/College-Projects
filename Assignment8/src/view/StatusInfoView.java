package view;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Adventure;

public class StatusInfoView extends JPanel implements Observer {

	Adventure a;
	
	public StatusInfoView(Adventure a){
		this.a = a;
		setLayout(new GridLayout(4,1));
		
		for (int i = 0; i < a.getSquad().getNumPlayers(); i++){
		
		JPanel p0Panel = new JPanel(new GridLayout(4,1,1,1));
		
		JLabel name = new JLabel(a.getSquad().getPlayer(i).getName());
		JLabel hp = new JLabel("HP: " + Integer.toString(a.getSquad().getPlayer(i).getCurrentHP()));
		JLabel skill = new JLabel("Skill: " + Integer.toString(a.getSquad().getPlayer(i).getSkill()));
		JLabel status = new JLabel("Status: " + a.getSquad().getPlayer(i).getStatus().toString());
		
		p0Panel.add(name);
		p0Panel.add(hp);
		p0Panel.add(skill);
		p0Panel.add(status);
		
		add(p0Panel);
		}
		


	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
