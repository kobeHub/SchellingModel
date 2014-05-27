package model;

public class Console {
	int row, col;
	Board board;
	
	Console(int row, int column){
		this.row = row;
		this.col = column;
		board = new BoardA(row,column);
	}
	
	public void runSim(){
		int check =-1;
		while(check!=0)
			check = board.timeStep();
	}
}
