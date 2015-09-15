package mcd.validateRecord;


import javax.xml.namespace.QName;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPFault;
import javax.xml.ws.soap.SOAPFaultException;

import org.apache.axis.message.SOAPEnvelope;
import org.mule.api.MuleMessage;
import org.mule.api.routing.filter.Filter;


public class ValidateRecord implements Filter {
@Override
public boolean accept(MuleMessage message) {
	try {
Object responsePayload = message.getPayload();
String payload = responsePayload.toString();
	
	if (payload.equals("[]")){
	SOAPFault soapFault;
	
		soapFault = SOAPFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL).createFault();
		soapFault.setFaultString("Requested data not found in database");
		soapFault.setFaultCode("500");
		throw new SOAPFaultException(soapFault);

	} 
	}catch (SOAPException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


			

	
	return true;
}
}
