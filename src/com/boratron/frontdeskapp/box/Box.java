package com.boratron.frontdeskapp.box;

import com.boratron.frontdeskapp.common.Size;
import com.boratron.frontdeskapp.customer.Customer;
import com.boratron.frontdeskapp.utility.IdGenerator;

public class Box {
    private final int id;

    private final Size size;
    private final Customer owner;

    public Box(Size size, Customer owner) {
        this.size = size;
        this.owner = owner;

        this.id = IdGenerator.generateId();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Box box = (Box) obj;

        return this.id == box.getId();
    }

    public int getId() {
        return id;
    }

    public Size getSize() {
        return size;
    }

    public Customer getOwner() {
        return owner;
    }
}
