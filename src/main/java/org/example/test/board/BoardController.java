package org.example.test.board;

import lombok.RequiredArgsConstructor;
import org.example.test.board.model.BoardDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(
        origins = "http://localhost:5173",
        allowCredentials = "true"
)

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    // 게시글 작성
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody BoardDto.RegisterReq dto) {
        BoardDto.BoardRes result = boardService.register(dto);
        return ResponseEntity.ok(result);
    }


    // 게시글 상세 조회
    @GetMapping("/read/{idx}")
    public ResponseEntity read(@PathVariable Long idx) {
        BoardDto.BoardRes result = boardService.read(idx);
        return ResponseEntity.ok(result);
    }

    // 게시글 목록 조회 (전체 조회 )
    @GetMapping("/read/list")
    public ResponseEntity list() {
        List<BoardDto.BoardRes> result = boardService.list();
        return ResponseEntity.ok(result);
    }
}
