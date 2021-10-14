package common.util;

import cn.hutool.core.lang.Pair;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class TimeHelper {
    public TimeHelper() {
    }

    public static LocalDateTime nowLocalDateTime() {
        return LocalDateTime.now();
    }

    public static Timestamp nowTimestamp() {
        return Timestamp.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Instant nowInstant() {
        return LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant();
    }

    public static List<Pair<LocalDateTime, LocalDateTime>> listPearMonthTimeBetweenPairOrderByDesc(LocalDate startDate, LocalDate endDate) {
        Objects.requireNonNull(startDate, "Arg 'startDate' can not be null");
        Objects.requireNonNull(endDate, "Arg 'endDate' can not be null");
        YearMonth startYearMonth = YearMonth.from(startDate);
        YearMonth endYearMonth = YearMonth.from(endDate);
        return (List) Stream.iterate(startYearMonth, (yearMonth) -> {
            return yearMonth.plusMonths(1L);
        }).limit(ChronoUnit.MONTHS.between(startYearMonth, endYearMonth.plusMonths(1L))).sorted((o1, o2) -> {
            if (o1.equals(o2)) {
                return 0;
            } else {
                return o1.isBefore(o2) ? 1 : -1;
            }
        }).map((yearMonth) -> {
            if (yearMonth.equals(startYearMonth)) {
                return Pair.of(LocalDateTime.of(startDate, LocalTime.MIN), LocalDateTime.of(startYearMonth.atEndOfMonth(), LocalTime.MAX));
            } else {
                return yearMonth.equals(endYearMonth) ? Pair.of(LocalDateTime.of(endYearMonth.atDay(1), LocalTime.MIN), LocalDateTime.of(endDate, LocalTime.MAX)) : Pair.of(LocalDateTime.of(LocalDate.of(yearMonth.getYear(), yearMonth.getMonth(), 1), LocalTime.MIN), LocalDateTime.of(yearMonth.atEndOfMonth(), LocalTime.MAX));
            }
        }).collect(Collectors.toList());
    }

    public static Integer getTotalPagesOfTimePageReqByDay(LocalDate startDate, LocalDate endDate, int pageSize) {
        Objects.requireNonNull(startDate, "Arg 'startDate' can not be null");
        Objects.requireNonNull(endDate, "Arg 'endDate' can not be null");
        Period period = Period.between(startDate, endDate.plusDays(1L));
        return pageSize == period.getDays() % pageSize ? 1 : period.getDays() / pageSize + (0 == period.getDays() % pageSize ? 0 : 1);
    }

    public static List<LocalDate> listLocalDateOfTimePageReqByDay(LocalDate startDate, LocalDate endDate, int pageSize, int offset) {
        Objects.requireNonNull(startDate, "Arg 'startDate' can not be null");
        Objects.requireNonNull(endDate, "Arg 'endDate' can not be null");
        LocalDate pageStartDate = startDate.plusDays((long) pageSize * (long) offset);
        pageStartDate = pageStartDate.isBefore(endDate) ? pageStartDate : endDate.plusDays(1L);
        LocalDate pageEndDate = pageStartDate.plusDays((long) (pageSize - 1));
        pageEndDate = pageEndDate.isBefore(endDate) ? pageEndDate : endDate;
        return (List) Stream.iterate(pageStartDate, (localDate) -> {
            return localDate.plusDays(1L);
        }).limit(ChronoUnit.DAYS.between(pageStartDate, pageEndDate.plusDays(1L))).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(listPearMonthTimeBetweenPairOrderByDesc(LocalDate.of(2021, 1, 2), LocalDate.of(2021, 6, 3)));
    }
}
