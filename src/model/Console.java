package model;

public class Console {
	int row, col;
	public Board board;
	
	public Console(int row, int column){
		this.row = row;
		this.col = column;
		board = new BoardA(row,column);
	}
	
	public void runSim(){
		int check =-1;
		while(check!=0){
			check = board.timeStep();
			drawBoard();
		}
	}
	
	public void drawBoard(){
		StringBuffer b = new StringBuffer();
		for(int i =0;i<row;i++){
			for(int j=0;j<col;j++){
				Position p = new Position(i,j);
				Agent a = board.getAgent(p);
				if(a==null)
					b.append("     ");
				else{
					String t = a.getType().toString();
					if(t.equals("ONE"))
						b.append("  O  ");
					else if(t.equals("TWO"))
						b.append("  X  ");
				}
			}
			b.append("\n");	
		}
		System.out.println(b.toString());
	}
}
