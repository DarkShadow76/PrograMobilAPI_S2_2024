package com.ulima.progamobil.s2_2024.programobilapi_s2_2024.entities.medical;

import com.ulima.progamobil.s2_2024.programobilapi_s2_2024.entities.users.PerfilPaciente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(
    name = "datos_medicos"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class DatosMedicos {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(
      name = "datos_medicos_id",
      updatable = false,
      nullable = false
  )
  private UUID id;

  @Column(
      nullable = false
  )
  private String alergias;

  @Column(
      nullable = false
  )
  private String enfermedadesPreexistentes;

  @OneToOne
  @JoinColumn(
      name = "perfil_id",
      referencedColumnName = "perfil_id",
      nullable = false
  )
  private PerfilPaciente perfilPaciente;

  @OneToMany(
      mappedBy = "datosMedicos",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  private List<RegistroMedico> registroMedicos = new ArrayList<>();
}