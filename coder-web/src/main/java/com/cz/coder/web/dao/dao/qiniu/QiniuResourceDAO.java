package com.fq.dao.dao.qiniu;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fq.entity.po.SpQiniuResourcePO;
import com.fq.entity.vo.SpQiniuResourceVO;

@Repository
public interface QiniuResourceDAO {

	List<SpQiniuResourceVO> selectQiniuResourceForPage(
			Map<String, Object> paramMap);

	Integer selectQiniuResourceForCount(Map<String, Object> paramMap);

	void insertQiniuResource(SpQiniuResourcePO resource);

	void insertQiniuUrlResource(SpQiniuResourcePO resource);

}
