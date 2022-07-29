import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestMethods  {     
        public static void main(String[] args) {         
            TestMethods t = new TestMethods();
            try {
                t.getDateString(LocalDateTime.now());
            } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }
           

        }

        public String getDateString(LocalDateTime ldt){    return DateTimeFormatter.ISO_ZONED_DATE_TIME.format(ldt); }
    }