package spring.umc6th.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class MissionRequestDTO {

    @Getter
    public static class ChallengeMissionDTO {
        @NotNull
        Long memberId;
        @NotNull
        Long missionId;
    }
}
