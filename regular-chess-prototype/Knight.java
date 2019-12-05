
public class Knight extends Piece {

    public Knight(boolean white) {
        super(white);
    }

    @Override
    public boolean check(Move move) {
    	
        int diffX = move.getTo().getX() - move.getFrom().getX();
        int diffY = move.getTo().getY() - move.getFrom().getY();
        
        return ((Math.abs(diffX) == 2 && Math.abs(diffY) == 1)
                || (Math.abs(diffY) ==2 && Math.abs(diffX) ==1));  
        
        }
}