package entities;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ExceptionLogs")
public class ExceptionLog extends PersistentObject {
	private static final long serialVersionUID = 1L;

	@Column(name = "tipo")
	private String tipo;
	@Column(name = "mensaje")
	private String mensaje;
	@Column(name = "stack_trace")
	private String stackTrace;
	@Column(name = "fecha")
	private Date fecha;

	public ExceptionLog() {

	}

	public ExceptionLog(Exception e) {
		tipo = e.getClass().getName();
		mensaje = e.getMessage();
		stackTrace = getStackTraceString(e);
		fecha = new Date();
	}

	private String getStackTraceString(Exception e) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		return sw.toString();
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
