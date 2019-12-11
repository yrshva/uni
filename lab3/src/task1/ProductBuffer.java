package task1;

import java.awt.*;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class ProductBuffer extends LinkedList<Product> {
    private int maxSize;

    public ProductBuffer (int maxSize) {
        this.maxSize = maxSize;
    }

    public synchronized boolean put(Product product) {
        if (this.size() == maxSize) {
            return false;
        }
        else {
            this.push(product);
            return true;
        }
    }

    public synchronized Product take() {
        if (this.size() > 0) {
            return this.removeFirst();
        } else {
            return null;
        }
    }

}
