import java.util.Scanner;

public class ChessMain {
    public static void main(String[] args) {
        ChessGame game = new ChessGame();
        Scanner scanner = new Scanner(System.in);
        boolean gameRunning = true;
        
        System.out.println("Welcome to Chess Game!");
        System.out.println("Enter moves in format: e2 e4 (from to)");
        System.out.println("Type 'quit' to exit the game");
        
        game.displayBoard();
        
        while (gameRunning) {
            System.out.print("\nEnter your move: ");
            String input = scanner.nextLine().trim().toLowerCase();
            
            if (input.equals("quit")) {
                gameRunning = false;
                continue;
            }
            
            // Parse the move
            try {
                String[] parts = input.split("\\s+");
                if (parts.length != 2) {
                    System.out.println("Invalid format. Use 'e2 e4' format.");
                    continue;
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
                    continue;
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
        
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}