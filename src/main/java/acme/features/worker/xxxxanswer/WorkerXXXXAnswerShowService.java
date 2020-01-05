
package acme.features.worker.xxxxanswer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.XXXXAnswer.XXXXAnswer;
import acme.entities.applications.Application;
import acme.entities.roles.Worker;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class WorkerXXXXAnswerShowService implements AbstractShowService<Worker, XXXXAnswer> {

	@Autowired
	WorkerXXXXAnswerRepository repository;


	@Override
	public boolean authorise(final Request<XXXXAnswer> request) {
		assert request != null;

		boolean result;
		int applicationId;
		XXXXAnswer answer;
		Application application;
		Principal principal;

		principal = request.getPrincipal();
		applicationId = request.getModel().getInteger("id");
		answer = this.repository.findOneById(applicationId);
		application = answer.getApplication();
		result = answer.getApplication().getId() == application.getId() && application.getWorker().getId() == principal.getActiveRoleId();

		return result;
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

}
