package fa.appcode.web.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ConfirmTicketVo {

    private String dateSelecting;
    private String timeSelecting;
    private String[] idSeatSelecting;
    private String movieId;
    private Integer scheduleId;
    private Double useScore;
    private String memberId;
    private Double totalPrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConfirmTicketVo that = (ConfirmTicketVo) o;
        return dateSelecting.equals(that.dateSelecting)
                && timeSelecting.equals(that.timeSelecting)
                && Arrays.equals(idSeatSelecting, that.idSeatSelecting)
                && movieId.equals(that.movieId)
                && scheduleId.equals(that.scheduleId)
                && useScore.equals(that.useScore)
                && totalPrice.equals(that.totalPrice);
    }


}
