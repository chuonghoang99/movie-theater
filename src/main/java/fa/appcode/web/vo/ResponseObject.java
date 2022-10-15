/*
 *
 * @author: ChuongHV1
 * @date: Dec 4, 2021
 */

package fa.appcode.web.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseObject {

	private String status;
	
	private String message;
	
	private Object data;


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ResponseObject that = (ResponseObject) o;
		return Objects.equals(status, that.status) && Objects.equals(message, that.message) && Objects.equals(data, that.data);
	}

	@Override
	public int hashCode() {
		return Objects.hash(status, message, data);
	}
}
