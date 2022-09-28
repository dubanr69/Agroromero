package com.example.Agroromero.Entidades;

import javax.persistence.*;

@Entity
@Table(name = "empleado")
public class Empleado {
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;*/
    @Id
    private Long documentoIdentidad;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "correo")
    private String correo;
    @Column(name = "empresaEmpleadoPertenece")
    private String empresaEmpleadoPertenece;
    @Column(name = "rolEmpleado")
    private String rolEmpleado;

/*
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "nit",nullable = false)
    private Empresa empresa;

 */
@ManyToOne(optional = false)
@JoinColumn(name = "nit")
private Empresa empresa;

    public Empleado(){

    }


    /*public Empleado(String nombre, String correo, String empresaEmpleadoPertenece, String rolEmpleado, MovimientoDinero movimiento1) {
        this.nombre = nombre;
        this.correo = correo;
        this.empresaEmpleadoPertenece = empresaEmpleadoPertenece;
        this.rolEmpleado = rolEmpleado;
        this.movimiento1 = movimiento1;
    }
    */

    public Long getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(Long documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEmpresaEmpleadoPertenece() {
        return empresaEmpleadoPertenece;
    }

    public void setEmpresaEmpleadoPertenece( String empresaEmpleadoPertenece) {
        this.empresaEmpleadoPertenece = empresaEmpleadoPertenece;
    }

    public String getRolEmpleado() {
        return rolEmpleado;
    }

    public void setRolEmpleado(String rolEmpleado) {
        this.rolEmpleado = rolEmpleado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }



    /*  public montoMovimiento getmontoMovimiento() {
        return getmontoMovimiento();
    }

    public void montoMovimiento(montoMovimiento movimiento) {
        this.getmontoMovimiento() = movimiento;
    }
/*
    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", empresaEmpleadoPertenece='" + empresaEmpleadoPertenece + '\'' +
                ", rolEmpleado='" + rolEmpleado + '\'' +
                ", movimiento1=" + this.movimiento1 +
                '}';
    }

 */
}
