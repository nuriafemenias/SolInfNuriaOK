package balletApp.balletOK;

import balletApp.balletOK.gui.*;
import processing.core.PApplet;
import processing.core.PImage;

import static balletApp.balletOK.Midas.*;

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
        db = new DataBase("admin", "12345", "musica");
        db.connect();
        gui = new GUI(this, db);
    }

    public void draw() {
        background(255);
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

            case Barra:
                gui.dibujaPantallaBarra(this);
                break;

            case VariacionesListaCanciones:
                gui.dibujaPantallaVariacionesListaCanciones(this);
                break;

            case ListaCanciones:
                gui.dibujaPantallaListaCanciones(this);
                break;

            case Listas:
                 gui.dibujaPantallaListas(this);
                 break;

            case Reproductor:
                gui.dibujaPantallaReproductor(this);
                break;
        }

        fill(0);
        text(gui.pantallaActual.toString(), 100, 100);

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
            if (keyCode == LEFT) {
                gui.c.prevMonth();
                println("PREV MONTH");
            }
            else if (keyCode == RIGHT) {
                gui.c.nextMonth();
                println("PREV MONTH");
            }
        }
    }

    public void mousePressed() {

        // Clicks sobre Pantalla REGISTRO //////////////////////////////////////////////////////////

        String[][] inf;
        if (gui.pantallaActual == GUI.PANTALLA.registro) {
            // Boton Entra
            if (gui.b1.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Canciones;
            }
            // Textfields Nombre, Usuario, Contraseña1, Contraseña2
            gui.tf1.isPressed(this);
            gui.tf2.isPressed(this);
            gui.tf4.isPressed(this);
            gui.tf5.isPressed(this);
        }

        // Clicks sobre Pantalla CANCIONES //////////////////////////////////////////////////////////

        else if (gui.pantallaActual == GUI.PANTALLA.Canciones) {
            // Boton TuCuenta
            if (gui.b3.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Favoritos;
            }
            // Boton Canciones
            else if (gui.b4.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Canciones;
            }
            // Boton Calentamiento
            else if (gui.b7.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Calentamiento;
            }
            //Boton Coreografia
            else if (gui.b8.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Coreografia;
            }
        }

        // Clicks sobre Pantalla FAVORITOS /////////////////////////////////////////////////////////////

        else if (gui.pantallaActual == GUI.PANTALLA.Favoritos) {
            // Boton TuCuenta
            if (gui.b3.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Favoritos;
            }
            // Boton Canciones
            else if (gui.b4.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Canciones;
            }
            // Boton Página Siguiente
            else if (gui.t1b1.mouseOverButton(this)) {
                gui.t1.nextPage();
            }
            // Botón Página Anterior
            else if (gui.t1b2.mouseOverButton(this)) {
                gui.t1.prevPage();
            }
            // Botón Favoritos
            else if (gui.rb2.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Favoritos;
            }
            // Boton TusCanciones
            else if (gui.rb3.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.TusCanciones;
            }
            // Boton TusListas
            else if (gui.rb4.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.TusListas;
            }
        }

        // Clicks sobre Pantalla TUS CANCIONES /////////////////////////////////////////////////////////////

        else if (gui.pantallaActual == GUI.PANTALLA.TusCanciones) {
            // Boton TuCuenta
            if (gui.b3.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Favoritos;
            }
            // Boton Canciones
            else if (gui.b4.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Canciones;
            }
            // Boton Página Siguiente
            else if (gui.t2b1.mouseOverButton(this)) {
                gui.t2.nextPage();
            }
            // Botón Página Anterior
            else if (gui.t2b2.mouseOverButton(this)) {
                gui.t2.prevPage();
            }
            // Botón Favoritos
            if (gui.rb2.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Favoritos;
            }
            // Boton TusCanciones
            else if (gui.rb3.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.TusCanciones;
            }
            // Boton TusListas
            else if (gui.rb4.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.TusListas;
            }
            // Boton Agregar Canción
            else if (gui.b5.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.agregarCanción;
            }
        }

        // Clicks sobre Pantalla TUS LISTAS /////////////////////////////////////////////////////////////

        else if (gui.pantallaActual == GUI.PANTALLA.TusListas) {

            // Click sobre alguna card
            if (!gui.confirml.isVisible()) {
                gui.cardSeleccionada = gui.ptl1.checkCardClick(this);
            }


            // Boton TuCuenta
            if (gui.b3.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Favoritos;
            }
            // Boton Canciones
            else if (gui.b4.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Canciones;
            }
            // Botón Aceptar del Confirm
            else if (gui.confirml.isVisible() && gui.confirml.bAceptar.mouseOverButton(this)) {
                String titulo = gui.cardSeleccionada.getTitle();
                db.deleteInfoTaulaLista(titulo);
                gui.ptl1 = new PagedTusListas(this, gui.numCardsPage2, -10 + menuWidth + margeH, margeV + 60, gui.cardsW, gui.cardsH);
                String[][] inf3 = db.getInfoTaulaTusListas("nuriafemeniass");
                gui.ptl1.setData(inf3);
                gui.ptl1.setCards(this, gui.iconoP);
                gui.confirml.setVisible(false);
            }
            //  Botón Cancelar del Confirm
            else if (gui.confirml.isVisible() && gui.confirml.bCancelar.mouseOverButton(this)) {
                gui.confirml.setVisible(false);
            }
            // Botón Papelera Card Seleccionada
            else if (gui.cardSeleccionada != null && gui.cardSeleccionada.mouseOnPapeleraButton(this)) {
                gui.confirml.setVisible(true);
            }
            // Click sobre card de PagedTusListas ptl1
            else if (gui.ptl1.numCardOver(this) != -1) {
                TusListasCard tlcSelecccionada = gui.ptl1.checkCardClick(this);
                String tituloLista = tlcSelecccionada.getTitle();
                gui.tituloLista = tituloLista;
                System.out.println("LISTA SELECCIONADA: " + tituloLista);
                String[][] infoCanciones = gui.db.getInfoCancionesLista(tituloLista);
                db.printArray2d(infoCanciones);
                System.out.println("NUM CANCIOnES LISTA: " + infoCanciones.length);
                gui.pantallaActual = GUI.PANTALLA.cancionesTusListas;

                gui.ptSongsList = new PagedTable(6, 3);
                String[] headers = {"NUM", "TITULO", "FECHA"};
                gui.ptSongsList.setHeaders(headers);
                float[] colWidths = {20, 40, 40};
                gui.ptSongsList.setColumnWidths(colWidths);
                gui.ptSongsList.setData(infoCanciones);


            }
            // Botón Agregar Lista
            else if (gui.b6.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.agregarLista;
            }

            // Botones de Pàgina Anterior y Siguiente del PagedTusListas
            gui.ptl1.checkButtons(this);

        }

        // Clicks sobre Pantalla AGREGAR LISTA /////////////////////////////////////////////////////////////

        else if (gui.pantallaActual == GUI.PANTALLA.agregarLista) {
            // Boton TuCuenta
            if (gui.b3.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Favoritos;
            }
            // Boton Canciones
            else if (gui.b4.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Canciones;
            }
            // Botón Favoritos
            else if (gui.rb2.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Favoritos;
            }
            // Boton TusCanciones
            else if (gui.rb3.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.TusCanciones;
            }
            // Boton TusListas
            else if (gui.rb4.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.TusListas;
            }
            // Botón Guardar
            else if (gui.b29.mouseOverButton(this)) {
                String titulo = gui.tf6.text;
                String subtitulo = gui.tf66.text;
                String categoria = gui.s3.getSelectedValue();
                String numCateg = db.getClaveFromTabla("categoría", "idCategoría", "nombre", categoria);
                db.insertLista(titulo, subtitulo, numCateg);
            }
            // Sí / No
            else if (gui.sb3.mouseOverButton(this)) {
                gui.sb3.toggle();
            }
            else if (gui.s3.mouseOverSelect(this)) {
                if (!gui.s3.isCollapsed()) {
                    gui.s3.update(this);
                }
                gui.s3.toggle();
            }

            // Textfields Título y Subtítulo
            gui.tf6.isPressed(this);
            gui.tf66.isPressed(this);

        }

        // Clicks sobre Pantalla AGREGAR CANCIÓN /////////////////////////////////////////////////////////////

        else if (gui.pantallaActual == GUI.PANTALLA.agregarCanción) {
            // Boton TuCuenta
            if (gui.b3.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Favoritos;
            }
            // Boton Canciones
            else if (gui.b4.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Canciones;
            }
            // Botón Favoritos
            else if (gui.rb2.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Favoritos;
            }
            // Boton TusCanciones
            else if (gui.rb3.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.TusCanciones;
            }
            // Boton TusListas
            else if (gui.rb4.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.TusListas;
            }
            //Botón Guardar
            else if (gui.b29.mouseOverButton(this)) {

                String titulo = gui.tf6.text;
                String dia = db.formataFechaEng(gui.c.getSelectedDate());
                String lista = gui.s2.getSelectedValue();
                String favoritos = gui.sb1.isEnabled() ? "1" : "0";
                db.insertCancion(titulo, dia, lista, favoritos);

                // Ara que s'ha creat una cançó cal actualitzar FAVORITOS
                gui.t1 = new PagedTable(gui.files, gui.columnes);
                gui.t1.setHeaders(gui.headers);
                inf = db.getInfoTaulaFavoritos("nuriafemeniass");
                gui.t1.setData(inf);
                gui.t1.setColumnWidths(gui.colWidths);

            }
            // Select Categoria
            else if (gui.s1.mouseOverSelect(this)) {
                if (!gui.s1.isCollapsed()) {
                    gui.s1.update(this);
                }
                gui.s1.toggle();
            }
            // Select Lista
            else if (gui.s2.mouseOverSelect(this)) {
                if (!gui.s2.isCollapsed()) {
                    gui.s2.update(this);      // Actualitzar valor
                }
                gui.s2.toggle();        // Plegar o desplegar
            }
            // Favoritos
            else if (gui.sb1.mouseOverButton(this)) {
                gui.sb1.toggle();
            }
            // Botón Volver
            else if (gui.b9.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.TusCanciones;
            }

            // Botones del Calendario
            gui.c.checkButtons(this);

            // Textfields
            gui.tf6.isPressed(this);
            gui.tf66.isPressed(this);


        }

        // Clicks sobre Pantalla CALENTAMIENTO /////////////////////////////////////////////////////////////

        else if (gui.pantallaActual == GUI.PANTALLA.Calentamiento) {
            // Boton TuCuenta
            if (gui.b3.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Favoritos;
            }
            // Boton Canciones
            else if (gui.b4.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Canciones;
            }
            // Botón Barra
            else if (gui.b21.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Barra;
                gui.nombreCalentamiento = "BARRA";
                gui.pl1 = new PagedLists(this, gui.numCardsPage2, -10 + menuWidth + margeH, margeV + 60, gui.cardsW, gui.cardsH);
                String[][] infoBarra = db.getInfoListasCategoria("nuriafemeniass", "Barra");
                gui.pl1.setData(infoBarra);
                gui.pl1.setCards(this);
            }
            // Botón Centro
            else if (gui.b22.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Barra;
                gui.nombreCalentamiento = "CENTRO";
                gui.pl1 = new PagedLists(this, gui.numCardsPage2, -10 + menuWidth + margeH, margeV + 60, gui.cardsW, gui.cardsH);
                String[][] infoCentro = db.getInfoListasCategoria("nuriafemeniass", "Centro");
                gui.pl1.setData(infoCentro);
                gui.pl1.setCards(this);

            }
            // Boton Diagonal
            else if (gui.b23.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Barra;
                gui.nombreCalentamiento = "DIAGONAL";
                gui.pl1 = new PagedLists(this, gui.numCardsPage2, -10 + menuWidth + margeH, margeV + 60, gui.cardsW, gui.cardsH);
                String[][] infoDiagonal = db.getInfoListasCategoria("nuriafemeniass", "Diagonal");
                gui.pl1.setData(infoDiagonal);
                gui.pl1.setCards(this);

            }
            // Botón Agregar Lista
            else if (gui.b27.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.agregarLista;
            }

        }


        // Clicks sobre Pantalla COREOGRAFIA /////////////////////////////////////////////////////////////

        else if (gui.pantallaActual == GUI.PANTALLA.Coreografia) {
            // Boton TuCuenta
            if (gui.b3.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Favoritos;
            }
            else if (gui.b4.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Canciones;
            }
            else if (gui.b21a.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Barra;
                gui.nombreCalentamiento = "BALLETS";
                gui.pl1 = new PagedLists(this, gui.numCardsPage2, -10 + menuWidth + margeH, margeV + 60, gui.cardsW, gui.cardsH);
                String[][] infoBarra = db.getInfoListasCategoria("nuriafemeniass", "Ballets");
                gui.pl1.setData(infoBarra);
                gui.pl1.setCards(this);
            }
            else if (gui.b22a.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Barra;
                gui.nombreCalentamiento = "VARIACIONES";
                gui.pl1 = new PagedLists(this, gui.numCardsPage2, -10 + menuWidth + margeH, margeV + 60, gui.cardsW, gui.cardsH);
                String[][] infoCentro = db.getInfoListasCategoria("nuriafemeniass", "Variaciones");
                gui.pl1.setData(infoCentro);
                gui.pl1.setCards(this);

            }
            else if (gui.b23a.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Barra;
                gui.nombreCalentamiento = "OTRAS";
                gui.pl1 = new PagedLists(this, gui.numCardsPage2, -10 + menuWidth + margeH, margeV + 60, gui.cardsW, gui.cardsH);
                String[][] infoDiagonal = db.getInfoListasCategoria("nuriafemeniass", "Otras");
                gui.pl1.setData(infoDiagonal);
                gui.pl1.setCards(this);

            }
            // Botón Agregar Lista
            else if (gui.b27.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.agregarLista;
            }

        }


        // Clicks sobre Pantalla BARRA, CENTRO, DIAGONAL /////////////////////////////////////////////////////////////
        else if (gui.pantallaActual == GUI.PANTALLA.Barra) {
            // Boton TuCuenta
            if (gui.b3.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Favoritos;
            }
            // Boton Agregar Lista
            else if (gui.b27.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.agregarLista;
            }
            // Boton Canciones
            else if (gui.b4.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Canciones;
            }
            // Botons del PagedList pl1
            gui.pl1.checkButtons(this);
            // Abrir lista canciones
            if (gui.pl1.numCardOver(this) != -1) {
                ListCard lcSelecccionada = gui.pl1.checkCardClick(this);
                String tituloLista = lcSelecccionada.getTitle();
                gui.tituloLista = tituloLista;

                gui.pantallaActual = GUI.PANTALLA.Listas;
                int numCardsPage = 7;
                float cardsW = 850, cardsH = rect2Height - 60 - 50;
                gui.ps1 = new PagedSongs(this, numCardsPage, -10 + menuWidth + margeH, margeV + 60, cardsW, cardsH);

                String[][] infoCanciones = db.getInfoCancionesCategoria("nuriafemeniass", "Barra");
                gui.ps1.setData(infoCanciones);
                PImage imgFave, imgNoFave, imgPlay;
                imgFave = this.loadImage("imgFave.png");
                imgNoFave = this.loadImage("imgNoFave.png");
                imgPlay = this.loadImage("imgPlay.png");
                gui.ps1.setCards(this, imgFave, imgNoFave, imgPlay);
            }
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        else if (gui.pantallaActual == GUI.PANTALLA.Listas) {
            gui.ps1.checkButtons(this);
            gui.cs = gui.ps1.checkCardClick(this);
            // Boton TuCuenta
            if (gui.b3.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Favoritos;
            }
            // Boton Canciones
            else if (gui.b4.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Canciones;
            }
            // Boton Agregar Lista
            else if (gui.b27.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.agregarLista;
            }
            gui.db.updateFavoritoCancion("Nom Canço", true);
            gui.db.updateFavoritoCancion("Nom Canço", false);

        }

        // Clicks sobre Pantalla LISTA CANCIONES /////////////////////////////////////////////////////////////

        else if (gui.pantallaActual == GUI.PANTALLA.ListaCanciones) {
            // Botons del PagedSong ps1
            gui.ps1.checkButtons(this);
            gui.cs = gui.ps1.checkCardClick(this);
        }

        // Clicks sobre Pantalla REPRODUCTOR /////////////////////////////////////////////////////////////
        else if (gui.pantallaActual == GUI.PANTALLA.Reproductor) {
            // Boton TuCuenta
            if (gui.b3.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Favoritos;
            }
            // Boton Canciones
            else if (gui.b4.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Canciones;
            }
            // Botones del Music Player
            gui.mp.checkButtons(this);
        }

        // Clicks sobre Pantalla CANCIONES TUS LISTAS /////////////////////////////////////////////////////////////
        else if (gui.pantallaActual == GUI.PANTALLA.cancionesTusListas) {
            // Boton TuCuenta
            if (gui.b3.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Favoritos;
            }
            // Boton Canciones
            else if (gui.b4.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Canciones;

                gui.db.updateFavoritoCancion("Nom Canço", true);
                gui.db.updateFavoritoCancion("Nom Canço", false);
            }
            else if (gui.b9.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.TusListas;
            }
        }
    }

    public void mouseDragged() {
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }


}