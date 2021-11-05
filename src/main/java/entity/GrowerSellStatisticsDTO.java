package entity;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * <p>菜农卖货汇总列表</p>
 *
 * @author wangxiaohuan@caiduofu.cn
 * @date 2021-11-13 15:29:40
 */
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
public class GrowerSellStatisticsDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<PurchaserItemDTO> purchaserStatisticsList;
    private List<GoodsItemDTO> goodIsStatisticsList;
}