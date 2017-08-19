package weixin.zzq.mapper;

import java.util.List;

import weixin.zzq.model.Email;
public interface EmailMapper {
	 void save(Email email);

	 Email findById(int id);

	 List<Email> selectWhereBeizhu(String Beizhu);

	 List<Email> selectWhereDingshi(String Dingshi);
	
	 List<Email> findAll();

	 void delete(int id);
}
