package miner;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class Gold extends Thing {
    public static final int CAT_SPEED = 2;
    private Point2D velocity;
    protected final Ellipse coin;


    public Gold(Point2D center) {
        super(center);
        double angle = Math.random() * 2 * Math.PI;
        velocity = new Point2D(CAT_SPEED*Math.cos(angle),CAT_SPEED*Math.sin(angle));
        coin = createEllipse(10,10);
        coin.setFill(Color.YELLOW);
        coin.setLayoutX(center.getX());
        coin.setLayoutY(center.getY());
    }

}
