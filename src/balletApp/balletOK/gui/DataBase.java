package balletApp.balletOK.gui;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBase {
    Connection c;
    Statement query;
    String user, password, databaseName;
    boolean connectat = false;
    public DataBase(String user, String password, String databaseName){
        this.user = user;
        this.password = password;
        this.databaseName = databaseName;
    }

    /**
     * Conecta la aplicación con la base de datos
     */
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

    /**
     * Devuelve el número de filas de una tabla en concreto
     * @param nomTaula Nombre de la tabla
     * @return Int
     */    public int getNumRowsTaula(String nomTaula){
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

    /**
     * Devuelve el número de filas de una query en concreto
     * @param q Query
     * @return Int
     */
    public int getNumRowsQuery(String q){
        try {
            System.out.println(q);
            ResultSet rs = query.executeQuery( q);
            rs.next();
            return rs.getInt("n");
        }
        catch(Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    /**
     * Devuelve la información de la tabla Llista
     * @param nomUsuario Nombre del usuario
     * @return Array bidimensional de String
     */
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

    /**
     * Devuelve los nombres de las listas
     * @param nomUsuario nombre de usuario
     * @return Array bidimensional de String
     */
    // Retorna les dades d'una taula en concret
    public String[] getNombresListas(String nomUsuario){
        String qn = "SELECT COUNT(*) AS n FROM lista l, usuario u WHERE  l.Usuario = u.nombre AND l.Usuario = '"+nomUsuario+"' ";
        int numFiles = getNumRowsQuery(qn);
        String[] info = new String[numFiles];
        try {
            String q = "SELECT l.título AS TITULO FROM lista l, usuario u WHERE l.Usuario = u.nombre AND l.Usuario = '"+nomUsuario+"' ORDER BY TITULO ASC";

            ResultSet rs = query.executeQuery(q);
            int nr = 0;
            while (rs.next()) {
                info[nr] = rs.getString("TITULO");
                nr++;
            }
            return info;
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * Devuelve la información de la tabla Cacniones
     * @param nomUsuario Nombre del usuario
     * @return Array bidimensional de String
     */
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

    /**
     * Devuelve información de la tabla de la pantalla Favoritos
      * @param nomUsuario Nombre del usuario
      * @return Array Bidimensional de String
     */
    public String[][] getInfoTaulaFavoritos(String nomUsuario){
        String qn ="SELECT COUNT(*) AS n "+
                "FROM canción c , usuario u, lista l "+
                "WHERE l.Usuario = u.nombre AND l.título=c.Lista_título AND c.favorito = '1' AND u.nombre='" + nomUsuario + "' " ;
        int numFiles = getNumRowsQuery(qn);
        int numCols  = 3;
        String[][] info = new String[numFiles][numCols];
        try {
            String q = "SELECT c.título AS TITULO, c.Lista_título AS LISTA, c.orden AS ORDEN "+
                    "FROM canción c , usuario u, lista l "+
                    "WHERE l.Usuario = u.nombre AND l.título=c.Lista_título AND c.favorito = '1' AND u.nombre='" + nomUsuario + "' " +
                    "ORDER BY ORDEN ASC";
            Statement query = c.createStatement();
            ResultSet rs = query.executeQuery(q);
            int nr = 0;
            while (rs.next()) {
                info[nr][0] = rs.getString("ORDEN");
                info[nr][1] = rs.getString("LISTA");
                info[nr][2] = rs.getString("TITULO");
                nr++;
            }
            return info;
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * Devuelve información de la tabla de la pantalla TusCanciones
     * @param nomUsuario Nombre del usuario
     * @return Array Bidimensional de String
     */
    public String [][] getInfoTaulaTusCanciones (String nomUsuario){
        int numFiles = getNumRowsTaula("canción");
        int numCols  = 3;
        String[][] info = new String[numFiles][numCols];
        try {
            Statement query = c.createStatement();
            ResultSet rs = query.executeQuery( "SELECT c.título AS TITULO, c.Lista_título AS LISTA, c.orden AS ORDEN FROM canción c ");
            int nr = 0;
            while (rs.next()) {
                info[nr][0] = rs.getString("ORDEN");
                info[nr][1] = rs.getString("LISTA");
                info[nr][2] = rs.getString("TITULO");
                nr++;
            }
            return info;
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * Devuelve información de la tabla de la pantalla TusListas
     * @param nomUsuario Nombre del usuario
     * @return Array Bidimensional de String
     */
    public String [][] getInfoTaulaTusListas(String nomUsuario){
        String qn ="SELECT COUNT(*) As n FROM lista l, usuario u, categoría c WHERE l.Usuario = u.nombre AND l.Usuario = '"+nomUsuario+"' AND l.Categoría = c.idCategoría";
        int numFiles = getNumRowsQuery(qn);
        int numCols  = 3;
        String[][] info = new String[numFiles][numCols];
        try {
            String q ="SELECT l.numCanciones AS NUM, l.título AS TITULO, c.nombre AS CATEGORIA FROM lista l, usuario u, categoría c WHERE l.Usuario = u.nombre AND l.Usuario = '"+nomUsuario+"' AND l.Categoría = c.idCategoría ORDER BY l.orden ASC";
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

    /**
     * Devuelve la información de las canciones de una lista
     * @param idLista identificador de la lista
     * @return Array Bidimensional de String
     */
    public String[][] getInfoCancionesLista(String idLista){
        String qn ="SELECT COUNT(*) As n FROM canción c, lista l WHERE c.Lista_título = l.título AND l.título = '"+idLista+"' ORDER BY c.orden ASC";
        int numFiles = getNumRowsQuery(qn);
        int numCols  = 3;
        String[][] info = new String[numFiles][numCols];
        try {
            String q ="SELECT c.orden AS ORDEN, c.título AS TITULO, c.día AS DIA FROM canción c, lista l " +
                    "WHERE c.Lista_título = l.título AND l.título = '"+idLista+"' ORDER BY c.orden ASC";
            ResultSet rs = query.executeQuery(q);
            int nr = 0;
            while (rs.next()) {
                info[nr][0] = String.valueOf(rs.getInt("ORDEN"));
                info[nr][1] = rs.getString("TITULO");
                info[nr][2] = rs.getString("DIA");
                nr++;
            }
            return info;
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * Devuelve las canciones de una lista
     * @param nomUsuario Usuario al que pertenecen las canciones
     * @param nomLista Nombre de la lista
     * @return Array Bidimensional de String
     */
    public String[][] getCancionesLista(String nomUsuario, String nomLista){
        String qn = "SELECT COUNT(*) AS n " +
                " FROM canción c, lista l,  usuario u " +
                " WHERE c.Lista_título=l.título AND l.Usuario= u.nombre " +
                "  AND u.nombre='"+nomUsuario+"' AND l.título='"+nomLista+"' ";
        int numFiles = getNumRowsQuery(qn);
        int numCols  = 4;
        String[][] info = new String[numFiles][numCols];
        try {
            String q = "SELECT c.título AS TITULO, c.día AS DIA, c.Lista_título AS LISTA, c.orden AS ORDEN, c.favorito AS FAVORITO " +
                    " FROM canción c, lista l,  usuario u " +
                    " WHERE c.Lista_título=l.título AND l.Usuario= u.nombre " +
                    "  AND u.nombre='"+nomUsuario+"' AND l.título='"+nomLista+"' " +
                    " ORDER BY c.título ASC";
            System.out.println(q);
            ResultSet rs = query.executeQuery( q);
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

    /**
     * Devuelve la clave de una tabla
     * @param nombreTable Nombre de la tabla
     * @param nombreClave Nombre de la clave
     * @param nombreColumna Nombre de la columna
     * @param valorColumna Valor de la columna
     * @return String
     */
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

    /**
     * Inserta una nueva canción
     * @param titulo Título de la canción
     * @param dia Día de la agregación de la nueva canción
     * @param categoria Categoría de la canción
     * @param favorito String que determina si la canción "Favorita" o no
     */
    public void insertCancion(String titulo, String dia, String categoria, String favorito){
        try {
            String q = "INSERT INTO canción (título, día, Lista_título, favorito, orden) VALUES ('" + titulo + "', '" + dia + "','"+categoria+"','"+favorito+"', '50')";
            System.out.println(q);
            query.execute(q);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Inserta una nueva lista
     * @param titulo Título de la lista que se va insertar
     * @param subtitulo Subtítulo de la lista
     * @param categoria Categoría a la que pertenece la lista
     */
    public void insertLista(String titulo, String subtitulo, String categoria){
        try {
            String q = "INSERT INTO lista (título, subtítulo, numCanciones, Usuario, Categoría, orden) VALUES ('" + titulo + "', '" + subtitulo + "', '0', 'nuriafemeniass', '" + categoria + "', '36')";
            System.out.println(q);
            query.execute(q);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Devuelve la Lista de Categorias de Canciones.
     * @param nomUsuario Usuario de la aplicación
     * @param nombreCategoria Categoria de las listas
     * @return Array Bidimensional de String
     */
    public String [][] getInfoListasCategoria(String nomUsuario, String nombreCategoria){
        String qn = "SELECT COUNT(*) AS n "+
                "FROM lista l, usuario u, categoría c "+
                "WHERE l.Usuario = u.nombre AND l.Usuario = '"+nomUsuario+"' AND l.Categoría = c.idCategoría AND c.nombre='"+nombreCategoria+"' ";
        int numFiles = getNumRowsQuery(qn);
        int numCols  = 4;
        String[][] info = new String[numFiles][numCols];
        try {
            String q ="SELECT l.título AS TITULO, l.subtítulo AS SUBTITULO, l.numCanciones as NUM, l.orden AS ORDEN "+
                    "FROM lista l, usuario u, categoría c "+
                    "WHERE l.Usuario = u.nombre AND l.Usuario = '"+nomUsuario+"' AND l.Categoría = c.idCategoría AND c.nombre='"+nombreCategoria+"' "+
                    "ORDER BY l.orden ASC";
            ResultSet rs = query.executeQuery(q);
            int nr = 0;
            while (rs.next()) {
                info[nr][0] = String.valueOf(rs.getString("ORDEN"));
                info[nr][1] = rs.getString("TITULO");
                info[nr][2] = rs.getString("SUBTITULO");
                info[nr][3] = rs.getString("NUM");
                nr++;
            }
            return info;
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * Devuelve la Lista de Usuarios en la Base de Datos.
     * @return Array Bidimensional String
     */
    public String[][] getUsuaris(){
        int numFiles = getNumRowsTaula("usuario");
        int numCols = 2;
        String[][] usuarios = new String [numFiles][numCols];
        try {
            String q ="SELECT * FROM USUARIO";
            ResultSet rs = query.executeQuery(q);
            int nr = 0;
            while (rs.next()) {
                usuarios[nr][0] = String.valueOf(rs.getString("nombre"));
                usuarios[nr][1] = rs.getString("password");
                nr++;
            }
            return usuarios;
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * Borra una lista de la tabla
     * @param titulo Título de la lista que va a ser borrada
     */
    public void deleteInfoTaulaLista(String titulo){
        try {
            String q = "DELETE FROM lista WHERE `lista`.`título` = '"+titulo+"'";
            System.out.println(q);
            query.execute(q);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }


    /**
     * Actualiza el campo FAVORITO de una determinada canción
     * @param idCancion Identificador de la canción seleccionada
     * @param favorito Valor booleano que determina si una canción és o no "Favorita"
     */
    public void updateFavoritoCancion(String idCancion, boolean favorito){
        String valorFavorito = favorito ? "1" : "0";
        String q = "UPDATE canción SET favorito = '" + valorFavorito + "' WHERE título = '" + idCancion + "' ";
        System.out.println(q);
        try {
            query.execute(q);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Imprime un array bidimensional
     * @param array Array que se desea imprimir
     */
    public void printArray2d(String[][] array){
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[i].length; j++){
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }


    /**
     * Conversión de las fechas del formato español al inglés
     * @param fechaEntrada Fecha recibida en idioma
     * @return
     */
    public String formataFechaEng(String fechaEntrada){

        String y = fechaEntrada.split("/")[2];
        String m = fechaEntrada.split("/")[1];
        String d = fechaEntrada.split("/")[0];

        return y+"-"+m+"-"+d;
    }
}