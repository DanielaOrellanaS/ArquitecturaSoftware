package com.banquito.accounts.model;

import javax.sql.rowset.serial.SerialArray;

public class ClientAddressPK {
    private SerialArray codeAddress;
    private int codeCuent;
    private int codeLocation;
    
    public ClientAddressPK() {
    }

    public ClientAddressPK(SerialArray codeAddress, int codeCuent, int codeLocation) {
        this.codeAddress = codeAddress;
        this.codeCuent = codeCuent;
        this.codeLocation = codeLocation;
    }
    public SerialArray getCodeAddress() {
        return codeAddress;
    }
    public void setCodeAddress(SerialArray codeAddress) {
        this.codeAddress = codeAddress;
    }
    public int getCodeCuent() {
        return codeCuent;
    }
    public void setCodeCuent(int codeCuent) {
        this.codeCuent = codeCuent;
    }
    public int getCodeLocation() {
        return codeLocation;
    }
    public void setCodeLocation(int codeLocation) {
        this.codeLocation = codeLocation;
    }
}
