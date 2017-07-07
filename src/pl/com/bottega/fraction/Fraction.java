package pl.com.bottega.fraction;

public final class Fraction {
    private final long numerator;
    private final long denominator;

    public Fraction(long numerator, long denominator) {
        if (denominator == 0) {
            System.out.println("Division by zero.");
            throw new RuntimeException("Division by 0");
        }
//        if (denominator < 0) {
//            denominator = (-1) * denominator;
//            numerator = (-1) * numerator;
//        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction add(Fraction addend) {
        long numerator = this.numerator * (addend.denominator) + (denominator * (addend.numerator));
        long denominator = this.denominator * (addend.denominator);
        return new Fraction(numerator, denominator);
    }

    public Fraction substract(Fraction subtrahend) {
        long numerator = this.numerator * (subtrahend.denominator) - (denominator * (subtrahend.numerator));
        long denominator = this.denominator * (subtrahend.denominator);
        return new Fraction(numerator, denominator);
    }

    public Fraction multiple(Fraction multiplicand) {
        long numerator = this.numerator * multiplicand.numerator;
        long denominator = this.denominator * multiplicand.denominator;
        return new Fraction(numerator, denominator);
    }

    public Fraction inverse() {
        if (numerator == 0) {
            System.out.println("No inverse for zero.");
            throw new RuntimeException("Division by 0");
        }
        return new Fraction(denominator, numerator);
    }

    public Fraction divide(Fraction divider) {
        return this.multiple(divider.inverse());
    }

    public int getIntegerPart() {
        return (int) (numerator / denominator);
    }

    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }

    public String toString() {
        return this.getNumerator() + "/" + this.getDenominator();
    }
}
