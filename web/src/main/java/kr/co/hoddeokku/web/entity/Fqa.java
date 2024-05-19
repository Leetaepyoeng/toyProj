package kr.co.hoddeokku.web.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Fqa {
    private int id;
    String title;
    String content;
    Date regDate;
    int adminId;
}
