import java.util.Random;

public class SensorGridMonitorApp {
    public static void main(String[] args) throws InterruptedException {
        int dataSize = 50000;
        double[] telemetry = new double[dataSize];
        Random rand = new Random(100);

        for (int i = 0; i < dataSize; i++) {
            telemetry[i] = 10.0 + (rand.nextDouble() * 90.0);
        }

        int numWorkers = 4;
        int chunkSize = dataSize / numWorkers;

        ParallelMinSearch[] minTasks = new ParallelMinSearch[numWorkers];
        ParallelMaxSearch[] maxTasks = new ParallelMaxSearch[numWorkers];
        Thread[] minThreads = new Thread[numWorkers];
        Thread[] maxThreads = new Thread[numWorkers];

        long startTime = System.nanoTime();

        for (int i = 0; i < numWorkers; i++) {
            int start = i * chunkSize;
            int end = (i == numWorkers - 1) ? dataSize : start + chunkSize;

            minTasks[i] = new ParallelMinSearch(telemetry, start, end);
            maxTasks[i] = new ParallelMaxSearch(telemetry, start, end);

            minThreads[i] = new Thread(minTasks[i]);
            maxThreads[i] = new Thread(maxTasks[i]);

            minThreads[i].start();
            maxThreads[i].start();
        }

        for (int i = 0; i < numWorkers; i++) {
            minThreads[i].join();
            maxThreads[i].join();
        }

        double globalMin = Double.MAX_VALUE;
        double globalMax = Double.MIN_VALUE;

        for (int i = 0; i < numWorkers; i++) {
            if (minTasks[i].getMinVal() < globalMin) {
                globalMin = minTasks[i].getMinVal();
            }
            if (maxTasks[i].getMaxVal() > globalMax) {
                globalMax = maxTasks[i].getMaxVal();
            }
        }

        long endTime = System.nanoTime();
        double executionTimeMs = (endTime - startTime) / 1e6;

        System.out.println("=== IoT Sensor Grid Parallel Search Summary ===");
        System.out.printf("Global Min Sensor Value: %.4f%n", globalMin);
        System.out.printf("Global Max Sensor Value: %.4f%n", globalMax);
        System.out.printf("Parallel Search Time across 4 Workers: %.3f ms%n", executionTimeMs);

    }
}