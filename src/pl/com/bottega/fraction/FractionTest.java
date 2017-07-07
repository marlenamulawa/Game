package pl.com.bottega.fraction;

public class FractionTest {

    public static void main(String[] args) {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(3, 4);

        Fraction add = fraction1.add(fraction2);
        System.out.println(fraction1 + " + " + fraction2 + " = " + add);
        Fraction subs = fraction1.substract(fraction2);
        System.out.println(fraction1 + " - " + fraction2 + " = " + subs);
        Fraction mult = fraction1.multiple(fraction2);
        System.out.println(fraction1 + " * " + fraction2 + " = " + mult);
        Fraction div = fraction1.divide(fraction2);
        System.out.println(fraction1 + " / " + fraction2 + " = " + div);
        Fraction inv = fraction1.inverse();
        System.out.println(fraction1 + " inverse  = " + inv);
    }
}
