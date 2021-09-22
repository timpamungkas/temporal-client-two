package id.co.myapp.temporalio.client.two.saga.activity;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface ClientTwoSagaActivity {

	@ActivityMethod
	String triggerClientTwoActivity_seq2(String identifier);

}
