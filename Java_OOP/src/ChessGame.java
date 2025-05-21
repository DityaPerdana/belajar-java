import java.util.Scanner;
import java.io.IOException;
import java.util.NoSuchElementException;

public class ChessGame {
    // Main method - program entry point
    public static void main(String[] args) {
        System.out.println("Starting Chess Game...");
        runGame();
    }
    
    // Static method to run the game
    public static void runGame() {
        ChessGame game = new ChessGame();
        Scanner scanner = new Scanner(System.in);
        boolean gameRunning = true;
        
        System.out.println("Welcome to Chess Game!");
        System.out.println("Enter moves in format: e2 e4 (from to)");
        System.out.println("Type 'quit' to exit the game");
        
        game.displayBoard();
        
        while (gameRunning) {
            try {
                System.out.print("\nEnter your move: ");
                
                // Check if there's input available before trying to read
                if (System.in.available() == 0 && !scanner.hasNextLine()) {
                    // If running in an environment without input, use a default move for demonstration
                    System.out.println("No input available. Using default move: e2 e4");
                    processMoveCommand(game, "e2 e4");
                    // Wait a bit before the next move to allow viewing
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    continue;
                }
                
                String input = scanner.hasNextLine() ? scanner.nextLine().trim().toLowerCase() : "quit";
                
                if (input.equals("quit")) {
                    gameRunning = false;
                    continue;
                }
                
                processMoveCommand(game, input);
                
            } catch (NoSuchElementException e) {
                System.out.println("Input error: No line available. Exiting game.");
                gameRunning = false;
            } catch (IllegalStateException e) {
                System.out.println("Scanner error: Scanner is closed. Exiting game.");
                gameRunning = false;
            } catch (IOException e) {
                System.out.println("IO error: " + e.getMessage() + ". Continuing with default moves.");
                // Use a default move if there's an IO error
                processMoveCommand(game, "e2 e4");
            }
        }
        
        System.out.println("Thanks for playing!");
        
        try {
            scanner.close();
        } catch (Exception e) {
            // Ignore exceptions when closing the scanner
        }
    }
    
    // Helper method to process a move command
    private static void processMoveCommand(ChessGame game, String input) {
        try {
            String[] parts = input.split("\\s+");
            if (parts.length != 2) {
                System.out.println("Invalid format. Use 'e2 e4' format.");
                return;
            }
            
            String from = parts[0];
            String to = parts[1];
            
            // Convert algebraic notation to array indices
            int startCol = from.charAt(0) - 'a';
            int startRow = 8 - (from.charAt(1) - '0');
            int endCol = to.charAt(0) - 'a';
            int endRow = 8 - (to.charAt(1) - '0');
            
            // Check if the indices are valid
            if (startCol < 0 || startCol > 7 || startRow < 0 || startRow > 7 ||
                endCol < 0 || endCol > 7 || endRow < 0 || endRow > 7) {
                System.out.println("Invalid move. Coordinates out of range.");
                return;
            }
            
            // Try to move the piece
            boolean moveSuccessful = game.movePiece(startRow, startCol, endRow, endCol);
            if (moveSuccessful) {
                game.displayBoard();
            } else {
                System.out.println("Invalid move. Try again.");
            }
            
        } catch (Exception e) {
            System.out.println("Error processing move: " + e.getMessage());
            System.out.println("Use format like 'e2 e4'.");
        }
    }
    
    // Chess game implementation
    private ChessPiece[][] board;
    private boolean isWhiteTurn;
    
    public ChessGame() {
        board = new ChessPiece[8][8];
        isWhiteTurn = true;
        setupBoard();
    }
    
    private void setupBoard() {
        board[0][0] = new ChessPiece(PieceType.ROOK, false);
        board[0][1] = new ChessPiece(PieceType.KNIGHT, false);
        board[0][2] = new ChessPiece(PieceType.BISHOP, false);
        board[0][3] = new ChessPiece(PieceType.QUEEN, false);
        board[0][4] = new ChessPiece(PieceType.KING, false);
        board[0][5] = new ChessPiece(PieceType.BISHOP, false);
        board[0][6] = new ChessPiece(PieceType.KNIGHT, false);
        board[0][7] = new ChessPiece(PieceType.ROOK, false);
        
        // Initialize black pawns
        for (int col = 0; col < 8; col++) {
            board[1][col] = new ChessPiece(PieceType.PAWN, false);
        }
        
        // Initialize white pawns
        for (int col = 0; col < 8; col++) {
            board[6][col] = new ChessPiece(PieceType.PAWN, true);
        }
        
        // Initialize white pieces
        board[7][0] = new ChessPiece(PieceType.ROOK, true);
        board[7][1] = new ChessPiece(PieceType.KNIGHT, true);
        board[7][2] = new ChessPiece(PieceType.BISHOP, true);
        board[7][3] = new ChessPiece(PieceType.QUEEN, true);
        board[7][4] = new ChessPiece(PieceType.KING, true);
        board[7][5] = new ChessPiece(PieceType.BISHOP, true);
        board[7][6] = new ChessPiece(PieceType.KNIGHT, true);
        board[7][7] = new ChessPiece(PieceType.ROOK, true);
    }
    
    // Move a piece from one position to another
    public boolean movePiece(int startRow, int startCol, int endRow, int endCol) {
        // Check if the move is valid
        if (!isValidMove(startRow, startCol, endRow, endCol)) {
            return false;
        }
        
        // Make the move
        board[endRow][endCol] = board[startRow][startCol];
        board[startRow][startCol] = null;
        
        // Switch turns
        isWhiteTurn = !isWhiteTurn;
        return true;
    }
    
    // Check if a move is valid (simplified version)
    private boolean isValidMove(int startRow, int startCol, int endRow, int endCol) {
        // Check if the start position has a piece
        if (board[startRow][startCol] == null) {
            return false;
        }
        
        // Check if it's the right player's turn
        if (board[startRow][startCol].isWhite() != isWhiteTurn) {
            return false;
        }
        
        // Check if the destination has a piece of the same color
        if (board[endRow][endCol] != null && 
            board[endRow][endCol].isWhite() == board[startRow][startCol].isWhite()) {
            return false;
        }
        
        // In a real implementation, we would check if the move follows the rules for the specific piece
        // This is a simplified version
        
        return true;
    }
    
    // Display the board in the console
    public void displayBoard() {
        System.out.println("  a b c d e f g h");
        System.out.println(" +-----------------+");
        
        for (int row = 0; row < 8; row++) {
            System.out.print((8 - row) + "|");
            
            for (int col = 0; col < 8; col++) {
                if (board[row][col] == null) {
                    // Use different background for alternating squares
                    if ((row + col) % 2 == 0) {
                        System.out.print("□ ");
                    } else {
                        System.out.print("■ ");
                    }
                } else {
                    System.out.print(board[row][col].getSymbol() + " ");
                }
            }
            
            System.out.println("|" + (8 - row));
        }
        
        System.out.println(" +-----------------+");
        System.out.println("  a b c d e f g h");
        System.out.println(isWhiteTurn ? "White's turn" : "Black's turn");
    }
    
    // Enum for piece types
    enum PieceType {
        PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING
    }
    
    // Class to represent a chess piece
    class ChessPiece {
        private PieceType type;
        private boolean isWhite;
        
        public ChessPiece(PieceType type, boolean isWhite) {
            this.type = type;
            this.isWhite = isWhite;
        }
        
        public PieceType getType() {
            return type;
        }
        
        public boolean isWhite() {
            return isWhite;
        }
        
        // Get the symbol for the piece
        public String getSymbol() {
            switch (type) {
                case PAWN:
                    return isWhite ? "♙" : "♟";
                case ROOK:
                    return isWhite ? "♖" : "♜";
                case KNIGHT:
                    return isWhite ? "♘" : "♞";
                case BISHOP:
                    return isWhite ? "♗" : "♝";
                case QUEEN:
                    return isWhite ? "♕" : "♛";
                case KING:
                    return isWhite ? "♔" : "♚";
                default:
                    return "?";
            }
        }
    }
}