package com.ulima.progamobil.s2_2024.programobilapi_s2_2024.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Padre {
  @Id
  @GeneratedValue(
      strategy = GenerationType.AUTO
  )
  @Column(
      updatable = false,
      nullable = false
  )
  private UUID id_padre;

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

  @CreationTimestamp
  private LocalDateTime created_at;

  @UpdateTimestamp
  private LocalDateTime updated_at;
}
