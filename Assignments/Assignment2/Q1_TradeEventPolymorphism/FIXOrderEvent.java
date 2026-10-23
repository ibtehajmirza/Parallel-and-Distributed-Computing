public class FIXOrderEvent extends TradeEvent {
    private String clOrdId;

    public FIXOrderEvent(String senderId, long timestamp, double basePrice, String clOrdId) {
        super(senderId, timestamp, basePrice);
        this.clOrdId = clOrdId;
    }

    @Override
    public void dispatch() {
        double fee = basePrice * 0.0015;
        double totalCost = basePrice + fee;
        System.out.println("[FIXOrderEvent] Executing Stock Purchase:");
        System.out.println("  Client Order ID: " + clOrdId);
        System.out.println("  Sender ID: " + senderId);
        System.out.println("  Base Price: $" + String.format("%.2f", basePrice));
        System.out.println("  Transaction Fee (0.15%): $" + String.format("%.4f", fee));
        System.out.println("  Total Execution Cost: $" + String.format("%.2f", totalCost));
    }
}