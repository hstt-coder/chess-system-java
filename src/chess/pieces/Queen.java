package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.enums.Color;

public class Queen extends ChessPiece {

    public Queen(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "Q";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean mat[][] = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position position = new Position(0, 0);

        //ABOVE
        position.setValues(this.position.getRow() - 1, this.position.getColumn());
        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
            mat[position.getRow()][position.getColumn()] = true;
            position.setRow(position.getRow() - 1);
        }
        if (getBoard().positionExists(position) && isThereAnyOpponentPiece(position))
            mat[position.getRow()][position.getColumn()] = true;

        //LEFT
        position.setValues(this.position.getRow(), this.position.getColumn() - 1);
        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
            mat[position.getRow()][position.getColumn()] = true;
            position.setColumn(position.getColumn() - 1);
        }
        if (getBoard().positionExists(position) && isThereAnyOpponentPiece(position))
            mat[position.getRow()][position.getColumn()] = true;

        //RIGHT
        position.setValues(this.position.getRow(), this.position.getColumn() + 1);
        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
            mat[position.getRow()][position.getColumn()] = true;
            position.setColumn(position.getColumn() + 1);
        }
        if (getBoard().positionExists(position) && isThereAnyOpponentPiece(position))
            mat[position.getRow()][position.getColumn()] = true;

        //BELOW
        position.setValues(this.position.getRow() + 1, this.position.getColumn());
        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
            mat[position.getRow()][position.getColumn()] = true;
            position.setRow(position.getRow() + 1);
        }
        if (getBoard().positionExists(position) && isThereAnyOpponentPiece(position))
            mat[position.getRow()][position.getColumn()] = true;

        // NW
        position.setValues(this.position.getRow() - 1, this.position.getColumn() - 1);
        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
            mat[position.getRow()][position.getColumn()] = true;
            position.setValues(position.getRow() - 1, position.getColumn() - 1);
        }
        if (getBoard().positionExists(position) && isThereAnyOpponentPiece(position))
            mat[position.getRow()][position.getColumn()] = true;

        // NE
        position.setValues(this.position.getRow() - 1, this.position.getColumn() + 1);
        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
            mat[position.getRow()][position.getColumn()] = true;
            position.setValues(position.getRow() - 1, position.getColumn() + 1);
        }
        if (getBoard().positionExists(position) && isThereAnyOpponentPiece(position))
            mat[position.getRow()][position.getColumn()] = true;

        //SW
        position.setValues(this.position.getRow() + 1, this.position.getColumn() - 1);
        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
            mat[position.getRow()][position.getColumn()] = true;
            position.setValues(position.getRow() + 1, position.getColumn() - 1);
        }
        if (getBoard().positionExists(position) && isThereAnyOpponentPiece(position))
            mat[position.getRow()][position.getColumn()] = true;

        //SE
        position.setValues(this.position.getRow() + 1, this.position.getColumn() + 1);
        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
            mat[position.getRow()][position.getColumn()] = true;
            position.setValues(position.getRow() + 1, position.getColumn() + 1);
        }
        if (getBoard().positionExists(position) && isThereAnyOpponentPiece(position))
            mat[position.getRow()][position.getColumn()] = true;

        return mat;
    }
}
