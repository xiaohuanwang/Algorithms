import entity.ProcurementOrderDO;
import entity.ProcurementOrderDailyInventoryRecordDO;
import entity.StockWeightDTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class ListMapGroupTest {
    public static void main(String[] args) {
        final List<ProcurementOrderDO> procurementOrderList = dataInit();
        List<StockWeightDTO> stockWeightDTOS = new ArrayList<>();
        final List<ProcurementOrderDailyInventoryRecordDO> procurementOrderDailyInventoryRecordDOList = dataInit1();
        Map<Long, BigDecimal> procurementOrderDailyInventoryRecordMap = procurementOrderDailyInventoryRecordDOList
                .parallelStream().
                        collect(Collectors.groupingBy(ProcurementOrderDailyInventoryRecordDO::getProcurementOrderNo,
                                Collectors.mapping(ProcurementOrderDailyInventoryRecordDO::getThatDayNetWeight,
                                        Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))));

        Map<Long, StockWeightDTO> procurementOrderWeightGroup = new HashMap<>(procurementOrderList.size());
        for (ProcurementOrderDO procurementOrderDO : procurementOrderList) {
            StockWeightDTO stockWeightDTO1 = new StockWeightDTO();
            stockWeightDTO1.setPurchaseWeight(procurementOrderDailyInventoryRecordMap.get(procurementOrderDO.getProcurementOrderNo()));
            stockWeightDTO1.setSupplyWeight(new BigDecimal(11));
            procurementOrderWeightGroup.put(procurementOrderDO.getProcurementOrderNo(), stockWeightDTO1);

        }

        final Map<Integer, List<ProcurementOrderDO>> procurementOrderGroupByGoodsNoMap = procurementOrderList.parallelStream()
                .collect(groupingBy(ProcurementOrderDO::getGoodsNo, Collectors.toList()));

        final Map<Integer, List<StockWeightDTO>> stockWeightMap = new HashMap<>(procurementOrderGroupByGoodsNoMap.size());
        procurementOrderGroupByGoodsNoMap.forEach((goodsNo, goodsNoGroupBy) -> {

            stockWeightMap.put(goodsNo, assemble(goodsNoGroupBy, procurementOrderWeightGroup));
        });
        stockWeightMap.forEach((a, b) -> {
            System.out.println(a + ":::" + b);
        });
    }

    public static List<StockWeightDTO> assemble(List<ProcurementOrderDO> procurementOrderList, Map<Long, StockWeightDTO> procurementOrderWeightGroup) {
        List<StockWeightDTO> stockWeightList = new ArrayList<>();
        final Map<Integer, List<ProcurementOrderDO>> procurementOrderGroupByQualityNoMap = procurementOrderList.parallelStream()
                .collect(groupingBy(ProcurementOrderDO::getQualityNo, Collectors.toList()));
        procurementOrderGroupByQualityNoMap.forEach((qualityNo, qualityNoGroupByList) -> {
            final List<Long> procurementOrderNoList = qualityNoGroupByList.parallelStream()
                    .map(ProcurementOrderDO::getProcurementOrderNo)
                    .collect(Collectors.toList());
            BigDecimal purchaseWeight = BigDecimal.ZERO;
            BigDecimal supplyWeight = BigDecimal.ZERO;
            for (Long procurementOrderNo : procurementOrderNoList) {
                StockWeightDTO stockWeightDTO = procurementOrderWeightGroup.get(procurementOrderNo);
                if (Objects.nonNull(stockWeightDTO.getPurchaseWeight())) {
                    purchaseWeight = purchaseWeight.add(stockWeightDTO.getPurchaseWeight());

                }
                if (Objects.nonNull(stockWeightDTO.getSupplyWeight())) {
                    supplyWeight = supplyWeight.add(stockWeightDTO.getSupplyWeight());
                }
            }


            StockWeightDTO stockWeight = new StockWeightDTO();
            stockWeight.setQualityNo(qualityNo);
            stockWeight.setPurchaseWeight(purchaseWeight);
            stockWeight.setSupplyWeight(supplyWeight);
            stockWeightList.add(stockWeight);
        });
        return stockWeightList;
    }


    public static List<ProcurementOrderDO> dataInit() {
        ProcurementOrderDO procurementOrderDO1 = new ProcurementOrderDO();
        procurementOrderDO1.setProcurementOrderNo(1111L);
        procurementOrderDO1.setUserNo(8);
        procurementOrderDO1.setGoodsNo(1);
        procurementOrderDO1.setQualityNo(22);

        ProcurementOrderDO procurementOrderDO2 = new ProcurementOrderDO();
        procurementOrderDO2.setProcurementOrderNo(2222L);
        procurementOrderDO2.setUserNo(8);
        procurementOrderDO2.setGoodsNo(1);
        procurementOrderDO2.setQualityNo(33);

        ProcurementOrderDO procurementOrderDO3 = new ProcurementOrderDO();
        procurementOrderDO3.setProcurementOrderNo(3333L);
        procurementOrderDO3.setUserNo(8);
        procurementOrderDO3.setGoodsNo(1);
        procurementOrderDO3.setQualityNo(22);

        ProcurementOrderDO procurementOrderDO4 = new ProcurementOrderDO();
        procurementOrderDO4.setProcurementOrderNo(4444L);
        procurementOrderDO4.setUserNo(8);
        procurementOrderDO4.setGoodsNo(2);
        procurementOrderDO4.setQualityNo(22);

        ProcurementOrderDO procurementOrderDO5 = new ProcurementOrderDO();
        procurementOrderDO5.setProcurementOrderNo(5555L);
        procurementOrderDO5.setUserNo(8);
        procurementOrderDO5.setGoodsNo(2);
        procurementOrderDO5.setQualityNo(33);

        List<ProcurementOrderDO> procurementOrderList = new ArrayList<ProcurementOrderDO>();
        procurementOrderList.add(procurementOrderDO1);
        procurementOrderList.add(procurementOrderDO2);
        procurementOrderList.add(procurementOrderDO3);
        procurementOrderList.add(procurementOrderDO4);
        procurementOrderList.add(procurementOrderDO5);
        return procurementOrderList;
    }

    public static List<ProcurementOrderDailyInventoryRecordDO> dataInit1() {
        ProcurementOrderDailyInventoryRecordDO procurementOrderDailyInventoryRecordDO1 = new ProcurementOrderDailyInventoryRecordDO();
        procurementOrderDailyInventoryRecordDO1.setProcurementOrderNo(1111L);
        procurementOrderDailyInventoryRecordDO1.setThatDay(LocalDate.of(2021, 10, 5));
        procurementOrderDailyInventoryRecordDO1.setThatDayNetWeight(new BigDecimal(5));

        ProcurementOrderDailyInventoryRecordDO procurementOrderDailyInventoryRecordDO2 = new ProcurementOrderDailyInventoryRecordDO();
        procurementOrderDailyInventoryRecordDO2.setProcurementOrderNo(1111L);
        procurementOrderDailyInventoryRecordDO2.setThatDay(LocalDate.of(2021, 10, 6));
        procurementOrderDailyInventoryRecordDO2.setThatDayNetWeight(new BigDecimal(6));

        ProcurementOrderDailyInventoryRecordDO procurementOrderDailyInventoryRecordDO3 = new ProcurementOrderDailyInventoryRecordDO();
        procurementOrderDailyInventoryRecordDO3.setProcurementOrderNo(1111L);
        procurementOrderDailyInventoryRecordDO3.setThatDay(LocalDate.of(2021, 10, 7));
        procurementOrderDailyInventoryRecordDO3.setThatDayNetWeight(new BigDecimal(7));

        ProcurementOrderDailyInventoryRecordDO procurementOrderDailyInventoryRecordDO4 = new ProcurementOrderDailyInventoryRecordDO();
        procurementOrderDailyInventoryRecordDO4.setProcurementOrderNo(2222L);
        procurementOrderDailyInventoryRecordDO4.setThatDay(LocalDate.of(2021, 10, 8));
        procurementOrderDailyInventoryRecordDO4.setThatDayNetWeight(new BigDecimal(8));

        ProcurementOrderDailyInventoryRecordDO procurementOrderDailyInventoryRecordDO5 = new ProcurementOrderDailyInventoryRecordDO();
        procurementOrderDailyInventoryRecordDO5.setProcurementOrderNo(2222L);
        procurementOrderDailyInventoryRecordDO5.setThatDay(LocalDate.of(2021, 10, 9));
        procurementOrderDailyInventoryRecordDO5.setThatDayNetWeight(new BigDecimal(9));

        List<ProcurementOrderDailyInventoryRecordDO> procurementOrderDailyInventoryRecordDOList = new ArrayList<>();
        procurementOrderDailyInventoryRecordDOList.add(procurementOrderDailyInventoryRecordDO1);
        procurementOrderDailyInventoryRecordDOList.add(procurementOrderDailyInventoryRecordDO2);

        procurementOrderDailyInventoryRecordDOList.add(procurementOrderDailyInventoryRecordDO3);

        procurementOrderDailyInventoryRecordDOList.add(procurementOrderDailyInventoryRecordDO4);

        procurementOrderDailyInventoryRecordDOList.add(procurementOrderDailyInventoryRecordDO5);
        return procurementOrderDailyInventoryRecordDOList;
    }
}
