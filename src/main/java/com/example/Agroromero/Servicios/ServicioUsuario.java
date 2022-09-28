package com.example.Agroromero.Servicios;
import com.example.Agroromero.Entidades.Empleado;
import com.example.Agroromero.Repositorios.RepositorioUsuario;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@Service
public class ServicioUsuario {
    private RepositorioUsuario repositorioUsuario;

    public ServicioUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public List<Empleado> getlistaEmpleado() {
        return this.repositorioUsuario.findAll();
    }
    public Empleado getllamarEmpleado(Long documentoIdentidad) {
        return this.repositorioUsuario.findById(documentoIdentidad).orElseThrow();
    }


    public Empleado crearUsuario(Empleado nuevoUsuario) {
        return this.repositorioUsuario.save(nuevoUsuario);
    }

    public Empleado actualizarUsuario(@PathVariable Long documentoIdentidad, @RequestBody Empleado e) {
        Empleado empleadoActual = this.repositorioUsuario.findById(documentoIdentidad).orElseThrow();
        empleadoActual.setDocumentoIdentidad((e.getDocumentoIdentidad()));
        empleadoActual.setCorreo((e.getCorreo()));
        empleadoActual.setNombre(e.getNombre());
        empleadoActual.setRolEmpleado(e.getRolEmpleado());
        empleadoActual.setEmpresaEmpleadoPertenece(e.getEmpresaEmpleadoPertenece());
        return this.repositorioUsuario.save(empleadoActual);
    }

    public Empleado eliminarUsuario(Long documentoIdentidad) {
        Empleado empleadoActual = this.repositorioUsuario.findById(documentoIdentidad).orElseThrow();
        this.repositorioUsuario.deleteById(documentoIdentidad);
        return empleadoActual;
    }

    public Empleado getUsuario(Long documentoIdentidad){
        return this.repositorioUsuario.findById(documentoIdentidad).orElseThrow();
    }
}

