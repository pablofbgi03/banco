package com.dawes.service;

import java.util.Date;
import java.util.List;

import com.dawes.modelo.Cuentas;
import com.dawes.modelo.Movimientos;
import com.dawes.modelo.Titulares;

public interface ServiceCuentas {
public void insertCuenta (Cuentas cuenta, Titulares titular);
	
	public void insertMovimientoEnCuenta(Movimientos movimiento);
	
	public void deleteCuenta (Cuentas cuenta);
	
	public List<Movimientos> getMovimientosEnCuenta(int idCuenta);
	
	public List<Movimientos> getMovimientosEnCuentaEntreFechas(int idCuenta, Date fechaIni, Date fechaFin);
	
	public Cuentas getDetalleCuenta(String numCuenta);
	
	public Cuentas getDetalleCuenta(int idCuenta);
	
	public List<Cuentas> getCuentas();
	
	public Movimientos getDetalleMovimientos(int idMovimiento);
}
