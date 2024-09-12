public class Complex {
    private double RealPart;
    private double ImaginaryPart;

    public Complex(double real, double imaginary) {
        this.RealPart = real;
        this.ImaginaryPart = imaginary;
    }

    public static  Complex Addition(Complex complex1, Complex complex2) {
        return new Complex(complex1.RealPart + complex2.RealPart, complex1.ImaginaryPart + complex2.ImaginaryPart);
    }
    public static Complex Deduction(Complex complex1, Complex complex2) {
        return new Complex(complex1.RealPart - complex2.RealPart, complex1.ImaginaryPart - complex2.ImaginaryPart);
    }
    public static Complex Multiplication(Complex complex1, Complex complex2) {
        return new Complex(complex1.RealPart * complex2.RealPart, complex1.ImaginaryPart * complex2.ImaginaryPart);
    }
    public static Complex Divisdion(Complex complex1, Complex complex2) {
        return new Complex(complex1.RealPart / complex2.RealPart, complex1.ImaginaryPart / complex2.ImaginaryPart);
    }
    public Complex Module() {
        return new Complex(Math.abs(RealPart), Math.abs(ImaginaryPart));
    }
    public double Argument() {
        return Math.tan(ImaginaryPart / RealPart);
    }
    public String print() {
        return "Real: " + RealPart + " Imaginary: " + ImaginaryPart;
    }

    public static void main(String[] args) {
        Complex complex = new Complex(2, 4);
        Complex complex1 = new Complex(2, 4);
        System.err.println("Addition: " + Complex.Addition(complex1, complex).print());
        System.err.println("Deduction: " + Complex.Deduction(complex1, complex).print());
        System.err.println("Multiplication: " + Complex.Multiplication(complex1, complex).print());
        System.err.println("Module: " + complex1.Module().print());
        System.err.println("Argument: " + complex1.Argument());
    }
    
}