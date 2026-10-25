import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SynchronizedStudentMap {
    public static void main(String[] args) {
        Map<String, Integer> studentMap = Collections.synchronizedMap(new HashMap<>());

        int threadCount = 3;
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        for (int i = 0; i < threadCount; i++) {
            final int threadId = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    int start = (threadId * 100) + 1;
                    int end = start + 100;

                    for (int j = start; j < end; j++) {
                        studentMap.put("Student_" + j, 70);
                    }
                }
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int expectedEntries = threadCount * 100;
        System.out.println("Expected number of entries: " + expectedEntries);
        System.out.println("Actual number of entries  : " + studentMap.size());
    }
}