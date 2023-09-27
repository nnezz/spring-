package com.green.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MemberDAO;
import com.green.dao.MemberDAOForMybatis;
import com.green.vo.MemberVO;


@WebServlet("/FS")
public class FirstServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String url = "member/lists.jsp";
		
		//일반 사용
		/*
		 * MemberDAO dao = MemberDAO.getInstance(); List<MemberVO> lists =
		 * dao.selectAll();
		 */
		
		//마이바티스 사용
		MemberDAOForMybatis dao = MemberDAOForMybatis.getInstance();
		List<MemberVO> lists =dao.selectAll();
		
		
		
		request.setAttribute("lists", lists);
		
		request.getRequestDispatcher(url).forward(request, response);
		
		
	}

}
