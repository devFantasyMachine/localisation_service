package cm.enspy.gi.project.localisation_service.config;

public class SecurityConstants {

    public static final String SECRET = "SECRET_KEY";
    public static final long ACCESS_EXPIRATION_TIME = 900_000; // 15 mins
    public static final long REFRESH_EXPIRATION_TIME = 90000_000; // 15 mins
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";

}