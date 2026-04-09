package org.example.test.board.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class BoardDto {

    // 게시글 작성 요청
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class RegisterReq {
        private String title;
        private String contents;

        // DTO -> 엔티티
        public Board toEntity() {
            return Board.builder()
                    .title(this.title)
                    .contents(this.contents)
                    .build();
        }
    }

    // 게시글 관련 응답 (작성, 조회 전부)
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Builder
    public static class BoardRes {
        private Long idx;
        private String title;
        private String contents;

        // 엔티티 -> dto
        public static BoardRes from(Board entity) {
            return BoardRes.builder()
                    .idx(entity.getIdx())
                    .title(entity.getTitle())
                    .contents(entity.getContents())
                    .build();
        }
    }
}
