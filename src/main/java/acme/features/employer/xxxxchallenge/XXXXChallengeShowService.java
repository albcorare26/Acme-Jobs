
package acme.features.employer.xxxxchallenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.XXXXChallenge.XXXXChallenge;
import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class XXXXChallengeShowService implements AbstractShowService<Employer, XXXXChallenge> {

	@Autowired
	XXXXChallengeRepository repository;


	@Override
	public boolean authorise(final Request<XXXXChallenge> request) {
		assert request != null;

		boolean result;
		int jobId;
		XXXXChallenge challenge;
		Job job;
		Principal principal;

		principal = request.getPrincipal();
		jobId = request.getModel().getInteger("id");
		challenge = this.repository.findOneById(jobId);
		job = challenge.getJob();
		result = challenge.getJob().getId() == job.getId() && job.getEmployer().getId() == principal.getActiveRoleId();

		return result;
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

}
