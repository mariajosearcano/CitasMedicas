package com.example.cita.servicio;

import com.example.cita.modelo.Cita;
import com.example.cita.modelo.Paciente;
import com.example.cita.repositorio.CitaRepositorio;
import com.example.cita.repositorio.PacienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService implements IServicePaciente{


    @Autowired
    PacienteRepositorio pacienteRepositorio;

    @Autowired
    CitaService citaService;


    @Override
    public List<Paciente> getList() {
        return pacienteRepositorio.findAll();
    }

    @Override
    public Paciente save(Paciente paciente) {
        return pacienteRepositorio.save(paciente);
    }

    @Override
    public Paciente findById(int id) {
        return pacienteRepositorio.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        Paciente paciente = findById(id);
        var citas = citaService.citaRepositorio.findByPaciente_idPaciente(id);
        if ( !citas.isEmpty() ) citaService.deleteByPaciente(id);
        if (paciente != null) pacienteRepositorio.deleteById(id);
    }

    public Page<Paciente> getList(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        var lista = pacienteRepositorio.findAll(pageable);
        return lista;
    }
}
