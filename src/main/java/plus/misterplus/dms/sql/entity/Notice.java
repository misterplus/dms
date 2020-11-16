package plus.misterplus.dms.sql.entity;

import java.util.Date;

public class Notice {
    private Date ntime;
    private String ntitle, ncontent;

    public Notice(Date ntime, String ntitle, String ncontent) {
        this.ntime = ntime;
        this.ntitle = ntitle;
        this.ncontent = ncontent;
    }
}
