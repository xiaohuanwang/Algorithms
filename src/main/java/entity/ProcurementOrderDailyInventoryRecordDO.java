package entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ProcurementOrderDailyInventoryRecordDO {
    private Long procurementOrderDailyInventoryRecordNo;
    private Long procurementOrderNo;
    private LocalDate thatDay;
    private BigDecimal thatDayNetWeight;
}
