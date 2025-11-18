package com.example.cita.modelo;

import com.example.cita.Adapter.LocalDateAdapter;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "paciente")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@XmlRootElement(name = "paciente")
@XmlAccessorType(XmlAccessType.FIELD)
public class Paciente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    @XmlElement(name = "idPaciente")
    public int idPaciente;
    
    @Column(name = "nombres", length = 100)
    @XmlElement(name = "nombres")
    public String nombres;
    
    @Column(name = "apellidos", length = 100)
    @XmlElement(name = "apellidos")
    public String apellidos;
    
    @Column(name = "email", length = 150)
    @XmlElement(name = "email")
    public String email;
    
    @Column(name = "fecha_nacimiento")
    @XmlElement(name = "fechaNacimiento")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate fechaNacimiento;
}