package balletApp.balletOK;
import balletApp.balletOK.gui.*;
import static balletApp.balletOK.Midas.*;
import processing.core.PImage;
import processing.core.PApplet;

public class GUI {
    public enum PANTALLA {registro, Favoritos, TusCanciones, agregarCanción, TusListas, cancionesTusListas,
        agregarLista, Canciones, Calentamiento, Barra, VariacionesListaCanciones, ListaCanciones, Reproductor, Coreografia
    }
    public PANTALLA pantallaActual;
    Colores colores;
    Fuentes fonts;
    Button  b1, b3, b4, b5, b6, b7, b8, b9, b10, b11, b21, b21a, b22, b22a, b23, b23a, b24, b25, b26, b27, b28, b29;
    RoundButton rb1, rb11, rb2, rb3, rb4, rbb;
    PImage icono1, icono2, icono3, icono4, icono5, icono6, icono7, icono8;
    MusicPlayer mp, mp111, mp112;
    TextField tf1, tf2, tf3, tf4, tf5, tf6, tf66, tf8, tf9;
    public Button t1b1, t1b2, t2b1, t2b2;
    float buttonW = 60, buttonH = 30;
    public PagedTable t1, t2;
    float tableW = rect2Width, tableH = rect2Height-60;
    int files = 7, columnes = 3;
    int filess = 7;
    String[] headers = {"Categoría", "Subcategoría","Título canción"};
    float[] colWidths = {20, 30, 50};
    String[][] inf3;
    Select s1, s3;
    String[] selectValues = {"Calentamiento", "Coreografía", "Tus Listas"};
    float selectW = 340, selectH = 30;
    SwitchButton sb1, sb2, sb3;
    Calendario c;
    PagedSongs ps1;
    PagedLists pl1;
    PagedTusListas ptl1;
    PagedTable ptSongsList;
    TusListasCard cardSeleccionada;
    SongCard cs = null;
    float cardsW = 850, cardsH = rect2Height-60-50;
    int numCardsPage = 7;
    int numCardsPage2 = 4;
    String[][] inf, inf2, inff;
    PImage imgFave, imgNoFave, imgPlay, iconoP;
    TextList tList;
    Button b;
    float tListW = 600;
    float buttonWl = 120, buttonHl = 40;
    DataBase db;
    Confirma confirml;
    float compW = 600, compH = 340;
    String title = "Confirma:";
    String message = "Seguro que quieres borrar esta lista?";
    String nombreCalentamiento, tituloLista;


    /**
     * Creación de los componentes de la GUI (inicialización).
     * @param p5 objeto de la clase PApplet para dibujar
     * @param db Parámetro conexión de la base de datos, de la clase DataBase.
     */
    public GUI(PApplet p5, DataBase db){
        this.db = db;
        colores = new Colores(p5);
        fonts = new Fuentes(p5);
        pantallaActual = PANTALLA.registro;
        b1 = new Button(p5, "Entra", 440+550+20, 220+5*40+5*20+80, 200, 50);
        b1.setColors(colores.getColorAt(5), 0, colores.getColorAt(2), colores.getColorAt(3));
        b3 = new Button(p5, "Tu cuenta", 50, margeV+usuariRadi+10+75, 250, 70);
        b3.setColors(colores.getColorAt(4), 0, colores.getColorAt(3), colores.getColorAt(3));
        b4 = new Button(p5, "Canciones", 50, margeV+usuariRadi+10+80+30+70, 250, 70);
        b4.setColors(colores.getColorAt(4), 0, colores.getColorAt(3), colores.getColorAt(3));
        b5 = new Button(p5, "Agregar canción", 390+(rect2Width-300), 100+rect2Height-40, 300, 40);
        b6 = new Button(p5, "Agregar lista", 390+(rect2Width-300), 100+rect2Height-40, 300, 40);
        b7 = new Button(p5, "Calentamiento", 390, margeV, rect34Width, rect34Height);
        b7.setColors(colores.getColorAt(2), colores.getColorAt(6), colores.getColorAt(1), colores.getColorAt(3));
        b7.setFont(fonts.getSecondFont());
        b8 = new Button(p5, "Coreografía", 390+rect34Width+50, margeV, rect34Width, rect34Height);
        b8.setColors(colores.getColorAt(2), colores.getColorAt(6), colores.getColorAt(1), colores.getColorAt(3));
        b8.setFont(fonts.getSecondFont());
        b9 = new Button(p5, "Volver", 400, 600-botonVolverHeight, botonVolverWidth, botonVolverHeight);
        b9.setColors(colores.getColorAt(4), 0, colores.getColorAt(3), colores.getColorAt(2));
        b11 = new Button(p5, "Volver", 390, 600-botonVolverHeight, botonVolverWidth, botonVolverHeight);
        b11.setColors(colores.getColorAt(4), 0, colores.getColorAt(3), colores.getColorAt(0));
        b10 = new Button(p5, "Volver", 50, 600, botonVolverWidth, botonVolverHeight);
        b10.setColors(colores.getColorAt(4), 0, colores.getColorAt(3), colores.getColorAt(0));
        b21 = new Button(p5, "Barra", 390, 100, botonesListasWidth, botonesListasHeight);
        b21.setColors(colores.getColorAt(3), 0, colores.getColorAt(2), colores.getColorAt(3));
        b22 = new Button(p5, "Centro", 390, 100+botonesListasHeight+40, botonesListasWidth, botonesListasHeight);
        b22.setColors(colores.getColorAt(3), 0, colores.getColorAt(2), colores.getColorAt(3));
        b23 = new Button(p5, "Diagonal", 390, 100+2*botonesListasHeight+2*40, botonesListasWidth, botonesListasHeight);
        b23.setColors(colores.getColorAt(3), 0, colores.getColorAt(2), colores.getColorAt(3));
        b24 = new Button(p5, "Ballets", 390, 100, botonesListasWidth, botonesListasHeight);
        b24.setColors(colores.getColorAt(3), 0, colores.getColorAt(2), colores.getColorAt(3));
        b25 = new Button(p5, "Variaciones", 390, 100+botonesListasHeight+40, botonesListasWidth, botonesListasHeight);
        b25.setColors(colores.getColorAt(3), 0, colores.getColorAt(2), colores.getColorAt(3));
        b26 = new Button(p5, "Otras", 390, 100+2*botonesListasHeight+2*40, botonesListasWidth, botonesListasHeight);
        b26.setColors(colores.getColorAt(3), 0, colores.getColorAt(2), colores.getColorAt(3));
        b27 = new Button(p5, "Agregar Lista", -10+menuWidth+margeH+500, margeV+60+rect2Height+40, botonAñadirWidth, botonAñadirHeight);
        b27.setColors(190, 0, 100, 190);
        b28 = new Button(p5, "Agregar Canción", -10+menuWidth+margeH+500, margeV+60+rect2Height+40, botonAñadirWidth, botonAñadirHeight);
        b28.setColors(190, 0, 100, 190);
        b29 = new Button(p5, "Guardar", -10 + menuWidth + margeH + 500, 600-botonAñadirHeight, botonAñadirWidth, botonAñadirHeight);
        b29.setColors(190, 0, 100, 190);
        b21a = new Button(p5, "Ballets", 390, 100, botonesListasWidth, botonesListasHeight);
        b21a.setColors(colores.getColorAt(3), 0, colores.getColorAt(2), colores.getColorAt(3));
        b22a = new Button(p5, "Variaciones", 390, 100+botonesListasHeight+40, botonesListasWidth, botonesListasHeight);
        b22a.setColors(colores.getColorAt(3), 0, colores.getColorAt(2), colores.getColorAt(3));
        b23a = new Button(p5, "Otras", 390, 100+2*botonesListasHeight+2*40, botonesListasWidth, botonesListasHeight);
        b23a.setColors(colores.getColorAt(3), 0, colores.getColorAt(2), colores.getColorAt(3));
        this.setMedia(p5);
        rb1 = new RoundButton(p5, icono1, margeH+(photo2Width/2), margeV+((usuariRadi)/2+15), usuariRadi-55);
        rb11 = new RoundButton(p5, icono1, margeH+photo1Width+margeH+(rect1Width/2), margeV+(usuariRadi/2)+10, usuariRadi-55);
        rb2 = new RoundButton(p5, icono2, 540+35, margeV+60+rect2Height+30+35, 35);
        rb2.setColors(colores.getColorAt(0), 0, colores.getColorAt(2), colores.getColorAt(3));
        rb3 = new RoundButton(p5, icono3, (540+35+540+550-35)/2, margeV+60+rect2Height+30+35, 35);
        rb3.setColors(colores.getColorAt(0), 0, colores.getColorAt(2), colores.getColorAt(3));
        rb4 = new RoundButton(p5, icono4, 540+550-35, margeV+60+rect2Height+30+35, 35);
        rb4.setColors(colores.getColorAt(0), 0, colores.getColorAt(2), colores.getColorAt(3));
        rbb = new RoundButton(p5, icono7, 220, 350, 320);
        rbb.setColors(colores.getColorAt(1), colores.getColorAt(1), colores.getColorAt(1), colores.getColorAt(1));
        mp111 = new MusicPlayer(p5,120, p5.height/3);
        mp112 = new MusicPlayer(p5,520, p5.height/1.5f);
        mp = new MusicPlayer(p5,365, 390);
        tf1 = new TextField(p5, 440, 250, 790, 30);
        tf1.setColors(colores.getColorAt(2), colores.getColorAt(6), colores.getColorAt(6), colores.getColorAt(4));
        tf1.setFont(fonts.getThirdFont());
        tf2 = new TextField(p5, 440, 250+40+20+10, 790, 30);
        tf2.setColors(colores.getColorAt(2), colores.getColorAt(6), colores.getColorAt(6), colores.getColorAt(4));
        tf2.setFont(fonts.getThirdFont());
        tf3 = new TextField(p5, 440, 250+2*40+2*20+20, 790, 30);
        tf3.setColors(colores.getColorAt(2), colores.getColorAt(6), colores.getColorAt(6), colores.getColorAt(4));
        tf3.setFont(fonts.getThirdFont());
        tf4 = new TextField(p5, 440+135, 250+3*40+3*20+30-45, 530, 30);
        tf4.setColors(colores.getColorAt(2), colores.getColorAt(6), colores.getColorAt(6), colores.getColorAt(4));
        tf4.setFont(fonts.getThirdFont());
        tf5 = new TextField(p5, 440+135, 250+4*40+4*20+40-35, 530, 30);
        tf5.setColors(colores.getColorAt(2), colores.getColorAt(6), colores.getColorAt(6), colores.getColorAt(4));
        tf5.setFont(fonts.getThirdFont());
        tf6 = new TextField(p5, 400, 140, 830, 30);
        tf6.setColors(colores.getColorAt(3), 0, 0, colores.getColorAt(2));
        tf6.setFont(fonts.getThirdFont());
        tf66 = new TextField(p5, 400, 140+70+45, 830, 30);
        tf66.setColors(colores.getColorAt(3), 0, 0, colores.getColorAt(2));
        tf66.setFont(fonts.getThirdFont());
        tf8 = new TextField(p5, 390, 100, 850, 30);
        tf8.setColors(colores.getColorAt(3), 0, 0, colores.getColorAt(2));
        tf8.setFont(fonts.getThirdFont());
        tf9 = new TextField(p5, 390, 100+30+20, 850, 30);
        tf9.setColors(colores.getColorAt(3), 0, 0, colores.getColorAt(2));
        tf9.setFont(fonts.getThirdFont());
        t1 = new PagedTable(files, columnes);
        t1.setHeaders(headers);
        inf = db.getInfoTaulaFavoritos("nuriafemeniass");
        t1.setData(inf);
        t1.setColumnWidths(colWidths);
        t2 = new PagedTable(filess, 3);
        String[] headersTusCanciones = {"Orden", "Lista", "Título"};
        t2.setHeaders(headersTusCanciones);
        inff = db.getInfoTaulaTusCanciones("nuriafemeniass");
        t2.setData(inff);
        t2.setColumnWidths(colWidths);
        t1b1 = new Button(p5, ">", 390 + tableW/2 + 10 + buttonW - buttonW/2, tableH + 130, buttonW, buttonH);
        t1b1.setColors(colores.getColorAt(3), 0, colores.getColorAt(2), colores.getColorAt(2));
        t1b2 = new Button(p5, "<", 390 + tableW/2 - 10 - buttonW - buttonW/2, tableH + 130, buttonW, buttonH);
        t1b2.setColors(colores.getColorAt(3), 0, colores.getColorAt(2), colores.getColorAt(2));
        t2b1 = new Button(p5, ">", 390 + tableW/2 + 10 + buttonW - buttonW/2, tableH + 130-50, buttonW, buttonH);
        t2b1.setColors(colores.getColorAt(3), 0, colores.getColorAt(2), colores.getColorAt(2));
        t2b2 = new Button(p5, "<", 390 + tableW/2 - 10 - buttonW - buttonW/2, tableH + 130-50, buttonW, buttonH);
        t2b2.setColors(colores.getColorAt(3), 0, colores.getColorAt(2), colores.getColorAt(2));
        s1 = new Select(selectValues, 400, 100+2*30+20+30+10, selectW, selectH);
        String[] nombresListas = db.getNombresListas("nuriafemeniass");
        tList = new TextList(p5, nombresListas, 400, 210+selectH+60+10, selectW, selectH);
        s3 = new Select(selectValues, 400+selectW+75, 100+2*30+20+30+10+70+100, selectW, selectH);
        sb1 = new SwitchButton(p5, 400, 210+selectH+60+30+50+10+25, 340, 40);
        sb2 = new SwitchButton(p5, 400, 210+selectH+60+30+50+10+10, 340, 40);
        sb3 = new SwitchButton(p5, 400, 210+selectH+50+70, 340, 40);
        c = new Calendario(390+350+60+10,210+(int)selectH+30-28,380,290);
        imgFave = p5.loadImage("imgFave.png");
        imgNoFave = p5.loadImage("imgNoFave.png");
        imgPlay = p5.loadImage("imgPlay.png");
        iconoP = p5.loadImage("papelera.png");
        ptl1 = new PagedTusListas(p5, numCardsPage2, -10+menuWidth+margeH, margeV+60, cardsW, cardsH);
        inf3 = db.getInfoTaulaTusListas("nuriafemeniass");
        ptl1.setData(inf3);
        ptl1.setCards(p5, iconoP);
        ps1 = new PagedSongs(p5, numCardsPage, -10+menuWidth+margeH, margeV+60, cardsW, cardsH);
        inf = db.getInfoTaulaCanciones("nuriafemeniass");
        ps1.setData(inf);
        ps1.setCards(p5, imgFave, imgNoFave, imgPlay);
        pl1 = new PagedLists(p5, numCardsPage2, -10+menuWidth+margeH, margeV+60, cardsW, cardsH);
        inf2 = db.getInfoTaulaLlista("nuriafemeniass");
        pl1.setData(inf2);
        pl1.setCards(p5);
        b = new Button(p5, "TRIA", 400+tListW+40, 210+selectH+50+40+30+70, buttonWl, buttonHl);
        confirml = new Confirma(p5, title, message, 390, 190, compW, compH);
        confirml.setVisible(false);
    }


    /**
     * Actualiza la tabla t1 que contiene las canciones "Favoritas" del usuario
     */
    public void updateFavoritos(){
        t1 = new PagedTable(files, columnes);
        t1.setHeaders(headers);
        String[][] inf = db.getInfoTaulaFavoritos("nuriafemeniass");
        t1.setData(inf);
        t1.setColumnWidths(colWidths);
    }


    /**
     * Carga los elementos multimedia que utilizan los componentes de la GUI
     * @param p5 objeto de la clase PApplet para dibujar
     */
    public void setMedia(PApplet p5){
        icono1 = p5.loadImage("RoundButton\\usuario.png");
        icono2 = p5.loadImage("RoundButton\\Favoritos.png");
        icono3 = p5.loadImage("RoundButton\\TusCanciones.png");
        icono4 = p5.loadImage("RoundButton\\TusListas.png");
        icono5 = p5.loadImage("calentamiento.png");
        icono6 = p5.loadImage("coreografia.png");
        icono7 = p5.loadImage("bailarina.png");
        icono8 = p5.loadImage("Logo2.png");
    }

    /**
     * Dibuja el conjunto de botones redondos principales de la aplicación
     * @param p5 objeto de la clase PApplet para dibujar
     */
    public void dibujaBotonsTuCuentaRB(PApplet p5){
        rb2.display(p5);
        rb3.display(p5);
        rb4.display(p5);
    }

    /**
     * Dibuja el menú de la aplicación con todos sus elementos
     * @param p5 objeto de la clase PApplet para dibujar
     */
    public void dibujaFullMenu(PApplet p5){
        p5.pushStyle();
        dibujaMenu(p5);
        p5.popStyle();
        rb1.display(p5);
        b3.display(p5);
        b4.display(p5);
        p5.image(icono8, 20, 440, 300, 300);
    }

    /**
     * Dibuja la pantalla Registro con todos sus elementos
     * @param p5 objeto de la clase PApplet para dibujar
     */
    public void dibujaPantallaRegistro(PApplet p5){
        p5.background(196, 183, 161);
        rbb.display(p5);
        dibujaRectRegistro(p5);
        rb11.display(p5);
        b1.display(p5);
        p5.fill(31, 27, 31); p5.textSize(20);
        p5.text("Nombre y Apellidos", 440, 240);
        tf1.display(p5);
        p5.fill(31, 27, 31); p5.textSize(20);
        p5.text("Nombre de usuario", 440, 240+40+20+10);
        tf2.display(p5);
        p5.fill(31, 27, 31); p5.textSize(20);
        p5.text("Contraseña", 440+135, 240+3*40+3*20+10*3-45);
        tf4.display(p5);
        p5.fill(31, 27, 31); p5.textSize(20);
        p5.text("Confirmar contraseña", 440+135, 240+4*40+4*20+10*4-35);
        tf5.display(p5);
    }

    /**
     * Dibuja la pantalla Favoritos con todos sus elementos
     * @param p5 objeto de la clase PApplet para dibujar
     */
    public void dibujaPantallaFavoritos(PApplet p5){
        p5.background(231, 224, 218);
        dibujaFullMenu(p5);
        p5.fill(31, 27, 31); p5.textSize(20);
        p5.text("Lista de tus Favoritos", 400, 75);
        dibujaBotonsTuCuentaRB(p5);
        p5.pushStyle();
        t1.display(p5, 390, 100, tableW, tableH);
        t1b1.display(p5);
        t1b2.display(p5);
        p5.popStyle();
    }

    /**
     * Dibuja la pantalla TusCanciones con todos sus elementos
     * @param p5 objeto de la clase PApplet para dibujar
     */
    public void dibujaPantallaTusCanciones(PApplet p5){
        p5.background(231, 224, 218);
        dibujaFullMenu(p5);
        p5.fill(31, 27, 31); p5.textSize(20);
        p5.text("Lista de Tus Canciones", 400, 75);
        dibujaBotonsTuCuentaRB(p5);
        b5.display(p5);
        t2.display(p5, 390, 100, tableW, tableH-50);
        t2b1.display(p5);
        t2b2.display(p5);
    }

    /**
     * Dibuja la pantalla AgregarCancion con todos sus elementos
     * @param p5 objeto de la clase PApplet para dibujar
     */
    public void dibujaPantallaAgregarCancion(PApplet p5){
        p5.background(231, 224, 218);
        dibujaFullMenu(p5);
        p5.fill(31, 27, 31); p5.textSize(20);
        p5.text("Agregar nueva canción", 400, 75);
        dibujaBotonsTuCuentaRB(p5);
        p5.fill(31, 27, 31); p5.textSize(20);
        p5.text("Título de la canción", 400, 130);
        tf6.display(p5);
        p5.fill(31, 27, 31); p5.textSize(20);
        p5.text("Deseas agregar la canción en Favoritos?", 400, 210+selectH+60+30+50+20);
        sb1.display(p5);
        p5.fill(31, 27, 31); p5.textSize(20);
        p5.text("Seleccionar categoría", 400, 100+2*30+20+30);
        b9.display(p5);
        p5.fill(31, 27, 31); p5.textSize(20);
        p5.text("Seleccionar fecha actual", 400+selectW+65+8, 100+2*30+85-23);
        c.display(p5);
        p5.fill(31, 27, 31); p5.textSize(20);
        p5.text("Seleccionar lista", 400, 210+selectH+60);
        tList.display(p5);
        s1.display(p5);
        b29.display(p5);
    }

    /**
     * Dibuja la pantalla TusListas con todos sus elementos
     * @param p5 objeto de la clase PApplet para dibujar
     */
    public void dibujaPantallaTusListas(PApplet p5){
        p5.background(231, 224, 218);
        dibujaFullMenu(p5);
        p5.fill(31, 27, 31); p5.textSize(20);
        p5.text("Tus Listas", 400, 75);
        dibujaBotonsTuCuentaRB(p5);
        b6.display(p5);
        ptl1.display(p5);
        confirml.display(p5);
    }

    /**
     * Dibuja la pantalla CancionesTusListas con todos sus elementos
     * @param p5 objeto de la clase PApplet para dibujar
     */
    public void dibujaPantallaCancionesTusListas(PApplet p5){
        p5.background(231, 224, 218);
        dibujaFullMenu(p5);
        p5.fill(31, 27, 31); p5.textSize(20);
        p5.text(tituloLista, 400, 75);
        dibujaBotonsTuCuentaRB(p5);
        b5.display(p5);
        b9.display(p5);
        ptSongsList.display(p5, 400, 100, 600, 400);
    }

    /**
     * Dibuja la pantalla AgregarLista con todos sus elementos
     * @param p5 objeto de la clase PApplet para dibujar
     */
    public void dibujaPantallaAgregarLista(PApplet p5){
            p5.background(231, 224, 218);
            dibujaFullMenu(p5);
            p5.fill(31, 27, 31); p5.textSize(20);
            p5.text("Agregar nueva lista", 400, 75);
            dibujaBotonsTuCuentaRB(p5);
            p5.fill(31, 27, 31); p5.textSize(20);
            p5.text("Título de la lista", 400, 130);
            tf6.display(p5);
            p5.fill(31, 27, 31); p5.textSize(20);
            p5.text("Subtítulo de la lista", 400, 130+70+45);
            tf66.display(p5);
            p5.fill(31, 27, 31); p5.textSize(20);
            p5.text("A qué categoría deseas que pertenezca la lista?", 400, 100+2*30+20+30+10+10+70+100);
            p5.text("Seleccionar categoría", 400+selectW+75, 100+2*30+20+30+70+100);
            s3.display(p5);
            b29.display(p5);
    }

    /**
     * Dibuja la pantalla Canciones con todos sus elementos
     * @param p5 objeto de la clase PApplet para dibujar
     */
    public void dibujaPantallaCanciones(PApplet p5){
        p5.background(231, 224, 218);
        dibujaFullMenu(p5);
        b7.display(p5);
        b8.display(p5);
        p5.image(icono5, 540, 430, 110, 220);
        p5.image(icono6, 990, 450, 150, 190);
    }

    /**
     * Dibuja la pantalla Calentamiento con todos sus elementos
     * @param p5 objeto de la clase PApplet para dibujar
     */
    public void dibujaPantallaCalentamiento(PApplet p5){
        p5.background(231, 224, 218);
        dibujaFullMenu(p5);
        p5.fill(31, 27, 31); p5.textSize(20);
        p5.text("Calentamiento", 400, 75);
        b21.display(p5);
        b22.display(p5);
        b23.display(p5);
        b27.display(p5);
    }

    /**
     * Dibuja la pantalla Coreografía con todos sus elementos
     * @param p5 objeto de la clase PApplet para dibujar
     */
    public void dibujaPantallaCoreografia(PApplet p5){
        p5.background(231, 224, 218);
        dibujaFullMenu(p5);
        p5.fill(31, 27, 31); p5.textSize(20);
        p5.text("Coreografía", 400, 75);
        b21a.display(p5);
        b22a.display(p5);
        b23a.display(p5);
        b27.display(p5);
    }

    /**
     * Dibuja la pantalla Barra con todos sus elementos
     * @param p5 objeto de la clase PApplet para dibujar
     */
    public void dibujaPantallaBarra(PApplet p5){
        p5.background(231, 224, 218);
        dibujaFullMenu(p5);
        p5.fill(31, 27, 31); p5.textSize(20);
        p5.text(this.nombreCalentamiento, 400, 75);
        b11.display(p5);
        b27.display(p5);
        pl1.display(p5);
    }

    /**
     * Dibuja la pantalla VariacionesListaCanciones con todos sus elementos
     * @param p5 objeto de la clase PApplet para dibujar
     */
    public void dibujaPantallaVariacionesListaCanciones(PApplet p5){
        p5.background(231, 224, 218);
        dibujaFullMenu(p5);
        p5.fill(31, 27, 31); p5.textSize(20);
        p5.text("Variaciones", 400, 65);
        b11.display(p5);
        b27.display(p5);
    }

    /**
     * Dibuja la pantalla ListaCanciones con todos sus elementos
     * @param p5 objeto de la clase PApplet para dibujar
     */
    public void dibujaPantallaListaCanciones(PApplet p5){
        p5.background(231, 224, 218);
        dibujaFullMenu(p5);
        b11.display(p5);
        b27.display(p5);
        ps1.display(p5);
    }

    /**
     * Dibuja la pantalla Reproductor con todos sus elementos
     * @param p5 objeto de la clase PApplet para dibujar
     */
    public void dibujaPantallaReproductor(PApplet p5){
        p5.background(231, 224, 218);
        mp.display(p5);
        p5.image(icono8, 1000, 0, 260, 220);
        b10.display(p5);
    }


    /**
     * Dibuja elemento de las zonas GUI, concretamente el rectángulo de la pantalla registro.
     * @param p5 objeto de la clase PApplet para dibujar
     */
    public void dibujaRectRegistro(PApplet p5){
        p5.fill(231, 224, 218);
        p5.rect(margeH+photo1Width+margeH, margeV+usuariRadi+margeV, rect1Width, rect1Height, 30);
    }

    /**
     * Dibuja elemento de las zonas GUI, concretamente el rectángulo del menú.
     * @param p5 objeto de la clase PApplet para dibujar
     */
    public void dibujaMenu(PApplet p5){
        p5.fill(231, 224, 218);
        p5.strokeWeight(2); p5.stroke(0);
        p5.rect(-10, -10, menuWidth, menuHeight);
    }
}