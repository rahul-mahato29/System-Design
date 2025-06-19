package Creational_Design_Pattern.FactoryPattern;

public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        //shapeObj = will hold rectangle object.
        Shape shapeObj1 = shapeFactory.getShape("RECTANGLE");

        //using rectangle object, calling method present inside the rectangle class.
        shapeObj1.draw();

        Shape shapeObj2 = shapeFactory.getShape("CIRCLE");
        shapeObj2.draw();
    }
}
