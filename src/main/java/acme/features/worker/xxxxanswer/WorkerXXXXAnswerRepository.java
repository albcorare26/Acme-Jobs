
package acme.features.worker.xxxxanswer;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.XXXXAnswer.XXXXAnswer;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface WorkerXXXXAnswerRepository extends AbstractRepository {

	@Query("select x from XXXXAnswer x where x.id = ?1")
	XXXXAnswer findOneById(int id);

	@Query("select x from XXXXAnswer x where x.application.id = ?1")
	Collection<XXXXAnswer> findManyByApplicationId(int applicationId);

	@Query("select count(a) from XXXXAnswer a where a.application.id = ?1")
	int findRatioXXXXAnswer(int applicationId);

}
