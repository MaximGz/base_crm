package ru.mts;

import ru.mts.model.Client;
import ru.mts.model.ClientStatus;
import ru.mts.service.ClientService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ClientService service = new ClientService();

        Client ivan = service.create(
                new Client(
                        "Ivan",
                        "Petrov",
                        "ivan@test.ru",
                        "+79991112233",
                        LocalDate.of(1990, 5, 15),
                        ClientStatus.ACTIVE.toString()
                )
        );

        Client client = service.findById(ivan.getId());
        System.out.println(client.getFirstName());

        service.delete(ivan.getId());

        System.out.println(Client.getClients().size());

    }
}