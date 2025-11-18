package com.example.cita.controlador;

import com.example.cita.modelo.Medico;
import com.example.cita.servicio.MedicoService;
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
public class MedicoController {

    @Autowired
    MedicoService medicoService;


    @GetMapping("/medico")
    public Page<Medico> getList(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        return medicoService.getList(page, size);
    }

    @GetMapping("/medicos")
    public List<Medico> getList(){
        return medicoService.getList();
    }

    @GetMapping(value = "/getMedicoById/{idMedico}")
    public Medico getMedicoById(@PathVariable int idMedico){
        Medico medico = medicoService.findById(idMedico);

        return medico;
    }

    @PostMapping("/saveMedico")
    public Medico saveMedico(@RequestBody Medico medico){
        return medicoService.save(medico);
    }


    @DeleteMapping("/deleteMedico/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteMedico(@PathVariable int id){
        Medico medico = medicoService.findById(id);
        if (medico == null) return ResponseEntity.notFound().build();
        this.medicoService.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Eliminado", true);
        return ResponseEntity.ok(response);
    }
    @PutMapping("/editarMedico/{id}")
    public ResponseEntity<Medico> editarMedico(
            @PathVariable int id,
            @RequestBody Medico medicoRecibido){
        Medico medico = this.medicoService.findById(id);
        if (medico == null) return ResponseEntity.notFound().build();
        else {

            medico.setApellidos(medicoRecibido.getApellidos());
            medico.setNombres(medicoRecibido.getNombres());
            medico.setEspecialidad(medicoRecibido.getEspecialidad());
            this.medicoService.save(medico);
            return ResponseEntity.ok(medico);
        }

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
