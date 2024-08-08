package model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	private String name;
	private int age;
	
	public String getTest() {
		return "테스트입니다.";
	}
}
