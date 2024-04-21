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
public class Drink {
    private int id;
    private String korName;
    private String engName;
    private int price;
    private String description;
    private Date regDate;
    private String img;
}
