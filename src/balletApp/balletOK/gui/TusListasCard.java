package balletApp.balletOK.gui;

import processing.core.PApplet;
import balletApp.balletOK.gui.RoundButton;
import processing.core.PImage;

public class TusListasCard {
    // Propietats
    String id;
    String title;
    String category;

    float x, y, w, h, b;

    public RoundButton bPapelera;
    PImage iconoP;


    // Constructor

    public TusListasCard(float x, float y, float w, float h, float b, String[] data) {
        this.id = data[0];
        this.title = data[1];
        this.category = data[2];
        //this.bPapelera = data[3].;

        this.x = x; this.y = y; this.w = w; this.h = h; this.b = b;
    }

    public void setButtons(PApplet p5, PImage iconoP){
        float xB = x + w - 30;
        float yB = this.y + 70;
        float rB = 20;
        this.bPapelera = new RoundButton(p5, iconoP, xB, yB, rB);
    }

    /*public void setButtons(PApplet p5, PImage imgFave, PImage imgNoFave, PImage imgPlay){
        float xB1 = x + w - 250;
        float xB2 = x + w - 150;
        float yB = this.y + this.h/2;
        float rB = 30;
        this.bFavorite = new FaveButton(imgFave, imgNoFave, xB1, yB, rB, this.favorite);
        this.bPlay = new RoundButton(p5, imgPlay, xB2, yB, rB);
        }
     */



    // Getters

    public String getTitle(){
        return this.title;
    }

    public String getCategory(){
        return this.category;
    }


    // Dibuixa la Card
    public void display(PApplet p5, boolean mouseOver) {

        p5.pushStyle();

        // Rectangle inferior
        p5.stroke(0);
        p5.fill(161, 141, 103);
        if (mouseOver) {
            p5.fill(196, 183, 161);
        }
        p5.rect(x, y, w, h, b/2);

        // Títol
        p5.fill(0);
        p5.textSize(24);
        p5.textAlign(p5.LEFT);
        p5.text(title, x + 10, y + h/2 + 10);


        // Categoria
        p5. fill(100, 100, 200);
        p5.noStroke();
        p5.rect(x + w - 100, y + 8, 100, 25);
        p5.fill(0);
        p5.textAlign(p5.RIGHT);
        p5.textSize(14);
        p5.text(category, x + w - 10, y + 25);
        p5.popStyle();

        //Papelera
        this.bPapelera.display(p5);
    }

    public boolean mouseOnCard(PApplet p5){
        return (p5.mouseX > x && p5.mouseX < x + w &&
                p5.mouseY > y && p5.mouseY < y + h);
    }

    public boolean mouseOnPapeleraButton(PApplet p5){
        return this.bPapelera.mouseOverButton(p5);
    }
}
