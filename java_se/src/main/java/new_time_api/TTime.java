package new_time_api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TTime {

    public static void main(String[] args) {
        DateTimeFormatter yy_mm_dd = DateTimeFormatter.ofPattern("yyyy MM dd hh:mm:ss");
        String format = yy_mm_dd.format(LocalDateTime.now());
        System.out.println(format);
    }

    void timeFormat() {
        DateTimeFormatter yy_mm_dd = DateTimeFormatter.ofPattern("yyyy MM dd");
        String format = yy_mm_dd.format(LocalDateTime.now());
    }
}
