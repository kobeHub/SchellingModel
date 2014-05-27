package testing;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import model.Agent;
import model.Agent.type;
import model.AgentA;
import model.BoardA;
import model.Console;
import model.Position;

public class BoardTest {

	@Test
	public void test() {
		Console c = new Console(4,4);
		c.drawBoard();
		
		for(int i =0;i<7;i++){
			Agent a = new AgentA(type.ONE, (float) 0.5);
			Agent b = new AgentA(type.TWO, (float) 0.5);
			c.board.addAgent(a);
			c.board.addAgent(b);
		}

		c.drawBoard();
		
		c.runSim();

	}
}
