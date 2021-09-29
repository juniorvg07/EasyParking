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
public class conexion_bd {
        
    //Atributos para la conexión a la base de datos
    private String url = "jdbc:mysql://localhost:3306/easyparking_db"; //Base de datos a llamar
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String user = "root";
    private String password = "0722";
    public Connection con = null; //Objeto: Estado de la conexión
    private Statement stmt = null;
    private ResultSet rs = null;
    
    //Constructor sin parámetros
    public conexion_bd(){             
        try {
            //Asignacin del Driver
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(conexion_bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            // Realizar la conexion
            con = DriverManager.getConnection(url, user, password);
            con.setTransactionIsolation(8);
            System.out.println("conectado");
        } catch (SQLException ex) {
            Logger.getLogger(conexion_bd.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(conexion_bd.class.getName()).log(Level.SEVERE, null, error);
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
       
    public static void main(String[] args) {
        conexion_bd cn=new conexion_bd();
        Statement st0;
        ResultSet rst;
        try {
            st0=cn.con.createStatement();
            rst=st0.executeQuery("select * from clientes");
            while (rst.next()) {                
                System.out.println(rst.getInt("idclientes")+" " +rst.getString("nombre")+" " +rst.getString("apellidos")+" " +rst.getString("celular")+" " +rst.getString("tipoVehiculo")+" " +rst.getString("placaVehiculo"));
            }
            cn.con.close();
        } catch (Exception e) {
        }
    
    }
    
}
