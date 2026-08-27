package com.redesemente.rede_semente.model

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Usuario(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var nome: String = "",

    var cpf: String = "",

    var email: String = "",

    @Enumerated(EnumType.STRING)
    var tipo: TipoUsuario = TipoUsuario.APOIADOR

)