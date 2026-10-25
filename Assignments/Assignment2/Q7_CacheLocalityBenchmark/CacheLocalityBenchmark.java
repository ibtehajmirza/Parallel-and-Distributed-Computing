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
     }
}