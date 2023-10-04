package com.green.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MemberDAOForMybatis;
import com.green.vo.MemberVO;

/**
 * Servlet implementation class MemberEmailServlet
 */
@WebServlet("/MES")
public class MemberEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("member/inputEmail.jsp").forward(request, response);
		//조회 하고 싶은 이메일 받아오기
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String email = request.getParameter("email");
		
		MemberDAOForMybatis dao = MemberDAOForMybatis.getInstance();
		MemberVO member = dao.selectByEmail(email);
		
		request.setAttribute("member", member);
		
		request.getRequestDispatcher("member/info.jsp").forward(request, response);
		
	}

}
