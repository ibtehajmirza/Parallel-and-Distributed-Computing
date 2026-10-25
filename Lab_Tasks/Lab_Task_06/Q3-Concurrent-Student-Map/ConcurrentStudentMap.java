import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentStudentMap {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        int threadCount = 5;
        int recordsPerThread = 1000;
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < threadCount; i++) {
            final int threadId = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    int start = (threadId * recordsPerThread) + 1;
                    int end = start + recordsPerThread;

                    for (int j = start; j < end; j++) {
                        map.put("Student_" + j, 80);
                    }

                    for (int j = start; j < end; j++) {
                        Integer marks = map.get("Student_" + j);
                    }
                }
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        int expectedEntries = threadCount * recordsPerThread;
        System.out.println("Number of threads     : " + threadCount);
        System.out.println("Expected entries      : " + expectedEntries);
        System.out.println("Actual entries in map : " + map.size());
        System.out.println("Total execution time  : " + executionTime + " ms");
    }
}