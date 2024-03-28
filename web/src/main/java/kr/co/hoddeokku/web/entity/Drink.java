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
    int id;
    String korName;
    String engName;
    int price;
    String description;
    Date regDate;
    String img;
}
