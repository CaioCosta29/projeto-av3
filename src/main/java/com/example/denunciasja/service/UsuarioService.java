package com.example.denunciasja.service;

import com.example.denunciasja.model.Usuario;
import com.example.denunciasja.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;


    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void salvarUsuario(Usuario usuario) {
        String senhaCriptografada = passwordEncoder.encode((usuario.getSenha()));
        usuario.setSenha(senhaCriptografada);
        usuarioRepository.save(usuario);
    }

    public Usuario carregarUsuarioPeloEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public boolean verificarSenha(String senhaDigitada, String senhaCriptografada) {
        return passwordEncoder.matches(senhaDigitada, senhaCriptografada);
    }
}
