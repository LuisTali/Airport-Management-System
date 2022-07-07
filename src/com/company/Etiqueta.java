package com.company;

import java.io.Serializable;
import java.util.Objects;

public class Etiqueta implements Serializable {
    private String tag;

    public Etiqueta(String tag) {
        this.tag = tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Etiqueta etiqueta = (Etiqueta) o;
        return Objects.equals(tag, etiqueta.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tag);
    }

    public String toString(){
        return tag;
    }
}
