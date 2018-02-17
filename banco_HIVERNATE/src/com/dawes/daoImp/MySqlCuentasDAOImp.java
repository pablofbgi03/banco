package com.dawes.daoImp;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.*;

import com.dawes.dao.CuentasDAO;
import com.dawes.modelo.Cuentas;
import com.dawes.modelo.Movimientos;
import com.dawes.modelo.Titulares;

public class MySqlCuentasDAOImp implements CuentasDAO{
SessionFactory sf;
	
	public MySqlCuentasDAOImp (SessionFactory sf){
		this.sf=sf;
	}

	@Override
	public void insertCuenta(Cuentas cuenta, Titulares titular){
		sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().save(cuenta);
		sf.getCurrentSession().getTransaction().commit();
	}

	@Override
	public void insertMovimientoEnCuenta(Movimientos movimiento) {
		sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().saveOrUpdate(movimiento);
		sf.getCurrentSession().getTransaction().commit();
	}

	@Override
	public void deleteCuenta(Cuentas cuenta) {
		sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().delete(cuenta);
		sf.getCurrentSession().getTransaction().commit();
	}

	@Override
	public List<Movimientos> getMovimientosEnCuenta(int idCuenta) {
		sf.getCurrentSession().beginTransaction();
		Query q = sf.getCurrentSession().createQuery("select c from Cuentas c where idCuenta=:idCuenta");
		q.setParameter("idCuenta", idCuenta);
		List<Movimientos> listaMovimientos=q.getResultList();
		sf.getCurrentSession().getTransaction().commit();
		
		return listaMovimientos;
	}

	@Override
	public List<Cuentas> getCuentas() {
		sf.getCurrentSession().beginTransaction();
		Query q = sf.getCurrentSession().createQuery("SELECT c FROM Cuentas c");
		List<Cuentas> lista=q.getResultList();
		sf.getCurrentSession().getTransaction().commit();
		
		for (Cuentas c: lista){
			System.out.println("Num. Cuenta: "+c.getNumCuenta() + " Saldo: "+c.getSaldo());
		}
		return lista;
	}
	
	@Override
	public Cuentas getDetalleCuenta(String numCuenta) {
		sf.getCurrentSession().beginTransaction();
		Query q = sf.getCurrentSession().createQuery("select c from Cuentas c where numCuenta=:numCuenta");
		q.setParameter("numCuenta", numCuenta);
		Cuentas c = (Cuentas) q.getSingleResult();
		sf.getCurrentSession().getTransaction().commit();
		
		return c;
	}

	@Override
	public Movimientos getDetalleMovimientos(int idMovimiento) {
		sf.getCurrentSession().beginTransaction();
		Query q = sf.getCurrentSession().createQuery("select m from Movimientos m where idMovimiento=:idMovimiento");
		q.setParameter("idMovimiento", idMovimiento);
		Movimientos m = (Movimientos) q.getSingleResult();
		sf.getCurrentSession().getTransaction().commit();
		
		return m;
	}

	@Override
	public List<Movimientos> getMovimientosEnCuentaEntreFechas(int idCuenta, Date fechaIni, Date fechaFin) {
		sf.getCurrentSession().beginTransaction();
		Query q = sf.getCurrentSession().createQuery("select m from Movimientos m where idCuenta=:idcuenta AND"
				+ " fecha between fechaIni AND fechaFin");
		q.setParameter("idCuenta", idCuenta);
		q.setParameter("fechaIni", fechaIni);
		q.setParameter("fechaFin", fechaFin);
		List<Movimientos> listaMovimientos=q.getResultList();
		sf.getCurrentSession().getTransaction().commit();
		
		return listaMovimientos;
	}

}
