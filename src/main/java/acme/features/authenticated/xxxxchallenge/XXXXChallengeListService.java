
package acme.features.authenticated.xxxxchallenge;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.XXXXChallenge.XXXXChallenge;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class XXXXChallengeListService implements AbstractListService<Authenticated, XXXXChallenge> {

	@Autowired
	XXXXChallengeRepository repository;


	@Override
	public boolean authorise(final Request<XXXXChallenge> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<XXXXChallenge> request, final XXXXChallenge entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "description", "moreInfo");
	}

	@Override
	public Collection<XXXXChallenge> findMany(final Request<XXXXChallenge> request) {
		assert request != null;

		Collection<XXXXChallenge> result = this.repository.findManyByJobId(request.getModel().getInteger("jobid"));

		return result;
	}

}
