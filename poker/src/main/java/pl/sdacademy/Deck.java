package pl.sdacademy;

import java.util.*;
import java.util.stream.Collectors;

public class Deck {
    private Set<Card> cards = new HashSet<>();

    public Deck() {
    }

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }

    public Card addRandomCard(){
        Card randomCard;
        do {
            int pickColor = new Random().nextInt(Color.values().length);
            int pickSymbol = new Random().nextInt(Symbol.values().length);
            randomCard = new Card(Color.values()[pickColor], Symbol.values()[pickSymbol]);
        } while (cards.contains(randomCard));
        return randomCard;
    }
    public void addRandomHand(){
        Set<Card> cardsOnHand = new HashSet<>();
        for (int i = 0; i < 5; i++) cardsOnHand.add(addRandomCard());
        this.setCards(cardsOnHand);
    }

    public boolean hasThree(){
        boolean result = false;
        for (Symbol symbol : Symbol.values()) {
            List<Card> myCards = cards.stream().filter(card -> card.getSymbol().equals(symbol)).collect(Collectors.toList());
            if(myCards.size() >= 3) result = true;
        }
        return result;
    }
    public void removeCardsFromDeck(){
        cards.clear();
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + cards +
                '}';
    }
}
