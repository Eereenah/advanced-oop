
public class Game {

	public static void main(String[] args) {
		
		Board b = new Board();
		Piece p1 = b.board[0][0].getChessPiece(); //rook
		Piece p2 = b.board[0][3].getChessPiece(); //king
		Piece p3 = b.board[3][3].getChessPiece(); //empty cell

		System.out.println(b.getPieceName(p1));
		System.out.println(b.getPieceName(p2));
		System.out.println(b.getPieceName(p3));
		
		
		Move move1 = new Move(1, 2, 2, 2); //valid pawn move
		Move move2 = new Move(1, 2, 1, 4); //invalid pawn move
		Move move3 = new Move(2, 1, 2, 2); //making move from an empty cell
		b.validateMove(move1);
		b.validateMove(move2);
		b.validateMove(move3);
	}

}
