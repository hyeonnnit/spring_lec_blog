package shop.mtcoding.blog.reply;

import lombok.Data;

public class ReplyRequest {
    @Data
    public class WriteDTO {
        private String comment;
        private int boardId;
    }
}
