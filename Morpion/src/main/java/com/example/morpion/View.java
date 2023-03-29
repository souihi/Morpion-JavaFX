package com.example.morpion;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import java.util.stream.IntStream;
import static com.example.morpion.Constants.*;



public class View {
    static Image Cercle = new Image("file:ressources/Cercle.png",240,240,false,false);
    static Image Croix = new Image("file:ressources/Croix.png", 240,240, false,false);
    private View(){

    }
    public static void drawMove(Image img, GraphicsContext gc, int x, int y){
        gc.drawImage(img, x * W_CASE + 5, y * W_CASE + 5);
    }
    public static void drawMove(Image img, GraphicsContext gc , int num){
        int x= num % 3;
        int y = num / 3;
        gc.drawImage(img, x * W_CASE + 5 , y * W_CASE + 5 );
    }
    public static void drawBoard(GraphicsContext gc){
        gc.setFill(Color.WHITE);
        gc.setLineWidth(1);
        gc.clearRect(0, 0 , W_BOARD, W_BOARD);
        gc.setFill(Color.RED);
        IntStream.range(1,3).forEach(i -> gc.strokeLine(i * W_CASE, 0, i * W_CASE, W_BOARD));
        IntStream.range(1,3).forEach( j -> gc.strokeLine(0,j * W_CASE, W_BOARD,j * W_CASE));
    }
}
