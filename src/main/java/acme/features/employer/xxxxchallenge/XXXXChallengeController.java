
package acme.features.employer.xxxxchallenge;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.XXXXChallenge.XXXXChallenge;
import acme.entities.roles.Employer;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/employer/xxxx-challenge/")
public class XXXXChallengeController extends AbstractController<Employer, XXXXChallenge> {

	@Autowired
	XXXXChallengeListService	listMineService;

	@Autowired
	XXXXChallengeShowService	showService;

	@Autowired
	XXXXChallengeCreateService	createService;

	@Autowired
	XXXXChallengeUpdateService	updateService;

	@Autowired
	XXXXChallengeDeleteService	deleteService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, this.showService);

		super.addCustomCommand(CustomCommand.LIST_MINE, BasicCommand.LIST, this.listMineService);

		super.addBasicCommand(BasicCommand.CREATE, this.createService);

		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);

		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);

	}

}
