public class PacketSymmetryAuditor {
    public static void main(String[] args) {
        String[] testPackets = {"RADAR", "GATEWAY", "1001001", "ABCDBCA"};
        System.out.println("=== Zero-Trust Packet Symmetry Auditor ===\n");

        for (String packet : testPackets) {
            verifyPacket(packet);
        }
    }

    public static void verifyPacket(String packet) {
        int len = packet.length();
        TransactionStack stack = new TransactionStack(len);
        RequestQueue queue = new RequestQueue(len);

        for (int i = 0; i < len; i++) {
            char ch = packet.charAt(i);

            if (!queue.isFull()) {
                queue.enqueue(ch);
            }

            if (!stack.isFull()) {
                stack.push(ch);
            }
        }

        boolean isSymmetric = true;
        while (!stack.isEmpty() && !queue.isEmpty()) {
            char fromStack = stack.pop();
            char fromQueue = queue.dequeue();
            if (fromStack != fromQueue) {
                isSymmetric = false;
                break;
            }
        }

        System.out.println("Payload: \"" + packet + "\" -> Bi-Directional Symmetry: " 
                + (isSymmetric ? "VERIFIED (Palindrome)" : "REJECTED (Asymmetric)"));
                
    }
}
