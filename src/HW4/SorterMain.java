package HW4;

import HW4.decoration.CheckerBoardDecorator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SorterMain {
    private static final int PRINT_LIMIT = 100;
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        boolean repeatMain = true;
        while (repeatMain) {

            System.out.println("\nPlease select the operation you want to do:\n" +
                    "1-)Insertion Sort\n" +
                    "2-)Merge Sort\n" +
                    "3-)Quick Sort\n" +
                    "4-)Comparison Test\n" +
                    "5-)Exit");

            String operation = scan.nextLine();

            // Initially check if user wants to quit.
            if (operation.equals("5")) {

                repeatMain = false;

            } else if (operation.equals("4")) {

                int[] differentArraySizes = {10, 20, 30, 100, 1000, 2000, 4000, 6000, 8000, 10000, 100000, 1000000, 10000000};

                for (int arraySize : differentArraySizes) {

                    // If we use the same random double array for all sorters, we will sort the same random array.
                    // That means after first sorting (merge sort) we will already have a sorted list to use in other sorter algorithms.
                    // We need different double[] objects with the same data. We need to clone the object.
                    // Otherwise we will only copy the reference of the same double[] object.

                    // We need to use exactly same array to compare different algorithms,
                    // If we create different random arrays, the execution time did not differ noticeably in this case ,
                    // but still it would not be a full comparison.
                    double[] firstArray = createRandomArray(arraySize);
                    double[] secondArray = firstArray.clone();
                    double[] thirdArray = firstArray.clone();


                    Sorter mergeSorter = new MergeSorter(firstArray);
                    Sorter insertionSorter = new InsertionSorter(secondArray);
                    Sorter quickSorter = new QuickSorter(thirdArray);

                    System.out.println("\n\nArray size: " + arraySize + "\n");
                    sortAnalyzer(insertionSorter);
                    sortAnalyzer(mergeSorter);
                    sortAnalyzer(quickSorter);
                }

            } else {

                if (operation.equals("1") || operation.equals("2") || operation.equals("3")) {
                    System.out.println("\nPlease enter the value you want to sort:\n" +
                            "Press 'q' to sorting.");

                    // Add numbers in list to sort.
                    ArrayList<Double> list = new ArrayList<>();

                    boolean controller = true;
                    while (controller) {
                        String inputString = checkDouble();
                        if (!inputString.equals("q")) {
                            double number = Double.parseDouble(inputString);
                            list.add(number);
                        } else {
                            controller = false;
                        }
                    }

                    double[] doubleArray = convertToArray(list);
                    list.clear();

                    Sorter sorter;

                    if (operation.equals("1")) {
                        sorter = new InsertionSorter(doubleArray);
                    } else if (operation.equals("2")) {
                        sorter = new MergeSorter(doubleArray);
                    } else {
                        sorter = new QuickSorter(doubleArray);
                    }

                    sorter.sort();

                    if (doubleArray.length > PRINT_LIMIT) {
                        System.out.println(Arrays.toString(sorter.getList()));
                    } else {
                        CheckerBoardDecorator.checkerBoard(sorter.getList());
                    }

                }  else {
                    System.out.println("Please enter the value between 1-4.");
                }
            }
        }
    }

    private static void sortAnalyzer(Sorter sorter) {
        // If array size is bigger then 10 thousand, we can not use Insertion sort anymore.
        if( !(sorter.getAlgorithmName().equals("Insertion") && sorter.getList().length > 100000) ) {
            final long startTime = System.nanoTime();
            sorter.sort();
            final long endTime = System.nanoTime();
            System.out.println(sorter.getAlgorithmName() + " sort execution time: "
                    + ((double) (endTime - startTime) / 1000000000));
        }
    }

    private static double[] createRandomArray(int arraySize) {
        double[] randomArray = new double[arraySize];
        Random rand = new Random();

        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = rand.nextDouble() * arraySize;
        }

        return randomArray;
    }

    private static String checkDouble() {
       return checkNumber();
    }

    private static String checkNumber() {
        String inputString = scan.nextLine();
        while (true) {
            try {
                if (inputString.equals("q")) {
                    break;
                }
                Double.parseDouble(inputString);
                break;
            } catch (Exception e) {

                System.out.println("Please enter a valid number.");

                inputString = scan.nextLine();
            }
        }
        return inputString;
    }

    private static double[] convertToArray(ArrayList<Double> list) {
        double[] doubleArray = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            doubleArray[i] = list.get(i);

        }
        return doubleArray;
    }
}
