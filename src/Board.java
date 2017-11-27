import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

	private Map<Integer, Cell> cells = new HashMap<>();
	private List<Cell> flagedCells = new ArrayList<>();
	private Cell firstFlagedCell;

	public Board(int xSize, int ySize) {
		for (int y = 0; y < ySize; y++) {
			for (int x = 0; x < xSize; x++) {
				int addr = y * xSize + x + 1;
				Cell c = new Cell(
						addr, 
						findWestFor(addr, xSize), 
						findNorthFor(addr, xSize));
				cells.put(addr, c);
			}
		}
	}

	private Cell findWestFor(int addr, int xSize) {
		int westAddr = addr - 1;
		return westAddr >= 1 && mod(westAddr, xSize) != 0 ? cells.get(westAddr) : null;
	}

	private int mod(int a, int b) {
		return a % b;
	}

	private Cell findNorthFor(int addr, int xSize) {
		return addr - xSize >= 1 ? cells.get(addr - xSize) : null;
	}

	public void setFlag(int flag, int addr) {
		Cell c = cells.get(addr);
		c.setFlag(flag);
		flagedCells.add(c);
		if(flag==1)
			firstFlagedCell = c;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Cell c : cells.values()) {
			sb.append(c.toString());
			sb.append(c.hasEast() ? "," : "\n");
		}
		return sb.toString();
	}

	public Cell getCellWithFirstFlag() {
		return firstFlagedCell;
	}

	public int getCellCount() {
		return cells.size();
	}
}
