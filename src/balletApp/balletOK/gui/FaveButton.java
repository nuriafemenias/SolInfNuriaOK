package balletApp.balletOK.gui;

import processing.core.PApplet;
import processing.core.PImage;

public class FaveButton {
    float x, y, r;
    PImage iconaFave, iconaNoFave;
    boolean favorite;

    public FaveButton(PImage icona1, PImage icona2, float x, float y, float r, boolean fave) {
        this.iconaFave = icona1;
        this.iconaNoFave = icona2;
        this.x = x;
        this.y = y;
        this.r = r;
        this.favorite = fave;
    }

    public boolean isFavorite(){
        return this.favorite;
    }

    public void setFavorite(boolean b) {
        this.favorite = b;
    }

    public void toggleFavorite() {
        this.favorite = !this.favorite;
    }

    public void display(PApplet p5) {

        p5.pushStyle();
        p5.imageMode(p5.CENTER);
        if (this.favorite) {
            p5.image(iconaFave, this.x, this.y, 2*this.r, 2*this.r);
        } else {
            p5.image(iconaNoFave, this.x, this.y, 2*this.r, 2*this.r);
        }
        p5.popStyle();
    }

    public boolean mouseOverButton(PApplet p5) {
        return p5.dist(p5.mouseX, p5.mouseY, this.x, this.y)<= this.r;
    }

    public void checkMouseClick(PApplet p5){
        if(mouseOverButton(p5)){
            toggleFavorite();
        }
    }
}