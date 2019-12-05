public class King extends Piece {

    public King(boolean white) {
        super(white);
    }

    @Override
    public boolean check(Move move) {
        int diffX = move.getTo().getX() - move.getFrom().getX();
        int diffY = move.getTo().getY() - move.getFrom().getY();
        return !(Math.abs(diffX) > 1 || Math.abs(diffY) > 1);
    }
}