package ru.netology.productManager;

public class Repository {

    Product[] products = new Product[0];

    public void add(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;

    }

    public void removeById(int id) {
        int lenght = products.length - 1;
        Product[] tmp = new Product[lenght];
        int index = 0;
        for (Product item : products) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }


    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

}