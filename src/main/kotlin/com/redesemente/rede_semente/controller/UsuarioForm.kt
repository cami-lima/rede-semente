package com.redesemente.rede_semente.controller

import com.redesemente.rede_semente.model.TipoUsuario

class UsuarioForm(
    var nome: String = "",
    var cpf: String = "",
    var email: String = "",
    var tipo: TipoUsuario = TipoUsuario.APOIADOR
)