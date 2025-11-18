package com.example.cita.reportes;

import com.example.cita.modelo.Cita;
import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "ReporteCitas")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReporteXML {
    
    @XmlElementWrapper(name = "citas")
    @XmlElement(name = "cita")
    private List<Cita> citas;

    public ReporteXML() {
    }

    public ReporteXML(List<Cita> citas) {
        this.citas = citas;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }
}
