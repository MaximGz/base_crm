package ru.mts.service;

import ru.mts.exceptions.ClientBlockedException;
import ru.mts.exceptions.ClientNotFoundException;
import ru.mts.model.*;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ClientService {
    private int nextInt = 0;
    private final Map<Integer, Client> clients = new HashMap<Integer, Client>();

    public Client create(Client client) {
        clients.put(nextInt, client);
        nextInt += 1;
        return client;
    }

    public Client findById(int id) {
        Client c = clients.get(id);
        if (c == null) {
            throw new ClientNotFoundException("Client with id " + id + " not found");
        }
        return c;
    }

    public void delete(int id) {
        Client c = clients.get(id);
        if(c.getStatus().equals(ClientStatus.BLOCKED)) {
            throw new ClientBlockedException("Client with id " + id + " is blocked");
        }
        clients.remove(id);
    }


    public List<Client> findByCriteria(ClientSearchCriteria criteria) {
        return clients.values().stream()
                .filter(c -> criteria.getLastName() == null || c.getLastName().equalsIgnoreCase(criteria.getLastName()))
                .filter(c -> criteria.getStatus() == null || c.getStatus().equals(criteria.getStatus()))
                .collect(Collectors.toList());
    }

    public List<Client> findAll(ClientSortField clientSortField, SortDirection sortDirection) {

        Comparator<Client> comparator = null;

        switch (clientSortField) {
            case FIRST_NAME:
                comparator = Comparator.comparing(Client::getFirstName);
                break;
            case LAST_NAME:
                comparator = Comparator.comparing(Client::getLastName);
                break;
            case DATE_OF_BIRTH:
                comparator = Comparator.comparing(Client::getBirthDate);
                break;
        }

        if (sortDirection == SortDirection.DESC) {
            comparator = comparator.reversed();
        }

        return clients.values().stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    public List<Client> pageResult(int pageSize) {
        return clients.values().stream()
                .limit(pageSize)
                .collect(Collectors.toList());
    }

    public void ClientStatistics() {
        System.out.println("Количество клиентов: " + clients.size());
        System.out.println("Количество ACTIVE: " + clients.values().stream()
                .filter(c -> c.getStatus().equals(ClientStatus.ACTIVE))
                .count());
        System.out.println("Количество INACTIVE: " + clients.values().stream()
                .filter(c -> c.getStatus().equals(ClientStatus.INACTIVE))
                .count());
        System.out.println("Количество BLOCKED: " + clients.values().stream()
                .filter(c -> c.getStatus().equals(ClientStatus.BLOCKED))
                .count());
        //System.out.println("Средний возраст клиентов: " + clients.values().stream()
               // .map(c -> c.)
        System.out.println(clients);
    }

    public void AverageClientAge() {
        Double averageAge = clients.values().stream()
                .map(c -> ChronoUnit.YEARS.between(c.getBirthDate(), LocalDate.now()))
                .mapToLong(c -> c)
                .average()
                .orElse(0.0);

        DecimalFormat df = new DecimalFormat("#.##");
        String formattedAverage = df.format(averageAge);
        System.out.println("Средний возраст клиентов: " + formattedAverage);
    }
}
