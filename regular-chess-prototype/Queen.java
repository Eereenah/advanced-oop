
public class Queen extends Piece {

    public Queen(boolean white) {
        super(white);
    }

    @Override
    public boolean check(Move move) {
        int diffX = move.getTo().getX() - move.getFrom().getX();
        int diffY = move.getTo().getY() - move.getFrom().getY();
        return  ((Math.abs(diffX) > 0 && Math.abs(diffY) > 0 && Math.abs(diffX) == Math.abs(diffY)))
                || !(Math.abs(diffX) > 0 && Math.abs(diffY) > 0);
    }
}