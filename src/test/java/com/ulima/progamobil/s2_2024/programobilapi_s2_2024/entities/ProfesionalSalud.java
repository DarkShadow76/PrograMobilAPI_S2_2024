package com.ulima.progamobil.s2_2024.programobilapi_s2_2024.entities;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

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
public class profesional_salud extends Usuario{
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
}
