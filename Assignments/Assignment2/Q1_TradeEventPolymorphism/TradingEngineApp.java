public class TradingEngineApp {
    public static void main(String[] args) {
        System.out.println("=== Trading Engine Application ===");

        long now = System.currentTimeMillis();

        TradeEvent event1 = new FIXOrderEvent("GATEWAY_FIX_01", now, 1500.00, "ORD-99823");
        TradeEvent event2 = new ReutersQuoteEvent("REUTERS_FEED_US", now, 250.00, 249.80, 250.25);
    }
}
