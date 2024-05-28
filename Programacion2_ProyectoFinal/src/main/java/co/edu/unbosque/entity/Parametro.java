package co.edu.unbosque.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * The persistent class for the parametro database table.
 * 
 */
@Entity
@Table(name = "parametro")
public class Parametro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "estado")
	private String estado;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
	@Column(name = "fcha_final")
	private Date fchaFinal;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
	@Column(name = "fcha_inicial")
	private Date fchaInicial;

	@Column(name = "valor_numero")
	private int valorNumero;

	@Column(name = "valor_texto")
	private String valorTexto;

	public Parametro() {
	}

	public Parametro(Long id, String descripcion, String estado, Date fchaFinal, Date fchaInicial, int valorNumero,
			String valorTexto) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.estado = estado;
		this.fchaFinal = fchaFinal;
		this.fchaInicial = fchaInicial;
		this.valorNumero = valorNumero;
		this.valorTexto = valorTexto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFchaFinal() {
		return fchaFinal;
	}

	public void setFchaFinal(Date fchaFinal) {
		this.fchaFinal = fchaFinal;
	}

	public Date getFchaInicial() {
		return fchaInicial;
	}

	public void setFchaInicial(Date fchaInicial) {
		this.fchaInicial = fchaInicial;
	}

	public int getValorNumero() {
		return valorNumero;
	}

	public void setValorNumero(int valorNumero) {
		this.valorNumero = valorNumero;
	}

	public String getValorTexto() {
		return valorTexto;
	}

	public void setValorTexto(String valorTexto) {
		this.valorTexto = valorTexto;
	}

}