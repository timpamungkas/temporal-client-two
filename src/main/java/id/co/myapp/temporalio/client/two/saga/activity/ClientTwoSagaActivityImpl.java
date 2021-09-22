package id.co.myapp.temporalio.client.two.saga.activity;

public class ClientTwoSagaActivityImpl implements ClientTwoSagaActivity {

	@Override
	public String triggerClientTwoActivity_seq2(String identifier) {
		String res = "Entering triggerClientTwoActivity_seq2 for " + identifier;

		System.out.println(res);
		return res;
	}

}
