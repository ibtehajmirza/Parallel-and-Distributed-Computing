public class ReutersQuoteEvent extends TradeEvent {
    private double bidPrice;
    private double askPrice;

    public ReutersQuoteEvent(String senderId, long timestamp, double basePrice, double bidPrice, double askPrice) {
        super(senderId, timestamp, basePrice);
        this.bidPrice = bidPrice;
        this.askPrice = askPrice;
    }

    @Override
    public void dispatch() {
        double spread = askPrice - bidPrice;
        System.out.println("[ReutersQuoteEvent] Market Analytics:");
        System.out.println("  Feed Source: " + senderId);
        System.out.println("  Bid Price: $" + String.format("%.2f", bidPrice));
        System.out.println("  Ask Price: $" + String.format("%.2f", askPrice));
        System.out.println("  Bid-Ask Spread: $" + String.format("%.4f", spread));
    }
}