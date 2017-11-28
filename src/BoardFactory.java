
public class BoardFactory {

	public static Board makeNewBoard() {

		Board b = new Board(6, 6);
		b.setFlag(1, 15);
		b.setFlag(2, 11);
		b.setFlag(3, 22);
		b.setFlag(4, 26);
		b.setFlag(5, 34);
		b.setFlag(6, 36);

//		Board b = new Board(4, 4);
//		b.setFlag(1, 3);
//		b.setFlag(2, 9);
//		b.setFlag(3, 5);
//		b.setFlag(4, 7);
		return b;
	}

}
