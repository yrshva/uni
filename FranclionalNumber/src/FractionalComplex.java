public class FractionalComplex{


    public FractionalComplex(double real, double imaginary) {

    }

    public FractionalComplex getFraction() {
        return null;
    }

    public void setFraction(double fraction) {

    }

    public void setFractionalComplex(double fractionalComplex) {

    }

    @Override
    public String toString() {
        return "Fractional Complex Number : "+ sum;
    }

    public double getResult(double x) {
        return 0;
    }

    public void setFractionalComplex() {

    }

    public void setFraction() {

    }
    
    public void setReal(String real) {
        this.sum = sum;
    }
    @Command(name = "Get fractional complex number sum",
            args = "",
            desc = "Returns  fractional complex number sum")
    public String getSum() {
        return String.valueOf(sum);
    }

    
    public FractionalComplex(String sum) {
        this.sum = sum;
    }

    public String sum;

}
