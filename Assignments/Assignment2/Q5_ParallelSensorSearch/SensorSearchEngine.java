public abstract class SensorSearchEngine implements Runnable {
    protected double[] sensorData;
    protected int startInd;
    protected int endInd;

    public SensorSearchEngine(double[] sensorData, int startInd, int endInd) {
        this.sensorData = sensorData;
        this.startInd = startInd;
        this.endInd = endInd;
    }

    public abstract void processGrid();

    @Override 
    public void run() {
        processGrid();
    }
}