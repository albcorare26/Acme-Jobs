
package acme.features.worker.xxxxanswer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.XXXXAnswer.XXXXAnswer;
import acme.entities.applications.Application;
import acme.entities.roles.Worker;
import acme.features.worker.application.WorkerApplicationRepository;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractCreateService;

@Service
public class WorkerXXXXAnswerCreateService implements AbstractCreateService<Worker, XXXXAnswer> {

	@Autowired
	WorkerXXXXAnswerRepository	repository;

	@Autowired
	WorkerApplicationRepository	applicationRepository;


	@Override
	public boolean authorise(final Request<XXXXAnswer> request) {
		assert request != null;

		Principal principal = request.getPrincipal();
		int applicationId = request.getModel().getInteger("applicationid");

		Application application = this.repository.findApplicationById(applicationId);

		boolean result;
		result = application.getWorker().getId() == principal.getActiveRoleId();

		return result;
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
		model.setAttribute("applicationid", entity.getApplication().getId());

	}

	@Override
	public XXXXAnswer instantiate(final Request<XXXXAnswer> request) {
		assert request != null;

		XXXXAnswer result;
		Application application;
		int applicationId;

		result = new XXXXAnswer();
		applicationId = request.getModel().getInteger("applicationid");
		application = this.applicationRepository.findOneApplicationById(applicationId);
		result.setApplication(application);

		return result;
	}

	@Override
	public void validate(final Request<XXXXAnswer> request, final XXXXAnswer entity, final Errors errors) {
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
	public void create(final Request<XXXXAnswer> request, final XXXXAnswer entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
