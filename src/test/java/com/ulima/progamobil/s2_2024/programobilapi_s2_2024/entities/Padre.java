package com.ulima.progamobil.s2_2024.programobilapi_s2_2024.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@Table(name = "padres")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@AttributeOverride(
    name = "usuario_id",
    column = @Column(
        name = "padre_id"
    )
)
public class Padre extends Usuario{
  @Column(
      nullable = false
  )
  private String nombre;

  @Column(
      nullable = false
  )
  private String apellido;

  @Column(
      unique = true,
      nullable = false
  )
  private String dni;

  @Column(
      nullable = false
  )
  private LocalDate fecha_nacimiento;

  @OneToOne
  @JoinColumn(
      name = "usuario_id",
      referencedColumnName = "usuario_id"
  )
  private Usuario usuario;
}
