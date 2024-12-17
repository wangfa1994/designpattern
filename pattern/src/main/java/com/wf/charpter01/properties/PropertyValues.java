package com.wf.charpter01.properties;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class PropertyValues  implements Iterable<PropertyValue>{

    private List<PropertyValue> content;



    @Override
    public Iterator<PropertyValue> iterator() {

        return content.iterator();
    }

    @Override
    public void forEach(Consumer<? super PropertyValue> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<PropertyValue> spliterator() {
        return Iterable.super.spliterator();
    }
}
