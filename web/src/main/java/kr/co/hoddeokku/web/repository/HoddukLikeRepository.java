package kr.co.hoddeokku.web.repository;

import org.apache.ibatis.annotations.Mapper;

import kr.co.hoddeokku.web.entity.HoddukLike;

@Mapper
public interface HoddukLikeRepository {
    int save(HoddukLike hddukLike);
    int delete(HoddukLike hoddukLike);
}
