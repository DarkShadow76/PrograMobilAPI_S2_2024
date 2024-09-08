package com.ulima.progamobil.s2_2024.programobilapi_s2_2024.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Usuario {
  @Id
  @GeneratedValue(
      strategy = GenerationType.AUTO
  )
  @Column(
      updatable = false,
      nullable = false
  )
  private UUID usuario_id;

  @NotBlank
  @Column(
      unique = true,
      nullable = false
  )
  private String email;

  @NotBlank
  @JsonProperty(
      access = JsonProperty.Access.WRITE_ONLY
  )
  @Column(
      nullable = false
  )
  private String contrasenia;

  // Relacion 1 a 1
  @OneToOne(
      mappedBy = "usuario",
      cascade = CascadeType.ALL,
      fetch = FetchType.LAZY
  )
  private Padre padre;

  @CreationTimestamp
  private LocalDateTime created_at;

  @UpdateTimestamp
  private LocalDateTime updated_at;
}
