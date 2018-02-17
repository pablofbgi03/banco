package com.dawes.daoImp;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;

import com.dawes.dao.TitularesDAO;
import com.dawes.modelo.Cuentas;
import com.dawes.modelo.Titulares;

public class MySqlTitularesDAOImp implements TitularesDAO{

	SessionFactory sf;
	
	public MySqlTitularesDAOImp (SessionFactory sf){
		this.sf=sf;
	}

	@Override
	public void insertTitular(Titulares titular) {
		sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().save(titular);
		sf.getCurrentSession().getTransaction().commit();
	}

	@Override
	public void deleteTitular(Titulares titular) {
		sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().delete(titular);
		sf.getCurrentSession().getTransaction().commit();
	}

	@Override
	public Titulares getDetalleTitular(String nif) {
		sf.getCurrentSession().beginTransaction();
		Query q = sf.getCurrentSession().createQuery("select t from Titulares t where nif=:nif");
		q.setParameter("nif", nif);
		Titulares t = (Titulares) q.getSingleResult();
		sf.getCurrentSession().getTransaction().commit();
		
		return t;
	}

	@Override
	public List<Titulares> getTitulares() {
		sf.getCurrentSession().beginTransaction();
		Query q = sf.getCurrentSession().createQuery("SELECT t FROM Titulares t");
		List<Titulares> lista=q.getResultList();
		sf.getCurrentSession().getTransaction().commit();
		
		for (Titulares t: lista){
			System.out.println("Id: "+t.getIdTitular()+" Nif: "+t.getNif() + " Nombre: "+t.getNombre());
		}
		return lista;
	}

	@Override
	public void insertCuentaEnTitular(Cuentas cuenta) {
		sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().saveOrUpdate(cuenta);
		sf.getCurrentSession().getTransaction().commit();
	}

}
