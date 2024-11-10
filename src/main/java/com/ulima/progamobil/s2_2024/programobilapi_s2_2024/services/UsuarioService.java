package com.ulima.progamobil.s2_2024.programobilapi_s2_2024.services;

import com.ulima.progamobil.s2_2024.programobilapi_s2_2024.entities.users.Usuario;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsuarioService {
  List<Usuario> findAll();

  Optional<Usuario> findById(UUID id);

  Usuario save(Usuario usuario);

  Optional<Usuario> update (UUID id, Usuario usuario);

  Optional<Usuario> delete(UUID id);
}
