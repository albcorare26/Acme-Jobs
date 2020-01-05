
package acme.features.employer.xxxxchallenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.XXXXChallenge.XXXXChallenge;
import acme.entities.roles.Employer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractUpdateService;

@Service
public class EmployerXXXXChallengeUpdateService implements AbstractUpdateService<Employer, XXXXChallenge> {

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

		String password = request.getModel().getString("password");

		if (!errors.hasErrors("password")) {
			String numbers = password.replaceAll("\\D", "");
			String letters = password.replaceAll("[^A-Za-z]", "");
			String symbols = password.replaceAll("\\w", "");

			//cambiar en numero en la entrega
			errors.state(request, numbers.length() >= 3 && letters.length() >= 3 && symbols.length() >= 3 || password.equals(""), "password", "worker.application.form.error.password");
		}

	}

	@Override
	public void update(final Request<XXXXChallenge> request, final XXXXChallenge entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
