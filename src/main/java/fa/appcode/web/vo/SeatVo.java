package fa.appcode.web.vo;

import lombok.Data;

@Data
public class SeatVo {
	private Integer seatId;
	private Integer seatType;
	private Double seatPrice;

	public SeatVo(Integer seatId, Integer seatType, Double seatPrice) {
		super();
		this.seatId = seatId;
		this.seatType = seatType;
		this.seatPrice = seatPrice;
	}

	public SeatVo() {
		super();
	}

}
