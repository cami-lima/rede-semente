package com.redesemente.rede_semente.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime

@Entity
class Voto(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @ManyToOne
    var proposta: Proposta? = null,

    @ManyToOne
    var usuario: Usuario? = null,

    var dataVoto: LocalDateTime = LocalDateTime.now()

)