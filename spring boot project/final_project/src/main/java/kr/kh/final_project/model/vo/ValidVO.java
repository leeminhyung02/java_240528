package kr.kh.final_project.model.vo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import kr.kh.final_project.model.util.Check_email;
import kr.kh.final_project.model.util.Check_id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValidVO {
	/*
	 * @NotNull - null값만 허용하지 않음 (wrapper의 integer, long, string등)
	 * 
	 * @NotBlank - null값과 공백허용하지 않음 (String에만 적용)
	 * 
	 * @NotEmpty - null값을 허용하지 않음(Array, list 적용)
	 * 
	 * @Pattern - 정규표현식에 맞는 문자열을 정의할 수 있음(String에만 적용)
	 * 
	 * @Email - 이메일형식 검즌(공백은 통과)
	 * 
	 * @Min - 최솟값
	 * 
	 * @Max - 최댓값
	 * 
	 */
	//아이디, 이메일 겹치는지 확인해야함 이름, 비밀번호는 괜찮
	@NotBlank(message = "ID는 필수입니다")
	@Check_id(message = "이미 있는 ID입니다.")
	@Pattern(regexp = "^\\w{6,13}$", message = "아이디는 영어, 숫자만 가능하며, 6~13자이어야 합니다." )
	private String User_id;

	@NotBlank(message = "비밀번호는 필수입니다")
	private String user_pw;
	
	@NotBlank(message = "email형식이어야 합니다") // 동시에 적용 쌉가능
	@Check_email(message = "이미 있는 이메일 입니다.")
	@Email // email형식이어야 함, 단 공백은 통과
	private String user_email;

	@NotBlank(message = "이름은 필수입니다.")
	private String user_name;
	
}
