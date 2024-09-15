package com.ulima.progamobil.s2_2024.programobilapi_s2_2024.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
@Table(
    name = "usuarios"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class Usuario {
  @Id
  @GeneratedValue(
      strategy = GenerationType.AUTO
  )
  @Column(
      name = "usuario_id",
      updatable = false,
      nullable = false
  )
  private UUID usuario_id;

  @NotBlank
  @Email
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

  /*
  Incluir Roles para los usuarios: Many to Many
  admin
  padre
  profesional_salud
  */

  private boolean enabled;

  @Transient
  private boolean admin;

  @CreationTimestamp
  private LocalDateTime created_at;

  @UpdateTimestamp
  private LocalDateTime updated_at;

  @PrePersist
  public void prePersist(){
    enabled=true;
  }
}
