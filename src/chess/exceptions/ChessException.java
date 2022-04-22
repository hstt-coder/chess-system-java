package chess.exceptions;

import boardgame.exceptions.BoardExecption;

public class ChessException extends BoardExecption {
    public ChessException(String msg) {
        super(msg);
    }
}
