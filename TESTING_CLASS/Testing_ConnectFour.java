public class Testing_ConnectFour {
    public static void main(String[] args) {
        // Aquí puedes probar la clase ConnectFour
        ConnectFour game = new ConnectFour();
        
        // Imprimir el tablero inicial
        char[][] grid = game.getGrid();
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                System.out.print(grid[col][row] + " ");
            }
            System.out.println();
        }
        
        // Imprimir el símbolo actual
        System.out.println("Símbolo actual: " + game.getCurrentSymbol());
    }
}