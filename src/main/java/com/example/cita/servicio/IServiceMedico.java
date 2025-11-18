package com.example.cita.servicio;

import com.example.cita.modelo.Medico;

import java.util.List;

public interface IServiceMedico {
    public List<Medico> getList();
    public Medico save(Medico medico);
    public Medico findById(int id);
    public void deleteById(int id);
}
