package plus.misterplus.dms.web;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Credentials {

    private final String username;
    private final String usertype;
}
