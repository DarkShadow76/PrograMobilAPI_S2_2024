package com.ulima.progamobil.s2_2024.programobilapi_s2_2024.entities.vaccination;

import com.ulima.progamobil.s2_2024.programobilapi_s2_2024.entities.users.PerfilPaciente;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "citas_vacunacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CitaVacunacion {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private UUID id;

  @NotNull
  @Column(
      name = "fecha_citra",
      nullable = false
  )
  private LocalDate fechaCita;

  @NotBlank
  @Column(
      name = "nombre_clinica",
      nullable = false
  )
  private String nombreClinica;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      name = "perfil_paciente_id",
      nullable = false
  )
  private PerfilPaciente perfilPaciente;

  @Column(
      name = "created_at",
      nullable = false,
      updatable = false
  )
  private LocalDate createdAt = LocalDate.now();

  @Column(
      name = "updated_at"
  )
  private LocalDate updatedAt;
}
