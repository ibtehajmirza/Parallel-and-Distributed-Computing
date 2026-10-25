public class ParallelMaxSearch extends SensorSearchEngine {
    private double maxVal = Double.MIN_VALUE;

    public ParallelMaxSearch(double[] sensorData, int startIdx, int endIdx) {
        super(sensorData, startIdx, endIdx);
    }

    @Override
    public void processGrid() {
        for (int i = startIdx; i < endIdx; i++) {
            if (sensorData[i] > maxVal) {
                maxVal = sensorData[i];
            }
        }
    }

    public double getMaxVal() {
        return maxVal;
    }
}