package com.aji.kerjain;

public class List_Item {
    private String head;
    private String deskripsi;
    private String lokasi;

    public List_Item(String head, String deskripsi, String lokasi) {
        this.head = head;
        this.deskripsi = deskripsi;
        this.lokasi = lokasi;

    }

    public String getHead() {
        return head;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getLokasi() {
        return lokasi;
    }
}
