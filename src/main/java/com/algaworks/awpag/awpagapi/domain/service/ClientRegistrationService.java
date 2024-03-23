package com.algaworks.awpag.awpagapi.domain.service;

import com.algaworks.awpag.awpagapi.domain.exception.BusinessException;
import com.algaworks.awpag.awpagapi.domain.model.Client;
import com.algaworks.awpag.awpagapi.domain.repositoriy.IClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class ClientRegistrationService {
    private final IClientRepository clientRepository;

    @Transactional
    public Client save(Client client) {
        boolean emailInUse = clientRepository.findByEmail(client.getEmail())
                .filter(c-> !c.equals(client))
                .isPresent();

        if (emailInUse) {
            throw new BusinessException("Email already exists");
        }

        return clientRepository.save(client);
    }

    @Transactional
    public void delete(Long clientId) {
        clientRepository.deleteById(clientId);
    }
}
