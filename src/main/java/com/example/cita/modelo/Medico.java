package com.example.cita.modelo;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import lombok.*;

@Entity
@Table(name = "medico")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@XmlRootElement(name = "medico")
@XmlAccessorType(XmlAccessType.FIELD)
public class Medico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medico")
    @XmlElement(name = "idMedico")
    public int idMedico;
    
    @Column(name = "nombres", length = 100)
    @XmlElement(name = "nombres")
    public String nombres;
    
    @Column(name = "apellidos", length = 100)
    @XmlElement(name = "apellidos")
    public String apellidos;
    
    @Column(name = "especialidad", length = 100)
    @XmlElement(name = "especialidad")
    public String especialidad;
}