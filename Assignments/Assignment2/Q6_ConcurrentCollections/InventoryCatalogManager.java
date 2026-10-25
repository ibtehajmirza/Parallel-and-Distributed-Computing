import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryCatalogManager {
    private static final int NUM_THREADS = 10;
    private static final int OPS_PER_THREAD = 50000;
    private static final int TOTAL_OPS = NUM_THREADS * OPS_PER_THREAD;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Inventory Catalog Concurrency Benchmark ===\n");
        benchmarkSynchronizedMap();
        System.out.println();
        benchmarkConcurrentMap();
    }

    public static void benchmarkSynchronizedMap() throws InterruptedException {
        Map<String, Integer> syncMap = Collections.synchronizedMap(new HashMap<>());
        
        for (int i = 0; i < 100; i++) {
            syncMap.put("PROD_" + i, 1000);
        }

        Thread[] workers = new Thread[NUM_THREADS];
        long startTime = System.currentTimeMillis();

        
    }
}