package application;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.enums.Color;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UI {
    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";


    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static ChessPosition readChessPosition(Scanner sc) {
        try {
            String s = sc.nextLine();
            char column = s.charAt(0);
            int row = Integer.parseInt(s.substring(1));

            return new ChessPosition(column, row);
        } catch (RuntimeException e) {
            throw new InputMismatchException("Error reading ChessPosition. Valid values are from a1 to h8");
        }
    }

    public static void printBoard(ChessPiece[][] pieces) {
        for (int i = 0; i < pieces.length; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < pieces.length; j++) {
                printPiece(pieces[i][j], false);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    public static void printMatch(ChessMatch chessMatch, List<ChessPiece> captured) {
        printBoard(chessMatch.getPieces());
        printCapturedPieces(captured);
        System.out.println();
        System.out.println("Turn: " + chessMatch.getTurn());

        if (!chessMatch.getCheckMate()) {
            System.out.print(ANSI_YELLOW);
            System.out.print("Waiting player: ");
            System.out.print(ANSI_YELLOW);
            if (chessMatch.getCurrentPlayer() == Color.WHITE)
                System.out.print(ANSI_WHITE);
            else
                System.out.print(ANSI_GREEN);

            System.out.print(chessMatch.getCurrentPlayer());
            System.out.print(ANSI_RESET);

            if (chessMatch.getCheck()) {
                System.out.println();
                System.out.print(ANSI_RED);
                System.out.println("+++++++++ CHECK +++++++++");
                System.out.print(ANSI_RESET);
            }
        } else {
            System.out.println();
            System.out.print(ANSI_RED);
            System.out.println("######### CHECKMATE #########");
            System.out.print(ANSI_RESET);
            System.out.println("WINNER: " + chessMatch.getCurrentPlayer());
        }


    }

    public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
        for (int i = 0; i < pieces.length; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < pieces.length; j++) {
                printPiece(pieces[i][j], possibleMoves[i][j]);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    private static void printPiece(ChessPiece piece, boolean background) {
        if(background)
            System.out.print(ANSI_BLUE_BACKGROUND );

        if (piece == null)
            System.out.print("-" + ANSI_RESET);
        else
            if (piece.getColor() == Color.WHITE)
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            else
                System.out.print(ANSI_GREEN+ piece + ANSI_RESET);

        System.out.print(" ");
    }

    private static void printCapturedPieces(List<ChessPiece> captured) {
        List<ChessPiece> white = captured.stream().filter(
                x -> x.getColor() == Color.WHITE).collect(Collectors.toList());
        List<ChessPiece> black = captured.stream().filter(
                x -> x.getColor() == Color.BLACK).collect(Collectors.toList());

        System.out.print(ANSI_RED);
        System.out.println("Captured pieces: ");
        System.out.print(ANSI_RESET);
        System.out.print("WHITE: ");
        System.out.print(ANSI_WHITE);
        System.out.println(Arrays.toString(white.toArray()));
        System.out.print(ANSI_RESET);
        System.out.print("BLACK: ");
        System.out.print(ANSI_GREEN);
        System.out.print(Arrays.toString(black.toArray()));
        System.out.print(ANSI_RESET);

    }
}
