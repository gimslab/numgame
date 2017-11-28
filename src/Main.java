public class Main {

	public static void main(String[] args) {

		Board board = BoardFactory.makeNewBoard();
		
		System.out.println(board.toString());
		
		Hourse h = new Hourse(board);

		h.runFrom(board.getCellWithFirstFlag());
		
		System.out.println("----");
		System.out.println(h.getPath());
		System.out.println("----");
		System.out.println(h.getFailedPath().toString());
	}

}
