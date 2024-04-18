package balletApp.balletOK.gui;

import processing.core.PApplet;
import processing.core.PImage;

public class TusListasCard {
    String id;
    String title;
    String category;

    float x, y, w, h, b;

    public RoundButton bPapelera;
    PImage iconoP;

    /**
     * Constructor de las cartas de TusListas
     * @param x Posición x de las cartas
     * @param y Posición y de las cartas
     * @param w Anchura de la carta
     * @param h Altura de la carta
     * @param data Array unidimensional con información de la carta del identificador, el título y la categoría
     */
    public TusListasCard(float x, float y, float w, float h, float b, String[] data) {
        this.id = data[0];
        this.title = data[1];
        this.category = data[2];
        this.x = x; this.y = y; this.w = w; this.h = h; this.b = b;
    }

    public void setButtons(PApplet p5, PImage iconoP){
        float xB = x + w - 30;
        float yB = this.y + 70;
        float rB = 20;
        this.bPapelera = new RoundButton(p5, iconoP, xB, yB, rB);
    }

    public String getTitle(){
        return this.title;
    }


    /**
     * Dibuja la carta
     * @param p5 objeto de la clase PApplet para dibujar
     * @param mouseOver devuelve si el ratón está sobre o no
     */
    public void display(PApplet p5, boolean mouseOver) {

        p5.pushStyle();
        p5.stroke(0);
        p5.fill(161, 141, 103);
        if (mouseOver) {
            p5.fill(196, 183, 161);
        }
        p5.rect(x, y, w, h, b/2);
        p5.fill(0);
        p5.textSize(24);
        p5.textAlign(p5.LEFT);
        p5.text(title, x + 10, y + h/2 + 10);
        p5. fill(195, 172, 194);
        p5.noStroke();
        p5.rect(x + w - 100, y + 8, 100, 25);
        p5.fill(0);
        p5.textAlign(p5.RIGHT);
        p5.textSize(14);
        p5.text(category, x + w - 10, y + 25);
        p5.popStyle();
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
