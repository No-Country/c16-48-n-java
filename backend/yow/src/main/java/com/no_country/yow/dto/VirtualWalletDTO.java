package com.no_country.yow.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class VirtualWalletDTO implements Serializable {

    private String name ;
    private String lastName;
    private String balance;
    private List<String> amountMovement;
    private List<String> date;


    public VirtualWalletDTO(){
        this.amountMovement = new ArrayList<>();
        this.date = new ArrayList<>();
    }
}
