package co.edu.unbosque.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;

/**
 * The persistent class for the auditoria database table.
 * 
 */
@Entity
@Table(name = "auditoria")
public class Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fcha_audtria")
	private Date fchaAudtria;

	@Column(name = "usrio_audtria")
	private String usrioAudtria;

	@Column(name = "accion_audtria")
	private String accionAudtria;

	@Column(name = "comentario_audtria")
	private String comentarioAudtria;

	@Column(name = "address_audtria")
	private String addressAudtria;

	public Auditoria() {
	}

	public Auditoria(Long id, Date fchaAudtria, String usrioAudtria, String accionAudtria, String comentarioAudtria,
			String addressAudtria) {
		super();
		this.id = id;
		this.fchaAudtria = fchaAudtria;
		this.usrioAudtria = usrioAudtria;
		this.accionAudtria = accionAudtria;
		this.comentarioAudtria = comentarioAudtria;
		this.addressAudtria = addressAudtria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFchaAudtria() {
		return fchaAudtria;
	}

	public void setFchaAudtria(Date fchaAudtria) {
		this.fchaAudtria = fchaAudtria;
	}

	public String getUsrioAudtria() {
		return usrioAudtria;
	}

	public void setUsrioAudtria(String usrioAudtria) {
		this.usrioAudtria = usrioAudtria;
	}

	public String getAccionAudtria() {
		return accionAudtria;
	}

	public void setAccionAudtria(String accionAudtria) {
		this.accionAudtria = accionAudtria;
	}

	public String getComentarioAudtria() {
		return comentarioAudtria;
	}

	public void setComentarioAudtria(String comentarioAudtria) {
		this.comentarioAudtria = comentarioAudtria;
	}

	public String getAddressAudtria() {
		return addressAudtria;
	}

	public void setAddressAudtria(String addressAudtria) {
		this.addressAudtria = addressAudtria;
	}

}