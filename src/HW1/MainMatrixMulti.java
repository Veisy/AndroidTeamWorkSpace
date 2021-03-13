package HW1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MainMatrixMulti {
    //Open system input resource
    private static final Scanner scan = new Scanner(System.in);

    // Create random object.
    private static final Random rand = new Random();

    public static void main(String[] args) {

        //Define and instantiate matrices
        Matrix firstMatrix = new Matrix("First Matrix"); // Create list for first matrix.
        Matrix secondMatrix = new Matrix("Second Matrix"); // Create list for second matrix.
        Matrix newMatrix = new Matrix("New Matrix"); // Create list for result matrix.

        while (true)
        {
            //Options
            System.out.println("Press 'w' for matrix multiplication\nPress 'e' for random matrix multiplication\nPress 'q' to finish."); // Determine which operator use.
            String operation = scan.nextLine();

            if(operation.equals("q")) {
                System.out.println("Process terminating...");
                break;
            } else if (operation.equals("w") || operation.equals("e")) {
                //Clear matrix inputs in each iteration
                firstMatrix.matrix.clear();
                secondMatrix.matrix.clear();
                newMatrix.matrix.clear();

                //Get matrix dimensions
                System.out.println("Please enter the first matrix row:");
                firstMatrix.row = getInt(); // Determine the first matrix row.
                System.out.println("Please enter the first matrix column:");
                firstMatrix.column = getInt(); // Determine the first matrix column.
                System.out.println("Please enter the second matrix row:");
                secondMatrix.row =  getInt(); // Determine the second matrix row.
                System.out.println("Please enter the second matrix column:"); // Determine the second matrix column.
                secondMatrix.column =  getInt();

                //Check if matrix multiplication is valid, if not don't make calculations and only print error message.
                if (!(firstMatrix.column == secondMatrix.row)) {
                    System.out.println("These matrices cannot be multiplied.\n"); // Error message.

                } else {
                    //We know the dimensions of new matrix
                    newMatrix.row = firstMatrix.row;
                    newMatrix.column = secondMatrix.column;

                    boolean isRandom;
                    //If operation is "w", isRandom is false.
                    //If operation is "e", isRandom is true.
                    isRandom = !operation.equals("w");

                    //Set matrices
                    setMatrix(firstMatrix,isRandom);
                    setMatrix(secondMatrix, isRandom);

                    //Calculate new matrix
                    newMatrix.matrix.addAll(calculateMatrixMulti(firstMatrix, secondMatrix));

                    //Print matrices
                    printMatrix(firstMatrix);
                    printMatrix(secondMatrix);
                    printMatrix(newMatrix);

                    System.out.println("\n");
                }

            } else {

                System.out.println("Please enter valid operation.\n"); // Error message.

            }

            //Just clear scan input
            scan.nextLine();
        }
    }

    //Take Integer inputs, and check if they are valid.
    private static int getInt() {
        while (!scan.hasNextInt())
        {
            System.out.println("Invalid input, Type Integer:");
            scan.next();
        }
        return scan.nextInt();
    }

    //Take Double inputs, and check if they are valid.
    private static Double getDouble() {
        while (!scan.hasNextDouble())
        {
            System.out.println("Invalid input, Type Double:");
            scan.next();
        }
        return scan.nextDouble();
    }

    //Get Matrix Inputs
    private static void setMatrix(Matrix inputMatrix, boolean isRandomMatrix) {

        for (int i = 0; i < inputMatrix.row; i++) { // Iterate the matrix row.

            ArrayList<Double> firstMatrixList = new ArrayList<>(); // Create temporary matrix list.
            double value;

            for (int j = 0; j < inputMatrix.column; j++) { // Iterate the matrix column.
                if(isRandomMatrix) {
                    value = rand.nextInt(100); // Randomly choose integer value between 0-100 for first matrix values.
                } else {
                    System.out.println("Enter the " + inputMatrix.matrixName + ": " + (i + 1) + ".row " + (j + 1) + ".column value:");
                    value = getDouble(); // Determine the value in first matrix.
                }

                firstMatrixList.add(value);
            }
            inputMatrix.matrix.add(firstMatrixList);
        }
    }

    //Calculate Matrix Multiplication
    private static ArrayList<ArrayList<Double>> calculateMatrixMulti(
            Matrix firstMatrix,
            Matrix secondMatrix) {

        ArrayList<ArrayList<Double>> calculatedMatrix = new ArrayList<>();

        for (int m = 0; m < firstMatrix.row; m++) { // Iterate the first matrix row.
            ArrayList<Double> new_matrix_list = new ArrayList<>(); // Create temporary result matrix list.
            for (int g = 0; g < secondMatrix.column; g++) { // Iterate the second matrix column.
                double resultMatrix = 0;
                for (int n = 0; n < secondMatrix.row; n++) { // Iterate the second matrix row.
                    resultMatrix += firstMatrix.matrix.get(m).get(n) * secondMatrix.matrix.get(n).get(g); // Matrix product.
                }
                new_matrix_list.add(resultMatrix);
            }
            calculatedMatrix.add(new_matrix_list);
        }
        return calculatedMatrix;
    }

    //Display Matrix
    private static void printMatrix(Matrix matrix) {
        System.out.println(matrix.matrixName);
        int length = matrix.matrix.size(); // Find the matrix length.
        for (int i = 0; i < length; i++) {
            System.out.println(matrix.matrix.get(i));
        }
    }

}
