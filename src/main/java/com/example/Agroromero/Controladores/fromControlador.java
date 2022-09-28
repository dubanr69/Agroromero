package com.example.Agroromero.Controladores;


import com.example.Agroromero.Entidades.Empleado;
import com.example.Agroromero.Entidades.Empresa;
import com.example.Agroromero.Entidades.MovimientoDinero;
import com.example.Agroromero.Entidades.UsuariosAuth;
import com.example.Agroromero.Servicios.ServicioEmpresa;
import com.example.Agroromero.Servicios.ServicioMovimientoDinero;
import com.example.Agroromero.Servicios.ServicioUsuario;
import com.example.Agroromero.Servicios.ServiciosUsuariosAuth;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller

public class fromControlador {
    ServicioUsuario serviciosUsu;
    ServicioEmpresa se1;
    ServicioMovimientoDinero smd1;
    ServiciosUsuariosAuth serviciosUsuariosAuth;

    public fromControlador(ServicioUsuario serviciosUsu, ServicioEmpresa se1, ServicioMovimientoDinero smd1, ServiciosUsuariosAuth serviciosUsuariosAuth) {
        this.serviciosUsu = serviciosUsu;
        this.se1 = se1;
        this.smd1 = smd1;
        this.serviciosUsuariosAuth = serviciosUsuariosAuth;
    }

    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal OidcUser principal) {
        if (principal != null) {
            //System.out.println(principal.getClaims());
            UsuariosAuth usuariosAuth = this.serviciosUsuariosAuth.getOrCreateUsuarios(principal.getClaims());
            model.addAttribute("usuariosAut", usuariosAuth);
        }
        return "index";
    }
    /*------------------Controladores Empleado_________*/

    //aqui hago usu de los servicios de usuarios


    @GetMapping("/empleados")
    public String empleados(Model modelP) {
        List<Empleado> empleados = this.serviciosUsu.getlistaEmpleado();
        modelP.addAttribute("empleado", empleados);
        return "empleados";
    }


    @GetMapping("/nuevoE")
    public String nuevoE(Model model) {
        model.addAttribute("empleado", new Empleado());
        return "nuevoE";
    }

    @GetMapping("/empleados/{documentoIdentidad}")
    public String actualizarEmpleado(@PathVariable long documentoIdentidad, Model model) {
        Empleado empleadoFind = this.serviciosUsu.getllamarEmpleado(documentoIdentidad);
        model.addAttribute("empleadoFind", empleadoFind);
        return "actualizarEmpleado";
    }

    @GetMapping("/empresas/{nit}")
    public String actualizarEmpresas(@PathVariable Long nit, Model modelp) {
        Empresa empresaFind = this.se1.llamarEmpresa(nit);
        modelp.addAttribute("empresaFind", empresaFind);
        return "actualizarEmpresas";
    }

    @GetMapping("/movimientoDinero")
    public String informacion(Model modelD) {
        List<MovimientoDinero> informacion = this.smd1.getInformacion();
        modelD.addAttribute("informacion", informacion);
        return "movimientoDinero";
    }

    @GetMapping("/creaMvto")
    public String creaMvto(Model movimientoD) {
        movimientoD.addAttribute("movimientoD", new MovimientoDinero());
        return "creaMvto";
    }


    /*---------------------Controladores Empresa___________*/

    @GetMapping("/empresa")
    public String empresa() {
        return "empresa";
    }

    @GetMapping("/empresas")
    public String empresas(Model modelE) {
        List<Empresa> empresas = this.se1.getInformacion();
        modelE.addAttribute("empresas", empresas);
        return "empresas";
    }

    @GetMapping("/nuevaE")
    public String nuevaE(Model model) {
        model.addAttribute("empresas", new Empresa());
        return "nuevaE";
    }

    @GetMapping("empleados/balance/{documentoIdentidad}")
    public String balance(@PathVariable Long documentoIdentidad) {
        double balancesT = this.smd1.getbalance(documentoIdentidad);
        return "balance";
    }
}
