package shop.mtcoding.blog.board;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import shop.mtcoding.blog.user.User;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final HttpSession session;
    private final BoardRepository boardRepository;
    @GetMapping("/api/board/{id}")
    public @ResponseBody Board apiBoard(@PathVariable int id){
        return boardRepository.findById(id);
    }
    @GetMapping({ "/", "/board" })
    public String index() {
        User sessionUser = (User) session.getAttribute("sessionUser");

        return "index";
    }

    @GetMapping("/board/saveForm")
    public String saveForm() {
        return "board/saveForm";
    }

    @GetMapping("/board/1")
    public String detail() {
        return "board/detail";
    }
}
