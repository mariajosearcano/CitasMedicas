package com.example.cita.repositorio;

import com.example.cita.modelo.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepositorio extends JpaRepository<Paciente, Integer> {
}
