package miner;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class MessHouse extends Thing {
    private Polygon house;
    private static final double SIZE = 50;
    public MessHouse(Point2D randomPoint) {
        super(randomPoint);
        house = new Polygon();
        house.getPoints().addAll(
                -SIZE,SIZE,
                SIZE,SIZE,
                SIZE,-SIZE,
                0.,-1.5*SIZE,
                -SIZE,-SIZE
        );
        house.setFill(Color.BROWN);
        house.setLayoutX(center.getX());
        house.setLayoutY(center.getY());
        FieldController.addChild(house);
    }
}
