package spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.dao.MemberDao;
import spring.vo.ListCommand;
import spring.vo.Member;

@Controller
public class MemberListController {
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping("/member/list")
	public String list(ListCommand listCommand,Errors error,Model model) {
		
		if(error.hasErrors()) {
			//타입변환 에러의 경우 typemissmatch 에러코드가 자동으로 발생됨
			return "member/memberList";
		}
		
		if(listCommand.getFrom() != null && listCommand.getTo() != null) {
			List<Member> list = memberDao.selectByRegdate(listCommand.getFrom(), listCommand.getTo());
			
			model.addAttribute("members",list);
		}
		
		
		return "member/memberList";
	}
}
