package com.redesemente.rede_semente.repository

import com.redesemente.rede_semente.model.Proposta
import org.springframework.data.jpa.repository.JpaRepository

interface PropostaRepository : JpaRepository<Proposta, Long>