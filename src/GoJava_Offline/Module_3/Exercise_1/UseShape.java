package GoJava_Offline.Module_3.Exercise_1;

import java.util.ArrayList;
import java.util.List;

public class UseShape {

    public static void main(String[] args) {
     Shape rectangle1 = new Rectangle(1,5);
     Shape rectangle2 = new Rectangle(1,5);
     Shape rectangle3 = new Rectangle(1,5);

     Shape square1 = new Square(5);
     Shape square2 = new Square(34);
     Shape square3 = new Square(3);

     Shape circle1 = new Circle(3);
     Shape circle2 = new Circle(10);
     Shape circle3 = new Circle(20);

        Group ListOfShapes = new Group();
        ListOfShapes.add(circle1);
        ListOfShapes.add(circle2);
        ListOfShapes.add(circle3);
        ListOfShapes.add(square1);
        ListOfShapes.add(square2);
        ListOfShapes.add(square3);

        for (Shape shape:ListOfShapes){
            System.out.println(shape.getArea());
        }
        System.out.println("Min area : " + ListOfShapes.getMinArea());
    }
}
