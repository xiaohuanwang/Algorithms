import common.util.LocalJsonUtil;
import entity.Student;
import entity.SummaryDetailDTO;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentTest {
    public static void main(String[] args) {
        List<Student> studentList = LocalJsonUtil.getListFromJson("json/Student.json", Student.class);
        System.out.println(studentList.toString());

        Map<Object, Object> languageMap = LocalJsonUtil.getMapFromJson("json/languageMap.json");
        System.out.println(languageMap.toString());

        List<SummaryDetailDTO> summaryDetailDTOList = LocalJsonUtil.getListFromJson("json/SummaryDetail.json", SummaryDetailDTO.class);
//        System.out.println(summaryDetailDTOList.toString());
        summaryDetailDTOList.parallelStream().forEach(summaryDetailDTO -> {
            //     System.out.println(summaryDetailDTO.getCreateTime());
        });
        Timestamp timestamp10 = Timestamp.valueOf("2021-10-01 00:00:00");
        summaryDetailDTOList.parallelStream().
                filter(summaryDetailDTO -> summaryDetailDTO.getCreateTime().after(timestamp10))
                .forEach(summaryDetailDTO -> {
                    System.out.println(summaryDetailDTO.getCreateTime());
                });

        final Map<Integer, List<SummaryDetailDTO>> purchaserGroutBy = summaryDetailDTOList.parallelStream()
                .collect(Collectors.groupingBy(SummaryDetailDTO::getPurchaserNo, Collectors.toList()));
        purchaserGroutBy.forEach((purchaser, summaryDetailList) -> {
            System.out.println(purchaser + ":::" + summaryDetailList);
            final Map<Integer, List<SummaryDetailDTO>> goodsNoGroup = summaryDetailList.parallelStream()
                    .collect(Collectors.groupingBy(SummaryDetailDTO::getGoodsNo, Collectors.toList()));

        });

    }
}
