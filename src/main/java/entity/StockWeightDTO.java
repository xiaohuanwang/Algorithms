package entity;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class StockWeightDTO {
    /**
     * 品质编号
     */
    private Integer qualityNo;
    /**
     * 收货重量
     */
    private BigDecimal purchaseWeight;
    /**
     * 卖货重量
     */
    private BigDecimal supplyWeight;
    /**
     * 差值重量=（收货重量-卖货重量）
     */
    private BigDecimal differenceWeight;
}
