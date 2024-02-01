package shop.mtcoding.blog.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import shop.mtcoding.blog.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final HttpSession session;
    private final BoardRepository boardRepository;
    @GetMapping({ "/", "/board" })
    public String index(HttpServletRequest request) {
        List<Board> boardList = boardRepository.findAll();
        System.out.println(boardList);
//        User sessionUser = (User) session.getAttribute("sessionUser");
        request.setAttribute("boardList",boardList);
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
