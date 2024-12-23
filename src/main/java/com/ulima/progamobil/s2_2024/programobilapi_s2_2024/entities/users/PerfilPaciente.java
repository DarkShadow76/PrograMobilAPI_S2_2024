package com.ulima.progamobil.s2_2024.programobilapi_s2_2024.entities.users;

import com.ulima.progamobil.s2_2024.programobilapi_s2_2024.entities.appointments.Cita;
import com.ulima.progamobil.s2_2024.programobilapi_s2_2024.entities.medical.DatosMedicos;
import com.ulima.progamobil.s2_2024.programobilapi_s2_2024.entities.vaccination.CitaVacunacion;
import com.ulima.progamobil.s2_2024.programobilapi_s2_2024.entities.vaccination.EsquemaVacunacion;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "perfil_paciente")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class PerfilPaciente {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "perfil_id",
      updatable = false,
      nullable = false
  )
  private UUID perfilId;

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

  @Column(
      nullable = false
  )
  private LocalDate fechaNacimiento;

  // Relación ManyToOne con Padre
  @ManyToOne(
      fetch = FetchType.LAZY
  )
  @JoinColumn(
      name = "padre_id",
      nullable = false
  )
  private Padre padre;

  // Relación OneToOne con Usuario
  @OneToOne
  @JoinColumn(
      name = "usuario_id",
      referencedColumnName = "usuario_id",
      nullable = false
  )
  private Usuario usuario;

  // Otras relaciones
  @OneToMany(
      mappedBy = "perfilPaciente",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  private List<EsquemaVacunacion> esquemasVacunacion = new ArrayList<>();

  @OneToOne(
      mappedBy = "perfilPaciente",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  private DatosMedicos datosMedicos;

  @OneToMany(
      mappedBy = "perfilPaciente",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  private List<Cita> citas = new ArrayList<>();

  @OneToMany(
      mappedBy = "perfilPaciente",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  private List<CitaVacunacion> citaVacunacion = new ArrayList<>();
}