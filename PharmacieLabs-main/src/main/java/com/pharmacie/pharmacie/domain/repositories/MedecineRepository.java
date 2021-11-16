package com.pharmacie.pharmacie.domain.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.pharmacie.pharmacie.domain.entities.medecine;

public interface MedecineRepository extends JpaRepository<medecine, Long>{

	medecine findByName(String name);
}
