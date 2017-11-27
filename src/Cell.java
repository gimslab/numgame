
public class Cell {
	private int addr;
	private Cell west;
	private Cell north;
	private Cell east;
	private Cell south;
	private int flag = 0;

	public Cell(int addr, Cell west, Cell north) {
		this.addr = addr;
		setWest(west);
		setNorth(north);
	}

	private void setWest(Cell west) {
		if (west != null) {
			this.west = west;
			west.east = this;
		}
	}

	private void setNorth(Cell north) {
		if (north != null) {
			this.north = north;
			north.south = this;
		}
	}

	@Override
	public String toString() {
		return addr + ":" + flag;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		return addr == ((Cell) o).addr;
	}

	public boolean hasEast() {
		return east != null;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public Cell west() {
		return west;
	}

	public Cell north() {
		return north;
	}

	public Cell east() {
		return east;
	}

	public Cell south() {
		return south;
	}

	public int flag() {
		return flag;
	}

	public boolean flagged() {
		return flag > 0;
	}
}
