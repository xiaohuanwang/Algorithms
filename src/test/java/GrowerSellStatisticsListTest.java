import cn.hutool.json.JSONObject;
import common.util.LocalJsonUtil;
import entity.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Description:
 * @date: 2021/11/5 3:32 下午
 * @author: 王小欢
 */
public class GrowerSellStatisticsListTest {
    public static void main(String[] args) {
        List<SummaryDetailDTO> summaryDetailDTOList = LocalJsonUtil.getListFromJson("json/SummaryDetail.json", SummaryDetailDTO.class);
        summaryDetailDTOList.parallelStream().forEach(summaryDetailDTO -> {
            //     System.out.println(summaryDetailDTO.getCreateTime());
        });
        Timestamp timestamp10 = Timestamp.valueOf("2021-10-01 00:00:00");
        Timestamp timestamp9 = Timestamp.valueOf("2021-09-01 00:00:00");
        Timestamp timestamp8 = Timestamp.valueOf("2021-08-01 00:00:00");



        /*summaryDetailDTOList.parallelStream().
                filter(summaryDetailDTO -> summaryDetailDTO.getCreateTime().after(timestamp10))
                .forEach(summaryDetailDTO -> {
                 //   System.out.println(summaryDetailDTO.getCreateTime());
                });*/

        //按代办分组
        final Map<Integer, List<SummaryDetailDTO>> purchaserGroutBy = summaryDetailDTOList.parallelStream()
                .collect(Collectors.groupingBy(SummaryDetailDTO::getSupplierNo, Collectors.toList()));
        GrowerSellStatisticsDTO growerSellStatisticsDTO = new GrowerSellStatisticsDTO();
        List<PurchaserItemDTO> purchaserStatisticsList = new ArrayList<>(purchaserGroutBy.size());
        purchaserGroutBy.forEach((purchaserNo, summaryDetailList) -> {
            PurchaserItemDTO purchaserItemDTO = new PurchaserItemDTO();
            purchaserItemDTO.setPurchaserNo(purchaserNo);
            purchaserItemDTO.setPurchaserName("合作社名字" + purchaserNo);
            purchaserStatisticsList.add(purchaserItemDTO);
            //按货品分组
            final Map<Integer, List<SummaryDetailDTO>> goodsNoGroupBy = summaryDetailList.parallelStream()
                    .collect(Collectors.groupingBy(SummaryDetailDTO::getGoodsNo, Collectors.toList()));
            List<GoodsItemDTO> goodsItemList = new ArrayList<>(goodsNoGroupBy.size());
            goodsNoGroupBy.forEach((goodsNo, summaryDetailList1) -> {
                GoodsItemDTO goodsItemDTO = new GoodsItemDTO();
                goodsItemDTO.setGoodsNo(goodsNo);
                goodsItemDTO.setGoodsName("商品名字" + goodsNo);
                goodsItemList.add(goodsItemDTO);
                //7天
                List<StatisticsItemDTO> statisticsItemList = new ArrayList<>(3);
                StatisticsItemDTO statisticsItemDTO7 = new StatisticsItemDTO();
                final BigDecimal netWeightTotal7;  //净重总结
                final BigDecimal payableAmountTotal7; //卖货金额总结
                netWeightTotal7 = summaryDetailList1.parallelStream()
                        .filter(summaryDetailDTO -> summaryDetailDTO.getCreateTime().after(timestamp10))
                        .map(SummaryDetailDTO::getNetWeight)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
                payableAmountTotal7 = summaryDetailList1.parallelStream()
                        .filter(summaryDetailDTO -> summaryDetailDTO.getCreateTime().after(timestamp10) && Objects.nonNull(summaryDetailDTO.getPayableOrReceivableAmount()))
                        .map(SummaryDetailDTO::getPayableOrReceivableAmount)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
                statisticsItemDTO7.setDayName("近7天");
                statisticsItemDTO7.setNetWeightTotal(netWeightTotal7);
                statisticsItemDTO7.setPayableAmountTotal(payableAmountTotal7);
                statisticsItemList.add(statisticsItemDTO7);

                StatisticsItemDTO statisticsItemDTO15 = new StatisticsItemDTO();
                final BigDecimal netWeightTotal15;  //净重总结
                final BigDecimal payableAmountTotal15; //卖货金额总结
                netWeightTotal15 = summaryDetailList1.parallelStream()
                        .filter(summaryDetailDTO -> summaryDetailDTO.getCreateTime().after(timestamp9))
                        .map(SummaryDetailDTO::getNetWeight)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
                payableAmountTotal15 = summaryDetailList1.parallelStream()
                        .filter(summaryDetailDTO -> summaryDetailDTO.getCreateTime().after(timestamp9) && Objects.nonNull(summaryDetailDTO.getPayableOrReceivableAmount()))
                        .map(SummaryDetailDTO::getPayableOrReceivableAmount)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
                statisticsItemDTO15.setDayName("近15天");
                statisticsItemDTO15.setNetWeightTotal(netWeightTotal15);
                statisticsItemDTO15.setPayableAmountTotal(payableAmountTotal15);
                statisticsItemList.add(statisticsItemDTO15);

                StatisticsItemDTO statisticsItemDTO30 = new StatisticsItemDTO();
                final BigDecimal netWeightTotal30;  //净重总结
                final BigDecimal payableAmountTotal30; //卖货金额总结
                netWeightTotal30 = summaryDetailList1.parallelStream()
                        .filter(summaryDetailDTO -> summaryDetailDTO.getCreateTime().after(timestamp8))
                        .map(SummaryDetailDTO::getNetWeight)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
                payableAmountTotal30 = summaryDetailList1.parallelStream()
                        .filter(summaryDetailDTO -> summaryDetailDTO.getCreateTime().after(timestamp8) && Objects.nonNull(summaryDetailDTO.getPayableOrReceivableAmount()))
                        .map(SummaryDetailDTO::getPayableOrReceivableAmount)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
                statisticsItemDTO30.setDayName("近30天");
                statisticsItemDTO30.setNetWeightTotal(netWeightTotal30);
                statisticsItemDTO30.setPayableAmountTotal(payableAmountTotal30);
                statisticsItemList.add(statisticsItemDTO30);
                goodsItemDTO.setStatisticsItemList(statisticsItemList);
                //   System.out.println("代办"+purchaserNo+"商品"+goodsNo);
            });
            //   System.out.println("代办"+purchaser);
            purchaserItemDTO.setGoodsItemList(goodsItemList);

        });
        growerSellStatisticsDTO.setPurchaserStatisticsList(purchaserStatisticsList);
        System.out.println(new JSONObject(growerSellStatisticsDTO).toString());

    }
}
