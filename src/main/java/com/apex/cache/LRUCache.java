package com.apex.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {

    private final int capacity;
    private final Map<K, Node<K, V>> map;

    private Node<K, V> head;
    private Node<K, V> tail;

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public synchronized V get(K key) {
        Node<K, V> node = map.get(key);
        if (node == null) {
            return null;
        }
        moveToHead(node);
        return node.value;
    }

    public synchronized void put(K key, V value) {
        Node<K, V> node = map.get(key);

        if (node != null) {
            node.value = value;
            moveToHead(node);
            return;
        }

        Node<K, V> newNode = new Node<>();
        newNode.key = key;
        newNode.value = value;

        map.put(key, newNode);
        addToHead(newNode);

        if (map.size() > capacity) {
            map.remove(tail.key);
            removeTail();
        }
    }

    private void addToHead(Node<K, V> node) {
        node.prev = null;
        node.next = head;

        if (head != null) {
            head.prev = node;
        }
        head = node;

        if (tail == null) {
            tail = head;
        }
    }

    private void moveToHead(Node<K, V> node) {
        if (node == head) return;
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(Node<K, V> node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node == tail) {
            tail = node.prev;
        }
    }

    private void removeTail() {
        if (tail == null) return;
        removeNode(tail);
    }

    public synchronized int size() {
        return map.size();
    }
}
