public class AsyncWebEngineApp {
    public static void main(String[] args) {
        System.out.println("Initial thread: " + Thread.currentThread().getName());

        TelemetryThread telemetry = new TelemetryThread("Telemetry-Worker");
        Thread logWorker = new Thread(new LogProcessorTask(), "Log-Worker");

        telemetry.start();
        logWorker.start();

        System.out.println("Thread started: " + telemetry.getName() + " | State: " + telemetry.getState());
        System.out.println("Thread started: " + logWorker.getName() + " | State: " + logWorker.getState());

        try {
            telemetry.join();
            logWorker.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted Main thread.");
        }

        System.out.println("All diagnostic tasks cleanly shut down.");
    }
}
