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
public class activos {
    int piso;
    String bloque;
    String celdas;
    int id;
    String nombre;
    String apellido;
    String tipo;
    String placa;
    String horaIngreso;

    public activos(int piso, String bloque, String celdas, int id, String nombre, String apellido, String tipo, String placa, String horaIngreso) {
        this.piso = piso;
        this.bloque = bloque;
        this.celdas = celdas;
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo = tipo;
        this.placa = placa;
        this.horaIngreso = horaIngreso;
    }

    public activos() {
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public String getBloque() {
        return bloque;
    }

    public void setBloque(String bloque) {
        this.bloque = bloque;
    }

    public String getCeldas() {
        return celdas;
    }

    public void setCeldas(String celdas) {
        this.celdas = celdas;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(String horaIngreso) {
        this.horaIngreso = horaIngreso;
    }
    
    
        public boolean guardarActivo(){
        conexion_bd conexion = new conexion_bd();
        String sentencia= "INSERT INTO activos (idcliente, piso, bloque, celda, tipo, placa, nombre, apellido, horaIngreso ) VALUES('"+this.id+"','"+this.piso+"','"+this.bloque+"','"+this.celdas+"','"+this.tipo+"','"+this.placa+"','"+this.nombre+"','"+this.apellido+"','"+this.horaIngreso+"')";
        
        conexion.insertBD(sentencia);
        conexion.closeConnection();
        
        return true;
    }
        
    public boolean eliminarActivo(String placa){
        conexion_bd conexion = new conexion_bd();
        String sentencia="DELETE FROM activos WHERE placa='"+placa+"'";
        
        return conexion.deleteBD(sentencia);  
    }
    
    public boolean actualizarActivo(int idcliente){
        conexion_bd conexion = new conexion_bd();
        String sentencia= "UPDATE activos SET nombre='"+this.nombre+"',apellidos='"+this.apellido+"',piso='"+this.piso+"'bloque='"+this.bloque+"',celda='"+this.celdas+"',tipo='"+this.tipo+"',placa='"+this.placa+"',horaIngreso='"+this.horaIngreso+"' WHERE idcliente="+id+";";
        
        return conexion.updateBD(sentencia);
    }
    
    public ArrayList<activos>listaractivo(){
        conexion_bd conexion = new conexion_bd();
        ArrayList<activos>listaActivos=new ArrayList<>();
        String sentencia="SELECT * FROM activos";
        ResultSet RS=conexion.consultarBD(sentencia);
        activos a;
        try{
            while(RS.next()){
                a=new activos();
                a.setId(RS.getInt("idcliente"));
                a.setPiso(RS.getInt("piso"));
                a.setBloque(RS.getString("bloque"));
                a.setCeldas(RS.getString("celda"));
                a.setTipo(RS.getString("tipo"));
                a.setPlaca(RS.getString("placa"));
                a.setNombre(RS.getString("nombre"));
                a.setApellido(RS.getString("apellido"));
                a.setHoraIngreso(RS.getString("horaIngreso"));
                
                listaActivos.add(a);
                
            }
        }catch(SQLException e){
            System.out.println("error Consulta: "+e.getMessage());}
        
        return listaActivos;
    } 
}
