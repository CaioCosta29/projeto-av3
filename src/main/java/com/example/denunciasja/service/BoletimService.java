package com.example.denunciasja.service;

import com.example.denunciasja.model.Boletim;
import com.example.denunciasja.model.Usuario;
import com.example.denunciasja.repository.BoletimRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoletimService {
    private final BoletimRepository boletimRepository;

    public BoletimService(BoletimRepository boletimRepository) {
        this.boletimRepository = boletimRepository;
    }

    public void salvarBoletim(Boletim boletim) {
        boletimRepository.save(boletim);
    }

    public List<Boletim> listarPorUsuario(Usuario usuario) {
        return boletimRepository.findAllByUsuario(usuario);
    }
}
