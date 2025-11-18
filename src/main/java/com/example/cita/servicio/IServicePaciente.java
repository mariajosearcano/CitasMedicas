package com.example.cita.servicio;

import com.example.cita.modelo.Paciente;

import java.util.List;

public interface IServicePaciente {
    public List<Paciente> getList();
    public Paciente save(Paciente paciente);
    public Paciente findById(int id);
    public void deleteById(int id);
}
