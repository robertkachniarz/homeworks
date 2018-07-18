package pl.sdacademy;

import java.util.*;
import java.util.function.Function;

public class PokerGame {
    private Map<String, Deck> players = new HashMap<>();


    int roundNumber = 1;
    public void nextRound(){
        System.out.println("Runda " + roundNumber);

        players.put("Player 0", new Deck());
        players.put("Player 1", new Deck());
        players.put("Player 2", new Deck());
        players.put("Player 3", new Deck());

        players.forEach((p, h) -> h.addRandomHand());
        players.forEach((p, h) -> System.out.println(h.getCards().toString()));

        Map<String,Boolean> whoHasThree = new HashMap<>();
        players.forEach((p, d) -> whoHasThree.put(p, d.hasThree()));
        System.out.println(whoHasThree.values().toString());

        int howManyPlayersHasThree = 0;
        String whoWin = null;
        for (String key : whoHasThree.keySet()){
            if(whoHasThree.get(key).equals(true)) {
                howManyPlayersHasThree++;
                whoWin = key;
            }
        }
        System.out.println(howManyPlayersHasThree);
        if(howManyPlayersHasThree == 0) {
            System.out.println("Nikt nie miał trójki. Remis! Następna runda!");
            System.out.println();
            System.out.println("=============================================================");
            System.out.println();
            roundNumber++;
            nextRound();
        }
        else if (howManyPlayersHasThree == 1){
            System.out.println("Wygrał: " +whoWin);
        }
        else {
            System.out.println("Kilku graczy miało trójkę. Remis! Następna runda!");
            System.out.println();
            System.out.println("=============================================================");
            System.out.println();
            roundNumber++;
            nextRound();
        }


    }
}
