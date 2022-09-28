package com.example.Agroromero.Repositorios;

import com.example.Agroromero.Entidades.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEmpresa extends JpaRepository<Empresa,Long> {
}
