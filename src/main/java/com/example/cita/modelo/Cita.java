package com.example.cita.modelo;

import com.example.cita.Adapter.LocalDateAdapter;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "cita")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@XmlRootElement(name = "cita")
@XmlAccessorType(XmlAccessType.FIELD)
public class Cita {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    @XmlElement(name = "idCita")
    private int idCita;
    
    @Column(name = "fecha_cita")
    @XmlElement(name = "fechaCita")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate fechaCita;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_id_medico", referencedColumnName = "id_medico")
    @XmlElement(name = "medico")
    private Medico medico;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_id_paciente", referencedColumnName = "id_paciente")
    @XmlElement(name = "paciente")
    private Paciente paciente;
}