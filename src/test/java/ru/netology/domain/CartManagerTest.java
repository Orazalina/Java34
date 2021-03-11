package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartManagerTest {
    private CartManager manager = new CartManager();
    PurchaseItem first = new PurchaseItem(1, "Постер", "Бладшот", "Боевик");
    PurchaseItem second = new PurchaseItem(2, "Постер", "Вперёд", "Мультфильм");
    PurchaseItem third = new PurchaseItem(3, "Постер", "Отель Белград", "Комедия");
    PurchaseItem fourth = new PurchaseItem(4, "Постер", "Джентльмены", "Боевик");
    PurchaseItem fifth = new PurchaseItem(5, "Постер", "Человек-невидимка", "Ужасы");

    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
    }

    @Test
    void shouldGetEmpty() {
        PurchaseItem[] expected = new PurchaseItem[0];
        PurchaseItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddToEmpty() {
        manager.add(first);
        PurchaseItem[] expected = new PurchaseItem[]{first};
        PurchaseItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddToExisted() {
        manager.add(first);
        PurchaseItem[] expected = new PurchaseItem[]{first};
        PurchaseItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
        manager.add(second);
        PurchaseItem[] expectedAdded = new PurchaseItem[]{second, first};
        PurchaseItem[] actualAdded = manager.getAll();
        assertArrayEquals(expectedAdded, actualAdded);
    }

    @Test
    void shouldGetMoviesForFeed() {
        setUp();
        PurchaseItem[] expected = new PurchaseItem[]{fifth, fourth, third, second, first};
        PurchaseItem[] actual = manager.getMoviesForFeed();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetMoviesForFlexFeed() {
        manager = new CartManager(3);
        setUp();
        PurchaseItem[] expected = new PurchaseItem[]{fifth, fourth, third};
        PurchaseItem[] actual = manager.getMoviesForFeed();
        assertArrayEquals(expected, actual);
    }
}