package com.munir.firelist;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by munirul.hoque on 8/11/2016.
 */
public class AddressBook {
    private String name;
    private String address;
    private String url;

    public AddressBook(){

    }

    public AddressBook(String name, String address, String url) {
        this.name = name;
        this.address = address;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String,Object> toMap(){
        HashMap<String,Object> result = new HashMap<>();
        result.put("name" , name);
        result.put("address" , address);
        result.put("url" , url);
        return result;
    }
}
