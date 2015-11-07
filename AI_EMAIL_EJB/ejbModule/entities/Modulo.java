package entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Modulos")
public class Modulo extends PersistentObject {

	@Enumerated (EnumType.STRING)
	private Modulos modulo;
	private String ip;
	private String port;
	private String cola;
	private boolean activo;

	public Modulo() {

	}

	public Modulo(Modulos modulo, String ip, String port, String cola) {

		this.modulo = modulo;
		this.ip = ip;
		this.port = port;
		this.cola = cola;
		this.activo = true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Modulos getmodulo() {
		return modulo;
	}

	public void setmodulo(Modulos modulo) {
		this.modulo = modulo;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getCola() {
		return cola;
	}

	public void setCola(String cola) {
		this.cola = cola;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
