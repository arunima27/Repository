package mcD.validateRecord;


import org.mule.api.MuleMessage;
import org.mule.api.routing.filter.Filter;


public class ValidateRecord implements Filter {
@Override
public boolean accept(MuleMessage message) {

Object responsePayload = message.getPayload();
String payload = responsePayload.toString();
	
	if (payload.equals("[]"))
	
			throw new NullPointerException("Requested data not found in database");


	return true;
}
}
