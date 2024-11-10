package com.ulima.progamobil.s2_2024.programobilapi_s2_2024.repositories;

import com.ulima.progamobil.s2_2024.programobilapi_s2_2024.entities.users.PerfilPaciente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.UUID;

@CrossOrigin(origins = "htt://localhost:5173/api")
@RepositoryRestResource(path = "perfil-pacientes")
public interface PerfilPacienteRepository extends CrudRepository<PerfilPaciente, UUID> {

}