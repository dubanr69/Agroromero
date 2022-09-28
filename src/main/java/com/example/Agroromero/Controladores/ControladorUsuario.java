package com.example.Agroromero.Controladores;
import com.example.Agroromero.Entidades.Empleado;
import com.example.Agroromero.Servicios.ServicioUsuario;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class ControladorUsuario {

    ServicioUsuario serviciosUsu;

    //Constructor

    public ControladorUsuario(ServicioUsuario serviciosUsu){
        this.serviciosUsu = serviciosUsu;

    }
    //Get
    /*
    @GetMapping("/user")
    public List<Empleado> user(){
        return this.serviciosUsu.getlistaEmpleado();
    }


     */
    //Post
    /*
    @PostMapping("/empleados")
    public Empleado crearEmpleado(@ModelAttribute Empleado nuevoUsuario, Model model){
        model.addAttribute(nuevoUsuario);
        return this.serviciosUsu.crearUsuario(nuevoUsuario);
    }*/
    @PostMapping("/empleados")
    public RedirectView crearEmpleado(@ModelAttribute Empleado nuevoUsuario, Model model){
        model.addAttribute(nuevoUsuario);
        this.serviciosUsu.crearUsuario(nuevoUsuario);
        return new RedirectView("/empleados");
    }





    //editar un registro

    @PutMapping("/empleados/{documentoIdentidad}")
    public RedirectView actualizarUsuario(@PathVariable Long documentoIdentidad, Empleado actEmpleado){
       this.serviciosUsu.actualizarUsuario(documentoIdentidad, actEmpleado);
        return new RedirectView("/empleados");

    }

    /*
    @PutMapping("/empleados/{documentoIdentidad}")
    public Empleado actualizarUsuario(@PathVariable Long id, @RequestBody Empleado actEmpleado){
        return this.serviciosUsu.actualizarUsuario(id, actEmpleado);

    }

     */

    //borrar un registro
    @DeleteMapping("/empleados/{documentoIdentidad}")
    public RedirectView eliminarUsuario(@PathVariable(value = "documentoIdentidad") Long documentoIdentidad){
        this.serviciosUsu.eliminarUsuario(documentoIdentidad);
        return new RedirectView("/empleados");
    }
    @GetMapping("/user/{id}")
    public Empleado usuario(@PathVariable Long documentoIdentidad){
        return this.serviciosUsu.getUsuario(documentoIdentidad);
    }
    /*
    @DeleteMapping("/eliminar/{documentoIdentidad}")
    public Empleado eliminarUsuario(@PathVariable(value = "documentoIdentidad") Long id){
        return this.serviciosUsu.eliminarUsuario(id);
    }
     */
}