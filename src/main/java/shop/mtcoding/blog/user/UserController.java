package shop.mtcoding.blog.user;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 컨트롤러
 * 1. 요청받기 (URL - URI 포함)
 * 2. http body는 어떻게? (DTO)
 * 3. 기본 MIME 전략 : x-www-form-urlencoded (username=ssar&password=1234)
 * 4. 유효성 검사하기 (body 데이터가 있다면)
 * 5. 클라이언트가 view만 원하는지 혹은 DB 처리 후 view(여기서는 디스패처)도 원하는지
 * 6. view만 원하면 view를 응답하면 끝
 * 7. DB처리를 원하면 Model(DAO)에게 위임 후 view를 응답하면 끝
 */

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserRepository userRepository;
    private final HttpSession session;
//    public UserController(){
//        System.out.println("기본 생성자");
//    }
//    public UserController(UserRepository userRepository){
//        System.out.println("풀 생성자");
//        this.userRepository = userRepository;
//    }
    @PostMapping("/login")
    public String login(UserRequest.LoginDTO requestDTO){
        // 1. 유효성 검사
        if (requestDTO.getUsername().length()<3){
            return "error/400";
        }
        // 2. 모델 필요
        User user = userRepository.findByUsernameAndPassword(requestDTO);
//        System.out.println(user);
        if (user==null){
            return "error/401";
        }else {
            session.setAttribute("sessionUser",user);
            // 3. 응답
            return "redirect:/";
        }
    }
    @PostMapping("/join")
    public String join(UserRequest.JoinDTO requestDTO){
        System.out.println(requestDTO);

        // 1. 유효성 검사
        if (requestDTO.getUsername().length()<3){
            return "error/400";
        }
        // 2. 동일 username 체크
        User user = userRepository.findByUsername(requestDTO.getUsername());
        if (user == null){
            // 3. modle에게 위임하기
            userRepository.save(requestDTO);
        }else {
            return "error/400";
        }
        return "redirect:/loginForm";

    }
    @GetMapping("/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "user/loginForm";
    }

    @GetMapping("/user/updateForm")
    public String updateForm() {
        return "user/updateForm";
    }

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/";
    }
}
