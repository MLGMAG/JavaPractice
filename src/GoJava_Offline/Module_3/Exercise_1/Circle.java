package GoJava_Offline.Module_3.Exercise_1;

public class Circle extends Shape {

    private double r;

    public Circle(int r) {
        this.r = r;
    }

    @Override
    double getArea() {
        return Math.PI * r * r;
    }

}
