package balletApp.balletOK;

import balletApp.balletOK.gui.DataBase;
import processing.core.PApplet;

public class Ballet extends PApplet {

    DataBase db;
    static GUI gui;

    public static void main(String[] args) {
        PApplet.main("balletApp.balletOK.Ballet", args);
    }


    public void settings() {
        fullScreen();
        smooth(10);
    }

    public void setup() {
        background(255);

        // Configura els paràmetres de connexió a la BBDD
        db = new DataBase("admin", "12345", "musica");
        // Connecta amb la BBDD
        db.connect();

        gui = new GUI(this, db);
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

            case Barra:
                gui.dibujaPantallaBarra(this);
                break;

            case VariacionesListaCanciones:
                gui.dibujaPantallaVariacionesListaCanciones(this);
                break;

            case ListaCanciones:
                gui.dibujaPantallaListaCanciones(this);
                break;

            case Reproductor:
                gui.dibujaPantallaReproductor(this);
                break;
        }

    }




    public void keyPressed() {
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
        gui.tf66.keyPressed(key, keyCode);
        gui.tf8.keyPressed(key, keyCode);
        gui.tf9.keyPressed(key, keyCode);

        if (gui.pantallaActual == GUI.PANTALLA.agregarCanción) {
            // Anar un mes enrere
            if (keyCode == LEFT) {
                gui.c.prevMonth();
                println("PREV MONTH");
            }
            // Anar un mes endavant
            else if (keyCode == RIGHT) {
                gui.c.nextMonth();
                println("PREV MONTH");
            }
        }

        // TextList
        if(gui.tList.getTextField().mouseOverTextField(this)){
            gui.tList.getTextField().keyPressed(key, (int)keyCode);
            gui.tList.update(this);
        }
    }

    public void mousePressed() {

        if (gui.pantallaActual == GUI.PANTALLA.agregarLista) {
            if(gui.b29.mouseOverButton(this)) {
                String titulo = gui.tf6.text;
                String subtitulo = gui.tf66.text;
                String categoria = gui.s3.getSelectedValue();
                String numCateg = db.getClaveFromTabla("categoría", "idCategoría","nombre", categoria);
                db.insertInfoTaulaLista(titulo, subtitulo, numCateg);
            }

        }

        if (gui.pantallaActual == GUI.PANTALLA.Favoritos || gui.pantallaActual == GUI.PANTALLA.TusCanciones || gui.pantallaActual == GUI.PANTALLA.agregarCanción || gui.pantallaActual == GUI.PANTALLA.TusListas || gui.pantallaActual == GUI.PANTALLA.cancionesTusListas || gui.pantallaActual == GUI.PANTALLA.agregarLista) {
            if(gui.rb3.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.TusCanciones;
            }else if(gui.rb4.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.TusListas;
            }
        }
        if (gui.pantallaActual == GUI.PANTALLA.cancionesTusListas || gui.pantallaActual == GUI.PANTALLA.TusCanciones) {
            if(gui.b5.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.agregarCanción;
            }
        }

        if (gui.pantallaActual == GUI.PANTALLA.Canciones) {
            if(gui.b8.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.Reproductor;
            }
        }


        if (gui.pantallaActual != GUI.PANTALLA.Reproductor && gui.pantallaActual != GUI.PANTALLA.registro) {
            if(gui.b3.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.Favoritos;
            }else if(gui.rb2.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.Favoritos;
            }else if(gui.rb3.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.TusCanciones;
            }else if(gui.rb4.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.TusListas;
            }else if(gui.b4.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.Canciones;
            }else if(gui.rb1.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.registro;
            }
        }

        if (gui.pantallaActual == GUI.PANTALLA.Barra || gui.pantallaActual == GUI.PANTALLA.ListaCanciones) {
            if(gui.b27.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.agregarLista;
            }
        }

        /*if (gui.pantallaActual == GUI.PANTALLA.Barra) {
            if(gui.b27.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.ListaCanciones;
            }
        }

         */

        if (gui.pantallaActual == GUI.PANTALLA.registro) {
            if(gui.b1.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.Canciones;
            }
            gui.tf1.isPressed(this);
            gui.tf2.isPressed(this);
            gui.tf3.isPressed(this);
            gui.tf4.isPressed(this);
            gui.tf5.isPressed(this);
        }

        if (gui.pantallaActual == GUI.PANTALLA.agregarCanción) {
            gui.tf6.isPressed(this);
            gui.tf66.isPressed(this);
        }

        if (gui.pantallaActual == GUI.PANTALLA.agregarLista) {
            gui.tf6.isPressed(this);
            gui.tf66.isPressed(this);
        }

        if (gui.pantallaActual == GUI.PANTALLA.Calentamiento) {
            // Comprova si pitjam sobre els botons del MusicPlayer
            if(gui.b21.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.TusListas;
            }else if(gui.b22.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.TusListas;
            }else if(gui.b23.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.TusListas;
            }
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
            if (gui.t1b1.mouseOverButton(this) && gui.t1b1.isEnabled()) {
                gui.t1.nextPage();
            } else if (gui.t1b2.mouseOverButton(this) && gui.t1b2.isEnabled()) {
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
        if(gui.s2.mouseOverSelect(this) && gui.s2.isEnabled()){
            if(!gui.s2.isCollapsed()){
                gui.s2.update(this);      // Actualitzar valor
                updateColor();    // Fer acció amb valor
            }
            gui.s2.toggle();        // Plegar o desplegar
        }
        if(gui.s3.mouseOverSelect(this) && gui.s3.isEnabled()){
            if(!gui.s3.isCollapsed()){
                gui.s3.update(this);      // Actualitzar valor
                updateColor();                // Fer acció amb valor
            }
            gui.s3.toggle();        // Plegar o desplegar
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
        if(gui.sb3.mouseOverButton(this)){
            gui.sb3.toggle();
            if(gui.sb3.isEnabled()){
                gui.bgColor = color(255);
            }
            else {
                gui.bgColor = color(0);
            }
        }

        // Si pitjam sobre el checboxes
        if(gui.cb1.onMouseOver(this)){
            gui.cb1.toggle();
        }

        if (gui.pantallaActual == GUI.PANTALLA.agregarCanción) {
            // Comprovar si clicam sobre botons del Calendari
            gui.c.checkButtons(this);
        }

        // Paged songs
        if (gui.pantallaActual == GUI.PANTALLA.ListaCanciones) {
            gui.ps1.checkButtons(this);
            gui.cs = gui.ps1.checkCardClick(this);
        }
        // Paged songs
        if (gui.pantallaActual == GUI.PANTALLA.agregarCanción) {
            gui.ps1.checkButtons(this);
            gui.cs = gui.ps1.checkCardClick(this);
        }

        // Paged lista
        if (gui.pantallaActual == GUI.PANTALLA.Barra) {
            gui.pl1.checkButtons(this);
            //gui.cs = gui.pl1.checkCardClick(this);
        }
        // Paged tus listas
        if (gui.pantallaActual == GUI.PANTALLA.TusListas) {

            //boolean botonSeleccionat =  gui.confirml.mouseOnCancelarButton(this);

            if(gui.confirml.isVisible()  && gui.confirml.bAceptar.mouseOverButton(this)){
                String titulo = gui.cardSeleccionada.getTitle();
                db.deleteInfoTaulaLista(titulo);
                gui.confirml.setVisible(false);
            }
            else if (gui.confirml.bCancelar.mouseOverButton(this)){
                gui.confirml.setVisible(false);
            }
            else if(gui.cardSeleccionada!=null && gui.cardSeleccionada.mouseOnPapeleraButton(this)){
               gui.confirml.setVisible(true);
            }
            //gui.cs = gui.ptl1.checkCardClick(this);
            /*if (gui.bAceptar.mouseOverButton(this) //&& gui.b.isEnabled()){

            }

            if(gui.b29.mouseOverButton(this)) {
                String titulo = gui.tf6.text;
                String categoria = gui.s3.getSelectedValue();
                String numCateg = db.getClaveFromTabla("categoría", "idCategoría","nombre", categoria);
                db.deleteInfoTaulaLista(titulo);
        }

        */

            gui.cardSeleccionada = gui.ptl1.checkCardClick(this);
            if(gui.b6.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.agregarLista;
            }


        }
        if (gui.pantallaActual == GUI.PANTALLA.Canciones) {
            if(gui.b7.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.Calentamiento;
            }
        }

        // TextList
        // Pitjam sobre el botó de TRIA
        if(gui.b.mouseOverButton(this) && gui.b.isEnabled()){
            gui.selectedText = gui.tList.getSelectedValue();
        }

        // Mirarm si pitjam damunt el textList (camp de text o botó)
        gui.tList.getTextField().isPressed(this);
        gui.tList.buttonPressed(this);


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
    static void updateCursor(PApplet p5) {
        if (gui.b.mouseOverButton(p5) || gui.tList.mouseOverButtons(p5)) {
            p5.cursor(HAND);
        } else {
            p5.cursor(ARROW);
        }
    }

    public void mouseDragged() {
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }


}