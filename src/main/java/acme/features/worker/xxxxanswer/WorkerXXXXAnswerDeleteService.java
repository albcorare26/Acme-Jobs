
package acme.features.worker.xxxxanswer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.XXXXAnswer.XXXXAnswer;
import acme.entities.roles.Worker;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractDeleteService;

@Service
public class WorkerXXXXAnswerDeleteService implements AbstractDeleteService<Worker, XXXXAnswer> {

	@Autowired
	WorkerXXXXAnswerRepository repository;


	@Override
	public boolean authorise(final Request<XXXXAnswer> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<XXXXAnswer> request, final XXXXAnswer entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<XXXXAnswer> request, final XXXXAnswer entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "description", "moreInfo");

	}

	@Override
	public XXXXAnswer findOne(final Request<XXXXAnswer> request) {
		assert request != null;

		XXXXAnswer result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

	@Override
	public void validate(final Request<XXXXAnswer> request, final XXXXAnswer entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void delete(final Request<XXXXAnswer> request, final XXXXAnswer entity) {
		this.repository.delete(entity);

	}

}
