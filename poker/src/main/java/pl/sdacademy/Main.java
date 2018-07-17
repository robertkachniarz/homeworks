package pl.sdacademy;

public class Main {
    public static void main(String[] args) {
        Deck myDeck = new Deck();
        Card myCard = new Card(Color.KARO, Symbol.ACE);

        for(int j = 0; j < 100; j++) {
            for (int i = 0; i < 5; i++) myDeck.addRandomCard();

            System.out.print(myDeck.toString());
            System.out.println(" " + myDeck.hasThree());
            myDeck.removeCardsFromDeck();
        }
    }
}
