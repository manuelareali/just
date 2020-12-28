package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sothawo.mapjfx.Coordinate;

import connector.Connector;
import entity.Donazione;

public class Donation_dao {
	private static final String SUCCESS = "Voce modificata con successo!";
    private static final String FAILED = "Operazione non riuscita.";


    private final Connector connector;
	
	
    
    
   public int crea_donazione(Donazione dono ) {
   
	   		int rowAffected;
	   		ResultSet rs = null;

          	//Registra Caritas
      	    String sql = "call crea_donazione(?,?,?,?,?)";

              try (Connection conn = connector.getConnection();
                   PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            	  pstmt.setInt(1, dono.getId_caritas() );
            	  pstmt.setInt(2, dono.getId_utente());
            	  pstmt.setInt(3, dono.getTipologia());
            	  pstmt.setString(4,dono.getDescrizione());
            	  pstmt.setString(5, dono.getIndirizzo());
              	
              
                  rowAffected = pstmt.executeUpdate();

                  if (rowAffected == 1) {
                      System.out.println(SUCCESS);
                  } else System.out.println(FAILED);


              } catch (SQLException ex) {
                  System.out.println((ex.getMessage()));
           
              }
			return 0;
             
          
   }
    

    
    public Donation_dao() {
    	connector = new Connector("jdbc:mysql://127.0.0.1:3306/Justthinkit", "root", "password");
    }
}
