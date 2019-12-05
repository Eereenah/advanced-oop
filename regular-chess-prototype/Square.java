
public class Square {

    private Piece chessPiece;
    public Square(Piece chessPiece) {

        if (chessPiece == null) {
            throw new NullPointerException("Chess piece can't be null");
        }

        this.chessPiece = chessPiece;
    }

    public Square() {
    	
    }

    public boolean isEmpty() {
        return chessPiece == null;
    }

    public void clear(){
        this.chessPiece = null;
    }

    public Piece getChessPiece() {
        return this.chessPiece;
    }
}