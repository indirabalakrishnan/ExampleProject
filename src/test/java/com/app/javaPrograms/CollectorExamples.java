package com.app.javaPrograms;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Product {
    int id;
    String name;
    float price;

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
public class CollectorExamples {
    public static void main (String a[]){
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Product(1, "Pen", 10f));
        productList.add(new Product(2, "Pencil", 20f));
        productList.add(new Product(3, "Rubber", 30f));
        productList.add(new Product(4, "Sharpner", 40f));
        productList.add(new Product(5, "Scale", 50f));

        List<Float> productPriceList = new ArrayList<Float>();
        productPriceList = productList.stream().map(x -> x.price).collect(Collectors.toList());
        System.out.println(productPriceList);

        Set<Float> productPriceSet = productList.stream().map(x -> x.price).collect(Collectors.toSet());
        System.out.println(productPriceSet);

        Double sumOfPrice = productList.stream().collect(Collectors.summingDouble(x -> x.price));
        System.out.println(sumOfPrice);

        Double average = productList.stream().collect(Collectors.averagingDouble(x -> x.price));
        System.out.println(average);

    }
}