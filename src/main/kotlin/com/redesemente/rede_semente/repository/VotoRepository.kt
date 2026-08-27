package com.redesemente.rede_semente.repository

import com.redesemente.rede_semente.model.Voto
import org.springframework.data.jpa.repository.JpaRepository

interface VotoRepository : JpaRepository<Voto, Long>