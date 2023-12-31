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

            if (gui.pantallaActual == GUI.PANTALLA.registro) {
                if (keyCode == LEFT) {
                    gui.t1.prevPage();
                } else if (keyCode == RIGHT) {
                    gui.t1.nextPage();
                }
            }

            gui.tf1.keyPressed(key, keyCode);
            gui.tf2.keyPressed(key, keyCode);
            gui.tf3.keyPressed(key, keyCode);
            gui.tf4.keyPressed(key, keyCode);
            gui.tf5.keyPressed(key, keyCode);
            gui.tf6.keyPressed(key, keyCode);
            gui.tf7.keyPressed(key, keyCode);
            gui.tf8.keyPressed(key, keyCode);
            gui.tf9.keyPressed(key, keyCode);
        }

        public void mousePressed() {

            if (gui.pantallaActual == GUI.PANTALLA.registro) {
                if (gui.b1.mouseOverButton(this)) {
                    println("HAS FET CLIC SOBRE EL BOTÓ B1");
                }
                gui.tf1.isPressed(this);
                gui.tf2.isPressed(this);
                gui.tf3.isPressed(this);
                gui.tf4.isPressed(this);
                gui.tf5.isPressed(this);
            }

            if (gui.pantallaActual == GUI.PANTALLA.agregarCanción) {
                gui.tf6.isPressed(this);
                gui.tf7.isPressed(this);
            }

            if (gui.pantallaActual == GUI.PANTALLA.agregarLista) {
                gui.tf6.isPressed(this);
                gui.tf7.isPressed(this);
            }

            if (gui.pantallaActual == GUI.PANTALLA.Calentamiento) {
                // Comprova si pitjam sobre els botons del MusicPlayer
                gui.mp.checkButtons(this);
            }

            if (gui.rb2.mouseOverButton(this)) {
                println("HAS FET CLIC SOBRE EL BOTÓ RB1");
            }
            if (gui.rb3.mouseOverButton(this)) {
                println("HAS FET CLIC SOBRE EL BOTÓ RB2");
            }
            if (gui.rb4.mouseOverButton(this)) {
                println("HAS FET CLIC SOBRE EL BOTÓ RB3");
            }


            if (gui.pantallaActual == GUI.PANTALLA.Favoritos) {
                    if (gui.b11.mouseOverButton(this) && gui.b11.isEnabled()) {
                        gui.t1.nextPage();
                } else if (gui.b22.mouseOverButton(this) && gui.b22.isEnabled()) {
                        gui.t1.prevPage();
                }
        }

        //Select
            // Si pitjam sobre el select 1
            if(gui.s1.mouseOverSelect(this) && gui.s1.isEnabled()){
                if(!gui.s1.isCollapsed()){
                    gui.s1.update(this);      // Actualitzar valor
                    updateColor();    // Fer acció amb valor
                }
                gui.s1.toggle();        // Plegar o desplegar
            }

            // Comprova si pitjam amb el mouse sobre el SwitchButton
            if(gui.sb1.mouseOverButton(this)){
                gui.sb1.toggle();
                if(gui.sb1.isEnabled()){
                    gui.bgColor = color(255);
                }
                else {
                    gui.bgColor = color(0);
                }
            }
            if(gui.sb2.mouseOverButton(this)){
                gui.sb2.toggle();
                if(gui.sb2.isEnabled()){
                    gui.bgColor = color(255);
                }
                else {
                    gui.bgColor = color(0);
                }
            }

    }

    // Modifica el color segons Select 1
    void updateColor(){
        if(gui.s1.getSelectedValue().equals("RED")){
            gui.bgColor = color(255, 0, 0);
        }
        else if(gui.s1.getSelectedValue().equals("GREEN")){
            gui.bgColor = color(0, 255, 0);
        }
        else if(gui.s1.getSelectedValue().equals("BLUE")){
            gui.bgColor = color(0, 0, 255);
        }
    }


        public void mouseDragged() {
            println("MOUSE DRAGGED");
        }

        public void mouseReleased() {
            println("MOUSE RELEASED");
        }


}
