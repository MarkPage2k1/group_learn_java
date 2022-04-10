import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class problem1 {
    public static void main(String[] args) {
        int n = getPositiveIntegerFromKeyboard("Enter the number of elements: ");
        ArrayList<Integer> list = getIntegerDataForArray(n);

        System.out.println("========================");
        System.out.println("Sum elements of array is " + sumOfIntegerElementsOfArray(list));
        System.out.println("Sum of first and last elements of array is " + (list.get(0) + list.get(list.size() - 1)));
    }

    private static int getIntegerDataFromKeyboard(String message) {
        while (true){
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print(message);
                int number = scanner.nextInt();
                return number;
            } catch (InputMismatchException e) {
                System.out.println("The data you entered is not valid!!!");
            } catch (Exception e) {
                System.out.println("ERROR!!!");
            }
        }
    } 
    
    private static int getPositiveIntegerFromKeyboard(String message) {
        while (true){
            int number = getIntegerDataFromKeyboard(message);
            if (number > 0) {
                return number;
            } else {
                System.out.println("The number of elements of the array must be greater than 0 !!!");
            }
        }
    }

    private static ArrayList<Integer> getIntegerDataForArray(int length) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int tmp;

        for (int i = 0; i < length; i++) {
            tmp = getIntegerDataFromKeyboard("Enter the number of elements " + i + ": ");
            list.add(tmp);   
        }
        return list;
    }

    private static long sumOfIntegerElementsOfArray(ArrayList<Integer> list) {
        long sum = 0;
        int length = list.size();

        for (int i = 0; i < length; i++) {
            sum += list.get(i);
        }
        return sum;
    }
}