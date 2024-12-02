package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Agendamento;
import com.example.demo.repositories.AgendamentoRepository;

@Service
public class AgendamentoService {
	
	private final AgendamentoRepository agendamentoRepository;
	
	@Autowired
	public AgendamentoService (AgendamentoRepository agendamentoRepository) {
		this.agendamentoRepository = agendamentoRepository;
	}
	
	public Agendamento salvarAgendamento (Agendamento agendamento) {
		return agendamentoRepository.save(agendamento);
	}
	
	public Agendamento buscarPorId (Long id) {
		return agendamentoRepository.findById(id).orElse(null);
	}
	
	public List<Agendamento> listarAgendamentos() {
		return agendamentoRepository.findAll();
	}
	
	public void deletarAgendamento (Long id) {
		agendamentoRepository.deleteById(id);
	}
	
	public Agendamento atualizarAgendamento (Long id, Agendamento agendamentoAtualizado) {
		Optional<Agendamento> agendamentoExistente= agendamentoRepository.findById(id);
		if(agendamentoExistente.isPresent()) {
			Agendamento agendamento = agendamentoExistente.get();
			agendamento.setDatahora(agendamentoAtualizado.getDatahora());
			agendamento.setStatus(agendamentoAtualizado.getStatus());
			agendamento.setPet(agendamentoAtualizado.getPet());
			return agendamentoRepository.save(agendamento);
		} else {
			return null;
		}
	}
}
