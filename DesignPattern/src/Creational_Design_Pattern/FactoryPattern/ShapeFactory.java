package Creational_Design_Pattern.FactoryPattern;

public class ShapeFactory {

    Shape getShape(String input) {

        switch (input) {
            case "CIRCLE":
                return new Circle();
            case "RECTANGLE":
                return new Rectangle();
            case "SQUARE":
                return new Square();
            default:
                return null;
        }
    }
}
