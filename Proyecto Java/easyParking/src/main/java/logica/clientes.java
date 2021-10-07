/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.conexion_bd;

/**
 *
 * @author Junior Vasquez
 */
public class clientes {
    int id;
    String nombre;
    String apellido;
    String celular;
    String tipoVehiculo;
    String placavehiculo;
    conexion_bd conexion=new conexion_bd();
    public clientes(int id, String nombre, String apellido, String celular, String tipoVehiculo, String placavehiculo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.tipoVehiculo = tipoVehiculo;
        this.placavehiculo = placavehiculo;
        
    }

    public clientes() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getPlacavehiculo() {
        return placavehiculo;
    }

    public void setPlacavehiculo(String placavehiculo) {
        this.placavehiculo = placavehiculo;
    }
    public boolean guardarCliente(){
        String sentencia= "INSERT INTO clientes (nombre, apellidos, celular, tipoVehiculo, placaVehiculo ) VALUES('"+this.nombre+"','"+this.apellido+"','"+this.celular+"','"+this.tipoVehiculo+"','"+this.placavehiculo+"')";
              return conexion.insertBD(sentencia);
    }
    public boolean eliminarcliente(int idcliente){
       String sentencia="DELETE FROM clientes WHERE idcliente='"+idcliente+"'";
       return conexion.deleteBD(sentencia);
       
    }
    public boolean actualizarcliente(int idcliente){
    String sentencia= "UPDATE clientes SET nombre='"+this.nombre+"',apellidos='"+this.apellido+"',celular='"+this.celular+"',tipoVehiculo='"+this.tipoVehiculo+"',placaVehiculo='"+this.placavehiculo+"' WHERE idcliente="+idcliente+";";
    return conexion.updateBD(sentencia);
    }
    public ArrayList<clientes>listarclientes(){
    ArrayList<clientes>listaclientes=new ArrayList<>();
    String sentencia="SELECT * FROM clientes";
    ResultSet RS=conexion.consultarBD(sentencia);
    clientes c;
    try{
            while(RS.next()){
                c=new clientes();
                c.setId(RS.getInt("idcliente"));
                c.setNombre(RS.getString("nombre"));
                 c.setApellido(RS.getString("apellido"));
                 c.setCelular(RS.getString("celular"));
                 c.setTipoVehiculo(RS.getString("tipoVehiculo"));
                 c.setPlacavehiculo(RS.getString("placaVehiculo"));
                
            }
        }catch(SQLException e){
            System.out.println("error Consulta: "+e.getMessage());}
        return listaclientes;
    
    }
}


        
    
  
            

