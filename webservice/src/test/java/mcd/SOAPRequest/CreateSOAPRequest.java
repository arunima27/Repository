package mcd.SOAPRequest;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;


public class CreateSOAPRequest {

	public static void main(String[] args) {

		try {

			MessageFactory factory = MessageFactory.newInstance();

			SOAPMessage soapMsg = factory.createMessage();

			SOAPPart part = soapMsg.getSOAPPart();

			SOAPEnvelope envelope = part.getEnvelope();

			SOAPHeader header = envelope.getHeader();

			SOAPBody body = envelope.getBody();

			SOAPBodyElement element = body.addBodyElement(envelope.createName(
					"logicalMethod", "base", "http://base.ws.mcd/"));

			element.addChildElement("arg0")
					.addTextNode("UCB");

			soapMsg.writeTo(System.out);


		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
