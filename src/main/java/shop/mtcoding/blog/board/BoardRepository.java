package shop.mtcoding.blog.board;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class BoardRepository {
    private final EntityManager em;

    public List<Board> findAll() {
        Query query = em.createNativeQuery("select * from board_tb order by id desc ", Board.class);
        List<Board> boardList=query.getResultList();
        return boardList;
    }
}
