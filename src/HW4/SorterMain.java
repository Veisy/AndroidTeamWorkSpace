package HW4;

import HW4.decoration.CheckerBoardDecorator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SorterMain {
    private static final int PRINT_LIMIT = 100;
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        boolean repeatMain = true;
        while (repeatMain) {

            System.out.println("Please select the operation you want to do:\n" +
                    "1-)Insertion Sort\n" +
                    "2-)Merge Sort\n" +
                    "3-)Exit");

            String operation = scan.nextLine();

            // Initially check if user wants to quit.
            if (operation.equals("3")) {

                repeatMain = false;

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

                    Sorter sorter;

                    if (operation.equals("1")) {
                        sorter = new InsertionSorter(doubleArray);
                    } else {
                        sorter = new MergeSorter(doubleArray);
                    }

                    sorter.sort();

                    list.clear();

                    if (doubleArray.length > PRINT_LIMIT) {
                        System.out.println(Arrays.toString(doubleArray));
                    } else {
                        CheckerBoardDecorator.checkerBoard(doubleArray);
                    }


                }  else {
                    System.out.println("Please enter the value between 1-3.");
                }
            }
        }
    }

    private static String checkDouble() {
        String inputString = scan.nextLine();
        while (true) {
            try {
                if (inputString.equals("q")) {
                    break;
                }
                Double.parseDouble(inputString);
                break;
            } catch (Exception e) {
                System.out.println("Please enter a double number.");
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
