public class Main {

    public static void main(String[] args) {
        long[] rotatedArray = { 8, 4, 5, 6, 7 };

        int rotations = findRotations(rotatedArray, 0, rotatedArray.length - 1, rotatedArray.length);
        System.out.println(rotations);
    }

    public static int findRotations(long[] rotatedArray, int first, int last, int length) {
        int middleElement = (int) Math.floor((first + last) / 2);
        int previousElement = (length + (middleElement - 1)) % length;
        int nextElement = (middleElement + 1) % length;

        if (rotatedArray[middleElement] < rotatedArray[previousElement] && rotatedArray[middleElement] < rotatedArray[nextElement]) {
            return middleElement;
        } else if (rotatedArray[middleElement] > rotatedArray[last]) {
            return findRotations(rotatedArray, middleElement + 1, last, length);
        } else {
           return findRotations(rotatedArray, first, middleElement - 1, length);
        }
    }
}
