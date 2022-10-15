package fa.appcode.web.vo;

import java.util.List;

import lombok.Data;

@Data
public class PageVo<E>  {
	private Integer pageIndex;
	private Integer totalPage;
	private List<E> content;
		
	public PageVo(Integer pageIndex, Integer totalPage, List<E> content) {
		super();
		this.pageIndex = pageIndex;
		this.totalPage = totalPage;
		this.content = content;
	}

	public PageVo() {
		super();
	}
	
}
