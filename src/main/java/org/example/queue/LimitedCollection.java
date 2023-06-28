package org.example.queue;

import org.example.Collection;

public interface LimitedCollection extends Collection {
    boolean isFull();
}
