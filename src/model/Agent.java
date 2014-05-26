package model;

import java.util.ArrayList;

public interface Agent {
	
	public enum type{
		ONE, TWO
	}
	
	/**
	 * Get the position of this agent.
	 * @return Position
	 */
	Position getPos();
	
	/**
	 * Set the position of this agent.
	 * @param loc - new Position
	 */
	void setPos(Position loc);
	
	/**
	 * Get type of the agent.
	 * @return type
	 */
	type getType();
	
	/**
	 * Get the tolerance % of this agent.
	 * @return Float representing tolerance. 
	 */
	float getTolerance();
	
	/**
	 * Given a list of neighbors, evaluates if happy or not.
	 * @param neighbors - ArrayList of neighbors of class Agent.
	 * @return true if happy, false if unhappy.
	 */
	boolean isHappy(ArrayList<Agent> neighbors);
}
