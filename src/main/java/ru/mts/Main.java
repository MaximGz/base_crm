package ru.mts;

import ru.mts.model.Client;
import ru.mts.model.ClientSearchCriteria;
import ru.mts.model.ClientStatistics;
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
                        ClientStatus.ACTIVE
                )
        );
        Client petr = service.create(
                new Client(
                        "Petr",
                        "Sidorov",
                        "petr@test.ru",
                        "+79992223344",
                        LocalDate.of(1985, 8, 20),
                        ClientStatus.ACTIVE
                )
        );

        Client maria = service.create(
                new Client(
                        "Maria",
                        "Ivanova",
                        "maria@test.ru",
                        "+79993334455",
                        LocalDate.of(1995, 3, 10),
                        ClientStatus.INACTIVE
                )
        );

        Client alexey = service.create(
                new Client(
                        "Alexey",
                        "Popov",
                        "alexey@test.ru",
                        "+79994445566",
                        LocalDate.of(1988, 11, 25),
                        ClientStatus.BLOCKED
                )
        );

        Client olga = service.create(
                new Client(
                        "Olga",
                        "Kuznetsova",
                        "olga@test.ru",
                        "+79995556677",
                        LocalDate.of(2000, 7, 5),
                        ClientStatus.ACTIVE
                )
        );

        Client sergey = service.create(
                new Client(
                        "Sergey",
                        "Popov",
                        "sergey@test.ru",
                        "+79996667788",
                        LocalDate.of(1975, 12, 1),
                        ClientStatus.ACTIVE
                )
        );

        // поиск по ID
        Client c1 = service.findById(1);
        System.out.println(c1.getFirstName());

        // поиск по фамилии
        ClientSearchCriteria criteria1 = new ClientSearchCriteria("Popov");
        System.out.println(service.findByCriteria(criteria1));

        // поиск по статусу
        ClientSearchCriteria criteria2 = new ClientSearchCriteria(ClientStatus.ACTIVE);
        System.out.println(service.findByCriteria(criteria2));

        // комбинированный поиск (фамилия + статус)
        ClientSearchCriteria criteria3 = new ClientSearchCriteria("Popov", ClientStatus.ACTIVE);
        System.out.println(service.findByCriteria(criteria3));

        // пагинация
        System.out.println(service.pageResult(2, 2));

        // несуществующий клиент
        Client c2 = service.findById(100);

        // попытку удалить BLOCKED клиента
        service.delete(3);

        // статистика
        ClientStatistics clientStatistics = service.ClientStatistics();


    }
}