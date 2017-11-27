
public class BoardFactory {

	public static Board makeNewBoard(int xSize, int ySize) {
		Board b = new Board(xSize, ySize);
		b.setFlag(1, 15);
		b.setFlag(2, 11);
		b.setFlag(3, 22);
		b.setFlag(4, 26);
		b.setFlag(5, 34);
		b.setFlag(6, 36);
		return b;
	}

}
