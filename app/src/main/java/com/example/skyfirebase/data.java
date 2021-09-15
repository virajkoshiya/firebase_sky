package com.example.skyfirebase;

public class data {

  //  String id;
    String name;
    String mob;
    String details;

    public data( String name, String mob, String details) {
       // this.id = id;
        this.name = name;
        this.mob = mob;
        this.details = details;
    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
