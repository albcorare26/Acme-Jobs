
package acme.features.authenticated.xxxxchallenge;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.XXXXChallenge.XXXXChallenge;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface XXXXChallengeRepository extends AbstractRepository {

	@Query("select x from XXXXChallenge x where x.id = ?1")
	XXXXChallenge findOneById(int id);

	@Query("select x from XXXXChallenge x where x.job.id = ?1")
	Collection<XXXXChallenge> findManyByJobId(int jobId);

}
