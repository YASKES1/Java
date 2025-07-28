package simple.eclipse.web.program;
//wskazuje problem podczas wykonywania operacji wejścia/wyjścia (I/O)
import java.io.IOException;
// zawiera dodatkowe informacje związane z awariami, 
//które występują w kontekście bazy danych
import java.sql.SQLException;

import java.util.List;
//możliwość wysyłąnia żądanie do innych zasobów, do 
//których należą (serwlet, plik HTML lub plik JSP
import javax.servlet.RequestDispatcher;
//wyjątek zgłaszany przez serwlet lub filtr w 
//celu wskazania, że ​​jest on trwale lub tymczasowo
//niedostępny
import javax.servlet.ServletException;
//Ta adnotacja jest określona w klasie i zawiera 
//metadane dotyczące deklarowanego serwletu
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
// zawiera szereg klas i interfejsów, które opisują
//i definiują kontrakty pomiędzy klasą serwletu
//działającą w ramach protokołu HTTP
//a środowiskiem wykonawczym 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import simple.eclipse.web.program.LinearFunDAO;
import simple.eclipse.web.program.linear_fun;
@WebServlet("/")
public class LinearFunServlet extends HttpServlet  {
	private static final long serialVersionUID = 1L;
    private LinearFunDAO linearFunDAO;

    public void init() {
    	linearFunDAO = new LinearFunDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertLinearFun(request, response);
                    break;
                case "/delete":
                    deleteLinearFun(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateLinearFun(request, response);
                    break;
                default:
                    listLinearFun(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listLinearFun(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < linear_fun > listLinearFun = linearFunDAO.getAllLinearFuns();
        request.setAttribute("listLinearFun", listLinearFun);
        RequestDispatcher dispatcher = request.getRequestDispatcher("linear-fun-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("linear-fun-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        linear_fun existingLinearFun = linearFunDAO.getLinearFun(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("linear-fun-form.jsp");
        request.setAttribute("linear_fun", existingLinearFun);
        dispatcher.forward(request, response);

    }

    private void insertLinearFun(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        Integer a = Integer.parseInt(request.getParameter("a"));
        Integer x = Integer.parseInt(request.getParameter("x"));
        Integer b = Integer.parseInt(request.getParameter("b"));
        linear_fun newLinearFun = new linear_fun(a, x, b);
        linearFunDAO.saveLinearFun(newLinearFun);
        response.sendRedirect("list");
    }

    private void updateLinearFun(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Integer a = Integer.parseInt(request.getParameter("a"));
        Integer x = Integer.parseInt(request.getParameter("x"));
        Integer b = Integer.parseInt(request.getParameter("b"));

        linear_fun newLinearFun = new linear_fun(id,a, x, b);
        linearFunDAO.updateLinearFun(newLinearFun);
        response.sendRedirect("list");
    }

    private void deleteLinearFun(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        linearFunDAO.deleteLinearFun(id);
        response.sendRedirect("list");
    }
}
