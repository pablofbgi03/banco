/**
 * 
 */
package com.dawes.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dawes.dao.CuentasDAO;
import com.dawes.dao.TitularesDAO;
import com.dawes.dao.TitularescuentaDAO;
import com.dawes.daoImp.MySqlCuentasDAOImp;
import com.dawes.daoImp.MySqlTitularesDAOImp;
import com.dawes.daoImp.MySqlTitularescuentasDAOImp;

/**
 * @author profesor
 *
 */
public class MySqlDAOFactory {

SessionFactory sf;
	
	public MySqlDAOFactory(){
		//recupera la info del fichero de hibernate.cfg.xml y realiza
		//una conexi�n a la bdd y crea una factoria de sesiones
		
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	public CuentasDAO getCuentasDAO() {
		return new MySqlCuentasDAOImp(sf);
	}
	
	public TitularesDAO getTitularesDAO() {
		return new MySqlTitularesDAOImp(sf);
	}
	
	public TitularescuentaDAO getTitCtaDAO() {
		return new MySqlTitularescuentasDAOImp(sf);
	}
}
