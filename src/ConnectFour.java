import java.util.*;
public class ConnectFour {
private char [][] grid;
private char currentSymbol;


// Constructor for ConnectFour
public ConnectFour() {
    this.grid = new char[7][6];
    this.currentSymbol = 'X'; // X para empezar el juego

    // Empezamos a llenar el tablero (Grid) con espacios vacios
    for (int col = 0 ; col < 7; col++) {
        for (int row = 0; row < 6; row++) {
            grid[col][row] = ' ';
        }
    }
}

    // getter opcionales en caso de que se necesiten
    public char[][] getGrid() {
        return grid;
}
    public char getCurrentSymbol() {
        return currentSymbol;
    }

  public boolean makeMove(int z) {
    // verificar la columna si es valida
    if(z < 0 || z >= 7) {
        return false; // Columna invalida
    }

    // Buscar la primera fila, Esto es de abajo hacia arriba (row  = 5 a 0)
    for (int row = 5; row >= 0; row--) {
        if (grid[z][row] == ' ') { // Si la celda esta vac
            // Colocamos el simbolo actual en la celda
            grid[z][row] = currentSymbol;


            // Cambiamos el simbolo actual para el siguiente jugador
            currentSymbol = (currentSymbol == 'X') ? 'O' : 'X';

            return true ; // Movimiento ya hecho
        }  
    }

    return false; // Columna llena
    }

    // Metodo isGameOver, para verificar si el juego ha terminado (Ganador o empate)
    public char isGameOver() {
        // Horizontal →
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col <= 3; col++) {
                char symbol = grid[col][row];
                if (symbol != ' ' && symbol == grid[col+1][row] && symbol == grid[col+2][row] && symbol == grid[col+3][row]) {
                    return symbol;
                }
            }
        }
        /*
        → Horizontal
        X X X X
        */

        // Vertical ↓
        for (int col = 0; col < 7; col++) {
            for (int row = 0; row <= 2; row++) {
                char symbol = grid[col][row];
                if (symbol != ' ' &&
                    symbol == grid[col][row+1] && symbol == grid[col][row+2] && symbol == grid[col][row+3]) {
                    return symbol;
                }
            }
        }
        /*
        ↓ Vertical
        X
        X
        X
        X
        */

        // Diagonal ↘
        for (int col = 0; col <= 3; col++) {
            for (int row = 0; row <= 2; row++) {
                char symbol = grid[col][row];
                if (symbol != ' ' && symbol == grid[col+1][row+1] && symbol == grid[col+2][row+2] && symbol == grid[col+3][row+3]) {
                    return symbol;
                }
            }
        }
        /*
        ↘ Diagonal
        X
          X
            X
              X
        */

        // Diagonal ↗
        for (int col = 0; col <= 3; col++) {
            for (int row = 3; row <= 5; row++) {
                char symbol = grid[col][row];
                if (symbol != ' ' &&
                    symbol == grid[col+1][row-1] &&  symbol == grid[col+2][row-2] && symbol == grid[col+3][row-3]) {
                    return symbol;
                }
            }
        }
        /*
        ↗ Diagonal
      X
        X
          X
            X
        */

        // Empate
        boolean full = true;
        for (int col = 0; col < 7; col++) {
            for (int row = 0; row < 6; row++) {
                if (grid[col][row] == ' ') {
                    full = false;
                    break;
                }
            }
        }

        if (full) return 'D'; // Empate
        return ' '; // Juego no ha terminado
    }
}

