package balletApp.balletOK;

import balletApp.balletOK.gui.DataBase;
import balletApp.balletOK.gui.PagedTable;
import balletApp.balletOK.gui.TusListasCard;
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

            case Listas:
                gui.dibujaPantallaListas(this);
                break;

            case Coreografia:
                gui.dibujaPantallaCoreografia(this);
                break;

            case Centro:
                gui.dibujaPantallaCentro(this);
                break;

            case Diagonal:
                gui.dibujaPantallaDiagonal(this);
                break;

            case Ballets:
                gui.dibujaPantallaBallets(this);
                break;

            case Otras:
                gui.dibujaPantallaOtras(this);
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
            if(gui.rb3.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.TusCanciones;
            }else if(gui.rb4.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.TusListas;
            } else if(gui.b.mouseOverButton(this) && gui.b.isEnabled()){
                gui.selectedText = gui.tList.getSelectedValue();
            }
            gui.tf6.isPressed(this);
            gui.tf66.isPressed(this);
            if(gui.b29.mouseOverButton(this)) {
                String titulo = gui.tf6.text;
                String subtitulo = gui.tf66.text;
                String categoria = gui.s3.getSelectedValue();
                String numCateg = db.getClaveFromTabla("categoría", "idCategoría","nombre", categoria);
                db.insertLista(titulo, subtitulo, numCateg);
            }
        } else if (gui.pantallaActual == GUI.PANTALLA.agregarCanción) {
            gui.ps1.checkButtons(this);
            gui.cs = gui.ps1.checkCardClick(this);
            gui.c.checkButtons(this);
            gui.tf6.isPressed(this);
            gui.tf66.isPressed(this);
            if(gui.rb3.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.TusCanciones;
            }else if(gui.rb4.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.TusListas;
            } else if(gui.b29.mouseOverButton(this)) {
                String titulo = gui.tf6.text;
                String dia = gui.c.getSelectedDate();
                String categoria = gui.s1.getSelectedValue();
                String favoritos = gui.sb1.toString();
                db.insertCancion(titulo, dia, categoria, favoritos);
            }
        } else if (gui.pantallaActual == GUI.PANTALLA.Canciones) {
            if(gui.b7.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.Calentamiento;
            }
            if(gui.b8.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.Coreografia;
            }
        } else if (gui.pantallaActual == GUI.PANTALLA.registro) {
            if(gui.b1.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.Canciones;
            }
            gui.tf1.isPressed(this);
            gui.tf2.isPressed(this);
            gui.tf3.isPressed(this);
            gui.tf4.isPressed(this);
            gui.tf5.isPressed(this);
        } else if (gui.pantallaActual == GUI.PANTALLA.Calentamiento) {
            if(gui.b21.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.Barra;
            }else if(gui.b22.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.Centro;
            }else if(gui.b23.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.Diagonal;
            }
        } else if (gui.pantallaActual == GUI.PANTALLA.Coreografia) {
            if(gui.b21a.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.Barra;
            }else if(gui.b22a.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.Centro;
            }else if(gui.b23a.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.Diagonal;
            }
        } else if (gui.pantallaActual == GUI.PANTALLA.Favoritos) {
            if(gui.rb3.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.TusCanciones;
            }else if(gui.rb4.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.TusListas;
            }else if (gui.t1b1.mouseOverButton(this) && gui.t1b1.isEnabled()) {
                gui.t1.nextPage();
            } else if (gui.t1b2.mouseOverButton(this) && gui.t1b2.isEnabled()) {
                gui.t1.prevPage();
            }
        } else if (gui.pantallaActual == GUI.PANTALLA.TusCanciones) {
            if(gui.b5.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.agregarCanción;
            } else if(gui.rb3.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.TusCanciones;
            }else if(gui.rb4.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.TusListas;
            } else if (gui.t2b1.mouseOverButton(this) && gui.t2b1.isEnabled()) {
                gui.t2.nextPage();
            } else if (gui.t2b2.mouseOverButton(this) && gui.t2b2.isEnabled()) {
                gui.t2.prevPage();
            }
        } else if (gui.pantallaActual == GUI.PANTALLA.ListaCanciones) {
            gui.ps1.checkButtons(this);
            gui.cs = gui.ps1.checkCardClick(this);
            if(gui.b27.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.agregarLista;
            }
        } else if (gui.pantallaActual == GUI.PANTALLA.Barra) {
            gui.pl1.checkButtons(this);
            if(gui.b27.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.agregarLista;
            }
        } else if (gui.pantallaActual == GUI.PANTALLA.TusListas) {
            if(gui.rb3.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.TusCanciones;
            }else if(gui.rb4.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.TusListas;
            } else if (gui.b1.isPressed(this)) {
                gui.ptl1.nextPage();
            } else if (gui.b2.isPressed(this)) {
                gui.ptl1.prevPage();
            }
            gui.cardSeleccionada = gui.ptl1.checkCardClick(this);
            if(gui.confirml.isVisible()  && gui.confirml.bAceptar.mouseOverButton(this)){
                String titulo = gui.cardSeleccionada.getTitle();
                db.deleteInfoTaulaLista(titulo);
                gui.confirml.setVisible(false);
            } else if (gui.confirml.bCancelar.mouseOverButton(this)){
                gui.confirml.setVisible(false);
            } else if(gui.cardSeleccionada!=null && gui.cardSeleccionada.mouseOnPapeleraButton(this)){
                gui.confirml.setVisible(true);
            } else if(gui.b6.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.agregarLista;
            } else if(gui.ptl1.numCardOver(this)!= -1){
                TusListasCard tlcSelecccionada = gui.ptl1.checkCardClick(this);
                String tituloLista = tlcSelecccionada.getTitle();
                System.out.println("LISTA SELECCIONADA: "+ tituloLista);
                String[][] infoCanciones = gui.db.getInfoCancionesLista(tituloLista);
                System.out.println("NUM CANCIONES LISTA: "+infoCanciones.length);
                gui.pantallaActual = GUI.PANTALLA.cancionesTusListas;

                gui.ptSongsList = new PagedTable(6, 3);
                String[] headers = {"NUM", "TITULO", "FECHA"};
                gui.ptSongsList.setHeaders(headers);
                float[] colWidths = {20, 40, 40};
                gui.ptSongsList.setColumnWidths(colWidths);
                gui.ptSongsList.setData(infoCanciones);

                tlcSelecccionada = null;
            }
        } else if (gui.pantallaActual == GUI.PANTALLA.Centro) {
            gui.pl2.checkButtons(this);
            if(gui.b27.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.agregarLista;
            }
        } else if (gui.pantallaActual == GUI.PANTALLA.Diagonal) {
            gui.pl3.checkButtons(this);
            if(gui.b27.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.agregarLista;
            }
        } else if (gui.pantallaActual == GUI.PANTALLA.Ballets) {
            gui.pl4.checkButtons(this);
            if(gui.b27.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.agregarLista;
            }
        } else if (gui.pantallaActual == GUI.PANTALLA.Otras) {
            gui.pl5.checkButtons(this);
            if(gui.b27.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.agregarLista;
            }
        } else if (gui.pantallaActual == GUI.PANTALLA.cancionesTusListas) {
            if(gui.rb3.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.TusCanciones;
            } else if(gui.rb4.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.TusListas;
            } else if(gui.b5.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.agregarCanción;
            }
        }




        /*if (gui.pantallaActual == GUI.PANTALLA.Favoritos || gui.pantallaActual == GUI.PANTALLA.TusCanciones || gui.pantallaActual == GUI.PANTALLA.agregarCanción || gui.pantallaActual == GUI.PANTALLA.TusListas || gui.pantallaActual == GUI.PANTALLA.cancionesTusListas || gui.pantallaActual == GUI.PANTALLA.agregarLista) {
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
        if (gui.pantallaActual == GUI.PANTALLA.Barra || gui.pantallaActual == GUI.PANTALLA.ListaCanciones) {
            if(gui.b27.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.agregarLista;
            }
        }
         */
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



        if(gui.s1.mouseOverSelect(this) && gui.s1.isEnabled()){
            if(!gui.s1.isCollapsed()){
                gui.s1.update(this);
                updateColor();
            }
            gui.s1.toggle();
        }
        if(gui.s2.mouseOverSelect(this) && gui.s2.isEnabled()){
            if(!gui.s2.isCollapsed()){
                gui.s2.update(this);
                updateColor();
            }
            gui.s2.toggle();
        }
        if(gui.s3.mouseOverSelect(this) && gui.s3.isEnabled()){
            if(!gui.s3.isCollapsed()){
                gui.s3.update(this);
                updateColor();
            }
            gui.s3.toggle();
        }

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