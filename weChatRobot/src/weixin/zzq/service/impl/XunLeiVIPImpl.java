package weixin.zzq.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import weixin.zzq.mapper.XunLeiVIPMapper;
import weixin.zzq.model.XunLeiVIP;
import weixin.zzq.service.XunLeiVIPService;
@Service
@Transactional
public class XunLeiVIPImpl implements XunLeiVIPService{
    @Resource 
	private XunLeiVIPMapper xunLeiVIPMapper;
	public void save(XunLeiVIP leiVIP) {
		xunLeiVIPMapper.save(leiVIP);
	}

	public List<XunLeiVIP> findAll() {
			return xunLeiVIPMapper.findAll();
	}

	public XunLeiVIP findById(Integer id) {
		
		return xunLeiVIPMapper.findById(id);
	}

	public List<XunLeiVIP> OrderByIdDasc() {
		return xunLeiVIPMapper.OrderByIdDasc();
	}

}
