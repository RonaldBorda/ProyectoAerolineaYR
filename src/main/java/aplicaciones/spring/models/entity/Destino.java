package aplicaciones.spring.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="destino")
public class Destino implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_des")
	private long id;
	private String departamiento;
	private String aeropuerto;
	@Column(name="codigo_aer")
	private String aerolinea;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDepartamiento() {
		return departamiento;
	}
	public void setDepartamiento(String departamiento) {
		this.departamiento = departamiento;
	}
	public String getAeropuerto() {
		return aeropuerto;
	}
	public void setAeropuerto(String aeropuerto) {
		this.aeropuerto = aeropuerto;
	}
	public String getAerolinea() {
		return aerolinea;
	}
	public void setAerolinea(String aerolinea) {
		this.aerolinea = aerolinea;
	}
	@Override
	public String toString() {
		return "Destino [id=" + id + ", departamiento=" + departamiento + ", aeropuerto=" + aeropuerto + ", aerolinea="
				+ aerolinea + "]";
	}
	
	
}
