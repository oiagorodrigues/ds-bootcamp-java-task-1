package dev.iagorodrigues.clientapi.services;

import dev.iagorodrigues.clientapi.dto.ClientDTO;
import dev.iagorodrigues.clientapi.entities.Client;
import dev.iagorodrigues.clientapi.exceptions.ResourceNotFoundException;
import dev.iagorodrigues.clientapi.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(PageRequest pageRequest) {
        return clientRepository.findAll(pageRequest).map(ClientDTO::new);
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        return clientRepository.findById(id)
                .map(ClientDTO::new)
                .orElseThrow(() -> new ResourceNotFoundException("Client doesn't exist"));
    }

    @Transactional
    public ClientDTO insert(ClientDTO clientDTO) {
        Client client = new Client();
        mapClientDtoToEntity(clientDTO, client);
        client = clientRepository.save(client);
        return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO clientDTO) {
        try {
            Client client = clientRepository.getOne(id);
            mapClientDtoToEntity(clientDTO, client);
            client = clientRepository.save(client);
            return new ClientDTO(client);
        } catch (EntityNotFoundException ex) {
            throw new ResourceNotFoundException("Client doesn't exist.");
        }
    }

    @Transactional
    public void delete(Long id) {
        try {
            clientRepository.deleteById(id);
        } catch (Exception ex) {
            throw new ResourceNotFoundException("Client doesn't exist.");
        }
    }

    private void mapClientDtoToEntity(ClientDTO clientDTO, Client client) {
        client.setName(clientDTO.getName());
        client.setChildren(clientDTO.getChildren());
        client.setCpf(clientDTO.getCpf());
        client.setIncome(clientDTO.getIncome());
        client.setBirthDate(clientDTO.getBirthDate());
    }

}
