package com.algaworks.awpag.awpagapi.domain.repositoriy;

import com.algaworks.awpag.awpagapi.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClientRepository extends JpaRepository<Client,Long> {

    List<Client> findByName(String name);
    List<Client> findByNameContaining(String nome);
}
