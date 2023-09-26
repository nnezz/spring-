package spring.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import spring.intercepter.AuthCheckIntercepter;

@Configuration  //스프링 설정 => 빈
@EnableWebMvc   //<mvc:annotation-driven/>

public class MvcConfig implements WebMvcConfigurer{
	//WebMvcConfigurer : mvc~~~
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		//<mvc:default-servlet-handler/>
		configurer.enable();
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		/*
	 	<mvc:view-resolvers>
		<mvc:jsp prefix="/WEB-INF/views/" />
		</mvc:view-resolvers>
		*/	
		
		//registry.jsp().prefix("/WEB-INF/views/").suffix(".jsp");
		registry.jsp().prefix("/WEB-INF/views/");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//<mvc:view-controller path="/main" view-name="main"/>
		registry.addViewController("/main").setViewName("main");
		registry.addViewController("/").setViewName("main");
	}
	
	//<!-- 메시지.프로퍼티를 읽어올 빈 객체 설정 -->
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource msgSrc = new ResourceBundleMessageSource();
		msgSrc.setDefaultEncoding("UTF-8");
		msgSrc.setBasenames("message.label","message.label");
		return msgSrc;
	}
	
	//1. 인터셉터에서 사용할 빈
	
	@Bean
	public AuthCheckIntercepter authCheckIntercepter() {
		return new AuthCheckIntercepter();
	}

	//2. 인터셉터에서 사용할 빈을 어디에 적용할 것인가?
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 
		registry.addInterceptor(authCheckIntercepter()).addPathPatterns("/edit/**");
	}
	

	
	
	
	
	
	
	
}
