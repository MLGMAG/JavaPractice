package GoJava_Offline.Module_3.Exercise_1;

public class Rectangle extends Shape {
    private int a;
    private int b;

    public  Rectangle(int a,int b){
        this.a = a;
        this.b = b;
    }

    @Override
    double getArea() {
        return a * b;
    }
}
