package entity;


import java.util.Date;

public class VolunteerUser {

    private int id;
    private String nome;
    private String cognome;
    private String password;
    private String indirizzo;
    private String recapitoTel;
    private String email;
    private String cartaDiCredito;
    private String nascita;
    private String citt�;
    private final String TABLE_NAME = "volontari";

    public VolunteerUser() {
    	 this.nome = "";
         this.cognome = "";
         this.password ="";
         this.indirizzo = "";
         this.recapitoTel = "";
         this.email = "";
         this.cartaDiCredito = "";
         this.nascita = null;
    }
    
    
    public VolunteerUser( String nome, String cognome, String password, String indirizzo, String recapitoTel, String email, String cartaDiCredito,String nascita, String citt�) {
        this.nome = nome;
        this.cognome = cognome;
        this.password = password;
        this.indirizzo = indirizzo;
        this.recapitoTel = recapitoTel;
        this.email = email;
        this.cartaDiCredito = cartaDiCredito;
        this.nascita = nascita;
        this.citt� = citt�;
    }

    public String getCitt�() {
    	return citt�;
    }
    
    public int getID() {
        return id;
    }

    public String getNascita() {
    	return nascita;
    }


    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getPassword() {
        return password;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getRecapitoTel() {
        return recapitoTel;
    }

    public String getEmail() {
        return email;
    }

    public String getCartaDiCredito() {
        return cartaDiCredito;
    }

    public void setID(int id) {
        if (id > 0) this.id = id;
    }
    
    public void setCitt�(String newcity) {
    	this.citt� = newcity;
    }

    public void setNascita(String nascita) {
    	this.nascita = nascita;
    }
    
    	
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public void setRecapitoTel(String recapitoTel) {
        this.recapitoTel = recapitoTel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCartaDiCredito(String cartaDiCredito) {
        this.cartaDiCredito = cartaDiCredito;
    }

 

    public String getTABLE_NAME() {
        return TABLE_NAME;
    }

    @Override
    public String toString() {
        return "VolunteerUser{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", password='" + password + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", recapitoTel='" + recapitoTel + '\'' +
                ", email='" + email + '\'' +
                ", cartaDiCredito='" + cartaDiCredito + '\'' +
                '}';
    }
}