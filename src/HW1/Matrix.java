package HW1;

import java.util.ArrayList;

public class Matrix {

    String matrixName;

    ArrayList<ArrayList<Double>> matrix;

    int row;
    int column;

    public Matrix(String name) {
        //Default values
        matrixName = name;
        matrix = new ArrayList<>();
        row = 0;
        column = 0;
    }
}
