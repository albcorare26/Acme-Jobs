
package acme.features.worker.application;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.applications.Application;
import acme.entities.jobs.Job;
import acme.entities.roles.Worker;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractCreateService;

@Service
public class WorkerApplicationCreateService implements AbstractCreateService<Worker, Application> {

	@Autowired
	WorkerApplicationRepository repository;


	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;
		int jobId = request.getModel().getInteger("jobId");
		Job job = this.repository.findJobById(jobId);
		Date now = new Date(System.currentTimeMillis());

		boolean result = job.getDeadline().after(now) && job.isStatus() == true;

		return result;
	}

	@Override
	public void bind(final Request<Application> request, final Application entity, final Errors errors) {

		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "moment", "status");

	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "referenceNumber", "qualifications", "skills", "statement", "password");

	}

	@Override
	public Application instantiate(final Request<Application> request) {

		assert request != null;

		Application result;

		result = new Application();
		result.setStatus("pending");

		Date moment = new Date(System.currentTimeMillis() - 1);
		result.setMoment(moment);

		Principal principal = request.getPrincipal();
		int workerId = principal.getActiveRoleId();
		Worker worker = this.repository.findWorkerById(workerId);
		result.setWorker(worker);

		int jobId = request.getModel().getInteger("jobId");
		Job job = this.repository.findJobById(jobId);
		result.setJob(job);

		return result;

	}

	@Override
	public void validate(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Collection<String> references;
		String password = request.getModel().getString("password");

		if (!errors.hasErrors("referenceNumber")) {
			references = this.repository.allReferences();
			errors.state(request, !references.contains(entity.getReferenceNumber()), "referenceNumber", "worker.application.form.error.reference");
		}

		if (!errors.hasErrors("password")) {
			String numbers = password.replaceAll("\\D", "");
			String letters = password.replaceAll("[^A-Za-z]", "");
			String symbols = password.replaceAll("\\w", "");

			//cambiar en numero en la entrega
			errors.state(request, numbers.length() >= 3 && letters.length() >= 3 && symbols.length() >= 3 || password.equals(""), "password", "worker.application.form.error.password");
		}

	}

	@Override
	public void create(final Request<Application> request, final Application entity) {
		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);
	}

}
