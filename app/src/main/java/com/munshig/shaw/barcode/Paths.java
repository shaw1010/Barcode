package com.munshig.shaw.barcode;

public class Paths {
    String getPath_barcode;
    String storePath_unique;

    public Paths(String getPath_barcode, String storePath_unique) {
        this.getPath_barcode = getPath_barcode;
        this.storePath_unique = storePath_unique;
    }

    public String getGetPath_barcode() {
        return getPath_barcode;
    }

    public void setGetPath_barcode(String getPath_barcode) {
        this.getPath_barcode = getPath_barcode;
    }

    public String getStorePath_unique() {
        return storePath_unique;
    }

    public void setStorePath_unique(String storePath_unique) {
        this.storePath_unique = storePath_unique;
    }
}

