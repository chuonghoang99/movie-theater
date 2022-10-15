package fa.appcode.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.appcode.repositories.TypeRepository;
import fa.appcode.services.TypeService;
import fa.appcode.web.entities.Type;
@Service
@Transactional
public class TypeServiceImpl implements TypeService {
	@Autowired
	TypeRepository typeRepository;
	@Override
	public List<Type> findAll() {
		
		return typeRepository.findAll();
	}

	@Override
	public Type getById(Integer typeId) {
		// TODO Auto-generated method stub
		return typeRepository.getById(typeId);
	}

}
