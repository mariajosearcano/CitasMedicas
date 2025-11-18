package com.example.cita.controlador;

import com.example.cita.modelo.Cita;
import com.example.cita.servicio.CitaService;
import com.example.cita.servicio.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("app")
@CrossOrigin(value = "http://localhost:4200")
public class CitaController {

    @Autowired
    CitaService citaService;

    @Autowired
    ReporteService reporteService;
    
    @GetMapping("/cita")
    public Page<Cita> getList(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "0") int size
    ){
        return citaService.getList(page, size);
    }

    @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> getReportXML(){
        try {
            String xml = reporteService.getXml();
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=ReporteCitas.xml")
                    .header(HttpHeaders.CONTENT_TYPE, "application/xml; charset=UTF-8")
                    .body(xml);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError()
                    .body("<error>Error generando el reporte: " + e.getMessage() + "</error>");
        }
    }

    @PostMapping(value = "/cita/save")
    public Cita saveCita(@RequestBody Cita cita) {
        return citaService.save(cita);
    }

    @GetMapping("/cita/{idCita}")
    public Cita getCitaById(@PathVariable int idCita){
        var cita = this.citaService.findById(idCita);
        return cita;
    }

    @PutMapping("/updateCita/{id}")
    public ResponseEntity<Cita> editarCita(
            @PathVariable int id,
            @RequestBody Cita citaRecibida){
        Cita cita = this.citaService.findById(id);
        if (cita == null) return ResponseEntity.notFound().build();
        else {
            cita.setFechaCita(citaRecibida.getFechaCita());
            this.citaService.save(cita);
            return ResponseEntity.ok(cita);
        }
    }
    
    @DeleteMapping("/deleteCita/{idCita}")
    public ResponseEntity<Map<String, Boolean>> deletePaciente(@PathVariable int idCita){
        Cita cita = citaService.findById(idCita);
        if (cita == null) return ResponseEntity.notFound().build();

        this.citaService.deleteById(idCita);

        Map<String, Boolean> response = new HashMap<>();
        response.put("Eliminado", true);
        return ResponseEntity.ok(response);
    }
}