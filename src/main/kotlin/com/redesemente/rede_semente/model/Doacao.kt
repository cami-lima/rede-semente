package com.redesemente.rede_semente.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime

@Entity
class Doacao(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @ManyToOne
    var proposta: Proposta? = null,

    @ManyToOne
    var apoiador: Usuario? = null,

    var valor: Double = 0.0,

    var dataDoacao: LocalDateTime = LocalDateTime.now()

)