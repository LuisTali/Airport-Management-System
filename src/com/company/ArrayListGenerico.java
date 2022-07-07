package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class ArrayListGenerico <V> implements Serializable {
    V value;
    ArrayList<V> arrayList;

    public ArrayListGenerico() {
        arrayList = new ArrayList<>();
    }

    public void añadir(V value){
        arrayList.add(value);
    }

    public void eliminar(int i){
        arrayList.remove(i);
    }

    public V buscarPorIndice(int i){
        return arrayList.get(i);
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (V valueAux : arrayList){
            buffer.append(valueAux.toString());
            buffer.append(" ");
        }
        return buffer.toString();
    }
}
