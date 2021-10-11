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
public class parqueadero {
    int id;
    int piso;
    String bloque;
    String celdas;
    double tarifaCarro;
    double tarifaMoto;
    double tarifaCamioneta;
    double tarifaCamion;
    
    public parqueadero(int id, int piso, String bloque, String celdas, double tarifaCarro, double tarifaMoto, double tarifaCamioneta, double tarifaCamion){
        this.id = id;
        this.piso = piso;
        this.bloque = bloque;
        this.celdas = celdas;
        this.tarifaCarro = tarifaCarro;
        this.tarifaMoto = tarifaMoto;
        this.tarifaCamioneta = tarifaCamioneta;
        this.tarifaCamion = tarifaCamion;
    }

    public parqueadero(int piso, String bloque, String celdas, double tarifaCarro, double tarifaMoto, double tarifaCamioneta, double tarifaCamion) {
        this.piso = piso;
        this.bloque = bloque;
        this.celdas = celdas;
        this.tarifaCarro = tarifaCarro;
        this.tarifaMoto = tarifaMoto;
        this.tarifaCamioneta = tarifaCamioneta;
        this.tarifaCamion = tarifaCamion;
    }
    
    public parqueadero(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getTarifaCarro() {
        return tarifaCarro;
    }

    public void setTarifaCarro(double tarifaCarro) {
        this.tarifaCarro = tarifaCarro;
    }

    public double getTarifaMoto() {
        return tarifaMoto;
    }

    public void setTarifaMoto(double tarifaMoto) {
        this.tarifaMoto = tarifaMoto;
    }

    public double getTarifaCamioneta() {
        return tarifaCamioneta;
    }

    public void setTarifaCamioneta(double tarifaCamioneta) {
        this.tarifaCamioneta = tarifaCamioneta;
    }

    public double getTarifaCamion() {
        return tarifaCamion;
    }

    public void setTarifaCamion(double tarifaCamion) {
        this.tarifaCamion = tarifaCamion;
    }
    
    public boolean configParqueadero(int id){
        conexion_bd conexion = new conexion_bd();
        
        String sentencia = "UPDATE parqueadero SET piso=" + this.piso + ",bloque='" + this.bloque 
                            + "',celdaParqueo='" + this.celdas + "',tarifaCarro=" + this.tarifaCarro
                            + ",tarifaMoto=" + this.tarifaMoto + ",tarifaCamioneta=" + this.tarifaCamioneta 
                            + ",tarifaCamion=" + this.tarifaCamion + " WHERE idparqueadero=" + id + ";";
        
        conexion.insertBD(sentencia);
        conexion.closeConnection();
        
        return true;
    }
    
    public ArrayList<parqueadero>listarParqueadero(){
        conexion_bd conexion = new conexion_bd();
        ArrayList<parqueadero>listaparqueadero=new ArrayList<>();
        String sentencia="SELECT * FROM parqueadero";
        ResultSet RS=conexion.consultarBD(sentencia);
        parqueadero p;
        try{
            while(RS.next()){
                p=new parqueadero();
                p.setPiso(RS.getInt("piso"));
                p.setBloque(RS.getString("bloque"));
                p.setCeldas(RS.getString("celdaParqueo"));
                p.setTarifaCarro(RS.getDouble("tarifaCarro"));
                p.setTarifaMoto(RS.getDouble("tarifaMoto"));
                p.setTarifaCamioneta(RS.getDouble("tarifaCamioneta"));
                p.setTarifaCamion(RS.getDouble("tarifaCamion"));
                
                listaparqueadero.add(p);
                
            }
        }catch(SQLException e){
            System.out.println("error Consulta: "+e.getMessage());}
        return listaparqueadero;
    
    }
    
}
