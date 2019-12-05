
public class Move {

	private Coords from;
	private Coords to;
	
	public Move(int x1, int y1, int x2, int y2) {
		from = new Coords(x1, y1);
		to = new Coords(x2, y2);
	}
	
	public Coords getFrom() {
		return from;
	}
	
	public void setFrom(Coords from) {
		this.from = from;
	}
	
	public Coords getTo() {
		return to;
	}
	
	public void setTo(Coords to) {
		this.to = to;
	}

}