public class Fraction extends FractionalComplex {
    public int real;
    public int imaginary;

    @Command(name = "Get real part",
            args = "",
            desc = "Returns real type type double")
    public double getReal() {
        return real;
    }
    @Command(name = "Get imaginary part",
            args = "",
            desc = "Returns imaginary type type double")
    public double getImaginary() {
        return imaginary;
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "real=" + real  +
                ", imaginary=" + imaginary +
                '}';
    }

    public Fraction(int real, int imaginary) {
        super(real, imaginary);
        this.real = real;
        this.imaginary = imaginary;
    }
}
