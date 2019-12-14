#include "board.h"
#include "command.h"
#include "piece.h"
#include "utility.h"

#include "king.h"
#include "queen.h"
#include "rook.h"
#include "bishop.h"
#include "knight.h"
#include "pawn.h"

#include <utility>
#include <map>
#include <vector>
#include <string>
#include <memory>
#include <iostream>
#include <fstream>

using std::map;
using std::vector;
using std::string;
using std::shared_ptr;
using std::cin;
using std::cout;
using std::endl;
using std::ofstream;
using std::ifstream;

Board::Board(Parser* p, Drawer* d) :
	squares(map<int, shared_ptr<Piece>>()),
	moves(vector<string>()),
	parser(p), drawer(d), whiteTurn(true) {

}

Board::~Board() {
	if (parser)
		delete parser;
	if (drawer)
		delete drawer;
}

Board::Board(const Board& rhs) :
	squares(rhs.squares), moves(rhs.moves),
	parser(rhs.parser), drawer(rhs.drawer), whiteTurn(rhs.whiteTurn), isCaptured(rhs.isCaptured){
}


void Board::operator=(const Board& rhs) {
	if (parser)
		delete parser;
	if (drawer)
		delete drawer;

	squares = rhs.squares;
	moves = rhs.moves;
	parser = rhs.parser;
	drawer = rhs.drawer;
	whiteTurn = rhs.whiteTurn;
	isCaptured = rhs.isCaptured;
}

void Board::startGame() {
	initBoard();

	while (true) {
		drawer->draw(this);
		string in;
		cout << ": ";
		cin >> in;
		Command c = parser->parseCommand(in, this);
		if (c.type == CommandType::CONTROL) {
			movePiece(c.origin, c.dest);
			moves.push_back(c.raw);
		}
		else if (c.type == CommandType::INVALID) {
			cout << "Invalid command" << endl;
			continue;
		}
	}
}

void Board::movePiece(int origin, int dest) {
	auto destPiece = squares.find(dest);
	if (destPiece != squares.end()) {
		squares.erase(destPiece);
		isCaptured = true;
	}
		
	auto originPiece = squares.find(origin);
	std::shared_ptr<Piece> chessPiece = originPiece->second;
	squares.insert(std::make_pair(dest, chessPiece));

	squares.erase(originPiece);
	auto newDest = squares.find(dest);
	newDest->second->setCurrentLocation(dest);
	if (isCaptured) {
		whiteTurn = !whiteTurn;
	}

}

void Board::initBoard() {
	squares.clear();
	moves.clear();
	isCaptured = false;
	whiteTurn = true;

	squares[1] = shared_ptr<Piece>(new Rook(1, true));
	squares[2] = shared_ptr<Piece>(new Knight(2, true));
	squares[3] = shared_ptr<Piece>(new Bishop(3, true));
	squares[4] = shared_ptr<Piece>(new Queen(4, true));
	squares[5] = shared_ptr<Piece>(new King(5, true));
	squares[6] = shared_ptr<Piece>(new Bishop(6, true));
	squares[7] = shared_ptr<Piece>(new Knight(7, true));
	squares[8] = shared_ptr<Piece>(new Rook(8, true));

	for (int i = 9; i < 17; ++i)
		squares[i] = shared_ptr<Piece>(new Pawn(i, true, true));

	squares[57] = shared_ptr<Piece>(new Rook(57, false));
	squares[58] = shared_ptr<Piece>(new Knight(58, false));
	squares[59] = shared_ptr<Piece>(new Bishop(59, false));
	squares[60] = shared_ptr<Piece>(new Queen(60, false));
	squares[61] = shared_ptr<Piece>(new King(61, false));
	squares[62] = shared_ptr<Piece>(new Bishop(62, false));
	squares[63] = shared_ptr<Piece>(new Knight(63, false));
	squares[64] = shared_ptr<Piece>(new Rook(64, false));

	for (int i = 49; i < 57; ++i)
		squares[i] = shared_ptr<Piece>(new Pawn(i, false, true));

}

