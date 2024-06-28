package student;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Subject implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int grade;
	private int semester;
	private int mid;
	private int finals;
	private int performance;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		return grade == other.grade && Objects.equals(name, other.name) && semester == other.semester;
	}

	@Override
	public int hashCode() {
		return Objects.hash(grade, name, semester);
	}

	public void update(int mid, int finals, int performance) {
		// TODO Auto-generated method stub
		this.mid = mid;
		this.finals = finals;
		this.performance = performance;
	}

	@Override
	public String toString() {
		return "과목 : "+ name + "\n" + grade + "학년 "+ semester +"학기\n중간 :"+mid+"기말 : "
				+finals+"\n수행 : "+performance+ "\n총점 : "+getTotal();
	}

	private double getTotal() {
		
		return (mid*0.4+finals*0.5+performance*0.1);
	}

	// 한 학생에게 같은 과목명, 학년, 학기 성적이 여러개 있을 수 없기 때문에
	// equals를 과목명, 하견ㄴ, 학기를 이용하여 오버라이딩

}
