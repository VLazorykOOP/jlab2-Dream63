public class Conus {
    private double radius;
    private double height;

    public Conus(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }
    
    public double SideSquareSize() {
        return Math.PI * radius * Math.sqrt(radius * radius + height + height);
    }
    public double Volume() {
        return 1/3 * Math.PI * radius * radius * height;
    }
    public void print() {
        System.err.println("Radius: " + radius + "\nHeight: " + height);
    }

    public static void main(String[] args) {
        Conus conus = new Conus(5, 10);

        conus.print();
        System.err.println("Volume: " + conus.Volume()); 
        System.err.println("Side Square Size: " + conus.SideSquareSize()); 

    }
}