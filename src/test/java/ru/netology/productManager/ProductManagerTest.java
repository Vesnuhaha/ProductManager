package ru.netology.productManager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    Repository repository = new Repository();
    ProductManager manager = new ProductManager(repository);


    Book book1 = new Book(1, "book1", 100, "Author1");
    Book book2 = new Book(2, "book2", 200, "Author2");
    Book book3 = new Book(3, "book3", 300, "Author3");
    Smartphone phone1 = new Smartphone(11, "Iphone 11", 110_000, "Apple");
    Smartphone phone2 = new Smartphone(12, "Iphone 12", 120_000, "Apple");
    Smartphone phone3 = new Smartphone(13, "Iphone 13", 130_000, "Apple");


    @Test
    public void addProducts() {
        manager.add(book1);
        manager.add(book2);
        repository.add(phone1);
        repository.add(phone2);
        manager.add(phone3);

        Product[] expected = {book1, book2, phone1, phone2, phone3};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);

    }

    @Test
    public void findById() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);

        Product expected = phone1;
        Product actual = repository.findById(11);
        assertEquals(expected, actual);
    }


    @Test
    public void removeById() {
        repository.add(book1);
        repository.add(book2);
        repository.add(book3);
        repository.add(phone1);
        repository.add(phone2);
        repository.add(phone3);

        repository.removeById(2);
        repository.removeById(13);

        Product[] expected = {book1, book3, phone1, phone2};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    //найти все товары
    public void findAll() {
        repository.add(book1);
        repository.add(book2);
        repository.add(book3);
        repository.add(phone1);
        repository.add(phone2);
        repository.add(phone3);

        Product[] expected = {book1, book2, book3, phone1, phone2, phone3};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);

    }

    @Test
    // найти по названию книгу
    public void findByNameBook() {
        repository.add(book1);
        repository.add(book2);
        repository.add(book3);
        repository.add(phone1);
        repository.add(phone2);
        repository.add(phone3);

        Product[] expected = {book3};
        Product[] actual = manager.searchBy("book3");

        assertArrayEquals(expected, actual);

    }

    @Test
    public void findByName() {
        repository.add(book1);
        repository.add(book2);
        repository.add(book3);
        repository.add(phone1);
        repository.add(phone2);
        repository.add(phone3);

        Product[] expected = {phone2};
        Product[] actual = manager.searchBy("Iphone 12");
        assertArrayEquals(expected, actual);
    }


    @Test
    public void findBookOutOfList() {
        repository.add(book1);
        repository.add(book2);
        repository.add(book3);

        Product[] expected = {};
        Product[] actual = manager.searchBy("book4");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findByUnCorrectId() {
        repository.add(book1);
        repository.add(book2);
        repository.add(book3);
        repository.add(phone1);
        repository.add(phone2);
        repository.add(phone3);

        Product actual = repository.findById(333);
        assertNull(actual);

    }

    @Test
    public void findAllSmartphones() {
        repository.add(book1);
        repository.add(book2);
        repository.add(book3);
        repository.add(phone1);
        repository.add(phone2);
        repository.add(phone3);

        Product[] expected = {phone1, phone2, phone3};
        Product[] actual = manager.searchBy("phone");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findByIdPhone() {
        repository.add(book1);
        repository.add(book2);
        repository.add(book3);
        repository.add(phone1);
        repository.add(phone2);
        repository.add(phone3);

        Product expected = phone3;
        Product actual = repository.findById(13);
        assertEquals(expected, actual);
    }

    @Test
    public void findSamsung() {
        repository.add(book1);
        repository.add(book2);
        repository.add(book3);
        repository.add(phone1);
        repository.add(phone2);
        repository.add(phone3);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }

}