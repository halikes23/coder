package com.fq.dao.impl.qiniu;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fq.dao.BaseDAO;
import com.fq.dao.dao.qiniu.QiniuResourceDAO;
import com.fq.entity.po.SpQiniuResourcePO;
import com.fq.entity.vo.SpQiniuResourceVO;

@Repository
public class QiniuResourceDaoImpl extends BaseDAO implements QiniuResourceDAO{

	@Override
	public List<SpQiniuResourceVO> selectQiniuResourceForPage(
			Map<String, Object> paramMap) {
		return this.getSqlMapClientTemplate().queryForList("QiniuResourceDaoImpl.selectQiniuResourceForPage",paramMap);
	}

	@Override
	public Integer selectQiniuResourceForCount(Map<String, Object> paramMap) {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("QiniuResourceDaoImpl.selectQiniuResourceForCount",paramMap);
	}

	@Override
	public void insertQiniuResource(SpQiniuResourcePO resource) {

		this.getSqlMapClientTemplate().insert("QiniuResourceDaoImpl.insertQiniuResource", resource) ;
		
	}

	@Override
	public void insertQiniuUrlResource(SpQiniuResourcePO resource) {
		this.getSqlMapClientTemplate().insert("QiniuResourceDaoImpl.insertQiniuUrlResource", resource);
	}

}
