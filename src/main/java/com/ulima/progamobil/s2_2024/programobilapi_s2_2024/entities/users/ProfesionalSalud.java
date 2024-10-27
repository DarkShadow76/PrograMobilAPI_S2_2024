package com.ulima.progamobil.s2_2024.programobilapi_s2_2024.entities.users;

import com.ulima.progamobil.s2_2024.programobilapi_s2_2024.entities.appointments.Cita;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "profesionales_salud")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@AttributeOverride(
    name = "usuario_id",
    column = @Column(
        name = "profesional_salud_id",
        updatable = false,
        nullable = false
    )
)
public class ProfesionalSalud extends Usuario{
    @Column(
        nullable = false
    )
    private String nombre;

    @Column(
        nullable = false
    )
    private String apellido;

    @NotBlank
    @Column(
        nullable = false
    )
    private String especialidad;

    @OneToMany(
        mappedBy = "profesionalSalud",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Cita> citas = new ArrayList<>();
}
