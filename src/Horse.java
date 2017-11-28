import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

public class Horse {

	private Board board;
	private PathMemory failedPaths = new PathMemory();
	private List<Cell> path = new ArrayList<>();

	public Horse(Board board) {
		this.board = board;
	}

	public void runFrom(Cell startCell) {

		path.add(startCell);
		Cell cur = startCell;
		while (path.size() < board.getCellCount()) {
			Cell next = findNextAvailableCell(cur);
			if (next == null) {
				if (path.size() <= 1) { // no way
					break;
				}
				saveIntoFailed(path);
				path.remove(path.size() - 1);
				cur = path.get(path.size() - 1);
				continue;
			}
			path.add(next);
			cur = next;
		}
	}

	private void saveIntoFailed(List<Cell> path) {
		failedPaths.add(copyOf(path));
	}

	private List<Cell> copyOf(List<Cell> path) {
		List<Cell> copied = new ArrayList<>();
		for (Cell c : path)
			copied.add(c);
		return copied;
	}

	private boolean isValidFlagOrder(List<Cell> path) {
		List<Integer> flagged = path.stream().filter(c -> c.flagged()).map(c -> c.flag()).collect(toList());
		List<Integer> sorted = flagged.stream().sorted().collect(toList());
		return flagged.equals(sorted);
	}

	private Cell findNextAvailableCell(Cell cur) {
		if (isAvail(cur.west()))
			return cur.west();
		if (isAvail(cur.north()))
			return cur.north();
		if (isAvail(cur.east()))
			return cur.east();
		if (isAvail(cur.south()))
			return cur.south();
		return null;
	}

	private boolean isAvail(Cell c) {
		return c != null && !path.contains(c) && !isTriedPath(c) && isValidFlagOrder(c);
	}

	private boolean isValidFlagOrder(Cell c) {
		List<Cell> tmp = copyOf(path);
		tmp.add(c);
		return isValidFlagOrder(tmp);
	}

	private boolean isTriedPath(Cell c) {
		List<Cell> tmp = copyOf(path);
		tmp.add(c);
		return failedPaths.contains(tmp);
	}

	public List<Cell> getPath() {
		return path;
	}

	public PathMemory getFailedPath() {
		return failedPaths;
	}

	public boolean succeedFinding() {
		return path.size() == board.getCellCount();
	}
}
