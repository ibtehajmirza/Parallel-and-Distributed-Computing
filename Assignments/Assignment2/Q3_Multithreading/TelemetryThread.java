public class TelemetryThread extends Thread {
    public TelemetryThread(String name) {
        super(name);
    }

    @Override 
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println("[" + getName() + "] Iteration " + i + ": Health Check -> CPU: OK | Memory: OK");

            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                System.out.println("TelemetryThread interrupted");
            }
        }
        System.out.println("[" + getName() + "] Completed.");
    }
}
