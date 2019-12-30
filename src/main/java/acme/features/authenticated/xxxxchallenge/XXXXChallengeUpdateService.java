
package acme.features.authenticated.xxxxchallenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.XXXXChallenge.XXXXChallenge;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractUpdateService;

@Service
public class XXXXChallengeUpdateService implements AbstractUpdateService<Authenticated, XXXXChallenge> {

	@Autowired
	XXXXChallengeRepository repository;


	@Override
	public boolean authorise(final Request<XXXXChallenge> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<XXXXChallenge> request, final XXXXChallenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<XXXXChallenge> request, final XXXXChallenge entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "description", "moreInfo");

	}

	@Override
	public XXXXChallenge findOne(final Request<XXXXChallenge> request) {
		assert request != null;

		XXXXChallenge result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

	@Override
	public void validate(final Request<XXXXChallenge> request, final XXXXChallenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void update(final Request<XXXXChallenge> request, final XXXXChallenge entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
