package com.ulima.progamobil.s2_2024.programobilapi_s2_2024.entities.medical;

import com.ulima.progamobil.s2_2024.programobilapi_s2_2024.entities.medical.DatosMedicos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "registro_medico")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class RegistroMedico {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "registro_medico_id", updatable = false, nullable = false)
  private UUID id;

  @Column(nullable = false)
  private String descripcion;

  @Column(nullable = false)
  private LocalDateTime fechaRegistro;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "datos_medicos_id", nullable = false)
  private DatosMedicos datosMedicos;
}
