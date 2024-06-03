package spring.umc6th.web.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MissionResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateMemberMissionResultDTO {
        Long memberMissionId;
        LocalDateTime createdAt;
    }
}
