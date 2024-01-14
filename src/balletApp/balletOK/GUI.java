package balletApp.balletOK;

import balletApp.balletOK.gui.*;

import static balletApp.balletOK.Mides.*;

import processing.core.PImage;
import processing.core.PApplet;


public class GUI {
    public enum PANTALLA {registro, Favoritos, TusCanciones, agregarCanción, TusListas,
        cancionesTusListas, agregarLista, Canciones, Calentamiento, Coreografia,
        Barra, Centro, Diagonal, Ballets, VariacionesListaCanciones, ListaCanciones
    };

    public PANTALLA pantallaActual;

    Colors colores;
    Fonts fonts;

    // Declaració dels components de la GUI
    Button  b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20,
            b21, b22, b23, b24, b25, b26, b27, b28;
    RoundButton rb1, rb11, rb2, rb3, rb4;
    PImage icono1, icono2, icono3, icono4;
    MusicPlayer
            /*1BARRA*/
            mp111, mp112, mp121, mp122, mp131, mp132, mp141, mp142, mp151, mp152, mp161, mp162, mp171, mp172, mp181, mp182,
            mp191, mp192, mp1101, mp1102, mp1111, mp1112, mp1121, mp1122, mp1131, mp1132, mp1141, mp1142, mp1151, mp1152,
            /*2CENTRO*/
            mp211, mp212, mp221, mp222, mp231, mp232, mp241, mp242, mp251, mp252, mp261, mp262, mp271, mp272,
            mp281, mp282, mp291, mp292, mp2101, mp2102, mp2111, mp2112, mp2121, mp2122, mp2131, mp2132,
            /*3DIAGONAL*/
            mp311, mp312, mp321, mp322, mp331, mp332, mp341, mp342, mp351, mp352, mp361, mp362, mp371, mp372,
            /*4BALLETS*/
                /*41Carmen*/
                mp411, mp412, mp413, mp414, mp415, mp416, mp417, mp418, mp419, mp4110, mp4111,
                /*42Don Quixote*/
                mp421, mp422, mp423, mp424, mp425, mp426, mp427, mp428, mp429, mp4210, mp4211, mp4212, mp4213, mp4214,
                /*43Giselle*/
                mp431, mp432, mp433, mp434, mp435, mp436, mp437, mp438, mp439, mp4310, mp4311, mp4312, mp4313, mp4314,
                /*44La Bayadere*/
                mp441, mp442, mp443, mp444, mp445, mp446, mp447, mp448, mp449, mp4410, mp4411, mp4412, mp4413, mp4414,
                /*45Le Corsaire*/
                mp451, mp452, mp453, mp454, mp455, mp456, mp457, mp458, mp459, mp4510, mp4511, mp4512, mp4513, mp4514,
                /*46Nutcracker*/
                mp461, mp462, mp463, mp464, mp465, mp466, mp467, mp468, mp469, mp4610, mp4611, mp4612, mp4613, mp4614,
                /*47Paquita*/
                mp471, mp472, mp473, mp474, mp475, mp476, mp477, mp478, mp479, mp4710, mp4711, mp4712, mp4713, mp4714,
                /*48Romeo and Juliet*/
                mp481, mp482, mp483, mp484, mp485, mp486, mp487, mp488, mp489, mp4810, mp4811, mp4812, mp4813, mp4814,
                /*49Swan Lake*/
                mp491, mp492, mp493, mp494, mp495, mp496, mp497, mp498, mp499, mp4910, mp4911, mp4912, mp4913, mp4914,
                /*410The Sleeping Beauty*/
                mp4101, mp4102, mp4103, mp4104, mp4105, mp4106, mp4107, mp4108, mp4109, mp41010, mp41011, mp41012, mp41013, mp41014,
            /*5OTRAS*/
            mp51, mp52, mp53, mp54, mp55, mp56, mp57,
            /*6VARIACIONES*/
                /*61Mujer*/
                mp611, mp612, mp613, mp614, mp615, mp616, mp617, mp618, mp619, mp6110,
                mp6111, mp6112, mp6113, mp6114, mp6115, mp6116, mp6117, mp6118,
                /*62Hombre*/
                mp621, mp622, mp623, mp624, mp625, mp626, mp627, mp628;

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
    Select s1, s2, s3;
    // Valors dels Selects
    String[] selectValues = {"Calentamiento", "Coreografía"};
    /*  String[] selectValues2 = {"Barra", "Centro", "Diagonal"};
             BARRA: String[] selectValues3 = {"", "", ""...};
             CENTRO: String[] selectValues3 = {"", "", ""...};
             DIAGONAL: String[] selectValues3 = {"", "", ""...};

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

    // Propietats de CheckBox
    CheckBox cb1;

    // Calendari
    Calendari c;

    // Paged songs
    // Cançons Paginades
        PagedSongs ps;

        // Cançó Seleccionada
        SongCard cs = null;

        // Dimensions de les cards
        float cardsW = 800, cardsH = 600;

        // Número de cançons per pàgina
        int numCardsPage = 8;

        // Dades de la taula
        String[][] inf = {
                {"1", "Títol Cançó 1", "POP", "true"},
                {"2", "Títol Cançó 2", "ROCK", "false"},
                {"3", "Títol Cançó 3", "CLASSIC", "true"},
                {"4", "Títol Cançó 4", "POP", "true"},
                {"5", "Títol Cançó 5", "POP", "false"},
                {"6", "Títol Cançó 6", "ROCK", "true"},
                {"7", "Títol Cançó 7", "DANCE", "true"},
                {"8", "Títol Cançó 8", "CLASSIC", "true"},
                {"9", "Títol Cançó 9", "POP", "false"},
                {"10", "Títol Cançó 10", "ROCK", "true"},
        };

        // Icones dels botons
        PImage imgFave, imgNoFave, imgPlay;




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
        /*b2 = new Button(p5, "¿Está ya registrado?", 440+10, 220+5*40+5*20+80, 540, 50);
        b2.setColors(colores.getColorAt(0), 0, colores.getColorAt(2), colores.getColorAt(3));
        //b2.setFont(fonts.getSecondFont());
        */
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
        //dibujaPantallaCalentamiento
        b21 = new Button(p5, "Barra", 390, 100, botonesListasWidth, botonesListasHeight);
        b21.setColors(colores.getColorAt(3), 0, colores.getColorAt(2), colores.getColorAt(3));
        //b21.setFont(fonts.getFirstFont());
        b22 = new Button(p5, "Centro", 390, 100+botonesListasHeight+40, botonesListasWidth, botonesListasHeight);
        b22.setColors(colores.getColorAt(3), 0, colores.getColorAt(2), colores.getColorAt(3));
        //b22.setFont(fonts.getFirstFont());
        b23 = new Button(p5, "Diagonal", 390, 100+2*botonesListasHeight+2*40, botonesListasWidth, botonesListasHeight);
        b23.setColors(colores.getColorAt(3), 0, colores.getColorAt(2), colores.getColorAt(3));
        //b23.setFont(fonts.getFirstFont());
        //dibujaPantallaCoreografía
        b24 = new Button(p5, "Ballets", 390, 100, botonesListasWidth, botonesListasHeight);
        b24.setColors(colores.getColorAt(3), 0, colores.getColorAt(2), colores.getColorAt(3));
        //b24.setFont(fonts.getFirstFont());
        b25 = new Button(p5, "Variaciones", 390, 100+botonesListasHeight+40, botonesListasWidth, botonesListasHeight);
        b25.setColors(colores.getColorAt(3), 0, colores.getColorAt(2), colores.getColorAt(3));
        //b25.setFont(fonts.getFirstFont());
        b26 = new Button(p5, "Otras", 390, 100+2*botonesListasHeight+2*40, botonesListasWidth, botonesListasHeight);
        b26.setColors(colores.getColorAt(3), 0, colores.getColorAt(2), colores.getColorAt(3));
        //b26.setFont(fonts.getFirstFont());
        // Agregar Lista o Canción
        b27 = new Button(p5, "Agregar Lista", -10+menuWidth+margeH+500, margeV+60+rect2Height+40, botonAñadirWidth, botonAñadirHeight);
        b27.setColors(190, 0, 100, 190);
        //b27.setFont(fonts.getFirstFont());
        b28 = new Button(p5, "Agregar Canción", -10+menuWidth+margeH+500, margeV+60+rect2Height+40, botonAñadirWidth, botonAñadirHeight);
        b28.setColors(190, 0, 100, 190);
        //b28.setFont(fonts.getFirstFont());



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
        mp111 = new MusicPlayer(p5,120, p5.height/3);
        mp111.setSound(p5, "C:\\Users\\usuario\\OneDrive\\Escritorio\\SolInfNuria\\SolInfNuria2324\\data\\MusicPlayer\\Calentamiento\\Barra\\1WarmUp\\1.mp3");
        mp112 = new MusicPlayer(p5,520, p5.height/1.5f);
        mp112.setSound(p5, "C:\\Users\\usuario\\OneDrive\\Escritorio\\SolInfNuria\\SolInfNuria2324\\data\\MusicPlayer\\Calentamiento\\Barra\\1WarmUp\\2.mp3");



        // Creació del Text Field
        // dibuijaPantallaRegistro
        tf1 = new TextField(p5, 440, 250, 790, 30);
        tf1.setColors(colores.getColorAt(5), 0, 0, colores.getColorAt(2));
        //tf1.setColors(150, 0, 0, 240);
        tf1.setFont(fonts.getThirdFont());
        tf2 = new TextField(p5, 440, 250+40+20+10, 790, 30);
        tf2.setColors(colores.getColorAt(5), 0, 0, colores.getColorAt(2));
        tf2.setFont(fonts.getThirdFont());
        tf3 = new TextField(p5, 440, 250+2*40+2*20+20, 790, 30);
        tf3.setColors(colores.getColorAt(5), 0, 0, colores.getColorAt(2));
        tf3.setFont(fonts.getThirdFont());
        tf4 = new TextField(p5, 440, 250+3*40+3*20+30, 530, 30);
        tf4.setColors(colores.getColorAt(5), 0, 0, colores.getColorAt(2));
        tf4.setFont(fonts.getThirdFont());
        tf5 = new TextField(p5, 440, 250+4*40+4*20+40, 530, 30);
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
        t1.setData(inf);
        t1.setColumnWidths(colWidths);
        // Creació dels botons 1
        t1b1 = new Button(p5, ">", 390 + tableW/2 + 10 + buttonW - buttonW/2, tableH + 130, buttonW, buttonH);
        t1b1.setColors(colores.getColorAt(5), 0, colores.getColorAt(2), colores.getColorAt(2));
        t1b2 = new Button(p5, "<", 390 + tableW/2 - 10 - buttonW - buttonW/2, tableH + 130, buttonW, buttonH);
        t1b2.setColors(colores.getColorAt(5), 0, colores.getColorAt(2), colores.getColorAt(2));


        // Creació dels Select
        s1 = new Select(selectValues, 390, 100+2*30+20+30, selectW, selectH);
        //s2 = new Select(selectValues, 390+selectW+, 100+2*30+20+30, selectW, selectH);
        //s3 = new Select(selectValues, 390, 100+2*30+20+30, selectW, selectH);


        // Creació dels Switch Button
        sb1 = new SwitchButton(p5, 390, 210+selectH+60, 350, 50);
        sb2 = new SwitchButton(p5, 390, 210+selectH+60+30+50, 350, 50);

        // Creació dels CheckBox
        cb1 = new CheckBox(p5, 440+530+30-5, 250+3*40+3*20+30-5,35);

        //Calendari
        c = new Calendari(390+350+60,210+(int)selectH+30,380,290);

        // Paged songs
            // Carregar de les imatges (icones);
            imgFave = p5.loadImage("imgFave.png");
            imgNoFave = p5.loadImage("imgNoFave.png");
            imgPlay = p5.loadImage("imgPlay.png");

            // Creació de la taula
            ps = new PagedSongs(p5, numCardsPage, 50, 50, cardsW, cardsH);
            ps.setData(inf);
            ps.setCards(p5, imgFave, imgNoFave, imgPlay);

    }






    // Carrega els elements multimedia que utilitzen els components del GUI
    public void setMedia(PApplet p5){
        //p5.scale(0.5f, 0.5f); ??????????????????????????????????? Fer imatge més petita ?????????????????????????????????????
        icono1 = p5.loadImage("C:\\Users\\usuario\\OneDrive\\Escritorio\\SolInfNuria\\SolInfNuria2324\\data\\RoundButton\\usuario.png");
        icono2 = p5.loadImage("C:\\Users\\usuario\\OneDrive\\Escritorio\\SolInfNuria\\SolInfNuria2324\\data\\RoundButton\\Favoritos.png"); // https://www.flaticon.es/icono-gratis/estrella_1828970?related_id=1828884&origin=search ; https://www.flaticon.es/icono-gratis/amor_5007082?related_id=5011077&origin=search
        icono3 = p5.loadImage("C:\\Users\\usuario\\OneDrive\\Escritorio\\SolInfNuria\\SolInfNuria2324\\data\\RoundButton\\TusCanciones.png"); // https://www.flaticon.es/icono-gratis/musica_4498848?related_id=4498154&origin=search ; https://www.flaticon.es/icono-gratis/lista-de-reproduccion_2585136
        icono4 = p5.loadImage("C:\\Users\\usuario\\OneDrive\\Escritorio\\SolInfNuria\\SolInfNuria2324\\data\\RoundButton\\TusListas.png"); // https://www.flaticon.es/icono-gratis/cancion_6499489 ; https://www.flaticon.es/icono-gratis/letras-de-canciones_10476137?related_id=10476143&origin=search ; https://www.flaticon.es/icono-gratis/lista-de-verificacion_10396949
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
        // b2.display(p5);
            p5.fill(0); p5.textSize(20);
            p5.text("Nombre y Apellidos", 440, 240);
        tf1.display(p5);
            p5.fill(0); p5.textSize(20);
            p5.text("Nombre de usuario", 440, 240+40+20+10);
        tf2.display(p5);
            p5.fill(0); p5.textSize(20);
            p5.text("Correo electrónico", 440, 240+(2*40)+(2*20)+(10*2));
        tf3.display(p5);
            p5.fill(0); p5.textSize(20);
            p5.text("Contraseña", 440, 240+3*40+3*20+10*3);
        tf4.display(p5);
            p5.fill(0); p5.textSize(20);
            p5.text("Confirmar contraseña", 440, 240+4*40+4*20+10*4);
        tf5.display(p5);
            p5.fill(0); p5.textSize(20);
            p5.text("Visualizar contraseña", 440+530+30+(35+10)-5, 250+3*40+3*20+30-5+25);
        cb1.display(p5);
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
        sb1.display(p5);
        sb2.display(p5);
        s1.display(p5);
        //s2.display(p5);
        //s3.display(p5);
        b9.display(p5);
        c.display(p5);
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
        // Botones y otros
        b12.display(p5);
        p5.textAlign(p5.LEFT); //??????????????????????????????????????????????????????????????????????????????????????
        b21.display(p5);
        b22.display(p5);
        b23.display(p5);
        b27.display(p5);
    }

    public void dibujaPantallaCoreografia(PApplet p5){
        // Pantalla
        p5.background(255);
        dibujaFullMenu(p5);
        dibujaRect2(p5);
        dibujaBotonsCanciones(p5);
        // Botones y otros
        b12.display(p5);
        b24.display(p5);
        b25.display(p5);
        b26.display(p5);
        b27.display(p5);
    }

    public void dibujaPantallaBarra(PApplet p5){
        // Pantalla
        p5.background(255);
        dibujaFullMenu(p5);
        dibujaRect2(p5);
        dibujaBotonsCanciones(p5);
        // Botones y otros
        b13.display(p5);
        b27.display(p5);
                // Dibuixa les Cards paginades
                ps.display(p5);
               /* // Indica el Resultat seleccionat
                if(cs!=null){
                    p5.fill(0); p5.textSize(18);
                    p5.text("PLAY:", 900, 300);
                    p5.text(cs.getTitle(), 900, 350);
                    p5.text(cs.getCategory(), 900, 380);
                  }
                */
    }
    public void dibujaPantallaCentro(PApplet p5){
        // Pantalla
        p5.background(255);
        dibujaFullMenu(p5);
        dibujaRect2(p5);
        dibujaBotonsCanciones(p5);
        // Botones y otros
        b13.display(p5);
        b27.display(p5);
    }
    public void dibujaPantallaDiagonal(PApplet p5){
        // Pantalla
        p5.background(255);
        dibujaFullMenu(p5);
        dibujaRect2(p5);
        dibujaBotonsCanciones(p5);
        // Botones y otros
        b13.display(p5);
        b27.display(p5);
    }
    public void dibujaPantallaBallets(PApplet p5){
        // Pantalla
        p5.background(255);
        dibujaFullMenu(p5);
        dibujaRect2(p5);
        dibujaBotonsCanciones(p5);
        // Botones y otros
        b13.display(p5);
        b27.display(p5);
    }

    public void dibujaPantallaVariacionesListaCanciones(PApplet p5){
        // Pantalla
        p5.background(255);
        dibujaFullMenu(p5);
        dibujaRect2(p5);
        dibujaBotonsCanciones(p5);
        // Botones y otros
        b13.display(p5);
        b27.display(p5);
    }

    public void dibujaPantallaListaCanciones(PApplet p5){
        // Pantalla
        p5.background(255);
        dibujaFullMenu(p5);
        dibujaRect2(p5);
        dibujaBotonsCanciones(p5);
        // Botones y otros
        b13.display(p5);
        b27.display(p5);
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
        //p5.rect(-10+menuWidth+margeH+500, margeV+60+rect2Height+40, botonAñadirWidth, botonAñadirHeight, 30);
    }
}