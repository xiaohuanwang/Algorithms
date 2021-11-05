package entity;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @Description:
 * @date: 2021/11/5 4:26 下午
 * @author: 王小欢
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
@Data
public class GoodsItemDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer goodsNo;
    private String goodsName;
    private List<StatisticsItemDTO> statisticsItemList;
}
