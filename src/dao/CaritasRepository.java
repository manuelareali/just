package dao;

import java.util.*;

import connector.Connector;
import entity.CaritasUser;
import java.sql.*;

public class CaritasRepository {

    private final Connector connector;
    private static final String SUCCESS = "Voce modificata con successo!";
    private static final String FAILED = "Operazione non riuscita.";

    public CaritasRepository() {
        this.connector =  new Connector("jdbc:mysql://127.0.0.1:3306/Justthinkit", "root", "password");;
    }

    public int insertCaritas(CaritasUser caritasUser) {

        ResultSet rs = null;
        int caritasID = 0;

        	//Registra Caritas
    	    String sql = "call registrazione_caritas(?,?,?,?,?,?,?,?)";

            try (Connection conn = connector.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            	System.out.println(caritasUser.getEmail() + caritasUser.getIndirizzoCaritas());
            	pstmt.setString(1,caritasUser.getEmail());
            	pstmt.setString(2, caritasUser.getPassword());
                pstmt.setString(3, caritasUser.getNomeCaritas());
                pstmt.setString(4, caritasUser.getIndirizzoCaritas());
                pstmt.setString(5,caritasUser.getRecapitoTelefonico());
                pstmt.setString(6, caritasUser.getTipologia());
                pstmt.setString(7, caritasUser.getCitt�());
                pstmt.setString(8, "Caritas");
                
            int rowAffected = pstmt.executeUpdate();
            if (rowAffected == 1) {

                rs = pstmt.getGeneratedKeys();
                if (rs.next())
                    caritasID = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return caritasID;
    }


  /*  public List<CaritasUser> getAllCaritas() {
        List<CaritasUser> carUsrs = new ArrayList<>();

        String sql = "SELECT * FROM caritas";

        try (Connection conn = connector.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
            
                String nomeCaritas = rs.getString("NomeCaritas");
              
                String indirizzoCaritas = rs.getString("IndirizzoCaritas");
                String tipologia = rs.getString("Tipologia");
                String recapitoTel = rs.getString("RecapitoTel");
               

                CaritasUser carUsr = new CaritasUser(nomeCaritas, indirizzoCaritas, tipologia, recapitoTel, email);
                carUsr.setId(rs.getInt("ID"));
                carUsrs.add(carUsr);
            }
            return carUsrs;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new IllegalStateException("error fetching users", ex);
        }
    }

*/
  public CaritasUser getCaritasByID(int id) {

        String sql = "SELECT  NomeCaritas, IndirizzoCaritas, Tipologia, RecapitoTel FROM caritas WHERE CodiceCaritas=?";
        ResultSet rs = null;
        CaritasUser carUsr = new CaritasUser();

        try (Connection conn = connector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {

                carUsr.setNomeCaritas(rs.getString("NomeCaritas"));
                carUsr.setId(id);
                carUsr.setIndirizzoCaritas(rs.getString("IndirizzoCaritas"));
                carUsr.setTipologia(rs.getString("Tipologia"));
                carUsr.setRecapitoTelefonico(rs.getString("RecapitoTel"));
               
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } return carUsr;
    }

    private String getPassword(CaritasUser carUser){
        String sql = "SELECT Password FROM caritas WHERE ID = ?";
        ResultSet res = null;
        String password = "";

        try(Connection conn = connector.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setInt(1, carUser.getID());
            res = pstmt.executeQuery();

            while (res.next()){
                password = res.getString("Password");
            }
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }finally {
            try {
                if (res != null) res.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        if(password.equals("")) return "";

        else return password;


    }


    public void updatePassword(CaritasUser carUser, String newPass, String oldPassword){
        String actPassword = getPassword(carUser);
        String sql = "UPDATE caritas SET Password = ? WHERE ID = ?";
        int rowAffected;

        if(actPassword.equals(oldPassword)) {
            try (Connection conn = connector.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, newPass);
                pstmt.setInt(2, carUser.getID());
                rowAffected = pstmt.executeUpdate();

                if (rowAffected == 1) {
                    System.out.println(SUCCESS);
                } else System.out.println(FAILED);


            } catch (SQLException ex) {
                System.out.println((ex.getMessage()));
            }
        }else System.out.println(FAILED);

    }



    public void updateCarName(int id, String carName) {
        String sql = "UPDATE caritas SET NomeCaritas = ? WHERE ID= ?";
        int rowAffected;
        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, carName);
            stmt.setInt(2, id);
            rowAffected = stmt.executeUpdate();

            if (rowAffected == 1) {
                System.out.println(SUCCESS);
            }else System.out.println(FAILED);


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updateType(int id, String type) {
        String sql = "UPDATE caritas SET Tipologia = ? WHERE ID = ?";
        int rowAffected;

        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, type);
            stmt.setInt(2, id);
            rowAffected = stmt.executeUpdate();

            if (rowAffected == 1) {
                System.out.println(SUCCESS);
            }else System.out.println(FAILED);


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updateEmail(int id, String email) {
        String sql = "UPDATE caritas SET Email = ? WHERE ID = ?";
        int rowAffected;
        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setInt(2, id);
            rowAffected = stmt.executeUpdate();

            if (rowAffected == 1) {
                System.out.println(SUCCESS);
            }else System.out.println(FAILED);


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updatePhoneNum(int id, String phoneNum) {
        String sql = "UPDATE caritas SET RecapitoTel = ? WHERE ID = ?";
        int rowAffected;
        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, phoneNum);
            stmt.setInt(2, id);
            rowAffected = stmt.executeUpdate();

            if (rowAffected == 1) {
                System.out.println(SUCCESS);
            }else System.out.println(FAILED);


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updateAddress(int id, String address) {
        String sql = "UPDATE caritas SET IndirizzoCaritas = ? WHERE ID = ?";
        int rowAffected;
        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, address);
            stmt.setInt(2, id);
            rowAffected = stmt.executeUpdate();

            if (rowAffected == 1) {
                System.out.println(SUCCESS);
            } else System.out.println(FAILED);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deleteCaritas(int id) {
        String sql = "DELETE FROM caritas where ID=?";
        int deletedRec;

        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            deletedRec = stmt.executeUpdate();

            if (deletedRec == 1) System.out.println("Caritas ID " + id + ", rimossa con successo!");

            else System.out.println("ID non trovato.");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deleteAll() {
        String sql = "DELETE FROM caritas";
        int delRecs;
        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            delRecs = stmt.executeUpdate();
            if (delRecs >= 1) System.out.println("\t ***** Voci Caritas rimosse con successo! *****");
            resetID();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void resetID() {
        String sql = "ALTER TABLE caritas AUTO_INCREMENT = 1";

        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.executeUpdate();
            System.out.println("\t ***** ID Values resetted successfully! *****");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void printCarsInTab(List<CaritasUser> caritasUsers){
        String s1 = "ID";
        String s2 = "Nome Caritas";
        String s3 = "Password";
        String s4 = "Indirizzo Caritas";
        String s5 = "Tipologia";
        String s6 = "RecapitoTel";
        String s7 =  "Email";
        String s8 = "Citt�";



        System.out.printf("%n %-22s %-22s %-22s %-22s %-22s %-22s %-22s %-22s %n", s1, s2, s3, s4, s5, s6, s7, s8);
        for(CaritasUser car:caritasUsers){
            System.out.printf("%-22s %-22s %-22s %-22s %-22s %-22s %-22s %n", car.getID(), car.getNomeCaritas(), car.getPassword(),
                    car.getIndirizzoCaritas(), car.getTipologia(), car.getRecapitoTelefonico(), car.getEmail(), car.getCitt�());
        }
    }

}
