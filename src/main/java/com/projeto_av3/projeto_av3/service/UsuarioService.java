package com.projeto_av3.projeto_av3.service;

import com.projeto_av3.projeto_av3.model.Usuario;
import com.projeto_av3.projeto_av3.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void salvarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
}
