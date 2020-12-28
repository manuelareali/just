package entity;

public class ShopUser {

    private int id;
    private String nomeShop;
    private String password;
    private String indirizzoShop;
    private String tipologia;
    private String recapitoTelefonico;
    private String email;
    private String citt�;
    private final String TABLE_NAME = "negozi";

   
    public ShopUser(String nomeShop, String password, String indirizzoShop, String tipologia, String recapitoTelefonico, String email, String citt�) {
        this.nomeShop = nomeShop;
        this.password = password;
        this.indirizzoShop = indirizzoShop;
        this.tipologia = tipologia;
        this.recapitoTelefonico = recapitoTelefonico;
        this.email = email;
        this.citt� = citt�;
    }

    public ShopUser() {
		// TODO Auto-generated constructor stub
	}

	public int getID() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) this.id = id;

    }

    public String getNomeShop() {
        return nomeShop;
    }

    public void setNomeShop(String nomeShop) {
        this.nomeShop = nomeShop;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIndirizzoShop() {
        return indirizzoShop;
    }

    public void setIndirizzoShop(String indirizzoShop) {
        this.indirizzoShop = indirizzoShop;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public String getRecapitoTelefonico() {
        return recapitoTelefonico;
    }

    public void setRecapitoTelefonico(String recapitoTelefonico) {
        this.recapitoTelefonico = recapitoTelefonico;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTABLE_NAME() {
        return TABLE_NAME;
    }

    @Override
    public String toString() {
        return "ShopUser{" +
                "nomeShop='" + nomeShop + '\'' +
                ", indirizzoShop='" + indirizzoShop + '\'' +
                ", tipo='" + tipologia + '\'' +
                ", recapito='" + recapitoTelefonico + '\'' +
                '}';
    }

	public String getcitt�() {
		return citt�;
		// TODO Auto-generated method stub
		
	}
	public void setCitt�(String newcity) {
		this.citt� = newcity;
	}
   

	
	
}