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
 * Servlet implementation class AddMemberServlet
 */
@WebServlet("/UCMS")
public class UpdateCheckMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//어떤 회원의 정보를 수정할지 이메일을 입력받기 위한 폼
		request.getRequestDispatcher("member/CheckEmailForm.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//이메일을 통해서 회원정보를 조회한 후 
		//업데이트 폼으로 연결
		
		request.setCharacterEncoding("UTF-8");
		
		String email = request.getParameter("email");
			
		MemberDAOForMybatis dao = MemberDAOForMybatis.getInstance();
		MemberVO member = dao.selectByEmail(email);
		
		request.setAttribute("member", member);
		
		request.getRequestDispatcher("member/updateForm.jsp").forward(request, response);
	}

}
