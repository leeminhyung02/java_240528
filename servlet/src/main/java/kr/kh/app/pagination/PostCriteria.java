package kr.kh.app.pagination;

import lombok.Data;
import lombok.NoArgsConstructor;

//현재 페이지 정보를 나타내는 클래스
@Data
@NoArgsConstructor
public class PostCriteria extends Criteria{

	private int co_num;
	
	public PostCriteria(int page, int perPageNum, String search, int co_num) {
		super(page, perPageNum, search);
		this.co_num = co_num;
	}
	
}