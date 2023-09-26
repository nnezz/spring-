package spring.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListCommand {
	
	//날짜를 입력받아서 시작일/종료일 기준으로 목록을 검색할 목적
	//클라이언트에 전달받은 데이터는 무조건 문자열
	//스프링에서는 자동형변환을 지원 : 문자열->문자열,기본타입
	
	@DateTimeFormat(pattern = "yyyyMMddHH")
	private Date from;
	@DateTimeFormat(pattern = "yyyyMMddHH")
	private Date to;
	
}
