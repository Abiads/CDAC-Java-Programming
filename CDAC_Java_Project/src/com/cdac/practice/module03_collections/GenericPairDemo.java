package com.cdac.practice.module03_collections;

import java.util.Objects;

/**
 * Generic class Pair<K, V> representing a 2-tuple of arbitrary types.
 */
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair<?, ?>)) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(key, pair.key) && Objects.equals(value, pair.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public String toString() {
        return String.format("Pair(key=%s, value=%s)", key, value);
    }
}

public class GenericPairDemo {

    public static void main(String[] args) {
        System.out.println("=== Generic Pair<K, V> Demonstration ===\n");

        // Example 1: Pair of String and Integer (e.g. Student name and roll number)
        Pair<String, Integer> studentRoll = new Pair<>("Aditya", 101);
        System.out.println("Student Record: " + studentRoll);
        System.out.println("Key type  : " + studentRoll.getKey().getClass().getSimpleName());
        System.out.println("Value type: " + studentRoll.getValue().getClass().getSimpleName());

        // Example 2: Pair of Integer and Double (Product ID and Price)
        Pair<Integer, Double> productPrice = new Pair<>(90021, 1499.50);
        System.out.println("\nProduct Record: " + productPrice);
        productPrice.setValue(1349.00); // Apply discount
        System.out.println("Updated Price : " + productPrice);

        // Example 3: Pair Equality Check
        Pair<String, Integer> pairA = new Pair<>("Code", 404);
        Pair<String, Integer> pairB = new Pair<>("Code", 404);
        System.out.println("\nPair A: " + pairA);
        System.out.println("Pair B: " + pairB);
        System.out.println("Are both pairs equal? " + pairA.equals(pairB));
    }
}
