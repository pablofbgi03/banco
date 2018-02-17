package com.dawes.service;


import com.dawes.dao.TitularescuentaDAO;
import com.dawes.modelo.Titularescuentas;
import com.dawes.util.MySqlDAOFactory;

public class ServiceTitularescuentasImp implements ServiceTitularescuentas{

	MySqlDAOFactory f;
	TitularescuentaDAO tc;
	
	public ServiceTitularescuentasImp() {
		//instaciamos la factoria = conectamos
		f = new MySqlDAOFactory();
		
		//obetenemos los usuarios existentes
		tc=f.getTitCtaDAO();
	}

	@Override
	public void insertTitCta(Titularescuentas titCta) {
		tc.insertTitCta(titCta);
	}

	@Override
	public void deleteTitCta(Titularescuentas titCta) {
		tc.deleteTitCta(titCta);
	}

	@Override
	public void updateTitCta(Titularescuentas titCta) {
		tc.updateTitCta(titCta);
	}
}
