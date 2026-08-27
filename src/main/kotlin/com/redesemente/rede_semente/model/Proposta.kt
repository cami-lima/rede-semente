package com.redesemente.rede_semente.model

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

@Entity
class Proposta(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var titulo: String = "",

    var descricao: String = "",

    var valorEstimado: Double = 0.0,

    var valorArrecadado: Double = 0.0,

    @Enumerated(EnumType.STRING)
    var status: StatusProposta = StatusProposta.INICIADA,

    @ManyToOne
    var microempreendedora: Usuario? = null,

    var linkComprovanteCompra: String? = null,

    var fotoEntrega: String? = null

)