
package acme.features.worker.xxxxanswer;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.XXXXAnswer.XXXXAnswer;
import acme.entities.roles.Worker;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/worker/xxxx-answer/")
public class WorkerXXXXAnswerController extends AbstractController<Worker, XXXXAnswer> {

	@Autowired
	WorkerXXXXAnswerListService		listMineService;

	@Autowired
	WorkerXXXXAnswerShowService		showService;

	@Autowired
	WorkerXXXXAnswerCreateService	createService;

	@Autowired
	WorkerXXXXAnswerUpdateService	updateService;

	@Autowired
	WorkerXXXXAnswerDeleteService	deleteService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, this.showService);

		super.addCustomCommand(CustomCommand.LIST_MINE, BasicCommand.LIST, this.listMineService);

		super.addBasicCommand(BasicCommand.CREATE, this.createService);

		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);

		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);

	}

}
