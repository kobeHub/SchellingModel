package model;

import java.util.ArrayList;
import java.util.Iterator;

public class AgentA implements Agent {
	
	Position pos;
	type group;
	float tolerance;
	
	public AgentA(Position p, type g, float t){
		pos = new Position(p);
		group = g;
		tolerance = t;
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
	public float getTolerance() {
		return tolerance;
	}

	@Override
	public boolean isHappy(ArrayList<Agent> neighbors) {
		int total = neighbors.size();
		int num = 0;
		Iterator<Agent> n = neighbors.iterator();
		while(n.hasNext())
			if(n.next().getType() == this.group)
				num+=1;
		
		float perc = (float)num/total;
		return perc <= tolerance;
	}
	
}
