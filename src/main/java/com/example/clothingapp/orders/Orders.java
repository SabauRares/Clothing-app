package com.example.clothingapp.orders;

public class Orders {
    private String name;
    private String brand;
    private String price;

    public Orders() {
    }

    public Orders(String name, String brand, String price)
    {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public String getName() {return name;}
    public void setName(String name)
    {
        this.name = name;
    }

    public String getBrand() {return brand;}
    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public String getPrice()
    {
        return price;
    }
    public void setPrice(String price)
    {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

}
