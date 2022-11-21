public class AccountAssoServiceParamPK {
    private String codeParam;
    private String codeAssociatedService;
    private int codeAccount;
    private String codeAccountAssoService;
    private String codeProduct;
    public AccountAssoServiceParamPK() {
    }
    public AccountAssoServiceParamPK(String codeParam, String codeAssociatedService, int codeAccount,
            String codeAccountAssoService, String codeProduct) {
        this.codeParam = codeParam;
        this.codeAssociatedService = codeAssociatedService;
        this.codeAccount = codeAccount;
        this.codeAccountAssoService = codeAccountAssoService;
        this.codeProduct = codeProduct;
    }
    public String getCodeParam() {
        return codeParam;
    }
    public void setCodeParam(String codeParam) {
        this.codeParam = codeParam;
    }
    public String getCodeAssociatedService() {
        return codeAssociatedService;
    }
    public void setCodeAssociatedService(String codeAssociatedService) {
        this.codeAssociatedService = codeAssociatedService;
    }
    public int getCodeAccount() {
        return codeAccount;
    }
    public void setCodeAccount(int codeAccount) {
        this.codeAccount = codeAccount;
    }
    public String getCodeAccountAssoService() {
        return codeAccountAssoService;
    }
    public void setCodeAccountAssoService(String codeAccountAssoService) {
        this.codeAccountAssoService = codeAccountAssoService;
    }
    public String getCodeProduct() {
        return codeProduct;
    }
    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

    
    
}
