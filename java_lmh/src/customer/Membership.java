package customer;

import java.io.Serializable;
import java.util.regex.Pattern;

import lombok.Data;

@Data
public class Membership implements Serializable {

	private static final long serialVersionUID = -1783446289356868108L;

	private String id;
	private String pw;
	private String name;
	private String p_number;
	private final String number_pattern = "^\\d{3}-\\d{3,4}-\\d{4}$";
	private final int member_num = 1; // 고유 회원 번호

	/**
	 * 회원가입
	 * 
	 * @param id       아이디
	 * @param pw       비밀번호
	 * @param name     이름
	 * @param p_number 전화번호
	 */
	public Membership(String id, String pw, String name, String p_number) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.p_number = p_number;
	}

	/**
	 * 비회원 로그인
	 * 
	 * @param name     이름
	 * @param p_number 전화번호
	 * @param pw       비밀번호
	 */
	public Membership(String name, String p_number, String pw) {
		this.id = null;
		this.name = name;
		this.p_number = p_number;
		this.pw = pw;
	}

	public boolean check_num(String p_number) {
		if (Pattern.matches(number_pattern, p_number)) {
			System.out.println("올바른 휴대전화 형식입니다. ");
			return true;
		} else {
			System.out.println("올바른 휴대전화 형식이 아닙니다. ");
		}
		return false;

	}
	// 메소드는 아직 미정
}