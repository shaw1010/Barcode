package com.munshig.shaw.barcode;

import java.util.List;

public class Unique_barcode {
String name;
String price;
    String packet;

    public Unique_barcode(String name, String price, String packet) {
        this.name = name;
        this.price = price;
        this.packet = packet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPacket() {
        return packet;
    }

    public void setPacket(String packet) {
        this.packet = packet;
    }
}
