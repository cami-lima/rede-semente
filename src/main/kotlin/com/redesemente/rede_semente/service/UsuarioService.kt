package com.redesemente.rede_semente.service

import com.redesemente.rede_semente.model.Usuario
import com.redesemente.rede_semente.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    private val usuarioRepository: UsuarioRepository
) {

    fun cadastrar(usuario: Usuario): Usuario {
        return usuarioRepository.save(usuario)
    }

    fun listarTodos(): List<Usuario> {
        return usuarioRepository.findAll()
    }
}