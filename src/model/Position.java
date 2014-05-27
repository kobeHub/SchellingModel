package model;

public class Position {

	int row, column;

	public Position(int r, int c) {
		row = r;
		column = c;
	}
	
	Position(Position p){
		this.row = p.getRow();
		this.column = p.getColumn();
	}

	/**
	 * Get row of position
	 * @return int
	 */
	int getRow() {
		return row;
	}

	/**
	 * Get column of position
	 * 
	 * @return int
	 */
	int getColumn() {
		return column;
	}

	/**
	 * Set the row of the position
	 * 
	 * @param row - int value for row.
	 */
	void setRow(int row) {
		this.row = row;
	}

	/**
	 * Set column of the position
	 * 
	 * @param col
	 *            - int value for column.
	 */
	void setColumn(int col) {
		this.column = col;
	}
	
	
	Position[] getNLocations(){
		Position[] p = new Position[8];
		p[0] = new Position(this.row, this.column-1);
		p[1] = new Position(this.row,this.column +1);
		p[2] = new Position(this.row-1, this.column);
		p[3] = new Position(this.row+1, this.column);
		p[4] = new Position(this.row+1, this.column+1);
		p[5] = new Position(this.row-1,this.column -1);
		p[6] = new Position(this.row+1, this.column-1);
		p[7] = new Position(this.row-1, this.column+1);
			
		return p;
	}
	
	@Override
	public String toString() {
		return row + " " + column;
	}

	@Override
	public boolean equals(Object p) {
		try {
			Position loc = (Position) p;
			return (this.row == loc.getRow() && this.column == loc.getColumn());
		} catch (Exception e) {
			return false;
		}
	}
	
	
}
