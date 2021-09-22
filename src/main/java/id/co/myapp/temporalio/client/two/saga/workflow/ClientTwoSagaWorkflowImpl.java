package id.co.myapp.temporalio.client.two.saga.workflow;

import java.time.Duration;

import id.co.myapp.temporalio.client.two.saga.activity.ClientTwoSagaActivity;
import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;

public class ClientTwoSagaWorkflowImpl implements ClientTwoSagaWorkflow {

	private ActivityOptions options = ActivityOptions.newBuilder().setScheduleToCloseTimeout(Duration.ofSeconds(2))
			.build();

	private final ClientTwoSagaActivity clientTwoSagaActivity = Workflow.newActivityStub(ClientTwoSagaActivity.class,
			options);

	@Override
	public String triggerClientTwoWorkflow(String identifier) {
		System.out.println("Entering triggerClientTwoWorkflow for " + identifier);

		clientTwoSagaActivity.triggerClientTwoActivity_seq2(identifier);

		return "Workflow done for " + identifier;
	}

}
