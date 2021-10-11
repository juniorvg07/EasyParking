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
    String estado;
    
    conexion_bd conexion=new conexion_bd();
    
    public clientes(int id, String nombre, String apellido, String celular, String tipoVehiculo, String placavehiculo, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.tipoVehiculo = tipoVehiculo;
        this.placavehiculo = placavehiculo;
        this.estado = estado;
    }

    public clientes(int id, String nombre, String apellido, String celular, String tipoVehiculo, String placavehiculo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.tipoVehiculo = tipoVehiculo;
        this.placavehiculo = placavehiculo;
    }

    public clientes(String estado) {
        this.estado = estado;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public boolean guardarCliente(){
        conexion_bd conexion = new conexion_bd();
        String sentencia= "INSERT INTO clientes (idclientes, nombre, apellidos, celular, tipoVehiculo, placavehiculo ) VALUES('"+this.id+"','"+this.nombre+"','"+this.apellido+"','"+this.celular+"','"+this.tipoVehiculo+"','"+this.placavehiculo+"')";
        
        conexion.insertBD(sentencia);
        conexion.closeConnection();
        
        return true;
    }
    public boolean eliminarcliente(int idcliente){
       String sentencia="DELETE FROM clientes WHERE idcliente='"+idcliente+"'";
       return conexion.deleteBD(sentencia);
       
    }
    public boolean actualizarcliente(int idcliente){
        conexion_bd conexion = new conexion_bd();
        String sentencia= "UPDATE clientes SET estado='"+this.estado+"' WHERE idclientes="+idcliente+";";
        return conexion.updateBD(sentencia);
    }
    
    public boolean actualizarcliente2(String placa){
        conexion_bd conexion = new conexion_bd();
        String sentencia= "UPDATE clientes SET estado='"+this.estado+"' WHERE placavehiculo='"+placa+"';";
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
                c.setId(RS.getInt("idclientes"));
                c.setNombre(RS.getString("nombre"));
                c.setApellido(RS.getString("apellidos"));
                c.setCelular(RS.getString("celular"));
                c.setTipoVehiculo(RS.getString("tipoVehiculo"));
                c.setPlacavehiculo(RS.getString("placavehiculo"));
                c.setEstado(RS.getString("estado"));
                
                listaclientes.add(c);
                
            }
        }catch(SQLException e){
            System.out.println("error Consulta: "+e.getMessage());}
        return listaclientes;
    
    }
}


        
    
  
            

