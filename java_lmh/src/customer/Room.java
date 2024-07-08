package customer;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Room implements Serializable{
	private static final long serialVersionUID = 6420217554170896710L;
	
	
	private int room_num;
	private boolean in;
	@Override
	public String toString() {
		if(in == true) {
			return "";
		}
		return "Room [" + room_num + "]";
	}
 
	
	
}
