package id.co.myapp.temporalio.client.two.saga.workflow;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface ClientTwoSagaWorkflow {

	@WorkflowMethod
	String triggerClientTwoWorkflow(String name);

}