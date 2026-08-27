package com.redesemente.rede_semente.controller

import com.redesemente.rede_semente.model.Usuario
import com.redesemente.rede_semente.service.UsuarioService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class UsuarioController(
    private val usuarioService: UsuarioService
) {

    @GetMapping("/usuarios")
    fun listar(model: Model): String {
        model.addAttribute("usuarios", usuarioService.listarTodos())
        return "usuarios"
    }

    @GetMapping("/usuarios/novo")
    fun formularioNovo(model: Model): String {
        model.addAttribute("usuario", UsuarioForm())
        return "usuario-form"
    }

    @PostMapping("/usuarios")
    fun cadastrar(@ModelAttribute usuarioForm: UsuarioForm): String {
        val usuario = Usuario(
            nome = usuarioForm.nome,
            cpf = usuarioForm.cpf,
            email = usuarioForm.email,
            tipo = usuarioForm.tipo
        )
        usuarioService.cadastrar(usuario)
        return "redirect:/usuarios"
    }
}