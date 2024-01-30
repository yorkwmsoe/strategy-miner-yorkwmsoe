package miner;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class Miner extends Thing {
    public static final int MINER_SPEED = 4;
    public static final double CIRCLE_RADIUS = 20;
    private boolean isHungry;
    private MessHouse target;
    private Point2D circleCenter;

    protected final Shape face;
    protected Shape leftEar;
    protected Shape rightEar;
    protected final Shape leftEye;
    protected final Shape rightEye;

    public Miner(Point2D randomPoint) {
        super(randomPoint);
        face = createEllipse(30,30);
        leftEye = createEllipse(5,5);
        rightEye = createEllipse(5,5);
        leftEye.setFill(Color.BLACK);
        rightEye.setFill(Color.BLACK);
        leftEar = createEllipse(5,10);
        rightEar = createEllipse(5,10);
        face.setFill(Color.TAN);
        leftEar.setFill(Color.TAN);
        rightEar.setFill(Color.TAN);
        setHunger();
        reposition();
        // (This is already implemented, and included just in case you
        // happen to be reading this, although I don't know why you would need
        // to.)
        //
        // Unlike previous examples this quarter, the FieldController is
        // responsible for adding the miner to itself when it creates it.
        //
        // But this minor is still responsible for adding all of its components
        // to be visible in the field.
    }

    public void setHunger() {
        double choice = Math.random();
        if(choice < 0.5) {
            isHungry = true;
            target = FieldController.getTheMessHouse();
        } else {
            isHungry = false;
            circleCenter = FieldController.selectRandomMiningPoint();
        }
    }

    public void step() {
        if(Math.random() < 0.02) {
            setHunger();
        }
        Point2D direction;
        if(isHungry) {
            direction = goEat();
        } else if(!isHungry) {
            direction = mine();
        } else {
            throw new IllegalStateException("It is impossible to reach this point in the program.");
        }
        this.center = this.center.add(direction.multiply(MINER_SPEED));
        reposition();
    }

    protected void reposition() {
        System.out.println("Repositioning "+this);
        face.setLayoutX(center.getX());
        face.setLayoutY(center.getY());
        leftEar.setLayoutX(center.getX()-25);
        leftEar.setLayoutY(center.getY()-3);
        rightEar.setLayoutX(center.getX()+25);
        rightEar.setLayoutY(center.getY()-3);
        leftEye.setLayoutX(center.getX()-10);
        leftEye.setLayoutY(center.getY()-10);
        rightEye.setLayoutX(center.getX()+10);
        rightEye.setLayoutY(center.getY()-10);
    }

    public Point2D mine() {
        Point2D vectorToCenter = circleCenter.subtract(center);
        if(center.distance(circleCenter) > CIRCLE_RADIUS) {
            return vectorToCenter.normalize();
        } else {
            vectorToCenter = vectorToCenter.normalize();
            // Rotates the vector to center by 90 degrees to find tangent to circle:
            return new Point2D(-vectorToCenter.getY(),vectorToCenter.getX());
        }
    }

    public Point2D goEat() {
        Point2D vectorToCat = target.getCenter().subtract(center);
        return vectorToCat.normalize();
    }

}
