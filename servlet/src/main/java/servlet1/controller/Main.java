package servlet1.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.vo.Person;


@WebServlet("/")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
    public Main() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Person p = new Person("홍길동", 21);
		request.setAttribute("person", p);
		
//		request.setAttribute("화면에서 사용할 변수명", "보낼 값");
		request.setAttribute("name", "홍길동");
		request.setAttribute("age", "21");
		
		request.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
