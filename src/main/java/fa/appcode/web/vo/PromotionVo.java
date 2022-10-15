package fa.appcode.web.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import fa.appcode.common.logging.LogUtils;
import fa.appcode.web.entities.Promotion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class PromotionVo {
    private Integer promotionId;

    @NotEmpty(message = "{promotion.detail.empty}")
    private String detail;

    @NotNull(message = "{promotion.discountLevel.empty}")
    private Integer discountLevel;

    @NotEmpty(message = "{promotion.endTime.empty}")
    @DateTimeFormat(pattern = "yyyy-MM-DD HH:mm")
    private String endTime;

    private String image;

    @NotEmpty(message = "{promotion.startTime.empty}")
    @DateTimeFormat(pattern = "yyyy-MM-DD HH:mm")
    private String startTime;

    @NotEmpty(message = "{promotion.title.empty}")
    private String title;

    private MultipartFile file;

    public Promotion getPromotionFromVo() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String[] startTimeValueArray = this.startTime.split("T");
        String[] endTimeValueArray = this.endTime.split("T");

        Date startTimeValue = simpleDateFormat.parse(startTimeValueArray[0]+" "+startTimeValueArray[1]);

        Date endTimeValue = simpleDateFormat.parse(endTimeValueArray[0]+" "+endTimeValueArray[1]);
        LogUtils.getLogger().info(endTimeValueArray[0]+" "+endTimeValueArray[1]);
        LogUtils.getLogger().info(startTimeValue+"*********************"+endTimeValue);

        return new Promotion(promotionId, detail, discountLevel, endTimeValue, image, startTimeValue, title);
    }
}
