import java.util.Random;

public class SensorGridMonitorApp {
    public static void main(String[] args) throws InterruptedException {
        int dataSize = 50000;
        double[] telemetry = new double[dataSize];
        Random rand = new Random(100);

        for (int i = 0; i < dataSize; i++) {
            telemetry[i] = 10.0 + (rand.nextDouble() * 90.0);
        }
    }
}