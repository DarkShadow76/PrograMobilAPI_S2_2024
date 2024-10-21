package com.ulima.progamobil.s2_2024.programobilapi_s2_2024.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(
    name = "esquema_vacunacion"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class EsquemaVacunacion {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(
      name = "esquema_id",
      updatable = false,
      nullable = false
  )
  private UUID esquemaId;

  @Column(
      nullable = false
  )
  private LocalDate fechaInicio;

  @Column(
      nullable = false
  )
  private LocalDate fechaFin;

  @ManyToMany
  @JoinTable(
      name = "esquema_vacunas",
      joinColumns = @JoinColumn(name = "esquema_id"),
      inverseJoinColumns = @JoinColumn(name = "vacuna_id")
  )
  private Set<Vacuna> vacunas = new HashSet<>();

  @ManyToOne(
      fetch = FetchType.LAZY
  )
  @JoinColumn(
      name = "perfil_id",
      nullable = false
  )
  private PerfilPaciente perfilPaciente;
}
