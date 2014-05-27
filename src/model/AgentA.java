package model;

import java.util.ArrayList;
import java.util.Iterator;

public class AgentA implements Agent {
	
	Position pos;
	type group;
	float comfort; //Percentage of like neighbors preferred. 
	
	public AgentA(Position p, type g, float t){
		pos = new Position(p);
		group = g;
		comfort = t;
	}
	
	public AgentA(type g, float t){
		pos = new Position(-1,-1);
		group = g;
		comfort = t;
	}

	@Override
	public Position getPos() {
		return pos;
	}

	@Override
	public void setPos(Position loc) {
		pos.setRow(loc.getRow());
		pos.setColumn(loc.getColumn());
	}

	@Override
	public type getType() {
		return group;
	}

	@Override
	public float getComfort() {
		return comfort;
	}

	@Override
	public boolean isHappy(ArrayList<Agent> neighbors) {
		// Unhappy if percentage of like neighbors is less than comfort level.
		int total = neighbors.size();
		
		if(total == 0)
			return true;
		
		int num = 0;
		Iterator<Agent> n = neighbors.iterator();
		while(n.hasNext())
			if(n.next().getType() == this.group)
				num+=1;
		
		float perc = (float)num/total;
		return !(perc < comfort);
	}
	
}
