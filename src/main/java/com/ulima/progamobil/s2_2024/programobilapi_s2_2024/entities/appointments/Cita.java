package com.ulima.progamobil.s2_2024.programobilapi_s2_2024.entities.appointments;

import com.ulima.progamobil.s2_2024.programobilapi_s2_2024.entities.users.PerfilPaciente;
import com.ulima.progamobil.s2_2024.programobilapi_s2_2024.entities.users.ProfesionalSalud;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(
    name = "citas"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cita {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @NotBlank(
      message = "El motivo de la cita no puede estar vacio"
  )
  @Column(nullable = false)
  private String motivo;

  private LocalDateTime fechaCita;

  @ManyToOne
  @JoinColumn(
      name = "perfil_paciente_id",
      referencedColumnName = "usuario_id",
      nullable = false
  )
  private PerfilPaciente perfilPaciente;

  @ManyToOne
  @JoinColumn(
      name = "profesional_salud_id",
      referencedColumnName = "usuario_id",
      nullable = false
  )
  private ProfesionalSalud profesionalSalud;

  @Column(nullable = false)
  private boolean isConfirmed;
}
