package model;

import java.util.ArrayList;
import java.util.Hashtable;

public class BoardA implements Board {

	Hashtable<String, Agent> agents;
	ArrayList<Agent> agentlist;
	int ROWS;
	int COLUMNS;

	BoardA(int r, int c) {
		ROWS = r;
		COLUMNS = c;
		agents = new Hashtable<String, Agent>();
		agentlist = new ArrayList<Agent>();
	}

	@Override
	public Position randomLoc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Agent> getNeighbors(Position loc) {
		
		
		return null;
	}

	@Override
	public Agent getAgent(Position loc) {
		return agents.get(loc.toString());
	}

	@Override
	public boolean isEmpty(Position loc) {
		if (agents.get(loc.toString()) == null)
			return true;
		else
			return false;
	}

	@Override
	public boolean addAgent(Agent a, Position loc) {
		try {
			agents.put(loc.toString(), a);
			agentlist.add(a);
			return true;
		} catch (NullPointerException e) {
			return false;
		}
	}

	@Override
	public boolean addAgent(Agent a) {
		Position loc = randomLoc();
		return addAgent(a,loc);
	}

	@Override
	public Agent removeAgent(Position loc) {
		return agents.remove(loc.toString());
	}

	@Override
	public int size() {
		return ROWS * COLUMNS;
	}

	@Override
	public int available() {
		return size() - agents.size();
	}

	@Override
	public void timeStep() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean isValidLoc(Position loc) {
		if (loc.getRow() < ROWS && loc.getColumn() < COLUMNS)
			return true;
		else
			return false;
	}

}
