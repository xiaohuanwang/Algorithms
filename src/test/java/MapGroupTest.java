import entity.ProcurementOrderDO;
import entity.StockWeightDTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class MapGroupTest {
    public static void main(String[] args) {

        final List<ProcurementOrderDO> procurementOrderList = dataInit();
        final Map<Integer, List<ProcurementOrderDO>> procurementOrderGroupByGoodsNoMap = procurementOrderList.parallelStream()
                .collect(Collectors.groupingBy(ProcurementOrderDO::getGoodsNo, Collectors.toList()));
        final Map<Integer, List<StockWeightDTO>> stockWeightMap = new HashMap<>(procurementOrderGroupByGoodsNoMap.size());
        final LocalDate startDate = LocalDate.now();
        final LocalDate endDate = LocalDate.now();
        procurementOrderGroupByGoodsNoMap.forEach((goodsNo,goodsNoGroupBy) ->
                stockWeightMap.put(goodsNo,assemble(goodsNoGroupBy,startDate,endDate)));

        stockWeightMap.forEach((a,b) -> {
            System.out.println(a+":::"+b);
        });

    }

/*    public static Map<Integer, List<StockWeightDTO>> assemble(Integer goodsNo, List<ProcurementOrderDO> procurementOrderList) {
        System.out.println(goodsNo+":::"+procurementOrderList);
        final Map<Integer, List<StockWeightDTO>> stockWeightMap = new HashMap<>();
        final Map<Integer, List<ProcurementOrderDO>> procurementOrderGroupByQualityNoMap = procurementOrderList.parallelStream()
                .collect(Collectors.groupingBy(ProcurementOrderDO::getQualityNo, Collectors.toList()));
        procurementOrderGroupByQualityNoMap.forEach((qualityNo,qualityNoGroupBy) ->
                stockWeightMap.put(goodsNo,abc(qualityNo,qualityNoGroupBy)));
        return stockWeightMap;
    }*/

    public static List<StockWeightDTO> assemble(List<ProcurementOrderDO> procurementOrderList,final LocalDate startDate,  final LocalDate endDate){
        System.out.println(startDate);
        System.out.println(endDate);
        List<StockWeightDTO> stockWeightDTOS = new ArrayList<>();
        final Map<Integer, List<ProcurementOrderDO>> procurementOrderGroupByQualityNoMap = procurementOrderList.parallelStream()
                .collect(Collectors.groupingBy(ProcurementOrderDO::getQualityNo, Collectors.toList()));
        procurementOrderGroupByQualityNoMap.forEach((qualityNo,qualityNoGroupBy) -> {
            System.out.println(qualityNo + ":::" + qualityNoGroupBy);
            StockWeightDTO stockWeightDTO = new StockWeightDTO();
            stockWeightDTO.setQualityNo(qualityNo);
            stockWeightDTO.setSupplyWeight(new BigDecimal("15"));
            stockWeightDTOS.add(stockWeightDTO);
        });

        return stockWeightDTOS;
    }

    public static List<ProcurementOrderDO> dataInit () {
        ProcurementOrderDO procurementOrderDO1 = new ProcurementOrderDO();
        procurementOrderDO1.setProcurementOrderNo(6666L);
        procurementOrderDO1.setUserNo(8);
        procurementOrderDO1.setGoodsNo(1);
        procurementOrderDO1.setQualityNo(22);

        ProcurementOrderDO procurementOrderDO2 = new ProcurementOrderDO();
        procurementOrderDO2.setProcurementOrderNo(7777L);
        procurementOrderDO2.setUserNo(8);
        procurementOrderDO2.setGoodsNo(1);
        procurementOrderDO2.setQualityNo(33);

        ProcurementOrderDO procurementOrderDO3 = new ProcurementOrderDO();
        procurementOrderDO3.setProcurementOrderNo(8888L);
        procurementOrderDO3.setUserNo(8);
        procurementOrderDO3.setGoodsNo(1);
        procurementOrderDO3.setQualityNo(22);

        ProcurementOrderDO procurementOrderDO4 = new ProcurementOrderDO();
        procurementOrderDO4.setProcurementOrderNo(99999L);
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
}
