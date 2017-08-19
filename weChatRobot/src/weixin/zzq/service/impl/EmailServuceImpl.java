package weixin.zzq.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import weixin.zzq.mapper.EmailMapper;
import weixin.zzq.model.Email;
import weixin.zzq.service.EmailService;
@Service
@Transactional  
public class EmailServuceImpl implements EmailService{
    @Resource
    private EmailMapper emailMapper;
	public void save(Email email) {
		emailMapper.save(email);
	}

	public Email findById(int id) {
		return emailMapper.findById(id);
	}

	public List<Email> selectWhereBeizhu(String Beizhu) {
		return emailMapper.selectWhereBeizhu(Beizhu);
	}
  
	public List<Email> selectWhereDingshi(String Dingshi) {
		return emailMapper.selectWhereDingshi(Dingshi);
	}

	public List<Email> findAll() {
		
		return emailMapper.findAll();
	}

	public void delete(int id) {
		 emailMapper.delete(id);
	}

}
