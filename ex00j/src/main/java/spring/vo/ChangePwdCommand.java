package spring.vo;

import lombok.Data;

@Data
public class ChangePwdCommand {
	
	private String currentPassword;
	private String newPassword;
	
	
}
