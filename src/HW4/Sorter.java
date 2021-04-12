package HW4;

public abstract class Sorter {

    double[] list;

    public Sorter(double[] list) {
        this.list = list;
    }

    public abstract void sort();
}