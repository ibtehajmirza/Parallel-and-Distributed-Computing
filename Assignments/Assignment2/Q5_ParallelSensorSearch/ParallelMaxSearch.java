public class ParallelMaxSearch extends SensorSearchEngine {
    private double maxVal = Double.MIN_VALUE;

    public ParallelMaxSearch(double[] sensorData, int startIdx, int endIdx) {
        super(sensorData, startIdx, endIdx);
    }

    public double getMaxVal() {
        return maxVal;
    }
}