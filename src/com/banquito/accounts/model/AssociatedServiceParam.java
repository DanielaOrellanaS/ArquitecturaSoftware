package com.banquito.accounts.model;

public class AssociatedServiceParam {
    private AssociatedServiceParamPK pk;
    private String valueType;
    private String name;

    public AssociatedServiceParam() {
    }

    public AssociatedServiceParam(AssociatedServiceParamPK pk, String valueType, String name) {
        this.pk = pk;
        this.valueType = valueType;
        this.name = name;
    }

    public AssociatedServiceParamPK getPk() {
        return pk;
    }

    public void setPk(AssociatedServiceParamPK pk) {
        this.pk = pk;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
