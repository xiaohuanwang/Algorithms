package entity;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description:
 * @date: 2021/11/5 4:26 下午
 * @author: 王小欢
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
@Data
public class StatisticsItemDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String dayName;
    private BigDecimal netWeightTotal;
    private BigDecimal payableAmountTotal;
}
