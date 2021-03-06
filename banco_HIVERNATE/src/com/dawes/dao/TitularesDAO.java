package com.dawes.dao;

import java.util.List;

import com.dawes.modelo.Cuentas;
import com.dawes.modelo.Titulares;

public interface TitularesDAO {
public void insertTitular(Titulares titular);
	
	public void deleteTitular(Titulares titular);
	
	public Titulares getDetalleTitular (String nif);
	
	public List<Titulares> getTitulares();
	
	public void insertCuentaEnTitular(Cuentas cuenta);

}
