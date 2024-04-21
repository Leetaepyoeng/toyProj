package kr.co.hoddeokku.web.entity;

import java.time.LocalDateTime;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HoddukLike {
    private Long userId;
    private Long hoddukId;
    private LocalDateTime regDate;
}
