package bla;

class Fraction {

    static int count = 0;

    protected int numerator; //числитель
    public int denominator; //знаменатель

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        count += 1;
        return numerator + "/" + denominator;
    }

    public Fraction(int numerator, int denominator) throws Exception {
        System.out.println("constructor 1");
        if (denominator == 0)
            throw new Exception("Деление на ноль - это очень плохо");
        this.numerator = numerator;
        this.denominator = denominator;
        normalization();
    }

    Fraction(int numerator) throws Exception {
        this(numerator, 1);
        System.out.println("constructor 2");
    }

    public void normalization() {
        int nod = nod(numerator, denominator);
        numerator /= nod;
        denominator /= nod;
    }

    private int nod(int a, int b) {
        do {
            if (a > b) a %= b;
            else b %= a;
        } while (a != 0 && b != 0);
        return a + b;
    }
}
