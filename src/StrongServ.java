

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DbStrongheim;
import model.Report;
import model.Strongheim;

/**
 * Servlet implementation class StrongServ
 */
@WebServlet("/StrongServ")
public class StrongServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public StrongServ() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("-----------------------------------");
		List<Object[]> rpt = DbStrongheim.StrongheimAverages();
	
	for (Object[] r: rpt){
		System.out.print(r[0].toString());
		System.out.print("\t");
		System.out.print(r[1].toString());
		System.out.print("\t");
		System.out.print(r[2].toString());
		System.out.print("\t");
		System.out.println(r[3].toString());
	}
	System.out.println("finish");
	}
}
