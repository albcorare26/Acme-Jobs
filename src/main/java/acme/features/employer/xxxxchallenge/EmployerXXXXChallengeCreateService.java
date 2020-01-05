
package acme.features.employer.xxxxchallenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.XXXXChallenge.XXXXChallenge;
import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.features.employer.job.EmployerJobRepository;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class EmployerXXXXChallengeCreateService implements AbstractCreateService<Employer, XXXXChallenge> {

	@Autowired
	EmployerXXXXChallengeRepository	repository;

	@Autowired
	EmployerJobRepository	jobRepository;


	@Override
	public boolean authorise(final Request<XXXXChallenge> request) {
		assert request != null;

		boolean result = true;
		int jobId = request.getModel().getInteger("jobid");

		if (this.repository.findRatioXXXXChallenge(jobId) >= 1) {
			result = false;
		}

		return result;
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
		model.setAttribute("jobid", entity.getJob().getId());

	}

	@Override
	public XXXXChallenge instantiate(final Request<XXXXChallenge> request) {
		assert request != null;

		XXXXChallenge result;
		Job job;
		int jobId;

		result = new XXXXChallenge();
		jobId = request.getModel().getInteger("jobid");
		job = this.jobRepository.findOneById(jobId);
		result.setJob(job);

		return result;
	}

	@Override
	public void validate(final Request<XXXXChallenge> request, final XXXXChallenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<XXXXChallenge> request, final XXXXChallenge entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
