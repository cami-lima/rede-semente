package com.redesemente.rede_semente.repository

import com.redesemente.rede_semente.model.Doacao
import org.springframework.data.jpa.repository.JpaRepository

interface DoacaoRepository : JpaRepository<Doacao, Long>