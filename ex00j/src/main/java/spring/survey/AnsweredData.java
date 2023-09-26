package spring.survey;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnsweredData { //설문응답지 -> 커맨드 객체로 사용할 예정
	
	private List<String> responses;
	private Respondent respondent;
	
	
}
