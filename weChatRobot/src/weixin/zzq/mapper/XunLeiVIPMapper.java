package weixin.zzq.mapper;

import java.util.List;

import weixin.zzq.model.XunLeiVIP;
/**
 * 数据操作对应类
 * @author zhuzhiqiang
 *
 */
public interface XunLeiVIPMapper {
	void save(XunLeiVIP leiVIP);
	
    List<XunLeiVIP> findAll();
    
    XunLeiVIP findById(Integer id);
    
    List<XunLeiVIP> OrderByIdDasc();
}
