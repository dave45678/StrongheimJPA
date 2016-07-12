package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Strongheim;

public class DbStrongheim {

	public static void insert(Strongheim Strongheim) {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(Strongheim);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void update(Strongheim Strongheim) {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(Strongheim);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void delete(Strongheim Strongheim) {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.remove(em.merge(Strongheim));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static List<Strongheim> StrongheimSummary (){
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		String qString = "select b from Strongheim b";
		
		List<Strongheim> posts = null;
		try{
			TypedQuery<Strongheim> query = em.createQuery(qString,Strongheim.class);
			posts = query.getResultList();

		}catch (Exception e){
			e.printStackTrace();
		}
		finally{
				em.close();
			}
		return posts;
	}
/*	
	public static List<Report> StrongheimAverages(){
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		String qString = "select AVG(b.assignmentgrade) as assignmentgrade,b.assignmenttype from Strongheim b group by b.assignmenttype";
		
		List<Report> report = null;
		try{
			TypedQuery<Report> query = em.createQuery(qString,Report.class);
			report = query.getResultList();

		}catch (Exception e){
			e.printStackTrace();
		}
		finally{
				em.close();
			}
		return report;
	}
*/
	/**
	 * The result type of the SELECT clause is defined by the the result types
	 * of the select_expressions contained in it. When multiple 
	 * select_expressions are used in the SELECT clause, the result of the 
	 * query is of type Object[], and the elements in this result 
	 * correspond in order to the order of their specification in the 
	 * SELECT clause and in type to the result types of each of 
	 * the select_expressions.
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<Object[]> StrongheimAverages(){
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		String qString = "select MIN(b.assignmentgrade),MAX(b.assignmentgrade), AVG(b.assignmentgrade) as assignmentgrade,b.assignmenttype from Strongheim b group by b.assignmenttype";
		
		List<Object[]> report = null;
		try{
			report = em.createQuery(qString).getResultList();

		}catch (Exception e){
			e.printStackTrace();
		}
		finally{
				em.close();
		}
		return report;
	}	
	
	
	
	public static List<Strongheim> postsofUser(long userid)
	{
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		List<Strongheim> userposts = null;
		String qString = "select b from Strongheim b where b.bhuser.bhuserid = :userid";
		
		try{
			TypedQuery<Strongheim> query = em.createQuery(qString,Strongheim.class);
			query.setParameter("userid", userid);
			userposts = query.getResultList();
		}catch (Exception e){
			e.printStackTrace();
		}
		finally{
				em.close();
			}
		return userposts;	
	}
	public static List<Strongheim> postsofUser(String useremail)
	{
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		List<Strongheim> userposts = null;
		String qString = "select b from Strongheim b "
				+ "where b.bhuser.useremail = :useremail";
		
		try{
			TypedQuery<Strongheim> query = em.createQuery(qString,Strongheim.class);
			query.setParameter("useremail", useremail);
			userposts = query.getResultList();
		}catch (Exception e){
			e.printStackTrace();
		}
		finally{
				em.close();
			}
		return userposts;	
	}
	
	public static List<Strongheim> searchPosts (String search)
	{
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		List<Strongheim> searchposts = null;
		String qString = "select b from Strongheim b "
				+ "where b.posttext like :search";
		
		try{
			TypedQuery<Strongheim> query = em.createQuery(qString,Strongheim.class);
			query.setParameter("search", "%" + search + "%");
			searchposts = query.getResultList();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			em.close();
		}return searchposts;
	}
	
}