package com.redesemente.rede_semente.repository

import com.redesemente.rede_semente.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository : JpaRepository<Usuario, Long>