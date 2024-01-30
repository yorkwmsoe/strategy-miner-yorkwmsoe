package miner;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public abstract class Thing {
    protected Point2D center;

    public Thing(Point2D centerPoint) {
        this.center = centerPoint;
    }

    protected Ellipse createEllipse(double radiusX, double radiusY) {
        final Ellipse ellipse;
        ellipse = new Ellipse();
        ellipse.setRadiusX(radiusX);
        ellipse.setRadiusY(radiusY);
        ellipse.setStroke(Color.WHITE);
        FieldController.addChild(ellipse);
        return ellipse;
    }

    public Point2D getCenter() {
        return center;
    }

}
