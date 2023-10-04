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
@WebServlet("/UMS")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		MemberVO member = new MemberVO(email, name, password);
		
		MemberDAOForMybatis dao = MemberDAOForMybatis.getInstance();
		dao.updateMember(member);
		
		response.sendRedirect("http://localhost:8085/mybatis/FS");
	}

}
