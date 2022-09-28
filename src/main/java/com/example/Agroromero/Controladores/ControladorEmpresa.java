        package com.example.Agroromero.Controladores;

        import com.example.Agroromero.Entidades.Empleado;
        import com.example.Agroromero.Entidades.Empresa;
        import com.example.Agroromero.Servicios.ServicioEmpresa;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.web.servlet.view.RedirectView;

        import java.util.List;

@RestController
public class ControladorEmpresa {

    ServicioEmpresa se1;


    public ControladorEmpresa(ServicioEmpresa se1){
        this.se1 = se1;
    }
/*
    @GetMapping("/enterprise")
    public List<Empresa> informacion(){
        return this.se1.getInformacion();
    }


 */
    @PostMapping("/enterprise")
    public Empresa crearEmpresa(@RequestBody Empresa e){
        return this.se1.crearEmpresa(e);
    }

    @PostMapping("/empresas")
    public RedirectView crearEmpresa(@ModelAttribute Empresa nuevaEmpresa, Model model) {
        model.addAttribute(nuevaEmpresa);
        this.se1.crearEmpresa(nuevaEmpresa);
        return new RedirectView("/empresas");
    }

    @PutMapping("/empresas/{nit}")
    public RedirectView actualizarEmpresa(@PathVariable Long nit, Empresa actEmprresa){
        this.se1.actualizarEmpresa(nit, actEmprresa);
        return new RedirectView("/empresas");
    }
/*
    @PutMapping("/empleados/{documentoIdentidad}")
    public RedirectView actualizarUsuario(@PathVariable Long documentoIdentidad, Empleado actEmpleado) {
        this.serviciosUsu.actualizarUsuario(documentoIdentidad, actEmpleado);
        return new RedirectView("/empleados");
    }

 */






    @DeleteMapping("/empresas/{nit}")
    public RedirectView eliminarEmpresa(@PathVariable(value = "nit") Long nit){
        this.se1.eliminarEmpresa(nit);
        return new RedirectView("/empresas");
    }

}
