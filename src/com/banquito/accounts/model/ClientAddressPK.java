package com.banquito.accounts.model;

public class ClientAddressPK {
    private int codeAddress;
    private int codeCuent;
    private int codeLocation;
    
    public ClientAddressPK() {
    }

    public ClientAddressPK(int codeAddress, int codeCuent, int codeLocation) {
        this.codeAddress = codeAddress;
        this.codeCuent = codeCuent;
        this.codeLocation = codeLocation;
    }

    public int getCodeAddress() {
        return codeAddress;
    }

    public void setCodeAddress(int codeAddress) {
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