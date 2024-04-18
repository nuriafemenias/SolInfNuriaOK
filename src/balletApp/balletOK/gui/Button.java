package balletApp.balletOK.gui;

import processing.core.PApplet;
import processing.core.PFont;

public class Button {
    float x, y, w, h;
    int fillColor, strokeColor;
    int fillColorOver, fillColorDisabled;
    String textBoto;
    boolean enabled;
    PFont font;

    /**
     * Constructor de la clase Button
     * @param p5 objeto de la clase PApplet para dibujar
     * @param text Texto del botón
     * @param x Posición x del botón
     * @param y Posición y del botón
     * @param w Anchura del botón
     * @param h Altura del botón
     */
    public Button(PApplet p5, String text, float x, float y, float w, float h){
        this.textBoto = text;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.enabled = true;
        this.fillColor = p5.color(152, 113, 150);
        this.fillColorOver = p5.color(195, 172, 194);
        this.fillColorDisabled = p5.color(150);
        this.strokeColor = p5.color(0);
    }

    public void setEnabled(boolean b){
        this.enabled = b;
    }

    public void setColors(int cFill, int cStroke, int cOver, int cDisabled){
        this.fillColor = cFill;
        this.strokeColor = cStroke;
        this.fillColorOver = cOver;
        this.fillColorDisabled = cDisabled;
    }

    public void setFont(PFont f){
        this.font = f;
    }


    /**
     * Dibuja el botón
      * @param p5 objeto de la clase PApplet para dibujar
     */
    public void display(PApplet p5){
        p5.pushStyle();
        if(!enabled){
            p5.fill(fillColorDisabled);
        }
        else if(mouseOverButton(p5)){
            p5.fill(fillColorOver);
        }
        else{
            p5.fill(fillColor);
        }
        p5.stroke(strokeColor); p5.strokeWeight(2);
        p5.rect(this.x, this.y, this.w, this.h, 10);

        p5.fill(0); p5.textAlign(p5.CENTER); p5.textSize(20);
        if(this.font!=null) {
            p5.textFont(this.font);
        }
        p5.text(textBoto, this.x + this.w/2, this.y + this.h/2 + 10);
        p5.popStyle();
    }
    public boolean mouseOverButton(PApplet p5){
        return (p5.mouseX >= this.x) && (p5.mouseX <= this.x + this.w) &&
                (p5.mouseY >= this.y) && (p5.mouseY <= this.y + this.h);
    }
}
