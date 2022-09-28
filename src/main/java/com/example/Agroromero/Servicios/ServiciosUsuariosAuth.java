package com.example.Agroromero.Servicios;

import com.example.Agroromero.Entidades.UsuariosAuth;
import com.example.Agroromero.Repositorios.RepositorioUsuariosAuth;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ServiciosUsuariosAuth {
    private RepositorioUsuariosAuth repositorioUsuariosAuth;

    //Constructor

    public ServiciosUsuariosAuth(RepositorioUsuariosAuth repositorioUsuariosAuth) {
        this.repositorioUsuariosAuth = repositorioUsuariosAuth;
    }

    public RepositorioUsuariosAuth getRepositorioUsuariosAuth() {
        return repositorioUsuariosAuth;
    }

    public void setRepositorioUsuariosAuth(RepositorioUsuariosAuth repositorioUsuariosAuth) {
        this.repositorioUsuariosAuth = repositorioUsuariosAuth;
    }
//Metodos funcionales

    //funcion que busca el usuario
    public UsuariosAuth buscarPorEmail(String email){
        return this.repositorioUsuariosAuth.findByEmail(email);
    }
    // funcion que guarda el usuario

    public UsuariosAuth crearUsuario(UsuariosAuth newUsuario){
        return this.repositorioUsuariosAuth.save(newUsuario);
    }

    public UsuariosAuth getOrCreateUsuarios(Map<String, Object> DatosUsuario){
        String email = (String) DatosUsuario.get("email");
        UsuariosAuth usuario = buscarPorEmail(email);
        //valdacion usuario
        if(usuario == null){
            String alias = (String) DatosUsuario.get("nickname");
            String imagen = (String) DatosUsuario.get("picture");
            String Auth0Id = (String) DatosUsuario.get("sub");

            UsuariosAuth newUsuario = new UsuariosAuth(email=email,imagen=imagen, Auth0Id=Auth0Id);
            return crearUsuario(newUsuario);
        }
        System.out.println(usuario.getEmail());
        return usuario;
    }
}
