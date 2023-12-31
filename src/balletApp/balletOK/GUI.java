package balletApp.balletOK;

import balletApp.balletOK.gui.Button;
import balletApp.balletOK.gui.MusicPlayer;
import balletApp.balletOK.gui.RoundButton;
import balletApp.balletOK.gui.TextField;
import balletApp.balletOK.gui.PagedTable;
import balletApp.balletOK.gui.Select;
import balletApp.balletOK.gui.SwitchButton;
import static balletApp.balletOK.Mides.*;
import processing.core.PImage;
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
    Button b1,b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20;
    RoundButton rb1, rb11, rb2, rb3, rb4;
    PImage icono1, icono2, icono3, icono4;
    MusicPlayer mp;
    TextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9;

    // Propietats de "PagedTable" (taules)
    // Elements de la Interfície Gràfica (Table)
    // Botons
        public Button t1b1, t1b2;

        // Dimensions dels botons
        float buttonW = 60, buttonH = 30;

        // Taula Paginada
        public PagedTable t1;

        // Dimensions de la taula
        float tableW = rect2Width, tableH = rect2Height-60;

        // Número de files (capçalera inclosa) i columnes de la taula
        int files = 7, columnes = 3;

        // Títols de les columnes
        String[] headers = {"Categoría", "Subcategoría", "Título"};

        // Amplades de les columnes
        float[] colWidths = {20, 30, 50};

        // Dades de la taula
        String[][] info = {
                {"1", "Pere", "Soler Miralles"},
                {"2", "Maria", "Garcia Lopez"},
                {"3", "Joan", "Melis Cabrer"},
                {"4", "Bel", "Riera Mates"},
                {"5", "Jose", "Perez Galdós"},
                {"6", "Pere", "Soler Miralles"},
                {"7", "Maria", "Garcia Lopez"},
                {"8", "Joan", "Melis Cabrer"},
                {"9", "Bel", "Riera Mates"},
                {"10", "Jose", "Perez Galdós"},
                {"11", "Pere", "Soler Miralles"},
                {"12", "Maria", "Garcia Lopez",},
                {"13", "Joan", "Melis Cabrer"},
                {"14", "Bel", "Riera Mates"},
                {"15", "Jose", "Perez Galdós"},
                {"16", "Pepe", "Viyuela Lopez"},
        };


    // Propietats del Select
    Select s1;
        // Valors dels Selects
        String[] selectValues = {"Calentamiento", "Coreografía"};
    /*  String[] selectValues2 = {"Barra", "Centro", "Diagonal"};
             BARRA: String[] selectValues3 = {"", "", ""};
             CENTRO: String[] selectValues3 = {"", "", ""};
             DIAGONAL: String[] selectValues3 = {"", "", ""};

        o String[] selectValues2 = {"Ballets", "Variaciones", "Otras"};
             BALLETS: String[] selectValues3 = {"Cascanueces", "Don Quijote", "Giselle", "El Lago de los Cisnes", "La bella durmiente", "Romeo y Julieta", "Corsario", "Carmen"};
             VARIACIONES: String[] selectValues3 = {"Mujeres", "Hombres"};
    */

        // Dimensions dels botons
        float selectW = 350, selectH = 30;

        // Color de fons de l'App
        int bgColor = 255;

        // Valor numèric
        int n = 0;


    // Propietats de SwitchButton
    SwitchButton sb1, sb2;





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
        //b4.setFont(fonts.getSecondFont());
            //dibuijaPantallaRegistro
        b5 = new Button(p5, "Agregar canción", 390+(rect2Width-300), 100+rect2Height-40, 300, 40);
        b6 = new Button(p5, "Agregar lista", 390+(rect2Width-300), 100+rect2Height-40, 300, 40);
        b7 = new Button(p5, "Calentamiento", 390, margeV, rect34Width, rect34Height);
        b7.setColors(colores.getColorAt(0), 0, colores.getColorAt(2), colores.getColorAt(3));
        b7.setFont(fonts.getFirstFont());
        b8 = new Button(p5, "Coreografía", 390+rect34Width+50, margeV, rect34Width, rect34Height);
        b8.setColors(colores.getColorAt(0), 0, colores.getColorAt(2), colores.getColorAt(3));
        b8.setFont(fonts.getFirstFont());

        // BOTON VOLVER
            // Pantalla agregarCanción
            b9 = new Button(p5, "Volver", 390, 600-botonVolverHeight, botonVolverWidth, botonVolverHeight);
            b9.setColors(colores.getColorAt(7), 0, colores.getColorAt(5), colores.getColorAt(0));
            // Pantalla cancionesTusListas
            b10 = new Button(p5, "Volver", 390, 600-botonVolverHeight, botonVolverWidth, botonVolverHeight);
            b10.setColors(colores.getColorAt(7), 0, colores.getColorAt(5), colores.getColorAt(0));
            // Pantalla agregarLista
            b11 = new Button(p5, "Volver", 390, 600-botonVolverHeight, botonVolverWidth, botonVolverHeight);
            b11.setColors(colores.getColorAt(7), 0, colores.getColorAt(5), colores.getColorAt(0));
            // Pantalla Calentamiento y Coreografia (para volver a la pantalla "Canciones")
            b12 = new Button(p5, "Volver", -10+menuWidth+margeH, margeV+60+rect2Height+25, botonVolverWidth, botonVolverHeight);
            b12.setColors(colores.getColorAt(7), 0, colores.getColorAt(5), colores.getColorAt(0));
            // En todas las pantallas donde hay listas del Calentamiento (Barra, centro y diagonal) (para volver a la pantalla "Calentamiento")
            b13 = new Button(p5, "Volver", -10+menuWidth+margeH, margeV+60+rect2Height+25, botonVolverWidth, botonVolverHeight);
            b13.setColors(colores.getColorAt(7), 0, colores.getColorAt(5), colores.getColorAt(0));
            // En todas las pantallas donde hay listas de Coreografía (Variaciones, ballets y otras) (para volver a la pantalla "Coreografía")
            b14 = new Button(p5, "Volver", -10+menuWidth+margeH, margeV+60+rect2Height+25, botonVolverWidth, botonVolverHeight);
            b14.setColors(colores.getColorAt(7), 0, colores.getColorAt(5), colores.getColorAt(0));
            // Pantalla lista de canciones de Barra (para volver a la pantalla Barra)
            b15 = new Button(p5, "Volver", -10+menuWidth+margeH, margeV+60+rect2Height+25, botonVolverWidth, botonVolverHeight);
            b15.setColors(colores.getColorAt(7), 0, colores.getColorAt(5), colores.getColorAt(0));
            // Pantalla lista de canciones de Centro (para volver a la pantalla Centro)
            b16 = new Button(p5, "Volver", -10+menuWidth+margeH, margeV+60+rect2Height+25, botonVolverWidth, botonVolverHeight);
            b16.setColors(colores.getColorAt(7), 0, colores.getColorAt(5), colores.getColorAt(0));
            // Pantalla lista de canciones de Diagonal (para volver a la pantalla Diagonal)
            b17 = new Button(p5, "Volver", -10+menuWidth+margeH, margeV+60+rect2Height+25, botonVolverWidth, botonVolverHeight);
            b17.setColors(colores.getColorAt(7), 0, colores.getColorAt(5), colores.getColorAt(0));
            // Pantalla lista de canciones de Ballets (para volver a la pantalla Ballets)
            b18 = new Button(p5, "Volver", -10+menuWidth+margeH, margeV+60+rect2Height+25, botonVolverWidth, botonVolverHeight);
            b18.setColors(colores.getColorAt(7), 0, colores.getColorAt(5), colores.getColorAt(0));
            // Pantalla lista de canciones de Variaciones (para volver a la pantalla Variaciones)
            b19 = new Button(p5, "Volver", -10+menuWidth+margeH, margeV+60+rect2Height+25, botonVolverWidth, botonVolverHeight);
            b19.setColors(colores.getColorAt(7), 0, colores.getColorAt(5), colores.getColorAt(0));
            // Pantalla lista de canciones de Otras (para volver a la pantalla Otras)
            b20 = new Button(p5, "Volver", -10+menuWidth+margeH, margeV+60+rect2Height+25, botonVolverWidth, botonVolverHeight);
            b20.setColors(colores.getColorAt(7), 0, colores.getColorAt(5), colores.getColorAt(0));




//ICONOS --> https://www.flaticon.es/

        // Creació del RoundButton
            //botonsTuCuenta
                    this.setMedia(p5);  // Carrega les imatges
                    // Inicialització de components (botons)
        rb1 = new RoundButton(p5, icono1, margeH+(photo2Width/2), margeV+((usuariRadi)/2+15), usuariRadi-55);
        rb11 = new RoundButton(p5, icono1, margeH+photo1Width+margeH+(rect1Width/2), margeV+(usuariRadi/2)+10, usuariRadi-55);
        rb2 = new RoundButton(p5, icono2, 540+35, margeV+60+rect2Height+30+35, 35);
        rb2.setColors(colores.getColorAt(0), 0, colores.getColorAt(2), colores.getColorAt(3));
        rb3 = new RoundButton(p5, icono3, (540+35+540+550-35)/2, margeV+60+rect2Height+30+35, 35);
        rb3.setColors(colores.getColorAt(0), 0, colores.getColorAt(2), colores.getColorAt(3));
        rb4 = new RoundButton(p5, icono4, 540+550-35, margeV+60+rect2Height+30+35, 35);
        rb4.setColors(colores.getColorAt(0), 0, colores.getColorAt(2), colores.getColorAt(3));



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
            // dibuijaPantallaAgregarCancion
        tf6 = new TextField(p5, 390, 100, 850, 30);
        tf6.setColors(colores.getColorAt(5), 0, 0, colores.getColorAt(2));
        tf6.setFont(fonts.getThirdFont());
        tf7 = new TextField(p5, 390, 100+30+20, 850, 30);
        tf7.setColors(colores.getColorAt(5), 0, 0, colores.getColorAt(2));
        tf7.setFont(fonts.getThirdFont());
            // dibuijaPantallaAgregarLista
        tf8 = new TextField(p5, 390, 100, 850, 30);
        tf8.setColors(colores.getColorAt(5), 0, 0, colores.getColorAt(2));
        tf8.setFont(fonts.getThirdFont());
        tf9 = new TextField(p5, 390, 100+30+20, 850, 30);
        tf9.setColors(colores.getColorAt(5), 0, 0, colores.getColorAt(2));
        tf9.setFont(fonts.getThirdFont());


        // Creació de les Taules paginades
        // Creació de la taula 1
        t1 = new PagedTable(files, columnes);
        t1.setHeaders(headers);
        t1.setData(info);
        t1.setColumnWidths(colWidths);
        // Creació dels botons 1
        t1b1 = new Button(p5, ">", 390 + tableW/2 + 10 + buttonW - buttonW/2, tableH + 130, buttonW, buttonH);
        t1b1.setColors(colores.getColorAt(5), 0, colores.getColorAt(2), colores.getColorAt(2));
        t1b2 = new Button(p5, "<", 390 + tableW/2 - 10 - buttonW - buttonW/2, tableH + 130, buttonW, buttonH);
        t1b2.setColors(colores.getColorAt(5), 0, colores.getColorAt(2), colores.getColorAt(2));


        // Creació dels Select
        s1 = new Select(selectValues, 390, 100+2*30+20+30, selectW, selectH);


        // Creació dels Switch Button
        sb1 = new SwitchButton(p5, 390, 210+selectH+60, 350, 50);
        sb2 = new SwitchButton(p5, 390, 210+selectH+60+30+50, 350, 50);
    }








    // Carrega els elements multimedia que utilitzen els components del GUI
    public void setMedia(PApplet p5){
        //p5.scale(0.5f, 0.5f); ??????????????????????????????????? Fer imatge més petita ?????????????????????????????????????
        icono1 = p5.loadImage("usuario.png");
        icono2 = p5.loadImage("Favoritos.png"); // https://www.flaticon.es/icono-gratis/estrella_1828970?related_id=1828884&origin=search ; https://www.flaticon.es/icono-gratis/amor_5007082?related_id=5011077&origin=search
        icono3 = p5.loadImage("TusCanciones.png"); // https://www.flaticon.es/icono-gratis/musica_4498848?related_id=4498154&origin=search ; https://www.flaticon.es/icono-gratis/lista-de-reproduccion_2585136
        icono4 = p5.loadImage("TusListas.png"); // https://www.flaticon.es/icono-gratis/cancion_6499489 ; https://www.flaticon.es/icono-gratis/letras-de-canciones_10476137?related_id=10476143&origin=search ; https://www.flaticon.es/icono-gratis/lista-de-verificacion_10396949
    }

    public void dibujaBotonsTuCuentaRB(PApplet p5){
        rb2.display(p5);
        rb3.display(p5);
        rb4.display(p5);
    }

    public void dibujaPantallaRegistro(PApplet p5){
        // Pantalla
        p5.background(255);
        dibujaPhoto1(p5);
        //dibujaUsuari(p5);
        rb11.display(p5);
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
        //dibujaUsuariMenu(p5);
        rb1.display(p5);
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
            t1.display(p5, 390, 100, tableW, tableH);
            // Dibuixa els botons
            t1b1.display(p5);
            t1b2.display(p5);
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
        b5.display(p5);
    }

    public void dibujaPantallaAgregarCancion(PApplet p5){
        // Pantalla
        p5.background(255);
        dibujaFullMenu(p5);
        dibujaRect2(p5);
        dibujaBotonsTuCuenta(p5);
        // Botones y otros
        dibujaBotonsTuCuentaRB(p5);
        tf6.display(p5);
        tf7.display(p5);
        s1.display(p5);
        sb1.display(p5);
        sb2.display(p5);
        b9.display(p5);
    }

    public void dibujaPantallaTusListas(PApplet p5){
        // Pantalla
        p5.background(255);
        dibujaFullMenu(p5);
        dibujaRect2(p5);
        dibujaBotonsTuCuenta(p5);
        // Botones y otros
        dibujaBotonsTuCuentaRB(p5);
        b6.display(p5);
    }

    public void dibujaPantallaCancionesTusListas(PApplet p5){
        // Pantalla
        p5.background(255);
        dibujaFullMenu(p5);
        dibujaRect2(p5);
        dibujaBotonsTuCuenta(p5);
        // Botones y otros
        dibujaBotonsTuCuentaRB(p5);
        b5.display(p5);
        b10.display(p5);
    }

    public void dibujaPantallaAgregarLista(PApplet p5){
        // Pantalla
        p5.background(255);
        dibujaFullMenu(p5);
        dibujaRect2(p5);
        dibujaBotonsTuCuenta(p5);
        // Botones y otros
        dibujaBotonsTuCuentaRB(p5);
        tf8.display(p5);
        tf9.display(p5);
        b11.display(p5);
    }

    public void dibujaPantallaCanciones(PApplet p5){
        // Pantalla
        p5.background(255);
        dibujaFullMenu(p5);
        dibujaRect34(p5);
        // Botones y otros
        b7.display(p5);
        b8.display(p5);
    }

    public void dibujaPantallaCalentamiento(PApplet p5){
        // Pantalla
        p5.background(255);
        dibujaFullMenu(p5);
        dibujaRect2(p5);
        dibujaBotonsCanciones(p5);
        mp.display(p5);
        // Botones y otros
        b12.display(p5);
    }

    public void dibujaPantallaCoreografia(PApplet p5){
        // Pantalla
        p5.background(255);
        dibujaFullMenu(p5);
        dibujaRect2(p5);
        dibujaBotonsCanciones(p5);
        // Botones y otros
        b12.display(p5);
    }

    public void dibujaPantallaListas(PApplet p5){
        // Pantalla
        p5.background(255);
        dibujaFullMenu(p5);
        dibujaRect2(p5);
        dibujaBotonsCanciones(p5);
        // Botones y otros
        b13.display(p5);
    }

    public void dibujaPantallaListasCanciones(PApplet p5){
        // Pantalla
        p5.background(255);
        dibujaFullMenu(p5);
        dibujaRect2(p5);
        dibujaBotonsCanciones(p5);
        // Botones y otros
        b15.display(p5);
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

    /*public void dibujaUsuari(PApplet p5){                    // 3
        p5.fill(200);
        p5.ellipseMode(p5.CENTER);
        p5.ellipse(margeH+photo1Width+margeH+(rect1Width/2), margeV+(usuariRadi/2), usuariRadi, usuariRadi);
    }

     public void dibujaUsuariMenu(PApplet p5){                // 4
        p5.fill(190);
        p5.ellipse(margeH+(photo2Width/2), margeV+((usuariRadi+10)/2), usuariRadi+10, usuariRadi+10);
    }
    */

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
        //p5.rect(-10+menuWidth+margeH, margeV+60+rect2Height+25, botonVolverWidth, botonVolverHeight, 30);
        p5.rect(-10+menuWidth+margeH+500, margeV+60+rect2Height+40, botonAñadirWidth, botonAñadirHeight, 30);
    }
}