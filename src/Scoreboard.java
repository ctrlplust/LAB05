public class Scoreboard {
    private BST wintree; // Arbol de busqueda binaria para almacenar los jugadores y sus victorias
    private HashST<String,Player> players; // Tabla para almacenar nombre del jugador y el objeto player
    private int playedgames; //  Numero de partidas jugadas


    public Scoreboard() {
        this.wintree = new BST();
        this.players = new HashST<>();
        this.playedgames = 0;
    }

    // Metodo para agregar un jugador al Scoreboard, Este jugador se agrega SOLO si no existe previamente

    public void registerOkayter(String playername) {
        if (!players.contains(playername)) {
            Player newPlayer = new Player(playername);
            players.put(playername, newPlayer);
            wintree.insert(0, playername); // Empieza con 0 victorias
        }
    }
    public boolean checkPlayer(String playername) {
        return player.get(playername) != null; // Verifica si el jugador existe en la tabla (True o false)
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
}