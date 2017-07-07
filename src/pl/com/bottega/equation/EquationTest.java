package pl.com.bottega.equation;

import java.util.Scanner;

public class EquationTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Given quadratic equation:ax^2 + bx + c");
        System.out.print("Insert value for a: ");
        double a = scanner.nextDouble();
        System.out.print("Insert value for b: ");
        double b = scanner.nextDouble();
        System.out.print("Insert value for c: ");
        double c = scanner.nextDouble();
        System.out.println("Given quadratic equation: " + a + "x^2 + " + b + "x + " + c);
        scanner.nextLine();
        scanner.close();

        Equation equation = new Equation(a, b, c);
        double[] roots = equation.rootsCalculator();
        if (roots == null) {
            System.out.println("Roots don't exist");
        } else if (roots.length == 2) {
            System.out.println("Equation has two real roots: " + roots[0] + "," + roots[1]);
        } else if (roots.length == 1) {
            System.out.println("Equation has one real root " + roots[0]);
        }

        double[] extremaCoordinates = equation.extremaCalculator();

        if (a > 0) {
            System.out.println("Maximum value of function for argument x=" + extremaCoordinates[0] +
                    " is: " + extremaCoordinates[1]);
        } else
            System.out.println("Minimum value of function for argument x=" + extremaCoordinates[0] +
                    " is: " + extremaCoordinates[1]);
    }
}



