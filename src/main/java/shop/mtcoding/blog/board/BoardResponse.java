package shop.mtcoding.blog.board;

import lombok.Data;

import java.sql.Timestamp;

public class BoardResponse {
    @Data
    public static class DetailDTO {
        // Board
        private Integer id;
        private String title;
        private String content;
        private Integer userId;
        private String username;
        private Timestamp createdAt;

        // Reply
        private Integer rId;
        private Integer rUserId;
        private String rUsername;
        private String rComment;
    }
}
