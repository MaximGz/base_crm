package ru.mts.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private static final List<Client> clients = new ArrayList<>();

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private LocalDate birthDate;
    private ClientStatus status;

    public Client(String firstName, String lastName, String email, String phone, LocalDate birthDate, String status) {
        this.id = clients.size();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.status = ClientStatus.valueOf(status);
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public ClientStatus getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setStatus(ClientStatus status) {
        this.status = status;
    }

    public static List<Client> getClients() {
        return clients;
    }
}
