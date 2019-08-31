package pl.coderslab.domain;

import java.util.UUID;

public class Product {

    private UUID uuid;
    private String name;
    private double price;

    public Product(String name, double price) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
