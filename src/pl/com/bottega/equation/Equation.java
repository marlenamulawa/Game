package pl.com.bottega.equation;

public class Equation {
    private double a;
    private double b;
    private double c;

    public Equation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double[] rootsCalculator() {
        double delta = b * b - 4 * a * c;
        if (delta > 0) {
            double[] roots = new double[2];
            roots[0] = (-b + Math.sqrt(delta)) / (2 * a);
            roots[1] = (-b - Math.sqrt(delta)) / (2 * a);
            return roots;
        } else if (delta == 0) {
            double[] roots = new double[1];
            roots[0] = (-b + Math.sqrt(delta)) / (2 * a);
            return roots;
        } else {
            return null;
        }
    }

    public double[] extremaCalculator() {
        double[] extremaCoordinates = new double[2];
        extremaCoordinates[0] = -b / (2 * a);
        extremaCoordinates[1] = -(b * b - 4 * a * c) / (4 * a);
        return extremaCoordinates;
    }
}