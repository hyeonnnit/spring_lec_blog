package shop.mtcoding.blog.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserRepository {
    private EntityManager em;

    public UserRepository(EntityManager em) {
        this.em = em;
    }
    @Transactional
    public void save(UserRequest.JoinDTO requestDTO){
        System.out.println("UserRepository에 save 메소드 호출됨");
        Query query = em.createNativeQuery("insert into user_tb (username, password, email)values (?,?,?)");
        query.setParameter(1, requestDTO.getUsername());
        query.setParameter(2, requestDTO.getPassword());
        query.setParameter(3, requestDTO.getEmail());
        query.executeUpdate();

    }
    @Transactional
    public void saveV2(UserRequest.JoinDTO requestDTO){
        User user = new User();
        user.setUsername(requestDTO.getUsername());
        user.setPassword(requestDTO.getPassword());
        user.setEmail(requestDTO.getEmail());
        em.persist(user);
    }

    public User findByUsernameAndPassword(UserRequest.LoginDTO requestDTO) {
        Query query = em.createNativeQuery("select * from user_tb where username=? and password=?", User.class);
        query.setParameter(1, requestDTO.getUsername());
        query.setParameter(2, requestDTO.getPassword());
        try{
            User user = (User) query.getSingleResult();
            return user;
        }catch (Exception e){
            return null;
        }
    }

    public User findByUsername(String username) {
        Query query = em.createNativeQuery("select * from user_tb where username=?", User.class);
        query.setParameter(1, username);
        try{
            User user = (User) query.getSingleResult();
            return user;
        }catch (Exception e){
            return null;
        }
    }
}
