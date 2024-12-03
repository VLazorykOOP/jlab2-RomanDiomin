public class Prism {
    private double sideLength;
    private double height;

    public Prism(double sideLength, double height) {
        if (sideLength <= 0 || height <= 0) {
            throw new IllegalArgumentException("Сторона трикутника і висота мають бути більше нуля.");
        }
        this.sideLength = sideLength;
        this.height = height;
    }

    public double calculateBaseArea() {
        return (Math.sqrt(3) / 4) * Math.pow(sideLength, 2);
    }

    public double calculateLateralSurfaceArea() {
        return 3 * sideLength * height;
    }

    public double calculateVolume() {
        return calculateBaseArea() * height;
    }

    public double getSideLength() {
        return sideLength;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Призма:\n" +
                "Сторона трикутника: " + sideLength + "\n" +
                "Висота: " + height + "\n" +
                "Площа основи: " + calculateBaseArea() + "\n" +
                "Площа бічної поверхні: " + calculateLateralSurfaceArea() + "\n" +
                "Об'єм: " + calculateVolume();
    }

    public static void main(String[] args) {
        try {
            Prism prism = new Prism(5, 10);

            System.out.println(prism);
        } catch (IllegalArgumentException e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }
}
