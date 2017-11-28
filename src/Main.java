public class Main {

	public static void main(String[] args) {

		Board board = BoardFactory.makeNewBoard();

		System.out.println("*** board ***");
		System.out.println(board.toString());

		Horse horse = new Horse(board);

		horse.runFrom(
				board.getCellWithFirstFlag());

		System.out.println("*** result ***");
		System.out.println(horse.getPath());

		System.out.println("*** failed paths ***");
		System.out.println(horse.getFailedPath().toString());
	}

}
