package com.example.Agroromero.Repositorios;

import com.example.Agroromero.Entidades.UsuariosAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioUsuariosAuth extends JpaRepository<UsuariosAuth,Long> {
    UsuariosAuth findByEmail(String email);
}
