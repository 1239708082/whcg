package com.ltsk.whcg.base.mapper;

import com.ltsk.whcg.entity.Suspicsiteunload;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SuspicSiteUnloadMapper {

    @Select("select * from SUSPICSITEUNLOAD s where updatetime >= trunc(sysdate) and s.barriertype = #{type} and updatetime  = ( select max(updatetime) from SUSPICSITEUNLOAD where barriertype = #{type}) and name like #{name} and gdx like '11_.%' and gdy like '30%'")
    List<Suspicsiteunload> getAll(@Param("type") String type,@Param("name") String name);
}
