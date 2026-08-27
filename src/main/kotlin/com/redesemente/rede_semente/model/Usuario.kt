package com.redesemente.rede_semente.model

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var nome: String = ""
    var email: String = ""
    var cpf: String = ""

    @Enumerated(EnumType.STRING)
    var tipoUsuario: TipoUsuario = TipoUsuario.APOIADOR
}