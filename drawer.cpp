#include "drawer.h"
#include "board.h"
#include "piece.h"
#include "utility.h"

#include <ostream>
#include <iostream>
#include <string>
#include <memory>
#include <utility>

using std::shared_ptr;
using std::string;
using std::endl;
using std::pair;
using std::cout;


void Drawer::draw(Board* board) {
	char dot = '.';
	string rep(64, dot);

	for (auto beg = board->squares.begin(); beg != board->squares.end(); ++beg) {
		int pos = beg->first;
		shared_ptr<Piece> piece = beg->second;

		bool color = piece->getColor();
		PieceType type = piece->getType();

		char pie = pieceToString(color, type);
		rep[pos - 1] = pie;
	}

	if (system("CLS"))
		system("clear");
	cout << "white piece: lower letter, BLACK piece: UPPER letter" << endl;
	cout << "move piece from origin(ex: a7) to dest(ex: a5): a7a5" << endl;
	cout << "   " << "a b c d e f g h " << endl;
	cout << "-------------------" << endl;
	for (string::size_type i = 0; i < 8; ++i) {
		cout << i + 1 << "| ";
		string out = rep.substr(i * 8, 8);
		for (auto i : out)
			cout << i << " ";
		cout << endl;
	}
	cout << "-------------------" << endl;
	cout << "   " << "a b c d e f g h " << endl;
	if (board->isCaptured) {
		cout << (board->whiteTurn ? "WHITE" : "BLACK");
	}
	else{
		cout << endl;
		cout << "Senterej stage: move freely, white piece - lower letter, BLACK piece - UPPER letter" << endl;
		cout << "The rules will revert back to regular after the first capture." << endl;

	}
	
}

char Drawer::pieceToString(bool color, PieceType type) {
	char ret;
	switch (type) {
	case PieceType::PAWN:
		ret = 'a';
		break;
	case PieceType::BISHOP:
		ret = 'b';
		break;
	case PieceType::KNIGHT:
		ret = 'n';
		break;
	case PieceType::ROOK:
		ret = 'r';
		break;
	case PieceType::QUEEN:
		ret = 'q';
		break;
	case PieceType::KING:
		ret = 'k';
		break;
	default: break;
	}
	if (!color)
		ret -= 32;

	return ret;
}