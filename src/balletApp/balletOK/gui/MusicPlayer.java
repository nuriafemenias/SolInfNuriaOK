package balletApp.balletOK.gui;

import processing.core.PApplet;
import processing.sound.*;

public class MusicPlayer {
    float x, y;
    Button bPlay, bStop, bPause, bLoop;
    SoundFile so;
    String sTitle;
    float porcentaje;

    /**
     * Constructor del reproductor de música
     * @param p5 objeto de la clase PApplet para dibujar
     * @param x Posición x del reproductor
     * @param y Posición y del reproductor
     */
    public MusicPlayer(PApplet p5, float x, float y){
        this.x = x; this.y = y;
        bPlay = new Button(p5, "PLAY", this.x, this.y, 100, 50);
        bStop = new Button(p5, "STOP", this.x + 150, this.y, 100, 50);
        bPause = new Button(p5, "PAUSE", this.x + 300, this.y, 100, 50);
        bLoop = new Button(p5, "LOOP", this.x + 450, this.y, 100, 50);
        this.porcentaje = 0;
    }

    public void setSound(PApplet p5, String s){
        sTitle = s;
        so = new SoundFile(p5, s);
    }
    public void display(PApplet p5){
        p5.pushStyle();
        p5.stroke(161, 141, 103); p5.strokeWeight(8);
        p5.fill(196, 183, 161); p5.rectMode(p5.CORNER);
        p5.rect(this.x -50, this.y-200, 650, 350, 5);
        p5.stroke(0); p5.strokeWeight(5);
        p5.line(this.x, this.y - 50, this.x + 550, this.y - 50);
        p5.stroke(200, 100, 100); p5.strokeWeight(8);
        float llarg = 0;
        if(so!=null){
            this.porcentaje = so.position()/ so.duration();
            llarg = this.porcentaje * 550;
        }
        p5.textAlign(p5.CENTER); p5.fill(0); p5.textSize(16);
        p5.text(p5.nf(this.porcentaje * 100, 2, 2) +"%", this.x + 300, this.y -80);
        p5.line(this.x, this.y -50, this.x + llarg, this.y -50);
        p5.textSize(24);
        p5.text(this.sTitle, this.x + 300, this.y -120);
        bPlay.display(p5); bStop.display(p5); bPause.display(p5); bLoop.display(p5);
        p5.popStyle();
    }
    public void checkButtons(PApplet p5){
        if(bPlay.mouseOverButton(p5) && !so.isPlaying()){
            so.play();
        } else if(bPause.mouseOverButton(p5) && so.isPlaying()){
            so.pause();
        } else if(bStop.mouseOverButton(p5) && so.isPlaying()){
            so.stop();
        } else if(bLoop.mouseOverButton(p5)){
            so.loop();
        }
    }
}