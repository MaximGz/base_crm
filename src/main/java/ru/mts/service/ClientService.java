package ru.mts.service;

import ru.mts.model.Client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClientService {
    private final List<Client> clients = new ArrayList<>();

    public Client create(Client client) {
        clients.add(client);
        return client;
    }

    public Client findById(int id) {
        return clients.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public List<Client> findAll() {
        return Collections.unmodifiableList(clients);
    }

    public void delete(int id) {
        clients.removeIf(c -> c.getId() == id);
    }
}
