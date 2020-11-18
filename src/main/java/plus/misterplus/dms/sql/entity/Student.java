package plus.misterplus.dms.sql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String sno, spass, sname, dbno, dbd, drbno;

    public Student(String sno, String spass) {
        this.sno = sno;
        this.spass = spass;
    }
}
