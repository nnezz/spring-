package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring.vo.RegisterRequest;

public class RegisterRequestValidator implements Validator{
	
	//이메일 검증을 위한 정규식
	
	private static final String emailExp = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@"
			+ "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";
	
	private Pattern pattern;
	
	public RegisterRequestValidator() {
		pattern = Pattern.compile(emailExp);
	}
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		//전달받은 객체가 커맨드 객체인지를 판별 하는 메서드
		return RegisterRequest.class.isAssignableFrom(clazz);
									//특정 클래스가 어떤 클래스를 상속/구현했는지 판별
				
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		//실제 검증용 코드를 작성하는 부분
		//검증을 처리해서 에러가 있다면 errors 객체에 에러코드를 만드는 작업
		
		//이메일입력  / 이메일 형식
		//이름입력     /
		//비밀번호,비밀번호 확인 입력 
		//비밀번호와 확인이 일치  
		
		RegisterRequest regReq = (RegisterRequest)target;
		//1.이메일 검증
		if(regReq.getEmail() == null || regReq.getEmail().trim().isEmpty() ) {
			errors.rejectValue("email","required");
			//에러 출력 태그에 email 이라는 속성에 required 값(에러코드) 을 전달
			//								=> 대체되는 메시지로 변환
		}else {
			Matcher matcher = pattern.matcher(regReq.getEmail());
			
			if(!matcher.matches()) {
				errors.rejectValue("email","bad");
			}
		}
		
		//2 이름, 비밀번호,비밀번호 확인이 입력
		// 입력여부를 쉽게 처리해주는 기능  ValidationUtils
		/*
		 
		  if(regReq.getName() == null || regReq.getName().trim().isEmpty() ) {
		  errors.reject("name","required"); }
		 */
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
		// name이라는 필드가 비어있거나 공백문자가있다면 에ㅓ의 name속성에 required값 전달
		
		ValidationUtils.rejectIfEmpty(errors, "password", "required");
		ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "required");
		
		//3 비밀번호와 비밀번호 확인의 값이 일치 확인
		if(!regReq.getPassword().isEmpty() && !regReq.getConfirmPassword().isEmpty()) {
			//비밀번호와 비밀번호 확인 값이 비어있지 않다면
			if(!regReq.isPasswordEqualToConfirmPassword()) {
				errors.rejectValue("confirmPassword", "nomatch");
			}
		}
		
		
	}
	
}
