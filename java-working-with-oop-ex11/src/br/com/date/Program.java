// https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
package br.com.date;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Instant;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Program {

    public static void main(String[] args) {

        /*
                Main types Java 8+
        - Data-hora local
            - LocalDate
            - LocalTime
        
        - Data-hora global
            - Instant
        
        - Duração
            - Duration
        
        - Outros
            - ZoneId
            - ChronoUnit
         */
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());

        LocalDate d01 = LocalDate.now();
        LocalDateTime d02 = LocalDateTime.now();
        Instant d03 = Instant.now();

        LocalDate d04 = LocalDate.parse("2024-01-10");
        LocalDateTime d05 = LocalDateTime.parse("2024-01-10T15:12:19");
        Instant d06 = Instant.parse("2024-01-10T01:12:19Z");
        Instant d07 = Instant.parse("2024-01-10T15:12:19-03:00"); // converte a time zone especificada(-03:00) para a time zone de londres 
        LocalDate d08 = LocalDate.parse("24/01/2024", fmt1);
        LocalDateTime d09 = LocalDateTime.parse("24/01/2024 05:45", fmt2);
        LocalDate d10 = LocalDate.of(2024, 10, 01);
        LocalDateTime d11 = LocalDateTime.of(2022, 7, 20, 1, 30);

        System.out.println("Date: " + d01 + "\nTime: " + d02 + "\nInstant: " + d03);
        System.out.println("Parse: " + d04 + "\nTime parse: " + d05 + "\nGlobal parse: " + d06);
        System.out.println("UK Parse: " + d07 + "\nFormated: " + d08 + "\nTime Formated: " + d09);
        System.out.println("Date Formated: " + d10 + "\nFormated Time: " + d11);
        System.out.println("d04 = " + d04.format(fmt1));
        System.out.println("d04 = " + fmt1.format(d04));
        System.out.println("d04 = " + d04.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("d05 = " + d05.format(fmt1));
        System.out.println("d05 = " + d05.format(fmt2));
        System.out.println("d06 = " + fmt3.format(d06));

        LocalDate r1 = LocalDate.ofInstant(d06, ZoneId.systemDefault());
        LocalDate r2 = LocalDate.ofInstant(d06, ZoneId.of("Portugal"));
        LocalDateTime r3 = LocalDateTime.ofInstant(d06, ZoneId.systemDefault());
        LocalDateTime r4 = LocalDateTime.ofInstant(d06, ZoneId.of("Portugal"));

        System.out.println("r1 = " + r1);
        System.out.println("r2 = " + r2);
        System.out.println("r3 = " + r3);
        System.out.println("r4 = " + r4);

        System.out.println("d04 dia = " + d04.getDayOfWeek());

        LocalDate pastWeekLocalDate = d04.minusDays(7);
        LocalDate nextWeekLocalDate = d04.plusDays(7);

        System.out.println("Past week date: " + pastWeekLocalDate);
        System.out.println("Next week date: " + nextWeekLocalDate);

        LocalDateTime pastWeekLocalDateTime = d05.minusDays(7);
        LocalDateTime nextWeekLocalDateTime = d05.plusDays(7);

        System.out.println("Past week time: " + pastWeekLocalDateTime);
        System.out.println("Next week time: " + nextWeekLocalDateTime);

        Instant pastWeekInstant = d06.minus(7, ChronoUnit.DAYS);
        Instant nextWeekInstant = d06.plus(7, ChronoUnit.DAYS);

        System.out.println("Past week instant: " + pastWeekInstant);
        System.out.println("Next week instant: " + nextWeekInstant);
        
        Duration t1 = Duration.between(pastWeekLocalDateTime, nextWeekLocalDateTime);
        System.out.println("t1 dias = " + t1.toDays());
    }
}
