package com.boratron.frontdeskapp.box;

import java.util.ArrayList;
import java.util.List;

public class BoxDB {
    private final List<Box> boxes;

    public BoxDB() {
        this.boxes = new ArrayList<>();
    }

    public List<Box> getBoxes() {
        return boxes;
    }
}
