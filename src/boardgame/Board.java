package boardgame;

public class Board {
    private Integer rows;
    private Integer columns;
    private Piece[][] pieces;

    public Board(Integer rows, Integer columns) {
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getColumns() {
        return columns;
    }

    public void setColumns(Integer columns) {
        this.columns = columns;
    }

    public Piece piece(int row, int column) {
        return pieces[row][column];
    }
    public Piece piece(Position p) {
        return pieces[p.getRow()][p.getColumn()];
    }

    public void placePiece(Piece piece, Position pos) {
        pieces[pos.getRow()][pos.getColumn()] = piece;
        piece.position = pos;
    }

}
