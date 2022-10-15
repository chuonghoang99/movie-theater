package fa.appcode.common.utils;

import java.util.ArrayList;
import java.util.List;

public class  Constants {

	public static final String SPACE_WORD = " ";
	public static final String DEFAULT_WORD = "";
	public static final String PAGE_SIZE_STRING = "5";
	public static final String REGEX_DIGIT = "\\d+";
	public static final Integer IS_SOLD = 1;
	public static final Integer INVOICE_BOOKED = 1;
	
    // Chuong
    public static final String PATH_EMPLOYEE_IMG = "src/main/webapp/resources/img/employee/";
    
    //Truong
    public static final String SRC_PROMOTION_IMAGE = "src/main/webapp/resources/img/promotion/";
	public static final String SRC_PROMOTION_IMAGE_2 = "/resources/img/promotion/";
	public static final String MOVIE_SRC_IMG= "src/main/webapp/resources/img/movie"; 


	// Khanh
	public static final String MOVIE_SRC_IMG_2 = "/resources/img/movie/";


	public static void main(String[] args) {
		//String a = new String();
		List<String> list = new ArrayList<>();
		list.add("aaa");
		list.add(1, "bb");
		System.out.println(list);
	}
}
