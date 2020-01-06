
package acme.features.employer.xxxxchallenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.XXXXChallenge.XXXXChallenge;
import acme.entities.roles.Employer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractDeleteService;

@Service
public class EmployerXXXXChallengeDeleteService implements AbstractDeleteService<Employer, XXXXChallenge> {

	@Autowired
	EmployerXXXXChallengeRepository repository;


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
	public void delete(final Request<XXXXChallenge> request, final XXXXChallenge entity) {
		this.repository.delete(entity);

	}

}