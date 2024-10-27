package com.ulima.progamobil.s2_2024.programobilapi_s2_2024.entities.vaccination;

import com.ulima.progamobil.s2_2024.programobilapi_s2_2024.entities.vaccination.EsquemaVacunacion;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(
    name = "vacunas"
)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Vacuna {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(
      name = "vacuna_id",
      updatable = false,
      nullable = false
  )
  private UUID vacunaId;

  @NotBlank
  @Column(
      nullable = false
  )
  private String nombre;

  @NotBlank
  @Column(
      nullable = false
  )
  private String fabricante;

  @ManyToMany(
      mappedBy = "vacunas"
  )
  private Set<EsquemaVacunacion> esquema = new HashSet<>();
}
