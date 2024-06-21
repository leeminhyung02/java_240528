package day18.homework;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Member implements Serializable{


	private static final long serialVersionUID = -1365636226625753722L;
	
	private List < Schedule> list = new ArrayList<Schedule>();
	private String id;
	private String name;
	

	public Member(List<Schedule> list, String id, String name) {
		// TODO Auto-generated constructor stub
		this.list = list;
		this.id = id;
		this.name = name;
	}


	
	
	
	
}
