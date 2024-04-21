package kr.co.hoddeokku.web.service;

import kr.co.hoddeokku.web.entity.HoddukLike;

public interface HoddukLikeService {
    HoddukLike add(HoddukLike hoddukLike);
    String cancel(HoddukLike hoddukLike);
}
