package com.dawes.daoImp;

import org.hibernate.SessionFactory;


import com.dawes.dao.TitularescuentaDAO;
import com.dawes.modelo.Titularescuentas;

public class MySqlTitularescuentasDAOImp implements TitularescuentaDAO{

	SessionFactory sf;
	
	public MySqlTitularescuentasDAOImp (SessionFactory sf){
		this.sf=sf;
	}

	@Override
	public void insertTitCta(Titularescuentas titCta) {
		sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().save(titCta);
		sf.getCurrentSession().getTransaction().commit();
	}

	@Override
	public void deleteTitCta(Titularescuentas titCta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTitCta(Titularescuentas titCta) {
		// TODO Auto-generated method stub
		
	}
}
