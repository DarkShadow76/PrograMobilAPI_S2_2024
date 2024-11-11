package com.ulima.progamobil.s2_2024.programobilapi_s2_2024.entities.users;

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
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(
    name = "usuarios"
)
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

  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(
      name = "usuario_roles",
      joinColumns = @JoinColumn(name = "usuario_id"),
      inverseJoinColumns = @JoinColumn(name = "rol_id")
  )
  private Set<Rol> roles = new HashSet<>();

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
