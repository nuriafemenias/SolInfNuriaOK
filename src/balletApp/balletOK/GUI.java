package balletApp.balletOK;

import balletApp.balletOK.gui.Button;
import balletApp.balletOK.gui.MusicPlayer;
import balletApp.balletOK.gui.RoundButton;
import balletApp.balletOK.gui.TextField;
import balletApp.balletOK.gui.Table;
import balletApp.balletOK.gui.PagedTable;
import processing.core.PImage;
import static balletApp.balletOK.Mides.*;
import processing.core.PApplet;


public class GUI {
    public enum PANTALLA {registro, Favoritos, TusCanciones, agregarCanción,
        TusListas, cancionesTusListas, agregarLista,
        Canciones, Calentamiento, Coreografia, subListas,
        subListasCanciones};

    public PANTALLA pantallaActual;

    Colors colores;
    Fonts fonts;

    // Declaració dels components de la GUI
    Button b1,b2, b3, b4;
    RoundButton rb1, rb2, rb3;
    PImage icono1, icono2, icono3;
    MusicPlayer mp;
    TextField tf1, tf2, tf3, tf4, tf5;

    // Propietats de "PagedTable" (taules)
    // Elements de la Interfície Gràfica (Table)
    // Botons
    Button b11, b22;

    // Dimensions dels botons
    float buttonW = 60, buttonH = 60;

    // Taula Paginada
    PagedTable t;

    // Dimensions de la taula
    float tableW = rect2Width, tableH = rect2Height;

    // Número de files (capçalera inclosa) i columnes de la taula
    int files = 7, columnes = 5;

    // Títols de les columnes
    String[] headers = {"Id", "Nom", "Llinatges", "Edat", "Sexe"};

    // Amplades de les columnes
    float[] colWidths = {10, 20, 40, 10, 20};

    // Dades de la taula
    String[][] info = {
            {"1", "Pere", "Soler Miralles", "33", "Home"},
            {"2", "Maria", "Garcia Lopez", "25", "Dona"},
            {"3", "Joan", "Melis Cabrer", "47", "Home"},
            {"4", "Bel", "Riera Mates", "52", "Dona"},
            {"5", "Jose", "Perez Galdós", "37", "Home"},
            {"6", "Pere", "Soler Miralles", "33", "Home"},
            {"7", "Maria", "Garcia Lopez", "25", "Dona"},
            {"8", "Joan", "Melis Cabrer", "47", "Home"},
            {"9", "Bel", "Riera Mates", "52", "Dona"},
            {"10", "Jose", "Perez Galdós", "37", "Home"},
            {"11", "Pere", "Soler Miralles", "33", "Home"},
            {"12", "Maria", "Garcia Lopez", "25", "Dona"},
            {"13", "Joan", "Melis Cabrer", "47", "Home"},
            {"14", "Bel", "Riera Mates", "52", "Dona"},
            {"15", "Jose", "Perez Galdós", "37", "Home"},
            {"16", "Pepe", "Viyuela Lopez", "42", "Home"},
    };



    public GUI(PApplet p5){

        colores = new Colors(p5);
        fonts = new Fonts(p5);
        pantallaActual = PANTALLA.registro;

    // Creació de components (inicialització)
        // Creació dels Botons
            //dibuijaPantallaRegistro
        b1 = new Button(p5, "Entra", 440+550+20, 220+5*40+5*20+80, 200, 50);
        b1.setColors(colores.getColorAt(0), 0, colores.getColorAt(2), colores.getColorAt(3));
        //b1.setFont(fonts.getSecondFont());
        b2 = new Button(p5, "¿Está ya registrado?", 440+10, 220+5*40+5*20+80, 540, 50);
        b2.setColors(colores.getColorAt(0), 0, colores.getColorAt(2), colores.getColorAt(3));
        //b2.setFont(fonts.getSecondFont());
            //dibujaMenu
        b3 = new Button(p5, "Tu cuenta", 50, margeV+usuariRadi+10+75, 250, 70);
        b3.setColors(colores.getColorAt(0), 0, colores.getColorAt(2), colores.getColorAt(3));
        //b3.setFont(fonts.getSecondFont());
        b4 = new Button(p5, "Canciones", 50, margeV+usuariRadi+10+80+30+70, 250, 70);
        b4.setColors(colores.getColorAt(0), 0, colores.getColorAt(2), colores.getColorAt(3));
        //b1.setFont(fonts.getSecondFont());


//ICONOS --> https://www.flaticon.es/

        // Creació del RoundButton
            //botonsTuCuenta
                    this.setMedia(p5);  // Carrega les imatges
                    // Inicialització de components (botons)
        rb1 = new RoundButton(p5, icono1, 540+35, margeV+60+rect2Height+30+35, 35);
        rb1.setColors(colores.getColorAt(0), 0, colores.getColorAt(2), colores.getColorAt(3));
        rb2 = new RoundButton(p5, icono2, (540+35+540+550-35)/2, margeV+60+rect2Height+30+35, 35);
        rb2.setColors(colores.getColorAt(0), 0, colores.getColorAt(2), colores.getColorAt(3));
        rb3 = new RoundButton(p5, icono3, 540+550-35, margeV+60+rect2Height+30+35, 35);
        rb3.setColors(colores.getColorAt(0), 0, colores.getColorAt(2), colores.getColorAt(3));



        // Creació del Music Player
        mp = new MusicPlayer(p5,120, p5.height/3);
        mp.setSound(p5, "saxo.wav");



        // Creació del Text Field
            // dibuijaPantallaRegistro
        tf1 = new TextField(p5, 440, 220, 790, 40);
        tf1.setColors(colores.getColorAt(5), 0, 0, colores.getColorAt(2));
        tf1.setFont(fonts.getThirdFont());
        tf2 = new TextField(p5, 440, 220+40+20, 790, 40);
        tf2.setColors(colores.getColorAt(5), 0, 0, colores.getColorAt(2));
        tf2.setFont(fonts.getThirdFont());
        tf3 = new TextField(p5, 440, 220+2*40+2*20, 790, 40);
        tf3.setColors(colores.getColorAt(5), 0, 0, colores.getColorAt(2));
        tf3.setFont(fonts.getThirdFont());
        tf4 = new TextField(p5, 440, 220+3*40+3*20, 550, 40);
        tf4.setColors(colores.getColorAt(5), 0, 0, colores.getColorAt(2));
        tf4.setFont(fonts.getThirdFont());
        tf5 = new TextField(p5, 440, 220+4*40+4*20, 550, 40);
        tf5.setColors(colores.getColorAt(5), 0, 0, colores.getColorAt(2));
        tf5.setFont(fonts.getThirdFont());


        // Creació de les Taules paginades
        // Creació de la taula 1
        t = new PagedTable(files, columnes);
        t.setHeaders(headers);
        t.setData(info);
        t.setColumnWidths(colWidths);
        // Creació dels botons 1
        b11 = new Button(p5, "NEXT", 25 + tableW/2 + buttonW/1.5f, tableH + 80, buttonW, buttonH);
        b11.setColors(colores.getColorAt(5), 0, colores.getColorAt(2), colores.getColorAt(2));
        b22 = new Button(p5, "PREV", 25 + tableW/2 - buttonW/1.5f, tableH + 80, buttonW, buttonH);
        b22.setColors(colores.getColorAt(5), 0, colores.getColorAt(2), colores.getColorAt(2));


    }








    // Carrega els elements multimedia que utilitzen els components del GUI
    public void setMedia(PApplet p5){
        //p5.scale(0.5f, 0.5f); ??????????????????????????????????? Fer imatge més petita ?????????????????????????????????????
        icono1 = p5.loadImage("Favoritos.png"); // https://www.flaticon.es/icono-gratis/estrella_1828970?related_id=1828884&origin=search ; https://www.flaticon.es/icono-gratis/amor_5007082?related_id=5011077&origin=search
        icono2 = p5.loadImage("TusCanciones.png"); // https://www.flaticon.es/icono-gratis/musica_4498848?related_id=4498154&origin=search ; https://www.flaticon.es/icono-gratis/lista-de-reproduccion_2585136
        icono3 = p5.loadImage("TusListas.png"); // https://www.flaticon.es/icono-gratis/cancion_6499489 ; https://www.flaticon.es/icono-gratis/letras-de-canciones_10476137?related_id=10476143&origin=search ; https://www.flaticon.es/icono-gratis/lista-de-verificacion_10396949
    }

    public void dibujaBotonsTuCuentaRB(PApplet p5){
        rb1.display(p5);
        rb2.display(p5);
        rb3.display(p5);
    }

    public void dibujaPantallaRegistro(PApplet p5){
        // Pantalla
        p5.background(255);
        dibujaPhoto1(p5);
        dibujaUsuari(p5);
        dibujaRect1(p5);
        // Botones y otros
        b1.display(p5);
        b2.display(p5);
        tf1.display(p5);
        tf2.display(p5);
        tf3.display(p5);
        tf4.display(p5);
        tf5.display(p5);
    }

    public void dibujaFullMenu(PApplet p5){
        // Pantalla
        p5.pushStyle();
            dibujaMenu(p5);
        p5.popStyle();
        dibujaPhoto2(p5);
        dibujaUsuariMenu(p5);
        // Botones y otros
        b3.display(p5);
        b4.display(p5);
    }

    public void dibujaPantallaFavoritos(PApplet p5){
        // Pantalla
        p5.background(255);
        dibujaFullMenu(p5);
        dibujaRect2(p5);
        dibujaBotonsTuCuenta(p5);
        // Botones y otros
        dibujaBotonsTuCuentaRB(p5);
        p5.pushStyle();
            // Dibuixa la Table
            t.display(p5, 50, 50, tableW, tableH);
            // Dibuixa els botons
            b11.display(p5);
            b22.display(p5);
        p5.popStyle();
    }


    public void dibujaPantallaTusCanciones(PApplet p5){
        // Pantalla
        p5.background(255);
        dibujaFullMenu(p5);
        dibujaRect2(p5);
        dibujaBotonsTuCuenta(p5);
        // Botones y otros
        dibujaBotonsTuCuentaRB(p5);
    }

    public void dibujaPantallaAgregarCancion(PApplet p5){
        // Pantalla
        p5.background(255);
        dibujaFullMenu(p5);
        dibujaRect2(p5);
        dibujaBotonsTuCuenta(p5);
        // Botones y otros
        dibujaBotonsTuCuentaRB(p5);
    }

    public void dibujaPantallaTusListas(PApplet p5){
        // Pantalla
        p5.background(255);
        dibujaFullMenu(p5);
        dibujaRect2(p5);
        dibujaBotonsTuCuenta(p5);
        // Botones y otros
        dibujaBotonsTuCuentaRB(p5);
    }

    public void dibujaPantallaCancionesTusListas(PApplet p5){
        // Pantalla
        p5.background(255);
        dibujaFullMenu(p5);
        dibujaRect2(p5);
        dibujaBotonsTuCuenta(p5);
        // Botones y otros
        dibujaBotonsTuCuentaRB(p5);
    }

    public void dibujaPantallaAgregarLista(PApplet p5){
        // Pantalla
        p5.background(255);
        dibujaFullMenu(p5);
        dibujaRect2(p5);
        dibujaBotonsTuCuenta(p5);
        // Botones y otros
        dibujaBotonsTuCuentaRB(p5);
    }

    public void dibujaPantallaCanciones(PApplet p5){
        // Pantalla
        p5.background(255);
        dibujaFullMenu(p5);
        dibujaRect34(p5);
        // Botones y otros
    }

    public void dibujaPantallaCalentamiento(PApplet p5){
        // Pantalla
        p5.background(255);
        dibujaFullMenu(p5);
        dibujaRect2(p5);
        dibujaBotonsCanciones(p5);
        mp.display(p5);
        // Botones y otros
    }

    public void dibujaPantallaCoreografia(PApplet p5){
        // Pantalla
        p5.background(255);
        dibujaFullMenu(p5);
        dibujaRect2(p5);
        dibujaBotonsCanciones(p5);
        // Botones y otros
    }

    public void dibujaPantallaSubListas(PApplet p5){
        // Pantalla
        p5.background(255);
        dibujaFullMenu(p5);
        dibujaRect2(p5);
        dibujaBotonsCanciones(p5);
        // Botones y otros
    }

    public void dibujaPantallaSubListasCanciones(PApplet p5){
        // Pantalla
        p5.background(255);
        dibujaFullMenu(p5);
        dibujaRect2(p5);
        dibujaBotonsCanciones(p5);
        // Botones y otros
    }




    //  DIBUIX ELEMENTS, zones GUI
    public void dibujaPhoto1(PApplet p5){                      // 1
        //p5.fill(trivioApp.trivioColors.Colors.colors[3]);
        p5.fill(230);
        p5.rect(margeH, margeV, photo1Width, photo1Height);
    }

    public void dibujaRect1(PApplet p5){                      // 2
        p5.fill(200);
        p5.rect(margeH+photo1Width+margeH, margeV+usuariRadi+margeV, rect1Width, rect1Height, 30);
    }

    public void dibujaUsuari(PApplet p5){                    // 3
        p5.fill(200);
        p5.ellipseMode(p5.CENTER);
        p5.ellipse(margeH+photo1Width+margeH+(rect1Width/2), margeV+(usuariRadi/2), usuariRadi, usuariRadi);
    }

    public void dibujaUsuariMenu(PApplet p5){                // 4
        p5.fill(190);
        p5.ellipse(margeH+(photo2Width/2), margeV+((usuariRadi+10)/2), usuariRadi+10, usuariRadi+10);
    }

    public void dibujaPhoto2(PApplet p5){                    // 5
        p5.fill(190);
        p5.rect(margeH, menuHeight-photo2Height-margeV-10, photo2Width, photo2Height);
    }

    public void dibujaMenu(PApplet p5){                      // 6
        p5.fill(230);
        p5.strokeWeight(2); p5.stroke(0);
        p5.rect(-10, -10, menuWidth, menuHeight);
    }

    public void dibujaRect2(PApplet p5){                      // 7
        p5.fill(230);
        p5.rect(-10+menuWidth+margeH, margeV+60, rect2Width, rect2Height, 30);
    }

    public void dibujaBotonsTuCuenta(PApplet p5){             // 8
        p5.fill(230);
        p5.rect(-10+menuWidth+margeH+150, margeV+60+rect2Height+30, botonsTuCuentaWidth, botonsTuCuentaHeight, 30);
    }

    public void dibujaRect34(PApplet p5){                     // 9 i 10
        p5.fill(215);
        p5.rect(390, margeV, rect34Width, rect34Height, 30);
        p5.rect(390+rect34Width+50, margeV, rect34Width, rect34Height, 30);
    }

    public void dibujaBotonsCanciones(PApplet p5){           // 11 i 12
        p5.fill(215);
        p5.rect(-10+menuWidth+margeH, margeV+60+rect2Height+25, botonVolverWidth, botonVolverHeight, 30);
        p5.rect(-10+menuWidth+margeH+500, margeV+60+rect2Height+40, botonAñadirWidth, botonAñadirHeight, 30);
    }
}