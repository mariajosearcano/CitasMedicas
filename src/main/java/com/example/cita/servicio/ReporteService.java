package com.example.cita.servicio;

import com.example.cita.modelo.Cita;
import com.example.cita.reportes.ReporteXML;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.StringWriter;
import java.util.List;

@Service
public class ReporteService {
    
    @Autowired
    CitaService citaService;

    public String getXml() {
        try {
            List<Cita> citas = citaService.getList();
            
            if (citas == null || citas.isEmpty()) {
                return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ReporteXML>\n  <citas/>\n</ReporteXML>";
            }

            ReporteXML reporteXML = new ReporteXML();
            reporteXML.setCitas(citas);

            JAXBContext context = JAXBContext.newInstance(ReporteXML.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

            StringWriter writer = new StringWriter();
            marshaller.marshal(reporteXML, writer);

            return writer.toString();

        } catch (JAXBException e) {
            e.printStackTrace();
            throw new RuntimeException("Error generando XML: " + e.getMessage(), e);
        }
    }
}