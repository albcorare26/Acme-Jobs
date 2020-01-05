
package acme.features.worker.xxxxanswer;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.XXXXAnswer.XXXXAnswer;
import acme.entities.roles.Worker;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class WorkerXXXXAnswerListService implements AbstractListService<Worker, XXXXAnswer> {

	@Autowired
	WorkerXXXXAnswerRepository repository;


	@Override
	public boolean authorise(final Request<XXXXAnswer> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<XXXXAnswer> request, final XXXXAnswer entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "description", "moreInfo");
	}

	@Override
	public Collection<XXXXAnswer> findMany(final Request<XXXXAnswer> request) {
		assert request != null;

		Collection<XXXXAnswer> result = this.repository.findManyByApplicationId(request.getModel().getInteger("applicationid"));

		return result;
	}

}
