package miner;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class is both the controller for the main FXML window
 * and represents the entire board. It thus holds
 * all the squares on the board as well as the pieces and manages their interactions.
 */
public class FieldController {
    public static final int NUM_MINORS = 5;
    public static final int NUM_BEDS = 3;
    public static final int NUM_COINS = 30;
    private static FieldController theController = null;

    /* This is how big the screen is, roughly */
    public static final int FIELD_SIZE = 300;

    /* Gold is found at X values great than this number. */
    public static final int GOLD_BOUNDARY = 200;

    private final Random random = new Random();
    protected Point2D center;

    @FXML
    private Pane theField; // space to be searched

    private final List<Miner> miners = new ArrayList<>();
    private final List<Bed> beds = new ArrayList<>();
    private MessHouse messHouse;

    @FXML
    public void initialize() {
        // for fun, set up a gradient background; could probably do in SceneBuilder as well
        // note the label has a Z index of 2 so it is drawn above the panel, otherwise it may be displayed "under" the panel and not be visible
        theField.setStyle("-fx-background-color: linear-gradient(to bottom right, derive(forestgreen, 20%), derive(forestgreen, -40%));");
        // load image from a file; the file needs to be in the top folder of the project
        theController = this;

        messHouse = new MessHouse(new Point2D(GOLD_BOUNDARY/2.,FIELD_SIZE/2.));
        for(int i = 0; i < NUM_COINS; i++) {
            new Gold(selectRandomMiningPoint());
        }
        for(int i = 0; i < NUM_BEDS; i++) {
            //beds.add(new Bed(selectRandomFieldPoint()));
        }
        // Miners must be added after the messhouse so it is never null.
        for(int i = 0; i < NUM_MINORS; i++) {
            miners.add(new Miner(selectRandomFieldPoint()));
        }

        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(100),
                e -> step()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    /*
    Returns a point anywhere on the screen
     */
    public static Point2D selectRandomFieldPoint() {
        return new Point2D(Math.random()*FIELD_SIZE,Math.random()*FIELD_SIZE);
    }

    /**
     * Returns a point where the gold may be found.
     */
    public static Point2D selectRandomMiningPoint() {
        return new Point2D(GOLD_BOUNDARY+Math.random()*(FIELD_SIZE-GOLD_BOUNDARY),
                Math.random()*FIELD_SIZE);
    }

    private void step() {
        System.out.println("Stepping in time");
        for(Miner miner : miners) {
            miner.step();
        }
    }

    public static FieldController getTheController() {
        if(theController == null) {
            throw new IllegalStateException("theController should not be accessed before the " +
                    "gameboard is initialized.");
        }
        return theController;
    }

    public static void addChild(Node node) {
        getTheController().instanceAddChild(node);
    }
    private void instanceAddChild(Node node) {
        theField.getChildren().add(node);
    }

    public static void removeChild(Node node) {
        getTheController().instanceRemoveChild(node);
    }
    private void instanceRemoveChild(Node node) {
        theField.getChildren().remove(node);
    }

    public static MessHouse getTheMessHouse() {
        return getTheController().instanceGetTheMessHouse();
    }
    private MessHouse instanceGetTheMessHouse() {
        return messHouse;
    }
}
