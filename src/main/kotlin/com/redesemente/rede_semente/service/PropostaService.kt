package com.redesemente.rede_semente.service

import com.redesemente.rede_semente.model.Doacao
import com.redesemente.rede_semente.model.Proposta
import com.redesemente.rede_semente.model.StatusProposta
import com.redesemente.rede_semente.model.Usuario
import com.redesemente.rede_semente.model.Voto
import com.redesemente.rede_semente.repository.DoacaoRepository
import com.redesemente.rede_semente.repository.PropostaRepository
import com.redesemente.rede_semente.repository.VotoRepository
import org.springframework.stereotype.Service

@Service
class PropostaService(
    private val propostaRepository: PropostaRepository,
    private val votoRepository: VotoRepository,
    private val doacaoRepository: DoacaoRepository
) {

    fun cadastrar(proposta: Proposta): Proposta {
        return propostaRepository.save(proposta)
    }

    fun listarTodas(): List<Proposta> {
        return propostaRepository.findAll()
    }

    fun registrarVoto(propostaId: Long, usuario: Usuario) {
        val proposta = propostaRepository.findById(propostaId).orElseThrow()

        val voto = Voto(proposta = proposta, usuario = usuario)
        votoRepository.save(voto)

        val totalVotos = votoRepository.count()

        if (totalVotos >= 5 && proposta.status == StatusProposta.INICIADA) {
            proposta.status = StatusProposta.AGUARDANDO
            propostaRepository.save(proposta)
        }
    }

    fun registrarDoacao(propostaId: Long, apoiador: Usuario, valor: Double) {
        val proposta = propostaRepository.findById(propostaId).orElseThrow()

        val doacao = Doacao(proposta = proposta, apoiador = apoiador, valor = valor)
        doacaoRepository.save(doacao)

        proposta.valorArrecadado += valor

        if (proposta.valorArrecadado >= proposta.valorEstimado && proposta.status == StatusProposta.AGUARDANDO) {
            proposta.status = StatusProposta.APROVADA
        }

        propostaRepository.save(proposta)
    }
}