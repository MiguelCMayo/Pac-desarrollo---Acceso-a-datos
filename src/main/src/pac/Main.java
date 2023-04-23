package pac;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Main{

	public static void main(String[] args)  {
		
		//Conexion con Hibernate
		System.out.println("INICIO DE PROGRAMA...");
		Configuration cfg = new Configuration();
		SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder()
																	.configure()
																	.build());
		Session session = sessionFactory.openSession();
		System.out.println("CONFIGURACION REALIZADA");
	
		//Procedimientos que realizan los inserts de modulos, profesor y alumnos
		meterModulos(session);
		meterProfesor(session);
		meterAlumnos(session);
		
		//Cierre de sesiones
		session.close();
		sessionFactory.close();
	        
	}
	
	//Este procedimiento crea objetos de la clase Modulo y los guarda en una base de datos usando la biblioteca Hibernate
	public static void meterModulos(Session session){
		Modulo modulo1 = new Modulo("programacion B", "M03B");
	    Modulo modulo2 = new Modulo("Acceso a Datos", "M06");
	    Modulo modulo3 = new Modulo("Desarrollo de interfaces", "M07");
	    Modulo modulo4 = new Modulo("Proyecto DAM", "M13");
	    
	    Transaction tx = session.beginTransaction();
	    session.save(modulo1);
	    session.save(modulo2);
	    session.save(modulo3);
	    session.save(modulo4);
	    tx.commit();
	    
	    System.out.println(modulo1.toString());
	    System.out.println(modulo2.toString());
	    System.out.println(modulo3.toString());
	    System.out.println(modulo4.toString());
	}
	
	//Este procedimiento crea objetos de la clase Profesor y los guarda en una base de datos usando la biblioteca Hibernate
	public static void meterProfesor(Session session){
		Profesor profesor = new Profesor("Hassabis", "Mujer");
	    
		Transaction tx = session.beginTransaction();
	    session.save(profesor);
	    tx.commit();
	    
	    System.out.println(profesor.toString());
	}
	
	//Este procedimiento crea objetos de la clase Alumnos y los guarda en una base de datos usando la biblioteca Hibernate
	public static void meterAlumnos(Session session){
		Modulo modulo1 = session.get(Modulo.class, 1L);
	    Modulo modulo2 = session.get(Modulo.class, 2L);
	    Modulo modulo3 = session.get(Modulo.class, 3L);
	    Modulo modulo4 = session.get(Modulo.class, 4L);
	    
	    Set<Modulo> alumno1_modulos = new HashSet<Modulo>();
	    alumno1_modulos.add(modulo1);
	    alumno1_modulos.add(modulo2);
	    alumno1_modulos.add(modulo3);
	    alumno1_modulos.add(modulo4);
	    Alumno alumno1 = new Alumno("Sandberg", "USA", 26, "Mujer", alumno1_modulos);
	    
	    
	    Set<Modulo> alumno2_modulos = new HashSet<Modulo>();
	    alumno2_modulos.add(modulo1);
	    alumno2_modulos.add(modulo2);
	    alumno2_modulos.add(modulo3);
	    Alumno alumno2 = new Alumno("Fei-Fei Li", "China", 21, "Mujer", alumno2_modulos);
	    
	    Set<Modulo> alumno3_modulos = new HashSet<Modulo>();
	    alumno3_modulos.add(modulo3);
	    alumno3_modulos.add(modulo4);
	    Alumno alumno3 = new Alumno("Sohpie Wilson", "Reino Unido", 19, "Mujer", alumno3_modulos);
	    
	    Set<Modulo> alumno4_modulos = new HashSet<Modulo>();
	    alumno4_modulos.add(modulo2);
	    alumno4_modulos.add(modulo3);
	    alumno4_modulos.add(modulo4);
	    Alumno alumno4 = new Alumno("Aya Soffer", "Israel", 35, "Mujer", alumno4_modulos);
	    
	    Transaction tx = session.beginTransaction();
	    session.save(alumno1);
	    session.save(alumno2);
	    session.save(alumno3);
	    session.save(alumno4);
	    tx.commit();
	    
	    System.out.println(alumno1.toString());
	    System.out.println(alumno2.toString());
	    System.out.println(alumno3.toString());
	    System.out.println(alumno4.toString());
	}
}
