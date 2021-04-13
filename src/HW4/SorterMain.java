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
                    "3-)Comparison Test\n" +
                    "4-)Exit");

            String operation = scan.nextLine();

            // Initially check if user wants to quit.
            if (operation.equals("4")) {

                repeatMain = false;

            } else if (operation.equals("3")) {

                System.out.println("Enter the array size: ");
                int arraySize = checkInt();
                System.out.println("Max value: ");
                int maxLimit = checkInt();

                double[] firstArray = createRandomArray(arraySize, maxLimit);
                double[] secondArray = firstArray.clone();

                Sorter mergeSorter = new MergeSorter(firstArray);
                Sorter insertionSorter = new InsertionSorter(secondArray);

                final long mergeStartTime = System.nanoTime();
                mergeSorter.sort();
                final long mergeEndTime = System.nanoTime();
                System.out.println(arraySize + " numbers from 0 to " + maxLimit + " are sorted.");
                System.out.println("Merge sort execution time: "
                        + ((double) (mergeEndTime - mergeStartTime) / 1000000000));

                final long insertionStartTime = System.nanoTime();
                insertionSorter.sort();
                final long insertionEndTime = System.nanoTime();
                System.out.println("Insertion sort execution time: "
                        + ((double) (insertionEndTime - insertionStartTime) / 1000000000));

            } else {

                if (operation.equals("1") || operation.equals("2")) {
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
                    } else {
                        sorter = new MergeSorter(doubleArray);
                    }

                    sorter.sort();

                    if (doubleArray.length > PRINT_LIMIT) {
                        System.out.println(Arrays.toString(sorter.list));
                    } else {
                        CheckerBoardDecorator.checkerBoard(sorter.list);
                    }

                }  else {
                    System.out.println("Please enter the value between 1-4.");
                }
            }
        }
    }

    private static double[] createRandomArray(int arraySize, int maxLimit) {
        double[] randomArray = new double[arraySize];
        Random rand = new Random();

        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = rand.nextDouble() * maxLimit;
        }

        return randomArray;
    }

    private static Integer checkInt() {
        return Integer.parseInt(checkNumber(1));
    }

    private static String checkDouble() {
       return checkNumber(2);
    }

    private static String checkNumber(int inputType) {
        String inputString = scan.nextLine();
        while (true) {
            try {
                if (inputString.equals("q")) {
                    break;
                }

                if (inputType == 1) {
                    Integer.parseInt(inputString);
                } else {
                    Double.parseDouble(inputString);
                }
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
