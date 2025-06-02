package com.example.denunciasja.service;

import com.example.denunciasja.model.Denuncia;
import com.example.denunciasja.model.Usuario;
import com.example.denunciasja.repository.DenunciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DenunciaService {
    private final DenunciaRepository denunciaRepository;

    public DenunciaService(DenunciaRepository denunciaRepository) {
        this.denunciaRepository = denunciaRepository;
    }

    public void salvarDenuncia(Denuncia denuncia) {
        denunciaRepository.save((denuncia));
    }

    public List<Denuncia> listarPorUsuario(Usuario usuario) {
        return denunciaRepository.findAllByUsuario(usuario);
    }
}
