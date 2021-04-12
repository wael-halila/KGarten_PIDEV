package tn.esprit.spring.sevice.interfece;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.User;

@Repository
public interface IUserService extends CrudRepository<User, Long> {

	static void affecterEmployeADepartement(long idclaim, long iduser) {
		// TODO Auto-generated method stub
		
	}

}
