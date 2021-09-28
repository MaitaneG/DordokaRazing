package eus.uni.dam;

public class Produktua {

	private int idProd;
	private String deskripzioa="";
	private String category;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getIdProd() {
		return idProd;
	}
	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}
	public String getDeskripzioa() {
		return deskripzioa;
	}
	public void setDeskripzioa(String deskripzioa) {
		this.deskripzioa = deskripzioa;
	}
	
	public Produktua(int idProd, String deskripzioa) {
		
		this.idProd = idProd;
		this.deskripzioa = deskripzioa;
	}
public Produktua(int idProd, String deskripzioa, String kategoria) {
		this.category = kategoria;
		this.idProd = idProd;
		this.deskripzioa = deskripzioa;
	}
	@Override
	public String toString() {
		return idProd + "garren produktua, Deskripzioa => "+deskripzioa+", Mota: " + category + ".";
	}
	
	
}
