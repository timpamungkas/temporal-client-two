package id.co.myapp.temporalio.client.two.saga.worker;

import id.co.myapp.temporalio.client.two.Shared;
import id.co.myapp.temporalio.client.two.saga.activity.ClientTwoSagaActivityImpl;
import id.co.myapp.temporalio.client.two.saga.workflow.ClientTwoSagaWorkflowImpl;
import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.serviceclient.WorkflowServiceStubsOptions;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;

public class ClientTwoSagaWorker {

	public static void main(String[] args) {
		WorkflowServiceStubs service = WorkflowServiceStubs
				.newInstance(WorkflowServiceStubsOptions.newBuilder().setTarget(Shared.TEMPORAL_SERVER).build());
		WorkflowClient client = WorkflowClient.newInstance(service);
		WorkerFactory factory = WorkerFactory.newInstance(client);
		Worker worker = factory.newWorker(Shared.CLIENT_TWO_TASK_QUEUE);
		worker.registerWorkflowImplementationTypes(ClientTwoSagaWorkflowImpl.class);
		worker.registerActivitiesImplementations(new ClientTwoSagaActivityImpl());
		factory.start();
	}

}