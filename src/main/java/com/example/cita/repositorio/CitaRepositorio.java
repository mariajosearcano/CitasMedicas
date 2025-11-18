package com.example.cita.repositorio;

import com.example.cita.modelo.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CitaRepositorio extends JpaRepository<Cita, Integer> {

    //void deleteByPaciente_idPaciente(int id_paciente);
    List<Cita> findByPaciente_idPaciente(int idPaciente);
    List<Cita> findByMedico_idMedico(int idMedcio);
}
