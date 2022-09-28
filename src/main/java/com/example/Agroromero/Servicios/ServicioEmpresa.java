        package com.example.Agroromero.Servicios;

        import com.example.Agroromero.Entidades.Empleado;
        import com.example.Agroromero.Entidades.Empresa;
        import com.example.Agroromero.Repositorios.RepositorioEmpresa;
        import org.springframework.stereotype.Service;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestBody;

        import java.util.List;

@Service
public class ServicioEmpresa {

    private RepositorioEmpresa repositorioEmpresa;

    public ServicioEmpresa(RepositorioEmpresa repositorioEmpresa){
        this.repositorioEmpresa = repositorioEmpresa;
    }

    public List<Empresa> getInformacion(){
        return this.repositorioEmpresa.findAll();
    }

    public Empresa crearEmpresa(Empresa nuevaEmpresa) {
        return this.repositorioEmpresa.save(nuevaEmpresa);
    }

    public Empresa actualizarEmpresa(@PathVariable Long nit, @RequestBody Empresa e) {
        Empresa empresaActual = this.repositorioEmpresa.findById(nit).orElseThrow();
        empresaActual.setNit((e.getNit()));
        empresaActual.setNombre((e.getNombre()));
        empresaActual.setDireccion((e.getDireccion()));
        empresaActual.setTelefono((e.getTelefono()));

        return this.repositorioEmpresa.save(empresaActual) ;
    }



    public Empresa eliminarEmpresa(Long nit) {
        Empresa empresaActual = this.repositorioEmpresa.findById(nit).orElseThrow();
        this.repositorioEmpresa.deleteById(nit);
        return empresaActual;
    }
    public Empresa llamarEmpresa(Long nit){
        return this.repositorioEmpresa.findById(nit).orElseThrow();
    }
}
