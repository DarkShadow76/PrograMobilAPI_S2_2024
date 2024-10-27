package com.ulima.progamobil.s2_2024.programobilapi_s2_2024.entities.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(
    name = "roles"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rol {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(unique = true, nullable = false)
  @NotBlank(message = "El nombre de rol no puede esta vacio")
  private String name;

  @JsonIgnoreProperties({"roles", "handler", "hibernateLazyInitializer"})
  @ManyToMany(mappedBy = "roles")
  private List<Usuario> users = new ArrayList<>();

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Rol role = (Rol) o;
    return Objects.equals(id, role.id) && Objects.equals(name, role.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }
}
