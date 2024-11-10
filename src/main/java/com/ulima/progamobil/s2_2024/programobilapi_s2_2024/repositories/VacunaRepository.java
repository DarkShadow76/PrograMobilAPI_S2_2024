package com.ulima.progamobil.s2_2024.programobilapi_s2_2024.repositories;

import com.ulima.progamobil.s2_2024.programobilapi_s2_2024.entities.vaccination.Vacuna;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.UUID;

@CrossOrigin(origins = "http://localhost:5173/api")
@RepositoryRestResource(path = "vacunas")
public interface VacunaRepository extends CrudRepository<Vacuna, UUID> {

}
