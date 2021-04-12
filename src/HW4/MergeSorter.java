package HW4;

public class MergeSorter extends Sorter {

    public MergeSorter(double[] list) {
        super(list);
    }

    @Override
    public void sort() {
        double[] doubleArray = super.list;

        mergeSort(doubleArray);
    }

    // Recursive function to sort an array of integers.
    private void mergeSort(double[] doubleArray) {
        double[] partLeft, partRight;

        if (doubleArray.length < 2) return; // base condition. If the array has less than two element, do nothing.

        int midPoint, i;

        midPoint = doubleArray.length / 2;  // find the mid index.
        // create left and right sub arrays
        // mid elements (from index 0 till mid-1) should be part of left sub-array
        // and (n-mid) elements (from mid to n-1) will be part of right sub-array
        partLeft = new double[midPoint];
        partRight = new double[doubleArray.length - midPoint];

        for(i = 0; i < midPoint; i++)
            partLeft[i] = doubleArray[i]; // creating left sub array
        for(i = midPoint; i < doubleArray.length; i++)
            partRight[i - midPoint] = doubleArray[i]; // creating right sub array

        mergeSort(partLeft);  // sorting the left sub array
        mergeSort(partRight);  // sorting the right sub array
        merge(doubleArray, partLeft, partRight);  // Merging partLeft and partRight into doubleArray as sorted list.
    }

    private void merge(double[] doubleArray, double[] partLeft, double[] partRight) {
        int i,j,k;

        // i - to mark the index of left sub-array (L)
        // j - to mark the index of right sub-array (R)
        // k - to mark the index of merged sub-array (A)
        i = 0; j = 0; k =0;

        while(i < partLeft.length && j < partRight.length) {
            if(partLeft[i]  < partRight[j]) doubleArray[k++] = partLeft[i++];
            else doubleArray[k++] = partRight[j++];
        }

        while(i < partLeft.length)
            doubleArray[k++] = partLeft[i++];
        while(j < partRight.length)
            doubleArray[k++] = partRight[j++];
    }


}