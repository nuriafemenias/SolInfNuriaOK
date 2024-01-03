package balletApp.balletOK;

import processing.core.PApplet;

public class Ballet extends PApplet {

    GUI gui;


    public static void main(String[] args) {
        PApplet.main("balletApp.balletOK.Ballet", args);
    }

    public void settings() {
        fullScreen();
        smooth(10);
    }

    public void setup() {
        background(255);

        gui = new GUI(this);
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

            case Coreografia:
                gui.dibujaPantallaCoreografia(this);
                break;

            case Barra:
                gui.dibujaPantallaBarra(this);
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

            case Variaciones:
                gui.dibujaPantallaVariaciones(this);
                break;

            case WarmUpBarra:
                gui.dibujaPantallaWarmUpBarra(this);
                break;

            case PlieBarra:
                gui.dibujaPantallaPlieBarra(this);
                break;

            case SlowTenduBarra:
                gui.dibujaPantallaSlowTenduBarra(this);
                break;

            case Tendu4_4Barra:
                gui.dibujaPantallaTendu4_4Barra(this);
                break;

            case Tendu3_4Barra:
                gui.dibujaPantallaTendu3_4Barra(this);
                break;

            case JeteBarra:
                gui.dibujaPantallaJeteBarra(this);
                break;

            case FastJeteBarra:
                gui.dibujaPantallaFastJeteBarra(this);
                break;

            case RoundDeJambeATerreBarra:
                gui.dibujaPantallaRoundDeJambeATerreBarra(this);
                break;

            case FonduBarra:
                gui.dibujaPantallaFonduBarra(this);
                break;

            case BattementFrappeBarra:
                gui.dibujaPantallaBattementFrappeBarra(this);
                break;

            case AdagioBarra:
                gui.dibujaPantallaAdagioBarra(this);
                break;

            case RoundDeJambeEnlAirBarra:
                gui.dibujaPantallaRoundDeJambeEnlAirBarra(this);
                break;

            case GrandBattementBarra:
                gui.dibujaPantallaGrandBattementBarra(this);
                break;

            case ReleveBarra:
                gui.dibujaPantallaReleveBarra(this);
                break;

            case StrechBarra:
                gui.dibujaPantallaStrechBarra(this);
                break;

            case PortDeBrasCentro:
                gui.dibujaPantallaPortDeBrasCentro(this);
                break;

            case TenduCentro:
                gui.dibujaPantallaTenduCentro(this);
                break;

            case AdagioCentro:
                gui.dibujaPantallaAdagioCentro(this);
                break;

            case FonduCentro:
                gui.dibujaPantallaFonduCentro(this);
                break;

            case GrandBattementCentro:
                gui.dibujaPantallaGrandBattementCentro(this);
                break;

            case PirouetteCentro:
                gui.dibujaPantallaPirouetteCentro(this);
                break;

            case LittleJumpsCentro:
                gui.dibujaPantallaLittleJumpsCentro(this);
                break;

            case Allegro1Centro:
                gui.dibujaPantallaAllegro1Centro(this);
                break;

            case Allegro2Centro:
                gui.dibujaPantallaAllegro2Centro(this);
                break;

            case Allegro3Centro:
                gui.dibujaPantallaAllegro3Centro(this);
                break;

            case Allegro4Centro:
                gui.dibujaPantallaAllegro4Centro(this);
                break;

            case CodaCentro:
                gui.dibujaPantallaCodaCentro(this);
                break;

            case ReverenceCentro:
                gui.dibujaPantallaReverenceCentro(this);
                break;

            case JumpsDiagonal:
                gui.dibujaPantallaJumpsDiagonal(this);
                break;

            case BigJumpsDiagonal:
                gui.dibujaPantallaBigJumpsDiagonal(this);
                break;

            case TourEnlAirDiagonal:
                gui.dibujaPantallaTourEnlAirDiagonal(this);
                break;

            case PiquesDiagonal:
                gui.dibujaPantallaPiquesDiagonal(this);
                break;

            case TurnsDiagonal:
                gui.dibujaPantallaTurnsDiagonal(this);
                break;

            case SissoneDiagonal:
                gui.dibujaPantallaSissoneDiagonal(this);
                break;

            case ManegeDiagonal:
                gui.dibujaPantallaManegeDiagonal(this);
                break;
        }

    }




    public void keyPressed() {
        if(key=='0'){
            gui.pantallaActual = GUI.PANTALLA.registro;
        }
       else if(key=='1'){
            gui.pantallaActual = GUI.PANTALLA.Favoritos;
        }
        else if(key=='2'){
            gui.pantallaActual = GUI.PANTALLA.TusCanciones;
        }
        else if(key=='3'){
            gui.pantallaActual = GUI.PANTALLA.agregarCanción;
        }
        else if(key=='4'){
            gui.pantallaActual = GUI.PANTALLA.TusListas;
        }
        else if(key=='5'){
            gui.pantallaActual = GUI.PANTALLA.cancionesTusListas;
        }
        else if(key=='6'){
            gui.pantallaActual = GUI.PANTALLA.agregarLista;
        }
        else if(key=='7'){
            gui.pantallaActual = GUI.PANTALLA.Canciones;
        }
        else if(key=='8'){
            gui.pantallaActual = GUI.PANTALLA.Calentamiento;
        }
        else if(key=='9'){
            gui.pantallaActual = GUI.PANTALLA.Coreografia;
        }

        else if(key=='q'){
            gui.pantallaActual = GUI.PANTALLA.Barra;
        }
        else if(key=='w'){
            gui.pantallaActual = GUI.PANTALLA.Centro;
        }
        else if(key=='e'){
            gui.pantallaActual = GUI.PANTALLA.Diagonal;
        }
        else if(key=='r'){
            gui.pantallaActual = GUI.PANTALLA.Ballets;
        }
        else if(key=='t'){
            gui.pantallaActual = GUI.PANTALLA.Otras;
        }
        else if(key=='y'){
            gui.pantallaActual = GUI.PANTALLA.Variaciones;
        }
        else if(key=='u'){
            gui.pantallaActual = GUI.PANTALLA.WarmUpBarra;
        }
        else if(key=='i'){
            gui.pantallaActual = GUI.PANTALLA.PlieBarra;
        }
        else if(key=='o'){
            gui.pantallaActual = GUI.PANTALLA.SlowTenduBarra;
        }
        else if(key=='p'){
            gui.pantallaActual = GUI.PANTALLA.Tendu4_4Barra;
        }
        else if(key=='a'){
            gui.pantallaActual = GUI.PANTALLA.Tendu3_4Barra;
        }
        else if(key=='s'){
            gui.pantallaActual = GUI.PANTALLA.JeteBarra;
        }
        else if(key=='d'){
            gui.pantallaActual = GUI.PANTALLA.FastJeteBarra;
        }
        else if(key=='f'){
            gui.pantallaActual = GUI.PANTALLA.RoundDeJambeATerreBarra;
        }
        else if(key=='g'){
            gui.pantallaActual = GUI.PANTALLA.FonduBarra;
        }
        else if(key=='h'){
            gui.pantallaActual = GUI.PANTALLA.BattementFrappeBarra;
        }
        else if(key=='j'){
            gui.pantallaActual = GUI.PANTALLA.AdagioBarra;
        }
        else if(key=='k'){
            gui.pantallaActual = GUI.PANTALLA.RoundDeJambeEnlAirBarra;
        }
        else if(key=='l'){
            gui.pantallaActual = GUI.PANTALLA.GrandBattementBarra;
        }
        else if(key=='ñ'){
            gui.pantallaActual = GUI.PANTALLA.ReleveBarra;
        }
        else if(key=='z'){
            gui.pantallaActual = GUI.PANTALLA.StrechBarra;
        }
        else if(key=='x'){
            gui.pantallaActual = GUI.PANTALLA.PortDeBrasCentro;
        }
        else if(key=='c'){
            gui.pantallaActual = GUI.PANTALLA.TenduCentro;
        }
        else if(key=='v'){
            gui.pantallaActual = GUI.PANTALLA.AdagioCentro;
        }
        else if(key=='b'){
            gui.pantallaActual = GUI.PANTALLA.FonduCentro;
        }
        else if(key=='n'){
            gui.pantallaActual = GUI.PANTALLA.GrandBattementCentro;
        }
        else if(key=='m'){
            gui.pantallaActual = GUI.PANTALLA.PirouetteCentro;
        }
        else if(key=='Q'){
            gui.pantallaActual = GUI.PANTALLA.LittleJumpsCentro;
        }
        else if(key=='W'){
            gui.pantallaActual = GUI.PANTALLA.Allegro1Centro;
        }
        else if(key=='E'){
            gui.pantallaActual = GUI.PANTALLA.Allegro2Centro;
        }
        else if(key=='R'){
            gui.pantallaActual = GUI.PANTALLA.Allegro3Centro;
        }
        else if(key=='T'){
            gui.pantallaActual = GUI.PANTALLA.Allegro4Centro;
        }
        else if(key=='Y'){
            gui.pantallaActual = GUI.PANTALLA.CodaCentro;
        }
        else if(key=='U'){
            gui.pantallaActual = GUI.PANTALLA.ReverenceCentro;
        }
        else if(key=='I'){
            gui.pantallaActual = GUI.PANTALLA.JumpsDiagonal;
        }
        else if(key=='O'){
            gui.pantallaActual = GUI.PANTALLA.BigJumpsDiagonal;
        }
        else if(key=='P'){
            gui.pantallaActual = GUI.PANTALLA.TourEnlAirDiagonal;
        }
        else if(key=='A'){
            gui.pantallaActual = GUI.PANTALLA.PiquesDiagonal;
        }
        else if(key=='S'){
            gui.pantallaActual = GUI.PANTALLA.TurnsDiagonal;
        }
        else if(key=='D'){
            gui.pantallaActual = GUI.PANTALLA.SissoneDiagonal;
        }
        else if(key=='F'){
            gui.pantallaActual = GUI.PANTALLA.ManegeDiagonal;
        }



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
        gui.tf7.keyPressed(key, keyCode);
        gui.tf8.keyPressed(key, keyCode);
        gui.tf9.keyPressed(key, keyCode);
    }

    public void mousePressed() {

        if (gui.pantallaActual == GUI.PANTALLA.registro) {
            if (gui.b1.mouseOverButton(this)) {
                println("HAS FET CLIC SOBRE EL BOTÓ B1");
            }
            gui.tf1.isPressed(this);
            gui.tf2.isPressed(this);
            gui.tf3.isPressed(this);
            gui.tf4.isPressed(this);
            gui.tf5.isPressed(this);
        }

        if (gui.pantallaActual == GUI.PANTALLA.agregarCanción) {
            gui.tf6.isPressed(this);
            gui.tf7.isPressed(this);
        }

        if (gui.pantallaActual == GUI.PANTALLA.agregarLista) {
            gui.tf6.isPressed(this);
            gui.tf7.isPressed(this);
        }

        if (gui.pantallaActual == GUI.PANTALLA.Calentamiento) {
            // Comprova si pitjam sobre els botons del MusicPlayer
            gui.mp111.checkButtons(this);
            gui.mp112.checkButtons(this);
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
        // Si pitjam sobre el checboxes
        if(gui.cb1.onMouseOver(this)){
            gui.cb1.toggle();
        }

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


    public void mouseDragged() {
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }


}