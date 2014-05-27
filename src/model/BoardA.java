package model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Random;

public class BoardA implements Board {

	Hashtable<String, Agent> agents;
	ArrayList<Agent> agentlist;
	int ROWS;
	int COLUMNS;

	public BoardA(int r, int c) {
		ROWS = r;
		COLUMNS = c;
		agents = new Hashtable<String, Agent>();
		agentlist = new ArrayList<Agent>();
	}

	@Override
	public Position randomLoc() throws Exception {
		if (agents.size() == ROWS * COLUMNS)
			throw new Exception("World Full");
		else {

			Random r = new Random();

			ArrayList<Position> allValidLocations = new ArrayList<Position>();
			
			for (int i = 0; i < COLUMNS; i++) {
				for (int j = 0; j < ROWS; j++) {
					Position l = new Position(j, i);
					if (isValidLoc(l) && isEmpty(l))
						allValidLocations.add(l);
				}
			}

			if (allValidLocations.size() == 0)
				throw new Exception("No more space in the world");

			int rand = r.nextInt(allValidLocations.size());
			Position random = allValidLocations.get(rand);
			return random;
		}
	}

	@Override
	public ArrayList<Agent> getNeighbors(Position loc) {
		Position[] pos = loc.getNLocations();
		ArrayList<Agent> neighbors = new ArrayList<Agent>();
		
		for(int i=0; i<pos.length; i++)
			if(isValidLoc(pos[i]))
				if(getAgent(pos[i])!=null)
					neighbors.add(getAgent(pos[i]));
		
		return neighbors;
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
		Position loc;
		try {
			loc = randomLoc();
			return addAgent(a,loc);
		} catch (Exception e) {
			System.out.println("No empty space available.");
			e.printStackTrace();
			return false;
			
		}
		
	}

	@Override
	public Agent removeAgent(Position loc) {
		Agent a = agents.remove(loc.toString());
		if(a!=null)
			agentlist.remove(a);
		return a;
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
	public int timeStep() {
		Iterator<Agent> a = agentlist.iterator();
		int count =0;
		while(a.hasNext()){
			Agent cur = a.next();
			if(!cur.isHappy(getNeighbors(cur.getPos()))){
				count++;
				try {
					//Moving an agent who is not happy.
					Position loc = randomLoc();
					agents.remove(cur.getPos().toString());
					cur.setPos(loc);
					agents.put(loc.toString(),cur);
				} catch (Exception e) {
					System.out.println("No other position available");
					e.printStackTrace();
				}
			}
		}
		
		return count;
	}

	@Override
	public boolean isValidLoc(Position loc) {
		if (loc.getRow() < ROWS && loc.getColumn() < COLUMNS)
			return true;
		else
			return false;
	}

}
