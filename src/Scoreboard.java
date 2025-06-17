import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
public class Scoreboard {
    private BST wintree; // Arbol de busqueda binaria para almacenar los jugadores y sus victorias
    private HashST<String,Player> players; // Tabla para almacenar nombre del jugador y el objeto player
    private int playedgames; //  Numero de partidas jugadas


    public Scoreboard() {
        this.wintree = new BST();
        this.players = new HashST<>();
        this.playedgames = 0;
    }

    public Player getPlayer(String playername) {
    return players.get(playername);
}

    // Metodo para agregar un jugador al Scoreboard, Este jugador se agrega SOLO si no existe previamente

    public void registerPlayer(String playername) {
        if (!players.contains(playername)) {
            Player newPlayer = new Player(playername);
            players.put(playername, newPlayer);
            wintree.insert(0, playername); // Empieza con 0 victorias
        }
    }
    public boolean checkPlayer(String playername) {
        return players.get(playername) != null; // Verifica si el jugador existe en la tabla (True o false)
    }

    public void addGameResult(String winnerPlayername, String loserPlayername, boolean isdraw) {
        registerPlayer (winnerPlayername);
        registerPlayer (loserPlayername);

        Player winner = players.get(winnerPlayername);
        Player loser = players.get(loserPlayername);

        if (isdraw) {
            winner.addDraw();
            loser.addDraw();
        } else {
            winner.addWin();
            loser.addLoss();
            wintree.insert(winner.getWins(), winnerPlayername); // Actualiza el arbol de busqueda binaria con las victorias del ganador
     }

     playedgames++;
    }

    public Player[] winRange(int lo,int hi) {
        // Desde el arbol BST, se obtiene todos los nombres de jugadores
        //que tiene una cantidad de victorias entre [lo,hi]
        List<String> playernames = wintree.getKeysInRange(lo, hi);
        List<Player> result = new ArrayList<>();
        for(String name : playernames) {
            Player p = players.get(name);
            if (p != null) {
                result.add(p);
            }
        }
        return result.toArray(new Player[0]);
    }
    
public Player[] winSuccessor(int wins) {
    // Buscar en el BST el sucesor del numero de victorias dado
    Integer successorWins = wintree.getSuccessorKey(wins);

    // si no hay sucesor, retornar un arreglo vacio
    if (successorWins == null) {
        return new Player[0];
    }

    List<String> playernames = wintree.getValuesByKey(successorWins);
    List<Player> result = new ArrayList<>();
    for (String name : playernames) {
        Player p = players.get(name);
        if (p != null) {
            result.add(p);
        }
    }
    return result.toArray(new Player[0]);
}
}