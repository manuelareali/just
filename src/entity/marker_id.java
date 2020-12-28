package entity;




import com.sothawo.mapjfx.Marker;




public class marker_id{
	private Marker[] markerCarita = {null,null,null,null,null,null,null};
	private int id[] = {0,0,0,0,0,0,0,0};
	
	
	public marker_id(Marker[] caritas, int id_caritas[]) {
		this.markerCarita = caritas;
		this.id = id_caritas;
		
		
	}
	public marker_id() {
		Marker[] markerCarita = {null,null,null,null,null,null,null};
		int id[] = {0,0,0,0,0,0,0,0};
	}
	


	public  int[] id_marker(int i) {
		
		return this.id;
	}
	
	public Marker  getMarker(int i) {
		return this.markerCarita[i];
	}
	
	
   public void setMarker(int i, Marker nuovo) {
		this.markerCarita[i] = nuovo;
	}

  public  void setID(int i, int nuovoi) {
	  this.id[i]= nuovoi;
  }


	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}
    
    
    
    
};


