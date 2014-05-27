package model;

import java.util.ArrayList;
import java.util.Iterator;

public interface Board {
	
	/**
	 * Checks if given location is valid.
	 * @param loc - Position to be checked.
	 * @return true if location is valid, false if not valid.
	 */
	boolean isValidLoc(Position loc);
	
	/**
	 * Returns a random, unoccupied location on the board.
	 * @return Position which is unoccupied.
	 * @throws Exception when no empty location exists.
	 */
	Position randomLoc() throws Exception;

	/**
	 *  Returns the list of neighbors for the given location.
	 * @param loc Position to process.
	 * @return ArrayList of surrounding Agents
	 */
	ArrayList<Agent> getNeighbors(Position loc);

	/**
	 * Returns the agent in the given location. If none, returns null.
	 * @param loc Position to get agent from.
	 * @return Agent object if it exists, else null.
	 */
	Agent getAgent(Position loc);

	/**
	 * If given position is occupied, returns false. Else, true.
	 * @param loc Position to check.
	 * @return true if it is empty, false it is occupied.
	 */
	boolean isEmpty(Position loc);

	/**
	 * If loc is empty, adds agent a to it and returns true. Else false.
	 * @param a Agent to be added.
	 * @param loc position where a will be added.
	 * @return true if agent was added successfully, false otherwise.
	 */
	boolean addAgent(Agent a, Position loc);

	/**
	 * If loc is occupied, removes and returns that agent. Else, returns null.
	 * @param loc Position to remove agent from.
	 * @return Agent which was removed, or null if none existed at given position.
	 */
	Agent removeAgent(Position loc);

	/**
	 * If empty space is available, add agent to a randomly generated, unoccupied position.
	 * @param a Agent to be added.
	 * @return true if added successfully, false otherwise.
	 */
	boolean addAgent(Agent a);
	
	/**
	 * Size of the world. 
	 * @return int number of spots (occupied + vacant) in the world.
	 */
	int size();
	
	/**
	 * Number of unoccupied positions in the world
	 * @return int
	 */
	int available();
	
	/**
	 * Take a timestep, evaluate state of all agents and relocate if required. 
	 * @return int - number of unhappy agents.
	 */
	int timeStep();
	
	/**
	 * Get an iterator of all agents.
	 * @return iterator of all agents in the board.
	 */
	Iterator<Agent> getAgentList();
	
}
