package UnitTests;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Test;

import model.DbStrongheim;
import model.DbUtil;
import model.Myview;
import model.Strongheim;

public class StrongheimIdentityInsert {

	@Test
	public void test() {
		Strongheim s = new Strongheim();
		String student = "Jack";
		s.setStudent(student);
		BigDecimal assignmentgrade= new BigDecimal(98);
		s.setAssignmentgrade(assignmentgrade);
		String assignmenttype = "quiz";
		s.setAssignmenttype(assignmenttype);
		DbStrongheim.insert(s);
	}
	@Test
	public void test2(){
		model.Myview t = new model.Myview();
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		List<Myview> averages = null;
		String qString = "select a from Myview a order by a.average desc";
		
		try{
			TypedQuery<Myview> query = em.createQuery(qString,Myview.class);
			averages = query.getResultList();
		}catch (Exception e){
			e.printStackTrace();
		}
		finally{
				em.close();
			}
		for (Myview tbl: averages){
			System.out.print(tbl.getStudent());
			System.out.print("\t");
			System.out.print(tbl.getAverage());
			System.out.print("\n");
		}
	}

}
