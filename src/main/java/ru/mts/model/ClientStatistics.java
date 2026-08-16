package ru.mts.model;

public class ClientStatistics {
    private final int total;
    private final long active;
    private final long inactive;
    private final long blocked;
    private final double averageAge;

    public ClientStatistics(int total, long active, long inactive, long blocked, double averageAge) {
        this.total = total;
        this.active = active;
        this.inactive = inactive;
        this.blocked = blocked;
        this.averageAge = averageAge;
    }

    public long getActive() {
        return active;
    }

    public long getInactive() {
        return inactive;
    }

    public int getTotal() {
        return total;
    }

    public long getBlocked() {
        return blocked;
    }

    public double getAverageAge() {
        return averageAge;
    }
}
