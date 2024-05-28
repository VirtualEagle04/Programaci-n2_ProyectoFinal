package co.edu.unbosque.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@Table(name = "producto")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "id_categoria")
	private short idCategoria;

	@Column(name = "codigo")
	private String codigo;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "existencia")
	private int existencia;

	@Column(name = "precio_venta_actual")
	private BigDecimal precioVentaActual;

	@Column(name = "precio_venta_anterior")
	private BigDecimal precioVentaAnterior;

	@Column(name = "costo_venta")
	private BigDecimal costoVenta;

	@Column(name = "margen_utilidad")
	private double margenUtilidad;

	@Column(name = "tiene_iva")
	private String tieneIva;

	@Column(name = "stock_minimo")
	private int stockMinimo;

	@Column(name = "stock_maximo")
	private int stockMaximo;

	@Column(name = "estado")
	private String estado;

	public Producto() {
	}

	public Producto(short id, short idCategoria, String codigo, String descripcion, int existencia,
			BigDecimal precioVentaActual, BigDecimal precioVentaAnterior, BigDecimal costoVenta, double margenUtilidad,
			String tieneIva, int stockMinimo, int stockMaximo, String estado) {
		super();
		this.id = id;
		this.idCategoria = idCategoria;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.existencia = existencia;
		this.precioVentaActual = precioVentaActual;
		this.precioVentaAnterior = precioVentaAnterior;
		this.costoVenta = costoVenta;
		this.margenUtilidad = margenUtilidad;
		this.tieneIva = tieneIva;
		this.stockMinimo = stockMinimo;
		this.stockMaximo = stockMaximo;
		this.estado = estado;
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public short getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(short idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getExistencia() {
		return existencia;
	}

	public void setExistencia(int existencia) {
		this.existencia = existencia;
	}

	public BigDecimal getPrecioVentaActual() {
		return precioVentaActual;
	}

	public void setPrecioVentaActual(BigDecimal precioVentaActual) {
		this.precioVentaActual = precioVentaActual;
	}

	public BigDecimal getPrecioVentaAnterior() {
		return precioVentaAnterior;
	}

	public void setPrecioVentaAnterior(BigDecimal precioVentaAnterior) {
		this.precioVentaAnterior = precioVentaAnterior;
	}

	public BigDecimal getCostoVenta() {
		return costoVenta;
	}

	public void setCostoVenta(BigDecimal costoVenta) {
		this.costoVenta = costoVenta;
	}

	public double getMargenUtilidad() {
		return margenUtilidad;
	}

	public void setMargenUtilidad(double margenUtilidad) {
		this.margenUtilidad = margenUtilidad;
	}

	public String getTieneIva() {
		return tieneIva;
	}

	public void setTieneIva(String tieneIva) {
		this.tieneIva = tieneIva;
	}

	public int getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}

	public int getStockMaximo() {
		return stockMaximo;
	}

	public void setStockMaximo(int stockMaximo) {
		this.stockMaximo = stockMaximo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}