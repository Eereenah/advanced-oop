
public class Board {

	public Square[][] board;

	public Board() {

		this.board = new Square[8][8];

		this.initBoard();
		this.fillPawns(true);
		this.fillPawns(false);
		this.fillRooks();
		this.fillKnights();
		this.fillBishops();
		this.fillKings();
		this.fillQueens();

	}

	private void initBoard() {
		for (int i = 0; i < 8; ++i) {
			for (int j = 0; j < 8; ++j) {
				board[i][j] = new Square();
			}
		}
	}

	private boolean validateCoordinate(int coordinate) {
		return coordinate >= 0 && coordinate <= 7;
	}

	private boolean coordsInBoard(Move move) {
		return validateCoordinate(move.getFrom().getX()) && validateCoordinate(move.getFrom().getY())
				&& validateCoordinate(move.getTo().getX()) && validateCoordinate(move.getTo().getY());
	}

	private void fillPawns(boolean isWhite) {

		int rowIndex = isWhite ? 1 : 6;

		for (int i = 0; i < 8; ++i) {
			board[rowIndex][i] = new Square(new Pawn(isWhite));
		}

	}

	private void fillRooks() {

		final int leftCol = 0;
		final int rightCol = 7;

		board[0][leftCol] = new Square(new Rook(true));
		board[0][rightCol] = new Square(new Rook(true));
		board[7][leftCol] = new Square(new Rook(false));
		board[7][rightCol] = new Square(new Rook(false));

	}

	private void fillKnights() {

		final int leftCol = 1;
		final int rightCol = 6;

		board[0][leftCol] = new Square(new Knight(true));
		board[0][rightCol] = new Square(new Knight(true));
		board[7][leftCol] = new Square(new Knight(false));
		board[7][rightCol] = new Square(new Knight(false));

	}

	private void fillBishops() {

		final int leftCol = 2;
		final int rightCol = 5;

		board[0][leftCol] = new Square(new Bishop(true));
		board[0][rightCol] = new Square(new Bishop(true));
		board[7][leftCol] = new Square(new Bishop(false));
		board[7][rightCol] = new Square(new Bishop(false));

	}

	private void fillKings() {

		final int kingCol = 3;

		board[0][kingCol] = new Square(new King(true));
		board[7][kingCol] = new Square(new King(false));

	}

	private void fillQueens() {

		final int queenCol = 4;

		board[0][queenCol] = new Square(new Queen(true));
		board[7][queenCol] = new Square(new Queen(false));

	}

	public void validateMove(Move move) {
		if (!coordsInBoard(move)) {
			System.out.println("Coordinates are outside of the board");
		}

		Piece fromChessPiece = board[move.getFrom().getX()][move.getFrom().getY()].getChessPiece();
		if (fromChessPiece != null) {
			String pieceName = getPieceName(fromChessPiece);
			if (!fromChessPiece.check(move)) {
				System.out.println("That's not " + pieceName + "'s move");
			}

			else {
				System.out.println("The move is valid for " + pieceName);
			}
		}
		else {
			System.out.println("The chosen cell is empty");
		}
	}

	public String getPieceName(Piece p) {
		String pieceName = "the cell is empty";
		if (p instanceof Pawn)
			pieceName = "pawn";
		if (p instanceof Rook)
			pieceName = "rook";
		if (p instanceof Knight)
			pieceName = "knight";
		if (p instanceof Bishop)
			pieceName = "bishop";
		if (p instanceof King)
			pieceName = "king";
		if (p instanceof Queen)
			pieceName = "queen";
		return pieceName;
	}
}
