
public abstract class Piece {

	protected boolean color;

	public Piece(boolean color) {
		this.color = color;
	}

	public boolean isWhite() {
		return color;
	}

	public abstract boolean check(Move move);


}