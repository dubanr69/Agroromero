package com.example.Agroromero.Repositorios;
        import com.example.Agroromero.Entidades.Empleado;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;
@Repository
public interface RepositorioUsuario extends JpaRepository<Empleado, Long> {
}