package kr.co.hoddeokku.web.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HoddukView {
    private Long id;
    private String korName;
    private String engName;
    private int price;
    private String description;
    private String img;
    private int likeCount;
	private boolean like;
}
