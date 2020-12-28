package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ch.qos.logback.classic.Logger;
import connector.Connector;
import entity.partecipa_turno;
import entity.Orario;
import entity.Turno;

public class Prenota_dao {

    private final Connector connector;
    private static final String SUCCESS = "Voce modificata con successo!";
    private static final String FAILED = "Operazione non riuscita.";


	private String[] resGiorno = {null, null, null, null, null, null, null, null};
	private Orario[] ora;
	private List<Orario> oraArrayList;
	public Prenota_dao() {
		
        this.connector =  new Connector("jdbc:mysql://127.0.0.1:3306/Justthinkit", "root", "password");;
        
	}
	
		
		
	
	
	public String[] visualizza_giorni() {
		
		
	   	String sql = "Select * from giorni order by num_giorno ";
	   	int i = 0;
		ResultSet res = null;
		try (Connection conn = connector.getConnection();
	            PreparedStatement stmt = conn.prepareStatement(sql)) {
	
	           res = stmt.executeQuery();
	           
	
	           
	           while (res.next()) {
	        	   resGiorno[i] = res.getString("Nome");
	        	   i++;
	           }
	       } catch (SQLException ex) {
	           System.out.println(ex.getMessage());
	       } finally {
	           try {
	               if (res != null) res.close();
	           } catch (SQLException e) {
	               System.out.println(e.getMessage());
	           }
	       }
		return resGiorno;
		
		
		
	}
	
	
	
	public Orario[] visualizza_orario() {

		int numRows = 0;

		
		ResultSet res = null;
		try {
			Connection conn = connector.getConnection();

			String sql0 = "Select count(*) from orari ";

			PreparedStatement stmt0 = conn.prepareStatement(sql0);
			ResultSet res0 = null;
			res0 = stmt0.executeQuery();
			if (res0.next()) {
				numRows = res0.getInt("count(*)");
				ora = new Orario[numRows];
				
				
				String sql = "Select ora_inizio, ora_fine from orari ";
				PreparedStatement stmt = conn.prepareStatement(sql);
				res = stmt.executeQuery();

				int i = 0;
				while (res.next()) {
					ora[i] = new Orario(res.getString("ora_inizio"), res.getString("ora_fine"));
					i++;
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				if (res != null)
					res.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return ora;

	}	
	
	public List<Orario> visualizza_orario2() {
		oraArrayList = new ArrayList<Orario>();
		ResultSet res = null;
		try {
			Connection conn = connector.getConnection();

			String sql = "Select ora_inizio, ora_fine from orari ";
			PreparedStatement stmt = conn.prepareStatement(sql);
			res = stmt.executeQuery();

			while (res.next()) {
				oraArrayList.add(new Orario(res.getString("ora_inizio"), res.getString("ora_fine")));
			}
			res.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} 
		
		return oraArrayList;

	}
	
	
	
	public boolean partecipazione_turno(partecipa_turno turno) {
	
    	int rowAffected;
   		ResultSet rs = null;
   		
      	//Registra Caritas
  	    String sql = "call prenota_turno(?,?,?, ?)";

          try (Connection conn = connector.getConnection();
               PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        	  pstmt.setInt(3, turno.getCodice_caritas());
        	  pstmt.setInt(1, turno.getCodice_volontario());
        	  pstmt.setInt(2, turno.getCodice_Turno());
        	  pstmt.setString(4, turno.getCurriculum());
           
          
              rowAffected = pstmt.executeUpdate();

              if (rowAffected == 1) {
                  System.out.println(SUCCESS);
              } else System.out.println(FAILED);


          } catch (SQLException ex) {
              System.out.println((ex.getMessage()));
          }
		    	
   
    	return true;
    	
	}
	
	
	public int trova_turno(Turno turno ) {
		String sql;
		
		int ID = 0;
		
	   	sql = "call trova_id_turno(?,?,?)";
	
		ResultSet res = null;
		try (Connection conn = connector.getConnection();
	            PreparedStatement stmt = conn.prepareStatement(sql)) {
	
	           stmt.setString(1, turno.getGiorno());
	           stmt.setString(2, turno.getOrai());
	           stmt.setString(3, turno.getOraf());
	           res = stmt.executeQuery();
	
	           while (res.next()) {
	        	  ID = res.getInt("id_turno");
	           }
	       } catch (SQLException ex) {
	           System.out.println(ex.getMessage());
	       } finally {
	           try {
	               if (res != null) res.close();
	           } catch (SQLException e) {
	               System.out.println(e.getMessage());
	           }
	       }

		return ID;
		
	}
	
}
