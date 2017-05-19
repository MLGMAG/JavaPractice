package GoJava_Offline.Module_3.Exercise_1;

import java.util.ArrayList;
import java.util.List;

public class Group extends ArrayList<Shape> {
    List<Shape> ListOfShapes = new ArrayList<>();

    double getMinArea(){
        if(ListOfShapes.isEmpty()){

        }
        double minArea = Double.MAX_VALUE;
        for (Shape shape: ListOfShapes) {
            minArea=shape.getArea();
        }
        return minArea;
    }
}
