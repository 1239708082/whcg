package com.ltsk.whcg.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ltsk.whcg.entity.Trash;

@Mapper
public interface TrashMapper {
	@Select("select * from TRASH t where x is not null and y is not null")
	public List<Trash> getTrash(); 
	
	@Update("update TRASH set gdx=#{x},gdy=#{y} where id=#{id}")
	public int update_trash(@Param("y")String lat,@Param("x")String lon,@Param("id")Integer id);
	
//	@Select("select * from TRASH t where x is not null and y is not null")
	@Select("<script> " +  
            "SELECT * " +  
            "from TRASH " +  
            " <where> " +  
            " x like '114%'  and y like '30%'  " +  
            " <if test='xzqh != null'>and xzqh= #{xzqh}</if> " +  
            " </where> " +  
            " </script> ")  
	public List<Trash> getNewTrash(@Param("xzqh")String xzqh); 
	
}
