package HW4.decoration;

public class NumberOfChars {
    //This array will hold the number of chars of each element in the given input array.
    private final int[] numberOfChars;
    // This field will hold the greatest number of char.
    private int greatestNumberOfChar = 0;

    public NumberOfChars(double[] inputArray) {
        numberOfChars = new int[inputArray.length];

        calculateNumberOfChars(inputArray);
    }

    private void calculateNumberOfChars(double[] inputArray) {

        String stringSingleInput;

        for (int i = 0; i < inputArray.length; i++) {
            stringSingleInput = String.valueOf(inputArray[i]);
            numberOfChars[i] = stringSingleInput.length();

            if (numberOfChars[i] > greatestNumberOfChar) {
                greatestNumberOfChar = numberOfChars[i];
            }
        }
    }

    public int[] getNumberOfChars() {
        return numberOfChars;
    }

    public int getGreatestNumberOfChar() {
        return greatestNumberOfChar;
    }
}
