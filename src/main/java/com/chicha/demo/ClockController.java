package com.chicha.demo;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.geometry.Point3D;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.time.LocalTime;
import java.util.List;

public class ClockController {

    @FXML
    public Circle clockFace;

    @FXML
    private AnchorPane root;

    @FXML
    private Line hourHand;


    @FXML
    private Line minuteHand;

    @FXML
    private Line secondHand;

    @FXML
    private Text timeLabel;

    private Timeline timeline;

    public void initialize() {
        hourHand.getTransforms().add(new Rotate(getAngles()[0], clockFace.getCenterX(), clockFace.getCenterY()));
        minuteHand.getTransforms().add(new Rotate(getAngles()[1], clockFace.getCenterX(), clockFace.getCenterY()));
        secondHand.getTransforms().add(new Rotate(getAngles()[2], clockFace.getCenterX(), clockFace.getCenterY()));
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> updateClock()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void updateClock() {
        hourHand.getTransforms().set(0, new Rotate(getAngles()[0], clockFace.getCenterX(), clockFace.getCenterY()));
        minuteHand.getTransforms().set(0, new Rotate(getAngles()[1], clockFace.getCenterX(), clockFace.getCenterY()));
        secondHand.getTransforms().set(0, new Rotate(getAngles()[2], clockFace.getCenterX(), clockFace.getCenterY()));
    }
    private double[] getAngles(){
        LocalTime time = LocalTime.now();
        return new double[]{time.getHour() % 12 * 30 + time.getMinute() * 0.5, time.getMinute() * 6, time.getSecond() * 6};
    }
}
