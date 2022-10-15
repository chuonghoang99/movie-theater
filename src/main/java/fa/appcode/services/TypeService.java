package fa.appcode.services;

import java.util.List;

import fa.appcode.web.entities.Type;

public interface TypeService {
	List<Type> findAll();
	Type getById(Integer typeId);
}
