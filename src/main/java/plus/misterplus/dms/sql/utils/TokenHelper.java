package plus.misterplus.dms.sql.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import plus.misterplus.dms.web.Credentials;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenHelper {

    private static final long EXPIRE_TIME = 30 * 60 * 1000; //30 mins
    private static final String SECRET = "TD31V6W299GJV9KUYY8N";

    public static String createToken(String username, String usertype) {
        Map<String, Object> header = new HashMap<>();
        header.put("alg", "HS256");
        header.put("typ", "JWT");
        return JWT.create()
                .withHeader(header)
                .withClaim("username", username)
                .withClaim("usertype", usertype)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRE_TIME))
                .sign(Algorithm.HMAC256(SECRET));
    }

    public static boolean verify(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        DecodedJWT jwt = null;
        try {
            jwt = verifier.verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Credentials parseToken(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return new Credentials(jwt.getClaim("username").asString(), jwt.getClaim("usertype").asString());
    }

    public static boolean verifyAdmin(String token) {
        if (verify(token)) {
            Credentials credentials = parseToken(token);
            return "admin".equals(credentials.getUsertype());
        }
        return false;
    }
}
