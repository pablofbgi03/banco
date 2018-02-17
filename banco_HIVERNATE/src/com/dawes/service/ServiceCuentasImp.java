package com.dawes.service;

import java.util.Date;
import java.util.List;

import com.dawes.dao.CuentasDAO;
import com.dawes.modelo.Cuentas;
import com.dawes.modelo.Movimientos;
import com.dawes.modelo.Titulares;
import com.dawes.util.MySqlDAOFactory;

public class ServiceCuentasImp implements ServiceCuentas{
	
	MySqlDAOFactory f;
	CuentasDAO c;
	
	public ServiceCuentasImp() {
		//instaciamos la factoria = conectamos
		f = new MySqlDAOFactory();
		
		//obetenemos los usuarios existentes
		c=f.getCuentasDAO();
	}

	@Override
	public void insertCuenta(Cuentas cuenta, Titulares titular) {
		c.insertCuenta(cuenta, titular);
	}

	@Override
	public void insertMovimientoEnCuenta(Movimientos movimiento) {
		c.insertMovimientoEnCuenta(movimiento);
	}

	@Override
	public void deleteCuenta(Cuentas cuenta) {
		c.deleteCuenta(cuenta);
	}

	@Override
	public List<Movimientos> getMovimientosEnCuenta(int idCuenta) {
		return c.getMovimientosEnCuenta(idCuenta);
	}

	@Override
	public Cuentas getDetalleCuenta(String numCuenta) {
		return c.getDetalleCuenta(numCuenta);
	}

	@Override
	public List<Cuentas> getCuentas() {
		return c.getCuentas();
	}

	@Override
	public Cuentas getDetalleCuenta(int idCuenta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movimientos getDetalleMovimientos(int idMovimiento) {
		return c.getDetalleMovimientos(idMovimiento);
	}

	@Override
	public List<Movimientos> getMovimientosEnCuentaEntreFechas(int idCuenta, Date fechaIni, Date fechaFin) {
		return c.getMovimientosEnCuentaEntreFechas(idCuenta, fechaIni, fechaFin);
	}

}
