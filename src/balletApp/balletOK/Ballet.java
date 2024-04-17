package balletApp.balletOK;
import balletApp.balletOK.gui.*;
import processing.core.PApplet;
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

    /**
     * Función setup para configurar los parametros de la connesión a la BBDD y realizar la conexión.
     */
    public void setup() {
        background(255);
        db = new DataBase("admin", "12345", "musica");
        db.connect();
        gui = new GUI(this, db);
        String[][] inf = db.getCancionesLista("nuriafemeniass", "Warm up");
        db.printArray2d(inf);
    }

    /**
     * Dibuja las pantallas de la aplicación
     */
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

            case Reproductor:
                gui.dibujaPantallaReproductor(this);
                break;
        }
    }


    /**
     * Realiza la interacción con el teclado.
     */
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
            else if(gui.tList.getTextField().mouseOverTextField(this)){
                gui.tList.getTextField().keyPressed(key, (int)keyCode);
                gui.tList.update(this);
            }
        }
    }

    /**
     * Comprueba los usuarios de la aplicación para permitirles entrar.
     */
    public void comprovarLogin(){
        boolean entrar = false;
        String[][] usuaris = db.getUsuaris();
        db.printArray2d(usuaris);
        for (int f=0; f<usuaris.length; f++){
            println(usuaris[f][0], usuaris[f][1], gui.tf2.text, gui.tf5.text, gui.tf4.text);
            if(gui.tf2.text.trim().equals(usuaris[f][0].trim()) && gui.tf5.text.trim().equals(usuaris[f][1].trim()) && gui.tf4.text.trim().equals(usuaris[f][1].trim())){
                entrar = true;
                break;
            }
        }
        if(entrar){
            gui.pantallaActual = GUI.PANTALLA.Canciones;
        }
    }

    /**
     * Realiza la interacción con el ratón en cada una de las pantallas.
     */
    public void mousePressed() {
        if (gui.pantallaActual == GUI.PANTALLA.registro) {
            if (gui.b1.mouseOverButton(this)) {
                println("CHECK PASSWORD");
                comprovarLogin();
            }
            gui.tf1.isPressed(this);
            gui.tf2.isPressed(this);
            gui.tf4.isPressed(this);
            gui.tf5.isPressed(this);
        } else if (gui.pantallaActual == GUI.PANTALLA.Canciones) {
            if (gui.b3.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Favoritos;
            }
            else if (gui.b4.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Canciones;
            }
            else if (gui.b7.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Calentamiento;
            }
            else if (gui.b8.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Coreografia;
            }
        } else if (gui.pantallaActual == GUI.PANTALLA.Favoritos) {
            if (gui.b3.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Favoritos;
            }
            else if (gui.b4.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Canciones;
            }
            else if (gui.t1b1.mouseOverButton(this)) {
                gui.t1.nextPage();
            }
            else if (gui.t1b2.mouseOverButton(this)) {
                gui.t1.prevPage();
            }
            else if (gui.rb2.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Favoritos;
            }
            else if (gui.rb3.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.TusCanciones;
            }
            else if (gui.rb4.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.TusListas;
            }
        } else if (gui.pantallaActual == GUI.PANTALLA.TusCanciones) {
            if (gui.b3.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Favoritos;
            }
            else if (gui.b4.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Canciones;
            }
            else if (gui.t2b1.mouseOverButton(this)) {
                gui.t2.nextPage();
            }
            else if (gui.t2b2.mouseOverButton(this)) {
                gui.t2.prevPage();
            }
            if (gui.rb2.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Favoritos;
            }
            else if (gui.rb3.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.TusCanciones;
            }
            else if (gui.rb4.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.TusListas;
            }
            else if (gui.b5.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.agregarCanción;
            }
        } else if (gui.pantallaActual == GUI.PANTALLA.TusListas) {
            if (!gui.confirml.isVisible()) {
                gui.cardSeleccionada = gui.ptl1.checkCardClick(this);
            }
            if (gui.b3.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Favoritos;
            }
            else if (gui.b4.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Canciones;
            }
            else if (gui.rb2.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Favoritos;
            }
            else if (gui.rb3.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.TusCanciones;
            }
            else if (gui.rb4.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.TusListas;
            }
            else if (gui.confirml.isVisible() && gui.confirml.bAceptar.mouseOverButton(this)) {
                String titulo = gui.cardSeleccionada.getTitle();
                db.deleteInfoTaulaLista(titulo);
                gui.ptl1 = new PagedTusListas(this, gui.numCardsPage2, -10 + menuWidth + margeH, margeV + 60, gui.cardsW, gui.cardsH);
                String[][] inf3 = db.getInfoTaulaTusListas("nuriafemeniass");
                gui.ptl1.setData(inf3);
                gui.ptl1.setCards(this, gui.iconoP);
                gui.confirml.setVisible(false);
            }
            else if (gui.confirml.isVisible() && gui.confirml.bCancelar.mouseOverButton(this)) {
                gui.confirml.setVisible(false);
            }
            else if (gui.cardSeleccionada != null && gui.cardSeleccionada.mouseOnPapeleraButton(this)) {
                gui.confirml.setVisible(true);
            }
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
            else if (gui.b6.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.agregarLista;
            }
            gui.ptl1.checkButtons(this);
        } else if (gui.pantallaActual == GUI.PANTALLA.agregarLista) {
            if (gui.b3.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Favoritos;
            }
            else if (gui.b4.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Canciones;
            }
            else if (gui.rb2.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Favoritos;
            }
            else if (gui.rb3.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.TusCanciones;
            }
            else if (gui.rb4.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.TusListas;
            }
            else if (gui.b29.mouseOverButton(this)) {
                String titulo = gui.tf6.text;
                String subtitulo = gui.tf66.text;
                String categoria = gui.s3.getSelectedValue();
                String numCateg = db.getClaveFromTabla("categoría", "idCategoría", "nombre", categoria);
                db.insertLista(titulo, subtitulo, numCateg);
            }
            else if (gui.sb3.mouseOverButton(this)) {
                gui.sb3.toggle();
            }
            else if (gui.s3.mouseOverSelect(this)) {
                if (!gui.s3.isCollapsed()) {
                    gui.s3.update(this);
                }
                gui.s3.toggle();
            }
            gui.tf6.isPressed(this);
            gui.tf66.isPressed(this);
        } else if (gui.pantallaActual == GUI.PANTALLA.agregarCanción) {
            if (gui.b3.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Favoritos;
            }
            else if (gui.b4.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Canciones;
            }
            else if (gui.rb2.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Favoritos;
            }
            else if (gui.rb3.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.TusCanciones;
            }
            else if (gui.rb4.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.TusListas;
            }
            else if (gui.b29.mouseOverButton(this)) {
                String titulo = gui.tf6.text;
                String dia = db.formataFechaEng(gui.c.getSelectedDate());
                String lista = gui.tList.getSelectedValue();
                String favoritos = gui.sb1.isEnabled() ? "1" : "0";
                db.insertCancion(titulo, dia, lista, favoritos);
                gui.t1 = new PagedTable(gui.files, gui.columnes);
                gui.t1.setHeaders(gui.headers);
                String[][] inf = db.getInfoTaulaFavoritos("nuriafemeniass");
                gui.t1.setData(inf);
                gui.t1.setColumnWidths(gui.colWidths);

            }
            else if (gui.s1.mouseOverSelect(this)) {
                if (!gui.s1.isCollapsed()) {
                    gui.s1.update(this);
                }
                gui.s1.toggle();
            }
            else if (gui.sb1.mouseOverButton(this)) {
                gui.sb1.toggle();
            }
            else if (gui.b9.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.TusCanciones;
            }
            gui.c.checkButtons(this);
            gui.tf6.isPressed(this);
            gui.tf66.isPressed(this);
            gui.tList.getTextField().isPressed(this);
            gui.tList.buttonPressed(this);
        } else if (gui.pantallaActual == GUI.PANTALLA.Calentamiento) {
            if (gui.b3.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Favoritos;
            }
            else if (gui.b4.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Canciones;
            }
            else if (gui.b21.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Barra;
                gui.nombreCalentamiento = "BARRA";
                gui.pl1 = new PagedLists(this, gui.numCardsPage2, -10 + menuWidth + margeH, margeV + 60, gui.cardsW, gui.cardsH);
                String[][] infoBarra = db.getInfoListasCategoria("nuriafemeniass", "Barra");
                gui.pl1.setData(infoBarra);
                gui.pl1.setCards(this);
            }
            else if (gui.b22.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Barra;
                gui.nombreCalentamiento = "CENTRO";
                gui.pl1 = new PagedLists(this, gui.numCardsPage2, -10 + menuWidth + margeH, margeV + 60, gui.cardsW, gui.cardsH);
                String[][] infoCentro = db.getInfoListasCategoria("nuriafemeniass", "Centro");
                gui.pl1.setData(infoCentro);
                gui.pl1.setCards(this);
            }
            else if (gui.b23.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Barra;
                gui.nombreCalentamiento = "DIAGONAL";
                gui.pl1 = new PagedLists(this, gui.numCardsPage2, -10 + menuWidth + margeH, margeV + 60, gui.cardsW, gui.cardsH);
                String[][] infoDiagonal = db.getInfoListasCategoria("nuriafemeniass", "Diagonal");
                gui.pl1.setData(infoDiagonal);
                gui.pl1.setCards(this);
            }
            else if (gui.b27.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.agregarLista;
            }
        } else if (gui.pantallaActual == GUI.PANTALLA.Coreografia) {
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
            else if (gui.b27.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.agregarLista;
            }
        } else if (gui.pantallaActual == GUI.PANTALLA.Barra) {
            ListCard lcs = gui.pl1.checkCardClick(this);
            if (lcs != null){
                String tituloLista = lcs.getTitle();
                println(tituloLista);
                gui.pantallaActual = GUI.PANTALLA.ListaCanciones;
                gui.ps1 = new PagedSongs(this, gui.numCardsPage, -10+menuWidth+margeH, margeV+60, gui.cardsW, gui.cardsH);
                String[][] inf = db.getCancionesLista("nuriafemeniass", tituloLista);
                gui.ps1.setData(inf);
                gui.ps1.setCards(this, gui.imgFave, gui.imgNoFave, gui.imgPlay);
            }
            else if (gui.b3.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Favoritos;
            }
            else if (gui.b4.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Canciones;
            }
            gui.pl1.checkButtons(this);
        } else if (gui.pantallaActual == GUI.PANTALLA.ListaCanciones) {
                gui.ps1.checkButtons(this);
                gui.cs = gui.ps1.checkCardButtonsClick(this);
                if(gui.cs != null && gui.cs.bPlay.mouseOverButton(this)){
                    println("PLAY:"+ gui.cs.getTitle());
                    String tituloCancion = gui.cs.getTitle() +".mp3";
                    gui.mp.setSound(this, tituloCancion);
                    gui.pantallaActual = GUI.PANTALLA.Reproductor;
                }
                else if(gui.cs != null && gui.cs.bFavorite.mouseOverButton(this)){
                    println("FAVRITO:"+ gui.cs.getTitle());
                    String tituloCancion = gui.cs.getTitle();
                    boolean fav = ! gui.cs.bFavorite.isFavorite();
                    db.updateFavoritoCancion(tituloCancion, fav);
                    gui.updateFavoritos();
                    gui.cs.bFavorite.toggleFavorite();
                }
                else if (gui.b3.mouseOverButton(this)) {
                    gui.pantallaActual = GUI.PANTALLA.Favoritos;
                }
                else if (gui.b4.mouseOverButton(this)) {
                    gui.pantallaActual = GUI.PANTALLA.Canciones;
                }
                else if (gui.b11.mouseOverButton(this)) {
                    gui.pantallaActual = GUI.PANTALLA.Barra;
                }
        } else if (gui.pantallaActual == GUI.PANTALLA.Reproductor) {
            if (gui.b3.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Favoritos;
            }
            else if (gui.b4.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Canciones;
            }
            else if (gui.b10.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.ListaCanciones;
            }
            gui.mp.checkButtons(this);
        } else if (gui.pantallaActual == GUI.PANTALLA.cancionesTusListas) {
            if (gui.b3.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Favoritos;
            }
            else if (gui.b4.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Canciones;
                gui.db.updateFavoritoCancion("Nom Canço", true);
                gui.db.updateFavoritoCancion("Nom Canço", false);
            } else if (gui.rb2.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.Favoritos;
            }
            else if (gui.rb3.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.TusCanciones;
            }
            else if (gui.rb4.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.TusListas;
            }
        }
    }
}