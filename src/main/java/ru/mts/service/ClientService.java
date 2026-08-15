package ru.mts.service;

import ru.mts.model.Client;

import java.util.List;

public class ClientService {
    private static final List<Client> clients = Client.getClients();

    public Client create(Client client) {
        clients.add(client);
        return client;
    }

    public Client findById(int id) {
        return clients.get(id);
    }

    public List<Client> findAll() {
        return clients;
    }

    public void delete(int id) {
        clients.remove(id);
    }

}
