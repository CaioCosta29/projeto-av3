package com.example.denunciasja.repository;

import com.example.denunciasja.model.Denuncia;
import com.example.denunciasja.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DenunciaRepository extends JpaRepository<Denuncia, Integer> {
    List<Denuncia> findAllByUsuario(Usuario usuario);
}
