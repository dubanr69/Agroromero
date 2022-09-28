package com.example.Agroromero.Servicios;

//import com.example.Agroromero.Entidades.Empleado;
import com.example.Agroromero.Entidades.MovimientoDinero;
import com.example.Agroromero.Repositorios.RepositorioMovimientoDinero;
//import com.example.Agroromero.Repositorios.RepositorioUsuario;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ServicioMovimientoDinero {

    private RepositorioMovimientoDinero repositorioMD;

    public ServicioMovimientoDinero(RepositorioMovimientoDinero repositorioMD){
        this.repositorioMD = repositorioMD;
    }


    public List<MovimientoDinero> getInformacion(){
        return this.repositorioMD.findAll();
    }

    public MovimientoDinero crearMovimientoDinero(MovimientoDinero nuevoMovimientoDinero){
        return this.repositorioMD.save(nuevoMovimientoDinero);
    }

    public MovimientoDinero actualizarMovimientoDinero(@PathVariable Long id, @RequestBody MovimientoDinero md){
        MovimientoDinero movimientoDineroActual = this.repositorioMD.findById(id).orElseThrow();
        movimientoDineroActual.setConceptoMovimiento(md.getConceptoMovimiento());
        movimientoDineroActual.setMontoMovimiento(md.getMontoMovimiento());
        return this.repositorioMD.save(movimientoDineroActual);
    }

    public MovimientoDinero eliminarMovimientoDinero(Long id){
        MovimientoDinero movimientoDineroActual = this.repositorioMD.findById(id).orElseThrow();
        this.repositorioMD.deleteById(id);
        return movimientoDineroActual;
    }


    //metodo

    public double getbalance(Long id){
        List<MovimientoDinero> movimientos = this.repositorioMD.findAll();
        System.out.println(movimientos.size());
        System.out.println(movimientos.listIterator());
        double balance = 0;
        for (int i = 0; i < movimientos.size(); i++){
            if(movimientos.get(i).getEmpleado().getDocumentoIdentidad() == id.intValue()){
                System.out.println(movimientos.get(i).getMontoMovimiento());
                balance = balance + movimientos.get(i).getMontoMovimiento();
            }
        }
        System.out.println(balance);
        return balance;

    }
}









