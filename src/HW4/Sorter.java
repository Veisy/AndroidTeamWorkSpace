package HW4;

public abstract class Sorter {

    private final double[] list;

    public Sorter(double[] list) {
        this.list = list;
    }

    public abstract void sort();
    public abstract String getAlgorithmName();

    public double[] getList() {
        return list;
    }
}