package entity;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @Description:
 * @date: 2021/11/5 4:25 下午
 * @author: 王小欢
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
@Data
public class PurchaserItemDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer purchaserNo;
    private String purchaserName;
    private List<GoodsItemDTO> goodsItemList;
}
