package balletApp.balletLayout;

import processing.core.PApplet;

import static balletApp.balletPantalles.GUI.*;
import static balletApp.balletPantalles.Trivio004.*;

import static balletApp.balletLayout.Layout.*;

public class ballet003 extends PApplet {

    public static void main(String[] args) {
        PApplet.main("balletApp.balletLayout.ballet003", args);
    }

    public void settings() {
        fullScreen();
        smooth(10);
    }

    public void setup() {
        noStroke();
        textAlign(CENTER);
        textSize(18);
    }

    public void draw() {
        //switch(trivioApp.trivioPantalles.GUI.pantallaActual){
        //case registro:   gui.dibuixaPantallaInicial(this);
        //  break;
        //  }
    }

    public void keyPressed(){
        println("KEY PRESSED");
    }

    public void mousePressed(){
        println("X: "+mouseX+", Y:"+mouseY);
    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}