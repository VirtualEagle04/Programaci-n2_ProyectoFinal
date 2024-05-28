package co.edu.unbosque.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;

/**
 * The persistent class for the transaccion database table.
 * 
 */
@Entity
@Table(name = "transaccion")
public class Transaccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_hora")
	private Date fechaHora;

	@Column(name = "usuario")
	private String usuario;

	@Column(name = "id_producto")
	private int idProducto;

	@Column(name = "cant_comprada")
	private int cantComprada;

	@Column(name = "valor_unitario")
	private int valorUnitario;

	@Column(name = "id_tipo_pago")
	private short idTipoPago;

	@Column(name = "id_banco")
	private short idBanco;

	@Column(name = "id_franquicia")
	private short idFranquicia;

	@Column(name = "num_tarjeta")
	private String numTarjeta;

	@Column(name = "estado")
	private String estado;

	public Transaccion() {
	}

	public Transaccion(int id, Date fechaHora, String usuario, int idProducto, int cantComprada, int valorUnitario,
			short idTipoPago, short idBanco, short idFranquicia, String numTarjeta, String estado) {
		super();
		this.id = id;
		this.fechaHora = fechaHora;
		this.usuario = usuario;
		this.idProducto = idProducto;
		this.cantComprada = cantComprada;
		this.valorUnitario = valorUnitario;
		this.idTipoPago = idTipoPago;
		this.idBanco = idBanco;
		this.idFranquicia = idFranquicia;
		this.numTarjeta = numTarjeta;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getCantComprada() {
		return cantComprada;
	}

	public void setCantComprada(int cantComprada) {
		this.cantComprada = cantComprada;
	}

	public int getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(int valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public short getIdTipoPago() {
		return idTipoPago;
	}

	public void setIdTipoPago(short idTipoPago) {
		this.idTipoPago = idTipoPago;
	}

	public short getIdBanco() {
		return idBanco;
	}

	public void setIdBanco(short idBanco) {
		this.idBanco = idBanco;
	}

	public short getIdFranquicia() {
		return idFranquicia;
	}

	public void setIdFranquicia(short idFranquicia) {
		this.idFranquicia = idFranquicia;
	}

	public String getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}