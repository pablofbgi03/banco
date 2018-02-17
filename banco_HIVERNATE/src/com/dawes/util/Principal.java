package com.dawes.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.dawes.modelo.Cuentas;
import com.dawes.modelo.Movimientos;
import com.dawes.modelo.Titulares;
import com.dawes.modelo.Titularescuentas;
import com.dawes.service.ServiceCuentasImp;
import com.dawes.service.ServiceTitularesImp;
import com.dawes.service.ServiceTitularescuentasImp;

public class Principal {
	Scanner teclado = new Scanner(System.in);
	Scanner teclado2 = new Scanner(System.in);

	public void principal()  {
		
		ServiceCuentasImp servC = new ServiceCuentasImp();
		ServiceTitularesImp servT = new ServiceTitularesImp();
		ServiceTitularescuentasImp servTC = new ServiceTitularescuentasImp();
		
		int opcion = 0;

		do {

			do {
			System.out.println("Elige una opci�n:");
			System.out.println("1. Insertar un titular");
			System.out.println("2. Insertar una cuenta y asignarla a un titular existente");
			System.out.println("3. Insertar un movimiento a una cuenta existente");
			System.out.println("4. Eliminar un titular");
			System.out.println("5. Eliminar una cuenta");
			System.out.println("6. Actualizar un movimiento");
			System.out.println("7. Listar todos los movimientos entre fechas de un titular");
			System.out.println("8. Salir");
			
			opcion = teclado.nextInt();
			
		} while (opcion > 8 || opcion < 1);

		switch (opcion) {

		case 1:
			insercionDatosTitular(servT);
			
			break;

		case 2:
			insertarCuentaEnTitular(servC, servT, servTC);
			break;
			
		case 3:
			insertarDatosMovimiento(servC, servT);
			break;
			
		case 4:
			servT.getTitulares();
			
			System.out.println("Introduce el nif del titular que deseas eliminar");
			String nif = teclado.next();
			
			Titulares titular = servT.getDetalleTitular(nif);
			servT.deleteTitular(titular);
			break;
			
		case 5:
			servC.getCuentas();
			
			System.out.println("Introduce el n�mero de cuenta que deseas eliminar");
			String numCuenta = teclado.next();
			
			Cuentas c = servC.getDetalleCuenta(numCuenta);
			
			servC.deleteCuenta(c);
			break;
		
		case 6:
			informacionActualizarMovimiento(servC);
			break;
			
		case 7:
			servT.getTitulares();
			
			System.out.println("Introduce el nif del titular");
			String nif2 = teclado.next();
			
			System.out.println("Introduce la fecha de inicio de la consulta");
			String fechaI = teclado.next();
			
			System.out.println("Introduce la fecha de fin de la consulta");
			String fechaF = teclado.next();
			
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			Date fechaIni = null;
			Date fechaFin = null;
			
			try {
				fechaIni = df.parse(fechaI);
				fechaFin = df.parse(fechaF);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			Titulares titular2 = servT.getDetalleTitular(nif2);
			
			for (Titularescuentas titCta : titular2.getTitularescuentases() ){
				System.out.println(titCta.getCuentas().getMovimientoses());
			}
			break;
			
		case 8:
			break;
			
		}
	} while (opcion != 8);
}


	private void insertarCuentaEnTitular(ServiceCuentasImp servC, ServiceTitularesImp servT,
			ServiceTitularescuentasImp servTC) {
		servT.getTitulares();
		
		System.out.println("Introduce el nif del titular");
		String niff = teclado.next();
		
		System.out.println("Introduce el n�mero de la cuenta");
		String nummCuenta = teclado.next();
		teclado.nextLine();
		
		System.out.println("Introduce el saldo de la cuenta");
		Double saldo = teclado.nextDouble();
		teclado.nextLine();
		
		Titulares t = servT.getDetalleTitular(niff);
		Cuentas cuenta = new Cuentas(nummCuenta, saldo,new Date(), null, null);
		
		Titularescuentas tc = new Titularescuentas(cuenta, t, new Date());
		t.addTitularescuentas(tc);
		servC.insertCuenta(cuenta, t);
		servTC.insertTitCta(tc);
	}


	private void informacionActualizarMovimiento(ServiceCuentasImp servC) {
		servC.getCuentas();
		
		System.out.println("Introduce el n�mero de cuenta para ver los movimientos");
		String numCuenta = teclado.next();
		
		Cuentas cuenta = servC.getDetalleCuenta(numCuenta);
		
		System.out.println("Movimientos: ");
		System.out.println(cuenta.getMovimientoses());
		
		System.out.println("Selecciona el movimiento que deseas actualizar (idMovimiento)");
		int idMov = teclado.nextInt();
		
		Movimientos movimiento = servC.getDetalleMovimientos(idMov);
		
		System.out.println("Introduce el mismo o el nuevo valor de la fecha (dd/mm/yyyy)");
		String nuevaFecha = teclado.next();
		
		System.out.println("Introduce el mismo o el nuevo valor del tipo");
		String nTipo = teclado.next();
		
		System.out.println("Introduce el mismo o el nuevo valor del concepto");
		String nConcepto = teclado.next();
		
		System.out.println("Introduce el mismo o el nuevo valor del importe");
		double nImporte = teclado.nextDouble();
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date nFecha = null;
		try {
			nFecha = df.parse(nuevaFecha);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		movimiento.setFecha(nFecha);
		movimiento.setTipo(nTipo);
		movimiento.setConcepto(nConcepto);
		movimiento.setImporte(nImporte);
		
		servC.insertMovimientoEnCuenta(movimiento);
	}


	private void insertarDatosMovimiento(ServiceCuentasImp servC, ServiceTitularesImp servT) {
		servC.getCuentas();
		
		System.out.println("Introduce el n�mero de cuenta");
		String numCuenta = teclado.next();
		
		System.out.println("Introduce el tipo del movimiento (I/R)");
		String tipo = teclado.next();
		teclado.nextLine();
		
		System.out.println("Introduce el concepto del movimiento");
		String concepto = teclado.next();
		teclado.nextLine();
		
		System.out.println("Introduce el importe del movimiento");
		double importe = teclado.nextDouble();
		teclado.nextLine();
		
		Cuentas c =servC.getDetalleCuenta(numCuenta);
		
		//creo un correo que quiero a�adir al usuario
		Movimientos mo = new Movimientos(c, new Date(), tipo, concepto, importe);
		//Actualizo la coleccion de corrreos de ese usuario
		c.addMovimientos(mo);
		//persisto el correo
		servC.insertMovimientoEnCuenta(mo);
		
		double importeCuenta = c.getSaldo();
		
		String opIngreso = "I";
		String opReintegro = "R";
		
		if (opIngreso.equals(tipo)){
			double suma = importeCuenta + importe;
			c.setSaldo(suma);
			servT.insertCuentaEnTitular(c);
		}else if (opReintegro.equals(tipo)){
			double resta = importeCuenta - importe;
			c.setSaldo(resta);
			servT.insertCuentaEnTitular(c);
		}
		
	}


	private void insercionDatosTitular(ServiceTitularesImp servT) {
		System.out.println("Introduce el nombre del titular");
		String nombre = teclado.next();
		teclado.nextLine();
		
		System.out.println("Introduce el apellido del titular");
		String apellido = teclado.next();
		teclado.nextLine();
		
		System.out.println("Introduce la direcci�n del titular");
		String direccion = teclado.nextLine();
		
		System.out.println("Introduce la poblaci�n del titular");
		String poblacion = teclado.next();
		teclado.nextLine();
		
		System.out.println("Introduce el nif del titular");
		String nif = teclado.next();
		teclado.nextLine();
		
		System.out.println("Introduce la fecha de nacimiento del titular(dd/mm/yyyy)");
		String fechaNacimiento = teclado.next();
		teclado.nextLine();
		
		System.out.println("Introduce el cr�dito del titular");
		Double credito = teclado.nextDouble();
		
		//Se pasa el String a formato Date. 
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaNaci = null;
		
		try{
		    fechaNaci = df.parse(fechaNacimiento);
		    Titulares titular = new Titulares(nombre,apellido,direccion,poblacion,
					nif,fechaNaci,credito,null);
		servT.insertTitular(titular);
		System.out.println("Inserci�n correcta");
		} catch (Exception e){ 
			System.out.println("invalid format");
		}
	}
	
	
	public static void main(String[] args) {
		 
        Principal p = new Principal();
        p.principal();

	}
}
