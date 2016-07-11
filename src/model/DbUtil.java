package model;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DbUtil {
private static final EntityManagerFactory emf = 
Persistence.createEntityManagerFactory("Strongheim_test");
	public static EntityManagerFactory getEmFactory() {
		return emf;
	}
}
