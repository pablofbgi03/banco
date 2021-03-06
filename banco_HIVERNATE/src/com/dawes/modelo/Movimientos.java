package com.dawes.modelo;
// Generated 30-nov-2017 17:42:21 by Hibernate Tools 3.6.0.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Movimientos generated by hbm2java
 */
@Entity
@Table(name = "movimientos", catalog = "banco")
public class Movimientos implements java.io.Serializable {

	private Integer idMovimiento;
	private Cuentas cuentas;
	private Date fecha;
	private String tipo;
	private String concepto;
	private Double importe;

	public Movimientos() {
	}

	public Movimientos(Cuentas cuentas, Date fecha, String tipo, String concepto, Double importe) {
		this.cuentas = cuentas;
		this.fecha = fecha;
		this.tipo = tipo;
		this.concepto = concepto;
		this.importe = importe;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idMovimiento", unique = true, nullable = false)
	public Integer getIdMovimiento() {
		return this.idMovimiento;
	}

	public void setIdMovimiento(Integer idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCuentas")
	public Cuentas getCuentas() {
		return this.cuentas;
	}

	public void setCuentas(Cuentas cuentas) {
		this.cuentas = cuentas;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha", length = 10)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Column(name = "tipo", length = 1)
	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Column(name = "concepto", length = 245)
	public String getConcepto() {
		return this.concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	@Column(name = "importe", precision = 22, scale = 0)
	public Double getImporte() {
		return this.importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

}
