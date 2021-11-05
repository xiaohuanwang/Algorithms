package entity;


import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * <p>汇总单详情</p>
 *
 * @author puchaobo@caiduofu.cn
 * @date 2021-02-21 11:41:30
 */
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
public class SummaryDetailDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 从属订单编号
     */
    private Long orderNo;
    /**
     * 关联的汇总单编号
     */
    private Long summaryNo;
    /**
     * 采购方用户编号
     */
    private Integer purchaserNo;
    /**
     * 供应方用户编号
     */
    private Integer supplierNo;
    /**
     * 创建者编号
     */
    private Integer creatorNo;
    /**
     * 商品编号
     */
    private Integer goodsNo;
    /**
     * 规格编号列表","分隔
     */
    private String specificationNoList;
    /**
     * 品质编号
     */
    private Integer qualityNo;

    private BigDecimal expectedWeight;
    /**
     * 毛重
     */
    private BigDecimal grossWeight;
    /**
     * 第一次皮重
     */
    private BigDecimal firstTare;
    /**
     * 二次皮重
     */
    private BigDecimal secondTare;
    /**
     * 皮重 = {@link #firstTare} + {@link #secondTare}
     */
    private BigDecimal tare;
    /**
     * 损耗重量
     */
    private BigDecimal lossWeight;
    /**
     * 损耗后重量
     */
    private BigDecimal afterLossWeight;
    /**
     * 净重
     */
    private BigDecimal netWeight;

    /**
     * 件数
     */
    private Integer pieceCount;
    /**
     * 件重
     */
    private BigDecimal pieceWeight;
    /**
     * 期望价格
     */
    private BigDecimal expectedPrice;
    /**
     * 按斤价格
     */
    private BigDecimal unitPriceByWeight;
    /**
     * 按件价格
     */
    private BigDecimal unitPriceByPiece;
    /**
     * 价格浮动
     */
    private BigDecimal fluctuationInPrice;
    /**
     * 是否菜农管理费
     */
    private Boolean enableGrowerManagerAmountUnitByWeight;
    /**
     * 菜农管理费
     */
    private BigDecimal growerManagerAmountUnitByWeight;
    /**
     * 默认菜农管理费
     */
    private BigDecimal defaultGrowerManagerAmountUnitByWeight;
    /**
     * 是否开启送货筐数
     */
    private Boolean enableDeliveryBasket;
    /**
     * 总筐数
     */
    private Integer basketsCount;
    /**
     * 最终价格
     */
    private BigDecimal finalPrice;
    /**
     * 按斤服务费
     */
    private BigDecimal unitServiceChargeByWeight;
    /**
     * 服务费金额
     */
    private BigDecimal serviceChargeAmount;
    /**
     * 商品金额
     */
    private BigDecimal goodsAmount;
    /**
     * 商品向下取整抹零金额
     */
    private BigDecimal goodsDownRoundAmount;
    /**
     * 应收或应付金额
     */
    private BigDecimal payableOrReceivableAmount;
    /**
     * 已完成收支金额
     */
    private BigDecimal offsetAmount;
    /**
     * 调整金额
     */
    private BigDecimal adjustmentAmount;
    /**
     * 能否更新
     */
    private Boolean canUpdate;
    /**
     * 能否取消
     */
    private Boolean canDisable;
    /**
     * 能否恢复
     */
    private Boolean canRestore;
    /**
     * 能否删除
     */
    private Boolean canDel;
    /**
     * 除皮是否计算完成
     */
    private Boolean removeTareCompleted;
    /**
     * 是否完成
     */
    private Boolean completed;
    /**
     * 目标代办采购单编号
     */
    private Long targetProcurementOrderNo;
    /**
     * 来源代办采购单编号
     */
    private Long sourceProcurementOrderNo;
    /**
     * 目标订单采购方用户编号
     */
    private Integer orderAssociatedTargetOrderPurchaserNo;
    /**
     * 是否开启二次除皮
     */
    private Boolean enableSecondTareRemoval;
    /**
     * 是否开启结算向下取整
     */
    private Boolean enableSettlementDownRound;
    /**
     * 是否开启残次品重量
     */
    private Boolean enableLossWeight;
    /**
     * 登录用户采购方用户编号
     */
    private Integer loginUserPurchaserNo;
    /**
     * 代办备注
     */
    private String remarks;
    /**
     * 图片
     */
    private String picture;
    /**
     * MyBatis-Plus乐观锁
     **/
    private Integer version;
    /**
     * 创建时间
     */
    private Timestamp createTime;
}

