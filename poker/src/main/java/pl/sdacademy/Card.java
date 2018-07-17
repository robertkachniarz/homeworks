package pl.sdacademy;

import java.util.Objects;

public class Card {
    private final Color color;
    private final Symbol symbol;

    public Card(Color color, Symbol symbol) {
        this.color = color;
        this.symbol = symbol;
    }

    public Color getColor() {
        return color;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return color + " " + symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return color == card.color &&
                symbol == card.symbol;
    }

    @Override
    public int hashCode() {

        return Objects.hash(color, symbol);
    }
}
