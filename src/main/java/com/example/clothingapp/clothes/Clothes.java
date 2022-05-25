package com.example.clothingapp.clothes;

public class Clothes {
    private String name;
    private String brand;
    private String price;

    public Clothes() {
    }

    public Clothes(String name, String brand, String price)
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

    // public String getNameUser() {return nameUser;}
    //public void setNameUser(String title)
    //{
    // this.nameUser = nameUser;
    // }

    //public ChoiceBox<String> getTitleOrder() {return titleOrder;}
    //public void setTitleOrder(String titleOrder)
    // {
    // this.titleOrder = titleOrder;
    //}

    @Override
    public String toString() {
        return "Clothes{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}


