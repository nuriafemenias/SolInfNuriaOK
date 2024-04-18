
package balletApp.balletOK;

import processing.core.PApplet;

public class Colores {

            int[] colors;

            public Colores(PApplet p5){
                this.setColors(p5);
            }

            void setColors(PApplet p5){
                  this.colors = new int[8];
                  this.colors[0] = p5.color(0xFFE7E0DA);
                  this.colors[1] = p5.color(0xFFC4B7A1);
                  this.colors[2] = p5.color(0xFFA18D67);
                  this.colors[3] = p5.color(0xFFC3ACC2);
                  this.colors[4] = p5.color(0xFF987196);
                  this.colors[5] = p5.color(0xFF6D3A73);
                  this.colors[6] = p5.color(0xFF1F1B1F);
                  this.colors[7] = p5.color(0xFF4B7048);
        }

            int getNumColors(){
                return this.colors.length;
            }

            int getFirstColor(){
                return  this.colors[0];
            }

            int getSecondColor(){
                return  this.colors[1];
            }

            int getThirdColor(){
                return  this.colors[2];
            }

            int getColorAt(int i){
                return this.colors[i];
            }


            void displayColors(PApplet p5, float x, float y, float w){
                p5.pushStyle();
                p5.fill(0); p5.textAlign(p5.LEFT); p5.textSize(36);
                p5.text("Colors:", x, y-10);
                float wc = w / getNumColors();
                for(int i=0; i<getNumColors(); i++){
                    p5.fill(getColorAt(i)); p5.stroke(0); p5.strokeWeight(3);
                    p5.rect(x + i*wc, y, wc, wc);
                }
                p5.popStyle();
            }
        }