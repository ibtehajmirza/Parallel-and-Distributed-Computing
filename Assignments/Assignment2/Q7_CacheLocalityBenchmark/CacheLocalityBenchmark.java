public class CacheLocalityBenchmark {
    private static final int N = 2000;
    private static final int ITERATIONS = 10;
    private static double[][] matrix = new double[N][N];

     public static void main(String[] args) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = 1.0;
            }
        }

        System.out.println("=== Cache Locality Traversal Benchmark (2000 x 2000 Matrix) ===");

        traverseRowMajor();
        traverseColumnMajor();

        long startRow = System.nanoTime();
        for (int it = 0; it < ITERATIONS; it++) {
            traverseRowMajor();
        }
        long endRow = System.nanoTime();
        double rowTotalMs = (endRow - startRow) / 1e6;
        double rowAvgMs = rowTotalMs / ITERATIONS;

        long startCol = System.nanoTime();
        for (int it = 0; it < ITERATIONS; it++) {
            traverseColumnMajor();
        }

        long endCol = System.nanoTime();
        double colTotalMs = (endCol - startCol) / 1e6;
        double colAvgMs = colTotalMs / ITERATIONS;

        double speedup = colAvgMs / rowAvgMs;

        System.out.printf("Row-Major Traversal Average Time:    %.3f ms%n", rowAvgMs);
        System.out.printf("Column-Major Traversal Average Time: %.3f ms%n", colAvgMs);
        System.out.printf("Speedup Ratio (Row over Column):     %.2fx%n", speedup);
     }

     public static double traverseRowMajor() {
        double sum = 0.0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public static double traverseColumnMajor() {
        double sum = 0.0;
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N; i++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}