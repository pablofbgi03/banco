package com.dawes.service;

import java.util.List;

import com.dawes.dao.TitularesDAO;
import com.dawes.modelo.Cuentas;
import com.dawes.modelo.Titulares;
import com.dawes.util.MySqlDAOFactory;

public class ServiceTitularesImp implements ServiceTitulares {

	MySqlDAOFactory f;
	TitularesDAO t;
	
	public ServiceTitularesImp() {
		//instaciamos la factoria = conectamos
		f = new MySqlDAOFactory();
		
		//obetenemos los usuarios existentes
		t=f.getTitularesDAO();
	}

	@Override
	public void insertTitular(Titulares titular) {
		t.insertTitular(titular);
	}

	@Override
	public void deleteTitular(Titulares titular) {
		t.deleteTitular(titular);
	}

	@Override
	public Titulares getDetalleTitular(String nif) {
		return t.getDetalleTitular(nif);
	}

	@Override
	public List<Titulares> getTitulares() {
		return t.getTitulares();
	}

	@Override
	public void insertCuentaEnTitular(Cuentas cuenta) {
		t.insertCuentaEnTitular(cuenta);
	}

}
