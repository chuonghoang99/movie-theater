package fa.appcode.web.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Table(name = "promotion", schema = "movie_theater")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "promotion_id")
    private Integer promotionId;

    @Column(name = "detail", columnDefinition = "NVARCHAR(255)")
    @NotEmpty(message = "{promotion.detail.empty}")
    private String detail;

    @Column(name = "discount_level")
    @NotNull(message = "{promotion.discountLevel.empty}")
    private Integer discountLevel;

    @Column(name = "end_time", columnDefinition = "DATETIME")
    @NotNull(message = "{promotion.endTime.empty}")
    @DateTimeFormat(pattern = "YYYY-MM-DD HH:mm")
    private Date endTime;

    @Column(name = "image", columnDefinition = "VARCHAR(255)")
    private String image;

    @Column(name = "start_time", columnDefinition = "DATETIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @NotNull(message = "{promotion.startTime.empty}")
    private Date startTime;

    @Column(name = "title", columnDefinition = "VARCHAR(255)", unique = true)
    @NotEmpty(message = "{promotion.title.empty}")
    private String title;

    public Promotion(Integer promotionId, @NotEmpty(message = "{promotion.title.empty}") String title) {
        super();
        this.promotionId = promotionId;
        this.title = title;
    }

    public Promotion(Integer promotionId, @NotEmpty(message = "{promotion.detail.empty}") String detail, Date endTime,
                     Date startTime, @NotEmpty(message = "{promotion.title.empty}") String title) {
        super();
        this.promotionId = promotionId;
        this.detail = detail;
        this.endTime = endTime;
        this.startTime = startTime;
        this.title = title;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Promotion other = (Promotion) obj;
        return Objects.equals(promotionId, other.promotionId)
                && Objects.equals(title, other.title);
    }

    public Promotion(@NotEmpty(message = "{promotion.detail.empty}") String detail,
                     @NotNull(message = "{promotion.discountLevel.empty}") Integer discountLevel, Date endTime, String image,
                     Date startTime, @NotEmpty(message = "{promotion.title.empty}") String title) {
        super();
        this.detail = detail;
        this.discountLevel = discountLevel;
        this.endTime = endTime;
        this.image = image;
        this.startTime = startTime;
        this.title = title;
    }

}
