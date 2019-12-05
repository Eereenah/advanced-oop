
public class Rook extends Piece {

    public Rook(boolean white) {
        super(white);
    }

    @Override
    public boolean check(Move move) {
    	
        int diffX = move.getTo().getX() - move.getFrom().getX();
        int diffY = move.getTo().getY() - move.getFrom().getY();
        
        return !(Math.abs(diffX) > 0 && Math.abs(diffY) > 0);
       
        }
}