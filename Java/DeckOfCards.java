public class DeckOfCards {
    public class Card {
        public String suit;
        public String value;
    }

    public class Deck {
        Card[] cards;
        public void shuffle() {}
        public Card takeFromTop() {}
        public Card takeFromBottom() {}
        public Deck() {
            cards = new Card[52];
        }
    }
    
    public static void main(String[] agrs) {

    }
}
