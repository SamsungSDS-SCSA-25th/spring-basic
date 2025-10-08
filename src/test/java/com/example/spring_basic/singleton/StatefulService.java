package com.example.spring_basic.singleton;

public class StatefulService {

//    private int price;

    public int order(String name, int price) {
        System.out.println("name = " + name + ", price = " + price);
//        this.price = price;
        // stateless로 리팩터링
        return price;
    }

//    public int getPrice() {
//        return price;
//    }
}
