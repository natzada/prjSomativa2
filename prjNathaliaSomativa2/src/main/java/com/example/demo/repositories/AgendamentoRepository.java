package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}
