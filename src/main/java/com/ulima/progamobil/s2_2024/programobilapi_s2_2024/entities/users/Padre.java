package com.ulima.progamobil.s2_2024.programobilapi_s2_2024.entities.users;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Padre extends Usuario{
  @NotBlank
  @Column(
      nullable = false
  )
  private String nombre;

  @NotBlank
  @Column(
      nullable = false
  )
  private String apellido;

  @NotBlank
  @Column(
      unique = true,
      nullable = false
  )
  private String dni;

  @Column(
      nullable = false
  )
  private LocalDate fecha_nacimiento;

  @OneToMany(
      mappedBy = "padre",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  private List<PerfilPaciente> perfilPacientes =  new ArrayList<>();
}
