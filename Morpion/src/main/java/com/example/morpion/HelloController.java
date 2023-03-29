package com.example.morpion;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
//import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

//import java.util.ArrayList;
import java.util.Arrays;
//import java.util.List;
import static com.example.morpion.Constants.*;
import static com.example.morpion.Eplayer.*;


public class HelloController {
    @FXML
    private Canvas board;
    @FXML
    private CheckBox computer;
    private CheckBox human ;
    @FXML
    private ComboBox<String> level;
    @FXML
    private Label winner;
    private GraphicsContext gc;
    private Game game;
    public HelloController(){

    }
    @FXML
    public void initialize(){
    gc = board.getGraphicsContext2D();
    level.setItems(FXCollections.observableList(Arrays.asList(RANDOM, PERFECT)));

    }
    @FXML
    public void init(){
        var FirstPlayer = human.isSelected() ? HUMAN : COMPUTER;
        var mode = level.getSelectionModel().getSelectedIndex();
        game = new Game(FirstPlayer, mode);
        board.setOnMouseClicked(this::getInputs);
        View.drawBoard(gc);
    }
    @FXML
    public void run(){
    var t = new Thread(game);
    t.start();
    }
    @FXML
    public void start(){

    }
    @FXML
    public void reset(){

    }
    public void getInputs(MouseEvent e) {
        int i = (e.getX() < W_CASE) ? 0: (e.getX() < 500) ? 1 : 2;
        int j = (e.getY() < W_CASE) ? 0: (e.getY() < 500) ? 1 : 2;
        View.drawMove(View.Croix, gc, i, j);
    }
        public  void  updateWinner(){

        }
}
