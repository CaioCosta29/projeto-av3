package com.projeto_av3.projeto_av3.repository;

import com.projeto_av3.projeto_av3.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
