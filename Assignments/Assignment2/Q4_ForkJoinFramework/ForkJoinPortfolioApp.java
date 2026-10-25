import java.util.concurrent.ForkJoinPool;
import java.util.Random;

public class ForkJoinPortfolioApp {
    public static void main(String[] args) {
        int size = 10000;
        double[] assets = new double[size];
        Random rand = new Random(42);

        for (int i = 0; i < size; i++) {
            assets[i] = 100.0 + (rand.nextDouble() * 900.0);
        }

        ForkJoinPool pool = new ForkJoinPool();

        long startCalc = System.nanoTime();
        ParallelRiskCalculator initialCalc = new ParallelRiskCalculator(assets, 0, size);
        double totalRiskBefore = pool.invoke(initialCalc);
        long endCalc = System.nanoTime();

        long startAction = System.nanoTime();
        PortfolioThresholdTask stressTest = new PortfolioThresholdTask(assets, 0, size, 700.0);
        pool.invoke(stressTest);
        long endAction = System.nanoTime();

        ParallelRiskCalculator postCalc = new ParallelRiskCalculator(assets, 0, size);
        double totalRiskAfter = pool.invoke(postCalc);

        System.out.println("=== Parallel Portfolio Assessment Results ===");
        System.out.printf("Initial Total Risk Score: $%.2f%n", totalRiskBefore);
        System.out.printf("Post Stress-Test Risk Score: $%.2f%n", totalRiskAfter);
        System.out.printf("Risk Calculation Time: %.3f ms%n", (endCalc - startCalc) / 1e6);
        System.out.printf("Stress-Test In-Place Adjustment Time: %.3f ms%n", (endAction - startAction) / 1e6);
    }
}