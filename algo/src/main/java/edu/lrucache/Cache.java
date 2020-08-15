package edu.lrucache;

public interface Cache {
    void put(int key, int value);

    int get(int key);
}
