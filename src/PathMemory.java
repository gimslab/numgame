import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PathMemory {

	private List<String> paths = new ArrayList<>();

	public void add(List<Cell> path) {

		String pstr = toString(path);

		deleteItemsStartedBy(pstr);

		for (String p : paths) {
			if (pstr.startsWith(p)) {
				return;
			}
		}
		paths.add(pstr);
	}

	private void deleteItemsStartedBy(String pstr) {
		for (Iterator<String> it = paths.iterator(); it.hasNext();) {
			String next = it.next();
			if (next.startsWith(pstr))
				it.remove();
		}
	}

	public boolean contains(List<Cell> path) {

		String pstr = toString(path);

		for (String p : paths) {
			if (pstr.startsWith(p)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		paths.forEach(p -> sb.append(p).append("\n"));
		return sb.toString();
	}

	private String toString(List<Cell> path) {
		return path.toString().substring(1, path.toString().length() - 1);
	}
}
