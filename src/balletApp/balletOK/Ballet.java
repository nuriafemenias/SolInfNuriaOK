package balletApp.balletOK;

import processing.core.PApplet;

public class Ballet extends PApplet {

    GUI gui;


    public static void main(String[] args) {
        PApplet.main("balletApp.balletOK.Ballet", args);
    }

    public void settings() {
        fullScreen();
        smooth(10);
    }

    public void setup() {
        background(255);

        gui = new GUI(this);
    }

    public void draw() {
        background(255);
        // Dibuixa la pantalla corresponent
            switch (gui.pantallaActual) {
                case registro:
                    gui.dibujaPantallaRegistro(this);
                    break;

                case Favoritos:
                    gui.dibujaPantallaFavoritos(this);
                    break;

                case TusCanciones:
                    gui.dibujaPantallaTusCanciones(this);
                    break;

                case agregarCanción:
                    gui.dibujaPantallaAgregarCancion(this);
                    break;

                case TusListas:
                    gui.dibujaPantallaTusListas(this);
                    break;

                case cancionesTusListas:
                    gui.dibujaPantallaCancionesTusListas(this);
                    break;

                case agregarLista:
                    gui.dibujaPantallaAgregarLista(this);
                    break;

                case Canciones:
                    gui.dibujaPantallaCanciones(this);
                    break;

                case Calentamiento:
                    gui.dibujaPantallaCalentamiento(this);
                    break;

                case Coreografia:
                    gui.dibujaPantallaCoreografia(this);
                    break;

                case subListas:
                    gui.dibujaPantallaSubListas(this);
                    break;

                case subListasCanciones:
                    gui.dibujaPantallaSubListasCanciones(this);
                    break;
            }

        }

        public void keyPressed() {
            if(key=='0'){
                gui.pantallaActual = GUI.PANTALLA.registro;
            }
            else if(key=='1'){
                gui.pantallaActual = GUI.PANTALLA.Favoritos;
            }
            else if(key=='2'){
                gui.pantallaActual = GUI.PANTALLA.TusCanciones;
            }
            else if(key=='3'){
                gui.pantallaActual = GUI.PANTALLA.agregarCanción;
            }
            else if(key=='4'){
                gui.pantallaActual = GUI.PANTALLA.TusListas;
            }
            else if(key=='5'){
                gui.pantallaActual = GUI.PANTALLA.cancionesTusListas;
            }
            else if(key=='6'){
                gui.pantallaActual = GUI.PANTALLA.agregarLista;
            }
            else if(key=='7'){
                gui.pantallaActual = GUI.PANTALLA.Canciones;
            }
            else if(key=='8'){
                gui.pantallaActual = GUI.PANTALLA.Calentamiento;
            }
            else if(key=='9'){
                gui.pantallaActual = GUI.PANTALLA.Coreografia;
            }
            else if(key=='q'|| key=='Q'){
                gui.pantallaActual = GUI.PANTALLA.subListas;
            }
            else if(key=='w'|| key=='W'){
                gui.pantallaActual = GUI.PANTALLA.subListasCanciones;
            }

            gui.tf1.keyPressed(key, keyCode);
            gui.tf2.keyPressed(key, keyCode);
            gui.tf3.keyPressed(key, keyCode);
            gui.tf4.keyPressed(key, keyCode);
            gui.tf5.keyPressed(key, keyCode);
        }

        public void mousePressed() {

            if(gui.pantallaActual==GUI.PANTALLA.registro) {
                if (gui.b1.mouseOverButton(this)) {
                    println("HAS FET CLIC SOBRE EL BOTÓ B1");
                }
                gui.tf1.isPressed(this);
                gui.tf2.isPressed(this);
                gui.tf3.isPressed(this);
                gui.tf4.isPressed(this);
                gui.tf5.isPressed(this);
            }

            if(gui.pantallaActual==GUI.PANTALLA.Calentamiento){
                // Comprova si pitjam sobre els botons del MusicPlayer
                gui.mp.checkButtons(this);
            }

            if (gui.rb1.mouseOverButton(this)){
                println("HAS FET CLIC SOBRE EL BOTÓ RB1");
            }
            if (gui.rb2.mouseOverButton(this)){
                println("HAS FET CLIC SOBRE EL BOTÓ RB2");
            }
            if (gui.rb3.mouseOverButton(this)){
                println("HAS FET CLIC SOBRE EL BOTÓ RB3");
            }
        }

        public void mouseDragged() {
            println("MOUSE DRAGGED");
        }

        public void mouseReleased() {
            println("MOUSE RELEASED");
        }


}
