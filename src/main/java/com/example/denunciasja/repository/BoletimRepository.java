package com.example.denunciasja.repository;

import com.example.denunciasja.model.Boletim;
import com.example.denunciasja.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoletimRepository extends JpaRepository<Boletim, Integer> {
    List<Boletim> findAllByUsuario(Usuario usuario);
}
