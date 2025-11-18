package com.example.cita.controlador;

import com.example.cita.modelo.Paciente;
import com.example.cita.servicio.CitaService;
import com.example.cita.servicio.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("app")
@CrossOrigin(value = "http://localhost:4200")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @Autowired
    CitaService citaService;

    @GetMapping("/pacientes")
    public List<Paciente> getList(){
        var lista = pacienteService.getList();

        return lista;
    }
    @GetMapping("/paciente/{idPaciente}")
    public Paciente getPacienteById(@PathVariable int idPaciente){
        var paciente = this.pacienteService.findById(idPaciente);

        return paciente;
    }


    @GetMapping("/paciente")
    public Page<Paciente> getList(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "0") int size
    ){
        return pacienteService.getList(page, size);
    }

    @PostMapping("/savePaciente")
    public Paciente savePaciente(@RequestBody Paciente paciente){
        return pacienteService.save(paciente);
    }


    @DeleteMapping("/deletePaciente/{idPaciente}")
    public ResponseEntity<Map<String, Boolean>> deletePaciente(@PathVariable int idPaciente){
        Paciente paciente = pacienteService.findById(idPaciente);
        if (paciente == null) return ResponseEntity.notFound().build();

        this.pacienteService.deleteById(idPaciente);

        Map<String, Boolean> response = new HashMap<>();
        response.put("Eliminado", true);
        return ResponseEntity.ok(response);
    }
    @PutMapping("/editarPaciente/{id}")
    public ResponseEntity<Paciente> editarPaciente(
            @PathVariable int id,
            @RequestBody Paciente pacienteRecibido){
        Paciente paciente = this.pacienteService.findById(id);
        if (paciente == null) return ResponseEntity.notFound().build();
        else {

            paciente.setApellidos(pacienteRecibido.getApellidos());
            paciente.setNombres(pacienteRecibido.getNombres());
            paciente.setEmail(pacienteRecibido.getEmail());
            paciente.setFechaNacimiento(pacienteRecibido.getFechaNacimiento());
            this.pacienteService.save(paciente);
            return ResponseEntity.ok(paciente);
        }

    }

}
