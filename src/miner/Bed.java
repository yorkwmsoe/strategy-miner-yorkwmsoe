package miner;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Bed extends Thing {
        private Polygon bed;
        private static final double SIZE = 30;
        public Bed(Point2D randomPoint) {
            super(randomPoint);
            bed = new Polygon();
            bed.getPoints().addAll(
                    -SIZE,SIZE,
                    SIZE,SIZE,
                    SIZE,0.6*SIZE,
                    0.8*SIZE,0.6*SIZE,
                    0.8*SIZE,0.8*SIZE,
                    -0.8*SIZE,0.8*SIZE,
                    -0.8*SIZE,0.4*SIZE,
                    -SIZE,0.4*SIZE,
                    -SIZE,-SIZE
            );
            bed.setFill(Color.BROWN);
            bed.setLayoutX(center.getX());
            bed.setLayoutY(center.getY());
            FieldController.addChild(bed);
        }
    }