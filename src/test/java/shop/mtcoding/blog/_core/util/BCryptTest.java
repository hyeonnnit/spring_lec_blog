package shop.mtcoding.blog._core.util;

import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;

public class BCryptTest {

    // $2a$10$CdVkw/SEr6B1AAHJxEQZtu
    @Test
    public void gensalt_test(){
        String salt = BCrypt.gensalt();
        System.out.println(salt);
    }
    // $2a$10$WzLRRG916fODLbIvxXZlzO29FJwCXpUhPSFda5tvt1f2gF9KmHk7G
    @Test
    public void hashpw_test(){
        String rawPassword = "1234";
        String encPassword = BCrypt.hashpw(rawPassword,BCrypt.gensalt());
        System.out.println(encPassword);
    }
}
