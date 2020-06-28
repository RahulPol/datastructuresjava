package Recursion;

public class Recursion {

    /**
     * Calculate factorial value of given number Eg. 4! = 24, 5!=120
     * 
     * @param n number for which factorial needs to be calculated
     */
    static double factorial(int n) {
        if (n <= 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    /**
     * Fibonacci series value at nth position
     * 
     * @param n nth value of fibonacci series
     */
    static int fibonacci(int n) {
        // 0 1 1 2 3 5 ...
        if (n <= 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        // The function calculate the factorial value of given number.
        System.out.println(factorial(4));

        // The function calculate fibonacci value at given position
        System.out.println(fibonacci(4));

    }

}