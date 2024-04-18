package balletApp.balletOK.gui;

import processing.core.PApplet;

public class SwitchButton {
    float x, y, w, h;
    int fillColor, strokeColor, fillColorOver, fillColorDisabled;
    boolean enabled;

    public SwitchButton(PApplet p5, float x, float y, float w, float h){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.enabled = true;
        fillColor = p5.color(161, 141, 103);
        fillColorOver = p5.color(196, 183, 161);
        fillColorDisabled = p5.color(150);
        strokeColor = p5.color(0);
    }

    void setEnabled(boolean b){
        this.enabled = b;
    }

    public void toggle(){
        this.enabled = !this.enabled;
    }

    public boolean isEnabled(){
        return  this.enabled;
    }

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

        p5.rectMode(p5.CENTER); p5.textAlign(p5.CENTER); p5.textSize(24);
        if(this.enabled){
            p5.rect(this.x + this.h/2, this.y + this.h/2, this.h-10, this.h-10, 5);
            p5.fill(0);
            p5.text("Sí", this.x + this.h/2, this.y + this.h/2 + 10);
        }
        else {
            p5.rect(this.x + this.w - this.h/2, this.y + this.h/2, this.h-10, this.h-10, 5);
            p5.fill(0);
            p5.text("No", this.x + this.w - this.h/2, this.y + this.h/2 + 10);
        }

        p5.popStyle();

    }

    public boolean mouseOverButton(PApplet p5){
        return (p5.mouseX >= this.x) &&
                (p5.mouseX<=this.x + this.w) &&
                (p5.mouseY>= this.y) &&
                (p5.mouseY<= this.y + this.h);
    }
}
