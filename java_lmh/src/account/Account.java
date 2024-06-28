package account;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account implements Serializable, Comparable<Account>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String date;
	private String type;	//수입|지출
	private String info;
	private String classification;  //분류
	private int cash;
	@Override
	public String toString() {
		return "[" + date +" " + type + " " + classification + " 금액 : " 
	+ cash + " 내용 :" + info + "]";
	}
	@Override
	public int compareTo(Account o) {
		
		return 0;
	}
	

	
	
}
