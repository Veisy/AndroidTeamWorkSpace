package HW4;

public class InsertionSorter extends Sorter {

    public InsertionSorter(double[] list) {
        super(list);
    }

    @Override
    public void sort() {
        double[] doubleArray = super.list;

        for (int i = 1; i < doubleArray.length; i++) {
            if (doubleArray[i] < doubleArray[i - 1]) {
                double newValue = doubleArray[i];
                doubleArray[i] = doubleArray[i - 1];
                doubleArray[i - 1] = newValue;

                while (i >= 2 && doubleArray[i - 1] < doubleArray[i - 2]) {
                    newValue = doubleArray[i - 1];
                    doubleArray[i - 1] = doubleArray[i - 2];
                    doubleArray[i - 2] = newValue;
                    i -= 1;
                }
            }
        }
    }
}
