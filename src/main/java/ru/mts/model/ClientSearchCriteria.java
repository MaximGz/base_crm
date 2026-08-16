package ru.mts.model;

public class ClientSearchCriteria {
    private String lastName;
    private ClientStatus status;

    public ClientSearchCriteria(String lastName, ClientStatus status) {
        this.lastName = lastName;
        this.status = status;
    }

    public ClientSearchCriteria(String lastName) {
        this.lastName = lastName;
    }

    public ClientSearchCriteria(ClientStatus status) {
        this.status = status;
    }

    public String getLastName() {
        return lastName;
    }

    public ClientStatus getStatus() {
        return status;
    }
}
