package org.madbit.soapsecurity;

import org.madbit.doubleit.DoubleItPortType;
import org.madbit.doubleit.DoubleItRequest;
import org.madbit.doubleit.DoubleItResponse;

public class DoubleItPortTypeImpl implements DoubleItPortType {

	@Override
	public DoubleItResponse doubleIt(DoubleItRequest parameters) {
		System.out.println("Call received");
		int num = parameters.getNumberToDouble();		
		DoubleItResponse response = new DoubleItResponse();
		response.setDoubledNumber(num * 2);
		return response;
	}

}
