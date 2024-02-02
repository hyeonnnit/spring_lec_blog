package shop.mtcoding.blog.board;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;
//bt.id, bt.title, bt.content, bt.user_id, ut.username, bt.created_at
// bt.id, bt.title, bt.content, bt.created_at, bt.user_id, ut.username
public class BoardResponse {
    @Data
    @AllArgsConstructor
    public static class DetailDTO{
        private int id;
        private String title;
        private String content;
        private int userId;
        private String username;
        private Timestamp createdAt;
    }
}
