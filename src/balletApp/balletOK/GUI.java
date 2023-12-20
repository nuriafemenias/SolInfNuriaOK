package balletApp.balletOK;

import balletApp.balletOK.gui.Button;
import balletApp.balletOK.gui.MusicPlayer;
import balletApp.balletOK.gui.TextField;
import processing.core.PApplet;

import static balletApp.oldstaff.balletLayout.Layout.*;

public class GUI {
    public enum PANTALLA {registro, Favoritos, TusCanciones, agregarCanción,
        TusListas, cancionesTusListas, agregarLista,
        Canciones, Calentamiento, Coreografia, subListas,
        subListasCanciones};

    public PANTALLA pantallaActual;

    Colors colores;
    Fonts fonts;

    // Declaració dels components de la GUI
    Button b1;
    // Music Player
    MusicPlayer mp;

    TextField tf1;


    public GUI(PApplet p5){

        colores = new Colors(p5);
        fonts = new Fonts(p5);
        pantallaActual = PANTALLA.registro;

        // Inicialització de components (botons)
        b1 = new Button(p5, "RED", 40, 400, 250, 100);
        b1.setColors(colores.getFirstColor(), colores.getSecondColor(), colores.getThirdColor(), colores.getColorAt(3));
        b1.setFont(fonts.getFirstFont());

        // Creació del Music Player
        mp = new MusicPlayer(p5,120, p5.height/3);
        mp.setSound(p5, "saxo.wav");

        tf1 = new TextField(p5, 200, 200, 400, 40);
        tf1.setColors(colores.getFirstColor(), colores.getSecondColor(), colores.getThirdColor(), colores.getColorAt(3));
        tf1.setFont(fonts.getFirstFont());
    }

    public void dibuixaPantallaRegistro(PApplet p5){
        p5.background(255);
        dibuixaPhoto1(p5);
        dibuixaUsuari(p5);
        dibuixaRect1(p5);
        b1.display(p5);
        tf1.display(p5);
    }

    public void dibuixaPantallaFavoritos(PApplet p5){
        p5.background(255);
        dibuixaFullMenu(p5);
        dibuixaRect2(p5);
        dibuixaBotonsTuCuenta(p5);
    }

    public void dibuixaPantallaTusCanciones(PApplet p5){
        p5.background(255);
        dibuixaFullMenu(p5);
        dibuixaRect2(p5);
        dibuixaBotonsTuCuenta(p5);
    }

    public void dibuixaPantallaAgregarCancion(PApplet p5){
        p5.background(255);
        dibuixaFullMenu(p5);
        dibuixaRect2(p5);
        dibuixaBotonsTuCuenta(p5);
    }

    public void dibuixaPantallaTusListas(PApplet p5){
        p5.background(255);
        dibuixaFullMenu(p5);
        dibuixaRect2(p5);
        dibuixaBotonsTuCuenta(p5);
    }

    public void dibuixaPantallaCancionesTusListas(PApplet p5){
        p5.background(255);
        dibuixaFullMenu(p5);
        dibuixaRect2(p5);
        dibuixaBotonsTuCuenta(p5);
    }

    public void dibuixaPantallaAgregarLista(PApplet p5){
        p5.background(255);
        dibuixaFullMenu(p5);
        dibuixaRect2(p5);
        dibuixaBotonsTuCuenta(p5);
    }

    public void dibuixaPantallaCanciones(PApplet p5){
        p5.background(255);
        dibuixaFullMenu(p5);
        dibuixaRect34(p5);
    }

    public void dibuixaPantallaCalentamiento(PApplet p5){
        p5.background(255);
        dibuixaFullMenu(p5);
        dibuixaRect2(p5);
        dibuixaBotonsCanciones(p5);
        // Dibuixa el MusicPlayer
        mp.display(p5);
    }

    public void dibuixaPantallaCoreografia(PApplet p5){
        p5.background(255);
        dibuixaFullMenu(p5);
        dibuixaRect2(p5);
        dibuixaBotonsCanciones(p5);
    }

    public void dibuixaPantallaSubListas(PApplet p5){
        p5.background(255);
        dibuixaFullMenu(p5);
        dibuixaRect2(p5);
        dibuixaBotonsCanciones(p5);
    }

    public void dibuixaPantallaSubListasCanciones(PApplet p5){
        p5.background(255);
        dibuixaFullMenu(p5);
        dibuixaRect2(p5);
        dibuixaBotonsCanciones(p5);
    }


    //  DIBUIX ELEMENTS, zones GUI
    public void dibuixaPhoto1(PApplet p5){                      // 1
        //p5.fill(trivioApp.trivioColors.Colors.colors[3]);
        p5.fill(230);
        p5.rect(margeH, margeV, photo1Width, photo1Height);
    }

    public void dibuixaRect1(PApplet p5){                      // 2
        p5.fill(200);
        p5.rect(margeH+photo1Width+margeH, margeV+usuariRadi+margeV, rect1Width, rect1Height, 30);
    }

    public void dibuixaUsuari(PApplet p5){                    // 3
        p5.fill(200);
        p5.ellipseMode(p5.CENTER);
        p5.ellipse(margeH+photo1Width+margeH+(rect1Width/2), margeV+(usuariRadi/2), usuariRadi, usuariRadi);
    }

    public void dibuixaUsuariMenu(PApplet p5){                // 4
        p5.fill(190);
        p5.ellipse(margeH+(photo2Width/2), margeV+((usuariRadi+10)/2), usuariRadi+10, usuariRadi+10);
    }

    public void dibuixaPhoto2(PApplet p5){                    // 5
        p5.fill(190);
        p5.rect(margeH, menuHeight-photo2Height-margeV-10, photo2Width, photo2Height);
    }

    public void dibuixaMenu(PApplet p5){                      // 6
        p5.fill(230);
        p5.strokeWeight(2); p5.stroke(0);
        p5.rect(-10, -10, menuWidth, menuHeight);
    }

    public void dibuixaRect2(PApplet p5){                      // 7
        p5.fill(230);
        p5.rect(-10+menuWidth+margeH, margeV+60, rect2Width, rect2Height, 30);
    }

    public void dibuixaBotonsTuCuenta(PApplet p5){             // 8
        p5.fill(230);
        p5.rect(-10+menuWidth+margeH+150, margeV+60+rect2Height+30, botonsTuCuentaWidth, botonsTuCuentaHeight, 30);
    }

    public void dibuixaRect34(PApplet p5){                     // 9 i 10
        p5.fill(215);
        p5.rect(390, margeV, rect34Width, rect34Height, 30);
        p5.rect(390+rect34Width+50, margeV, rect34Width, rect34Height, 30);
    }

    public void dibuixaBotonsCanciones(PApplet p5){           // 11 i 12
        p5.fill(215);
        p5.rect(-10+menuWidth+margeH, margeV+60+rect2Height+25, botonVolverWidth, botonVolverHeight, 30);
        p5.rect(-10+menuWidth+margeH+500, margeV+60+rect2Height+40, botonAñadirWidth, botonAñadirHeight, 30);
    }

    public void dibuixaFullMenu(PApplet p5){
        p5.pushStyle();
        dibuixaMenu(p5);
        p5.popStyle();
        dibuixaPhoto2(p5);
        dibuixaUsuariMenu(p5);
    }
}