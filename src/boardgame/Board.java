package boardgame;

import boardgame.exceptions.BoardExecption;

public class Board {
    private Integer rows;
    private Integer columns;
    private Piece[][] pieces;

    public Board(Integer rows, Integer columns) {
        if(rows < 1 || columns < 1)
            throw new BoardExecption("Error creating board: " +
                    "there must be at least 1 row and 1 column");
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public Integer getRows() {
        return rows;
    }

    public Integer getColumns() {
        return columns;
    }

    public Piece piece(int row, int column) {
       if(!positionExists(row, column))
           throw new BoardExecption("Position not on the board");
        return pieces[row][column];
    }
    public Piece piece(Position p) {
        if(!positionExists(p))
            throw new BoardExecption("Position not on the board");
        return pieces[p.getRow()][p.getColumn()];
    }

    public void placePiece(Piece piece, Position pos) {
        if(thereIsAPiece(pos))
            throw new BoardExecption("There is already a piece on the position " + pos);
        pieces[pos.getRow()][pos.getColumn()] = piece;
        piece.position = pos;
    }

    public boolean positionExists(int row, int column) {
        return ((row >= 0 && row < rows) && (column >= 0 && column < columns));
    }

    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position) {
        if(!positionExists(position))
            throw new BoardExecption("Position not on the board");
        return piece(position) != null;
    }
}
