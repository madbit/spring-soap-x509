package org.madbit.soapsecurity;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.madbit.doubleit.DoubleItPortType;
import org.madbit.doubleit.DoubleItRequest;
import org.madbit.doubleit.DoubleItResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WSClient {
    public static void main(String[] args) {
        ApplicationContext factory = new ClassPathXmlApplicationContext("client-context.xml");
        org.madbit.doubleit.DoubleItPortType port = (DoubleItPortType) factory.getBean("client");
        
        // next three lines optional, they output the SOAP request/response XML
        Client client = ClientProxy.getClient(port);
        client.getInInterceptors().add(new LoggingInInterceptor());
        client.getOutInterceptors().add(new LoggingOutInterceptor()); 
        
        doubleIt(port, 10);
    }
    
    public static void doubleIt(DoubleItPortType port, int numToDouble) {
    	DoubleItRequest request = new DoubleItRequest();
    	request.setNumberToDouble(numToDouble);
        DoubleItResponse response = port.doubleIt(request);
        System.out.println("The number " + numToDouble + " doubled is " + response.getDoubledNumber());
    }
}

