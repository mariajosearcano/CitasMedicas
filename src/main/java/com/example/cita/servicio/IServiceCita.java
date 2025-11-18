package com.example.cita.servicio;

import com.example.cita.modelo.Cita;

import java.util.List;

public interface IServiceCita {
    public List<Cita> getList();
    public Cita save(Cita cita);
    public Cita findById(int id);
    public void deleteById(int id);
}
