/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.*;
import java.util.logging.*;

/**
 *
 * @author Junior Vasquez
 */
public class conexionBD {
        
    //Atributos para la conexión a la base de datos
    private String url = ""; //Base de datos a llamar
    public Connection con = null; //Objeto: Estado de la conexión
    private Statement stmt = null;
    private ResultSet rs = null;
    
    //Constructor sin parámetros
    public conexionBD(){      
        url = "jdbc:sqlite:reto5db.db";
        
        try {
            con = DriverManager.getConnection(url); //Obtener el estadco de la conexión
            
            if(con != null){
                
                DatabaseMetaData meta = con.getMetaData(); //No está vacío, entonces, meta va a guardar los metadatos
                System.out.println("Base de datos conectada!!!" + meta.getDriverName());
                
            }   
        }catch (SQLException error){
            System.out.println(error.getMessage());
        } 
    }
    
    //Método que retorna la conexión
    public Connection getConnection(){
        return con;
    }
    
    //Método que cierra la conexión
    public void closeConnection(){
        if(con != null){
            try{
                con.close();
            } catch(SQLException error){
                Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, error);
            }
        }
    }   
   
    // Metodo que devuelve un ResultSet de una consulta (tratamiento de SELECT)
    public ResultSet consultBD(String sentencia) {
        try {
            stmt= con.createStatement();
            rs= stmt.executeQuery(sentencia);
        } catch (SQLException sqlex) {
            System.out.println(sqlex.getMessage());
        } catch (RuntimeException rex) {
            System.out.println(rex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }   
    
    //Metodo para ingresar info a la base de datos
    public boolean insertBD(String sentencia){
        try {
            stmt = con.createStatement();
            stmt.execute(sentencia);
            
        } catch (SQLException | RuntimeException error) {
            return false;
        }
        return true;
    }

    //Borrar base de datos
    public boolean deleteBD(String sentencia){
        try {
            stmt = con.createStatement();
            stmt.execute(sentencia);
            
        } catch (SQLException | RuntimeException error) {
            return false;
        }
        return true;
    }

    public boolean updateBD(String sentencia){
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(sentencia);
            
        } catch (SQLException | RuntimeException error) {
            return false;
        }
        return true;
    }

    //Metodo para consultar dado en clases
    public ResultSet consultarBD(String sentencia){
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sentencia);
            
        } catch (SQLException | RuntimeException error) {
            System.out.println("Error en la rutina " + error);
        } catch (Exception error) {
            System.out.println("error: " + error.getMessage());
        }
        return rs;
    }

    public boolean setAutoCommitBD(boolean parametro) {
        try {
            con.setAutoCommit(parametro);
        } catch (SQLException sqlex) {
            System.out.println("Error al configurar el autoCommit " + sqlex.getMessage());
            return false;
        }
        return true;
    }

    public boolean commitBD() {
        try {
            con.commit();
            return true;
        } catch (SQLException sqlex) {
            System.out.println("Error al hacer commit " + sqlex.getMessage());
            return false;
        }
    }

    public boolean rollbackBD() {
        try {
            con.rollback();
            return true;
        } catch (SQLException sqlex) {
            System.out.println("Error al hacer rollback " + sqlex.getMessage());
            return false;
        }
    }    
    
}
