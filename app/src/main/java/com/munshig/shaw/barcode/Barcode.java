package com.munshig.shaw.barcode;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Map;

public class Barcode implements Parcelable{
    String Barcode;
    String Name;
    String Packet_Price;
    String Price;
    Boolean selected_name=false;
    Boolean selected_price=false;
    Boolean selected_packet=false;
//    public Barcode(String Barcode, String Name, String Price, String Packet_Price) {
//        Barcode = Barcode;
//        Name = Name;
//        Price = Price;
//        Packet_Price = Packet_Price;
//    }

    public Barcode() {
//        Barcode = Barcode;
//        Name = Name;
//        Price = Price;
//        Packet_Price = Packet_Price;
    }


    @Override
    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        // TODO Auto-generated method stub
        out.writeString(Barcode);
        out.writeString(Name);
        out.writeString(Packet_Price);
        out.writeString(Price);
    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<Barcode> CREATOR
            = new Parcelable.Creator<Barcode>() {
        public Barcode createFromParcel(Parcel in) {
            return new Barcode(in);
        }

        public Barcode[] newArray(int size) {
            return new Barcode[size];
        }
    };

    private Barcode(Parcel in) {
        Barcode = in.readString();
        Name = in.readString();
        Price = in.readString();
        Packet_Price = in.readString();
    }


    public String getBarcode() {
        return Barcode;
    }

    public void setBarcode(String barcode) {
        Barcode = barcode;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getPacket() {
        return Packet_Price;
    }

    public String getPacket_Price() {
        return Packet_Price;
    }

    public void setPacket_Price(String packet_Price) {
        Packet_Price = packet_Price;
    }

    public Boolean getSelected_name() {
        return selected_name;
    }

    public void setSelected_name(Boolean selected_name) {
        this.selected_name = selected_name;
    }

    public Boolean getSelected_price() {
        return selected_price;
    }

    public void setSelected_price(Boolean selected_price) {
        this.selected_price = selected_price;
    }

    public Boolean getSelected_packet() {
        return selected_packet;
    }

    public void setSelected_packet(Boolean selected_packet) {
        this.selected_packet = selected_packet;
    }

    public void setPacket(String packet) {
        Packet_Price = packet;
    }
}
