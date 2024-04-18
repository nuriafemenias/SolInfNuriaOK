package balletApp.balletOK.gui;

import processing.core.PApplet;
import processing.core.PImage;

public class SongCard {
    String id;
    String title;
    String category;
    boolean favorite;
    float x, y, w, h, b;
    public FaveButton bFavorite;
    public RoundButton bPlay;

    public SongCard(float x, float y, float w, float h, float b, String[] data) {
        this.id = data[0];
        this.title = data[1];
        this.category = data[2];
        this.favorite = data[3].equals("1")? true : false;

        this.x = x; this.y = y; this.w = w; this.h = h; this.b = b;
    }

    public void setButtons(PApplet p5, PImage imgFave, PImage imgNoFave, PImage imgPlay){
        float xB1 = x + w - 250;
        float xB2 = x + w - 150;
        float yB = this.y + this.h/2;
        float rB = 30;
        this.bFavorite = new FaveButton(imgFave, imgNoFave, xB1, yB, rB, this.favorite);
        this.bPlay = new RoundButton(p5, imgPlay, xB2, yB, rB);
    }


    public String getTitle(){
        return this.title;
    }

    public String getCategory(){
        return this.category;
    }



    public void display(PApplet p5, boolean mouseOver) {

        p5.pushStyle();
        p5.stroke(0);
        p5.fill(195, 172, 194);
        if (mouseOver) {
            p5.fill(152, 113, 150);
        }
        p5.rect(x, y, w, h, b/2);
        p5.fill(0);
        p5.textSize(24);
        p5.textAlign(p5.LEFT);
        p5.text(title, x + 10, y + h/2 + 10);
        p5. fill(161, 141, 103);
        p5.noStroke();
        p5.rect(x + w - 100, y + 8, 100, 25);
        p5.fill(0);
        p5.textAlign(p5.RIGHT);
        p5.textSize(14);
        p5.text(category, x + w - 10, y + 25);
        this.bFavorite.display(p5);
        this.bPlay.display(p5);
        p5.popStyle();
    }

    public boolean mouseOnCard(PApplet p5){
        return (p5.mouseX > x && p5.mouseX < x + w &&
                p5.mouseY > y && p5.mouseY < y + h);
    }


    public SongCard checkButtons(PApplet p5){

        this.bFavorite.checkMouseClick(p5);

        if(this.bPlay.mouseOverButton(p5)){
            return this;
        }

        return null;
    }
}