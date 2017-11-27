import java.util.List;

public class Main {

	public static void main(String[] args) {

		Board board = BoardFactory.makeNewBoard(6, 6);
		
		System.out.println(board.toString());
		
		Hourse h = new Hourse(board);

		h.runFrom(board.getCellWithFirstFlag());
		
		List<Cell> path = h.getPath();
		
		System.out.println(path);
	}

}
