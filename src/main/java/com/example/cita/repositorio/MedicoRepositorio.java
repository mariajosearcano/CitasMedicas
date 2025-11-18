package com.example.cita.repositorio;

import com.example.cita.modelo.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepositorio extends JpaRepository<Medico, Integer> {
}
