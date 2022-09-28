package com.example.Agroromero.Entidades;

import javax.persistence.*;

@Entity
@Table(name = "movimientodinero")
public class MovimientoDinero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long registroMoviento;
    @Column(name = "montomovimiento")
    private double montoMovimiento;
    @Column(name = "conceptomovimiento")
    private String conceptoMovimiento;

    @ManyToOne(optional = false)
    @JoinColumn (name = "documentoIdentidad")
    private Empleado empleado;

    /*
@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn (name = "documentoIdentidad",nullable = false)
private Empleado empleado;


    /*

    public MovimientoDinero(double montoMovimiento, String conceptoMovimiento) {
        this.montoMovimiento = montoMovimiento;
        this.conceptoMovimiento = conceptoMovimiento;


    }

     */
    public long getRegistroMoviento() {
        return registroMoviento;
    }

    public void setRegistroMoviento(long registroMoviento) {
        this.registroMoviento = registroMoviento;
    }
    public MovimientoDinero(){

    }

    public double getMontoMovimiento() {
        return montoMovimiento;
    }

    public String getConceptoMovimiento() {
        return conceptoMovimiento;
    }

    public void setMontoMovimiento(double montoMovimiento) {
        this.montoMovimiento = montoMovimiento;
    }

    public void setConceptoMovimiento(String conceptoMovimiento) {
        this.conceptoMovimiento = conceptoMovimiento;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    /*
 public double sumarMovimientos(){
        double cedula=this.empleado.getDocumentoIdentidad();
        return "cedula";
 }

     */
}







