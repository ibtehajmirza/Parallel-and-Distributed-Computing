public class ParallelMinSearch extends SensorSearchEngine {
    private double minVal = Double.MAX_VALUE;

    public ParallelMinSearch(double[] sensorData, int startIdx, int endIdx) {
        super(sensorData, startIdx, endIdx);
    }

    @Override
    public void processGrid() {
        for (int i = startInd; i < endInd; i++) {
            if (sensorData[i] < minVal) {
                minVal = sensorData[i];
            }
        }
    }

    public double getMinVal() {
        return minVal;
    }
}