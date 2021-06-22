package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;

public class MainView extends VBox {

    private Affine affine;
    private Button stepButton;
    private Canvas canvas;
    private Simulation simulation;

    public MainView() {
        this.simulation = new Simulation(10, 10);
        this.stepButton = new Button("Step");
        this.stepButton.setOnAction(actionEvent -> {
                    simulation.step();
                    draw();
        });
        this.canvas = new Canvas(400, 400);
        this.getChildren().addAll(this.stepButton, this.canvas);
        this.affine = new Affine();
        this.affine.appendScale(
                this.canvas.getWidth()/this.simulation.width, this.canvas.getHeight()/this.simulation.height);

        simulation.setAlive(2,3);
        simulation.setAlive(3,3);
        simulation.setAlive(4,3);

        simulation.setAlive(7,5);
        simulation.setAlive(7,6);
        simulation.setAlive(8,5);
        simulation.setAlive(8,6);


    }

    public void draw(){
        GraphicsContext g = this.canvas.getGraphicsContext2D();

        g.setTransform(this.affine);
        g.setFill(Color.LIGHTGRAY);
        g.fillRect(0,0,simulation.width,simulation.height);
        g.setFill(Color.BLACK);
        for (int x = 0; x < this.simulation.width; x++) {
            for (int y = 0; y < this.simulation.height; y++) {
                if(this.simulation.getState(x, y) == 1){
                    g.fillRect(x, y, 1, 1);
                }
            }
        }
        g.setStroke(Color.GRAY);
        g.setLineWidth(0.05);
        for (int x = 0; x <= this.simulation.width; x++) {
            g.strokeLine(x, 0, x, this.simulation.height);
        }
        for (int y = 0; y <= this.simulation.height; y++) {
            g.strokeLine(0, y, this.simulation.width, y);
        }

    }

}
