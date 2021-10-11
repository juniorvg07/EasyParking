/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Junior Vasquez
 */
public class factura {
    int idFactura;
    int idCliente;
    String fechaFactura;
    String bloque;
    String celda;
    String horaIngreso;
    String horaSalida;
    double tarifa;
    double totalFactura;

    public factura(int idFactura, int idCliente, String fechaFactura, String bloque, String celda, String horaSalida, double tarifa, double totalFactura) {
        this.idFactura = idFactura;
        this.idCliente = idCliente;
        this.fechaFactura = fechaFactura;
        this.bloque = bloque;
        this.celda = celda;
        this.horaSalida = horaSalida;
        this.tarifa = tarifa;
        this.totalFactura = totalFactura;
    }

    public factura() {
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(String fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public String getBloque() {
        return bloque;
    }

    public void setBloque(String bloque) {
        this.bloque = bloque;
    }

    public String getCelda() {
        return celda;
    }

    public void setCelda(String celda) {
        this.celda = celda;
    }

    public String getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(String horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public double getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(double totalFactura) {
        this.totalFactura = totalFactura;
    }
    
    
    
}
