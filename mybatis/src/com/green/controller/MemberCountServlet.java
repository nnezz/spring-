package com.green.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MemberDAOForMybatis;

@WebServlet("/MCS")
public class MemberCountServlet extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
					

			//마이바티스 사용
			MemberDAOForMybatis dao = MemberDAOForMybatis.getInstance();
			int cnt = dao.selectCnt();		
			
			request.setAttribute("cnt", cnt);
			
			request.getRequestDispatcher("member/cnt.jsp").forward(request, response);
			
	}

}
