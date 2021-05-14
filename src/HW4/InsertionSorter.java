package HW4;

public class InsertionSorter extends Sorter {

    public InsertionSorter(double[] list) {
        super(list);
    }

    @Override
    public void sort() {
        double[] doubleArray = super.list;

        double tempValue;

        for(int j, i = 1; i < doubleArray.length; i++){
            j = i;

            while ( j > 0 &&  doubleArray[j - 1] > doubleArray[j] ){
                tempValue = doubleArray[j];
                doubleArray[j] = doubleArray[j - 1];
                doubleArray[j - 1] = tempValue;
                j--;
            }
        }
    }

    @Override
    public String getAlgorithmName() {
        return "Insertion";
    }
}
