
public class Pawn extends Piece {

    public Pawn(boolean white) {
        super(white);
    }

    @Override
    public boolean check(Move move) {

        int diffX = move.getTo().getX() - move.getFrom().getX();
        int diffY = move.getTo().getY() - move.getFrom().getY();
        int startX = isWhite() ? 1 : 6;

        if (isWhite()) {
            if (move.getTo().getX() < move.getFrom().getX()) {
                return false;
            }
        } else {
            if (move.getTo().getX() > move.getFrom().getX()) {
                return false;
            }
        }

        //forward or moves more than 2 fields forward
        if (Math.abs(diffX) < 1 || Math.abs(diffX) > 2) {
            return false;
        }

        // forward when not on the first line
        if (move.getFrom().getX() != startX && Math.abs(diffX) > 1) {
            return false;
        }

        // Moves left or right, moves forward or moves forward too far)
        if (diffY != 0 && Math.abs(diffX) != 1) {
            return false;
        }

        // Moves forward 1 field but left / right more than 1 field
        if (Math.abs(diffX) == 1 && Math.abs(diffY) > 1) {
            return false;
        }

        return true;

    }
    
}