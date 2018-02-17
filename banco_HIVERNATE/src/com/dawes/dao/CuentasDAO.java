package com.dawes.dao;

import java.util.Date;
import java.util.List;

import com.dawes.modelo.Cuentas;
import com.dawes.modelo.Movimientos;
import com.dawes.modelo.Titulares;

public interface CuentasDAO {

public void insertCuenta (Cuentas cuenta, Titulares titular);
	
	public void insertMovimientoEnCuenta(Movimientos movimiento);
	
	public void deleteCuenta (Cuentas cuenta);
	
	public List<Cuentas> getCuentas();
	
	public List<Movimientos> getMovimientosEnCuentaEntreFechas(int idCuenta, Date fechaIni, Date fechaFin);
	
	public Cuentas getDetalleCuenta(String numCuenta);
	
	public Movimientos getDetalleMovimientos(int idMovimiento);
//nuevo
	public List<Movimientos> getMovimientosEnCuenta(int idCuenta);
}
