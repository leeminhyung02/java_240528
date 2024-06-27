package student;

import java.util.Objects;

import lombok.Data;

@Data
public class Subject {
	private String name;
	private int grade;
	private int semester;
	private int mid;
	private int finals;
	private int perfomance;
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		return grade == other.grade && mid == other.mid && Objects.equals(name, other.name);
	}
	@Override
	public int hashCode() {
		return Objects.hash(grade, mid, name);
	}
	
	//한 학생에게 같은 과목명, 학년, 학기 성적이 여러개 있을 수 없기 때문에
	//equals를 과목명, 하견ㄴ, 학기를 이용하여 오버라이딩
	
}
