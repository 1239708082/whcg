package com.ltsk.whcg.base.mapper;

import com.ltsk.whcg.entity.Site;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiteMapper {

    @Select("select t.* from site  t where t.updatetime =  ( select max(updatetime) from site  ) and gdx like '11_.%' and gdy like '30%'")
    public List<Site> getAll();
}
