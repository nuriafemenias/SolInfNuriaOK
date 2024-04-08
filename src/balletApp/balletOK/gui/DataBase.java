package balletApp.balletOK.gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBase {


    // VARIABLES

    // Variable de connexió a la BBDD
    Connection c;

    // Variable de consulta
    Statement query;

    // Dades de connexió (user, password, nom de la base de dades)
    String user, password, databaseName;

    // Estat de la connexió
    boolean connectat = false;



    // SETTER
    public DataBase(String user, String password, String databaseName){
        this.user = user;
        this.password = password;
        this.databaseName = databaseName;
    }



    // CONECTAR AMB DB
    public void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+databaseName+"?useTimezone=true&serverTimezone=UTC", user, password);
            query = c.createStatement();
            System.out.println("Connectat a la BBDD! :) ");
            connectat = true;
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }



    // GETTERS

    // Retorna el número de files d'una taula
    public int getNumRowsTaula(String nomTaula){
        try {
            ResultSet rs = query.executeQuery( "SELECT COUNT(*) AS n FROM "+ nomTaula );
            rs.next();
            int numRows = rs.getInt("n");
            return numRows;
        }
        catch(Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public int getNumRowsQuery(String q){
        try {
            ResultSet rs = query.executeQuery( q);
            rs.next();
            return rs.getInt("n");
        }
        catch(Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    // Retorna el número de columnes d'una taula de la base de dades
    public int getNumColsTaula(String nomTaula){
        try {
            String q = "SELECT count(*) as n FROM information_schema.columns WHERE table_name ='"+ nomTaula +"' AND table_schema='"+databaseName+"'";
            System.out.println(q);
            ResultSet rs = query.executeQuery( q);
            rs.next();
            int numCols = rs.getInt("n");
            return numCols;
        }
        catch(Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    // Retorna les dades d'una taula en concret
    public String[][] getInfoTaulaLlista(String nomUsuario){
        int numFiles = getNumRowsTaula("lista");
        int numCols  = 3;
        String[][] info = new String[numFiles][numCols];
        try {
            ResultSet rs = query.executeQuery( "SELECT DISTINCT l.numCanciones AS NUM, l.título AS TITULO, c.nombre AS CATEGORIA FROM lista l, usuario u, categoría c WHERE l.Usuario = '"+nomUsuario+"' AND l.Categoría = c.idCategoría ORDER BY l.orden ASC");
            int nr = 0;
            while (rs.next()) {
                info[nr][0] = String.valueOf(rs.getString("NUM"));
                info[nr][1] = rs.getString("TITULO");
                info[nr][2] = rs.getString("CATEGORIA");
                nr++;
            }
            return info;
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public String[][] getInfoTaulaCanciones(String nomUsuario){
        int numFiles = getNumRowsTaula("canción");
        int numCols  = 4;
        String[][] info = new String[numFiles][numCols];
        try {
            ResultSet rs = query.executeQuery( "SELECT c.título AS TITULO, c.Lista_título AS LISTA, c.favorito AS FAVORITO FROM canción c ORDER BY TITULO ASC");
            int nr = 0;
            while (rs.next()) {
                info[nr][0] = String.valueOf(nr+1);
                info[nr][1] = rs.getString("TITULO");
                info[nr][2] = rs.getString("LISTA");
                info[nr][3] = rs.getString("FAVORITO");
                nr++;
            }
            return info;
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public String [][] getInfoTaulaTusListas(String nomUsuario){
        String qn ="SELECT COUNT(*) As n FROM lista l, usuario u, categoría c WHERE l.Usuario = u.nombre AND l.Usuario = '"+nomUsuario+"' AND l.Categoría = c.idCategoría AND l.Categoría = '3'";
        int numFiles = getNumRowsQuery(qn);
        int numCols  = 3;
        String[][] info = new String[numFiles][numCols];
        try {
            String q ="SELECT l.numCanciones AS NUM, l.título AS TITULO, c.nombre AS CATEGORIA FROM lista l, usuario u, categoría c WHERE l.Usuario = u.nombre AND l.Usuario = '"+nomUsuario+"' AND l.Categoría = c.idCategoría AND l.Categoría = '3' ORDER BY l.orden ASC";
            ResultSet rs = query.executeQuery(q);
            int nr = 0;
            while (rs.next()) {
                info[nr][0] = String.valueOf(rs.getString("NUM"));
                info[nr][1] = rs.getString("TITULO");
                info[nr][2] = rs.getString("CATEGORIA");
                nr++;
            }
            return info;
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }


    // Retorna les dades de la columna NOM de la taula UNITAT
    public String[] getColumnaNomTaulaUnitat(){
        int numFiles = getNumRowsTaula("unitat");
        String[] info = new String[numFiles];
        try {
            ResultSet rs = query.executeQuery( "SELECT nom FROM unitat ORDER BY nom ASC");
            int nr = 0;
            while (rs.next()) {
                info[nr] = rs.getString("nom");
                nr++;
            }
            return info;
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }

    // Retorna el valor de la Columna NUMERO de la taula UNITAT per aquella fila amb NOM
    public String getNumeroFromTaulaUnitat(String nom)  {
        try {
            ResultSet rs = query.executeQuery( "SELECT numero FROM unitat WHERE nom = '"+nom+"'");
            rs.next();
            return String.valueOf(rs.getInt("numero"));
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public String getClaveFromTabla(String nombreTable, String nombreClave, String nombreColumna, String valorColumna){
        try {
            String q = "SELECT "+nombreClave+" AS clave FROM "+nombreTable+" WHERE "+nombreColumna+"='"+valorColumna+"'";
            ResultSet rs = query.executeQuery( q);
            rs.next();
            return rs.getString("clave");
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }



    // INSERTS

    // Inserta les dades a la taula Llista

    public void insertInfoTaulaLista(String titulo, String subtitulo, String categoria){
        try {
            String q = "INSERT INTO lista (título, subtítulo, numCanciones, Usuario, Categoría, orden) VALUES ('" + titulo + "', '" + subtitulo + "', '0', 'nuriafemeniass', '" + categoria + "', '36')";
            System.out.println(q);
            query.execute(q);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }



    // DELETES

    // Esborra la fila de la taula Unitat amb el número concret
    public void deleteInfoTaulaLista(String titulo){
        try {
            // DELETE FROM lista WHERE `lista`.`título` = 'hh'
            String q = "DELETE FROM lista WHERE `lista`.`título` = '"+titulo+"'"; //borrar una llista
            System.out.println(q);
            query.execute(q);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }



    // UPDATES

    // Actualitza les dades a la taula Unitat

    void updateInfoTaulaUnitat(String id, String num, String nom){
        try {
            String q = "UPDATE unitat SET numero='"+num+"', nom='"+nom+"' WHERE numero='"+id+"'";
            System.out.println(q);
            query.execute(q);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}
