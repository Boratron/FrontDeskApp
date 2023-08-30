package com.boratron.frontdeskapp.storagearea;

import com.boratron.frontdeskapp.box.Box;
import com.boratron.frontdeskapp.common.Size;

import java.util.ArrayList;
import java.util.List;

public class StorageArea {
    private final Size size;
    private final List<Box> boxes;
    private final int maxCapacity;

    public StorageArea(Size size, int maxCapacity) {
        this.size = size;
        this.maxCapacity = maxCapacity;

        this.boxes = new ArrayList<>();
    }

    public boolean addBox(Box box) {
        return boxes.add(box);
    }

    public boolean removeBox(Box box) {
        return boxes.remove(box);
    }

    public boolean checkAvailability() {
        return this.boxes.size() < maxCapacity;
    }

    public Size getSize() {
        return size;
    }

    public List<Box> getBoxes() {
        return boxes;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }
}
