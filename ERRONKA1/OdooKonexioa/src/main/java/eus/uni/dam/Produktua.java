package eus.uni.dam;

public class Produktua {

	private int idProd;
	private String deskripzioa = ""; // Aldagaien deklarazioa
	private double kantitatea;
	private double prezioa;
	private String kategoria;

	// Getter eta Setter -ak
	public double getPrezioa() {
		return prezioa;
	}

	public void setPrezioa(double prezioa) {
		this.prezioa = prezioa;
	}

	public String getKategoria() {
		return kategoria;
	}

	public void setKategoria(String kategoria) {
		this.kategoria = kategoria;
	}

	public double getKantitatea() {
		return kantitatea;
	}

	public void setKantitatea(double kantitatea) {
		this.kantitatea = kantitatea;
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

	/**
	 * Produktu klasearen konstruktorea
	 * 
	 * @param idProd
	 * @param deskripzioa
	 * @param kantitatea
	 * @param prezioa
	 * @param kategoria
	 */

	public Produktua(int idProd, String deskripzioa, double kantitatea, double prezioa, String kategoria) {

		this.idProd = idProd;
		this.deskripzioa = deskripzioa;
		this.kantitatea = kantitatea;
		this.prezioa = prezioa;
		this.kategoria = kategoria;
	}

	@Override
	/**
	 * ToString metodoa
	 */
	public String toString() {
		return idProd + ". produktua: " + deskripzioa + ".";
	}

}
