package trivioApp.trivioPantalles;

import processing.core.PApplet;

import static trivioApp.trivioLayout.Layout.*;

public class GUI {

    public enum PANTALLA {registro, Favoritos, TusCanciones, agregarCanción,
                          TusListas, cancionesTusListas, agregarLista,
                          Canciones, Calentamiento, Coreografia, subListas,
                          subListasCanciones};

    public PANTALLA pantallaActual;

    public GUI(){
        pantallaActual = PANTALLA.registro;
    }

    public void dibuixaPantallaRegistro(PApplet p5){
        p5.background(255);
        dibuixaPhoto1(p5);
        dibuixaUsuari(p5);
        dibuixaRect1(p5);
    }

    public void dibuixaPantallaFavoritos(PApplet p5){
        dibuixaFullMenu(p5);
    }

    public void dibuixaPantallaTusCanciones(PApplet p5){

    }

    public void dibuixaPantallaAgregarCancion(PApplet p5){

    }

    public void dibuixaPantallaTusListas(PApplet p5){

    }

    public void dibuixaPantallaCancionesTusListas(PApplet p5){

    }

    public void dibuixaPantallaAgregarLista(PApplet p5){

    }

    public void dibuixaPantallaCanciones(PApplet p5){

    }

    public void dibuixaPantallaCalentamiento(PApplet p5){

    }

    public void dibuixaPantallaCoreografia(PApplet p5){

    }

    public void dibuixaPantallaSubListas(PApplet p5){

    }

    public void dibuixaPantallaSubListasCanciones(PApplet p5){

    }


    //  DIBUIX ELEMENTS, zones GUI
    public void dibuixaPhoto1(PApplet p5){                      // 1
        //p5.fill(trivioApp.trivioColors.Colors.colors[3]);
        p5.fill(230);
        p5.rect(margeH, margeV, photo1Width, photo1Height);
    }

    public void dibuixaRect1(PApplet p5){                      // 2
        p5.fill(200);
        p5.rect(margeH+photo1Width+40, margeV+usuariRadi+40, rect1Width, rect1Height, 30);
    }

    public void dibuixaUsuari(PApplet p5){                    // 3
        p5.fill(200);
        p5.ellipseMode(p5.CENTER);
        p5.ellipse(margeH+photo1Width+40+(rect1Width/2), margeV+(usuariRadi/2), usuariRadi, usuariRadi);
    }

    public void dibuixaUsuariMenu(PApplet p5){                // 4
        p5.fill(215);
        p5.rect(margeH, margeV, usuariRadi, usuariRadi);
    }

    public void dibuixaPhoto2(PApplet p5){                    // 5
        p5.fill(215);
        p5.rect(margeH, margeV, photo2Width, photo2Height);
    }

    public void dibuixaMenu(PApplet p5){                      // 6
        p5.fill(215);
        p5.rect(margeH, margeV, photo1Width, photo1Height);
    }

    public void dibuixaRect2(PApplet p5){                      // 7
        p5.fill(215);
        p5.rect(margeH, margeV, photo1Width, photo1Height);
    }

    public void dibuixaBotonsTuCuenta(PApplet p5){             // 8
        p5.fill(215);
        p5.rect(margeH, margeV, photo1Width, photo1Height);
    }

    public void dibuixaRect34(PApplet p5){                     // 9 i 10
        p5.fill(215);
        p5.rect(margeH, margeV, photo1Width, photo1Height);
        p5.rect(margeH, margeV, photo1Width, photo1Height);
    }

    public void dibuixaBotonsCanciones(PApplet p5){           // 11 i 12
        p5.fill(215);
        //DIBUIXAR DOS BOTONS: 11, 12
        //EELIPSE, ELLIPSE
    }

    public void dibuixaFullMenu(PApplet p5){
        p5.fill(220);
        dibuixaMenu(p5);
        p5.fill(200);
        dibuixaPhoto2(p5);
        p5.fill(20);
        dibuixaUsuariMenu(p5);
    }
}
