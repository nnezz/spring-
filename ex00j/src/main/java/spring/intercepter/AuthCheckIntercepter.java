package spring.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import spring.vo.AuthInfo;

public class AuthCheckIntercepter implements HandlerInterceptor{


	//인터페이스 : 기능목록
	// 단점 : 목록에 있는 모든 기능을 일단 구현
	
	// 해결 1. Adapter 패턴
	// 인터페이스를 구현한 어댑터 클래스 : 모든 기능을 구현한 클래스 ( 기능의 몸체는 없는 
	// 실제 사용할 클래스는 어댑터 클래스를 상속받아서 필요한 기능만 구현해서 사용하도록 하는 방법)

	// 해결 2. 디폴트 매서드를 사용하는 방법
	// 구현 안해도 되는 메서드를 인터페이스에 만드는 방법
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 컨트롤러가 수행되기 전 사용되는 기능 -> 로그인 인증
		// 반환 값이 true 인 경우 컨트롤러 정상적으로 작동
		// 반환 값이 false 인 경우 컨트롤러 작동x
		
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		if(authInfo != null) {
			return true;
		}
		response.sendRedirect(request.getContextPath()+"/login");
		
		
		return false;
		}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// 컨트롤러가 수행된 후 -> 뷰페이지가 동작되기 전에 사용되는 기능
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// 뷰페이지가 작동된후 사용하는 기능
		
	}
	
	
	
}
