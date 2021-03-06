// Copyright (c) 2003-2012, Jodd Team (jodd.org). All Rights Reserved.

package jodd.examples.proxetta.n.proxy;

import jodd.proxetta.MethodInfo;
import jodd.proxetta.ProxyPointcut;
import jodd.proxetta.AnnotationInfo;

import jodd.examples.proxetta.n.proxy.advice.TxAdvice;

public class TxPointcut implements ProxyPointcut {

	public boolean apply(MethodInfo methodInfo) {
		AnnotationInfo[] anns = methodInfo.getAnnotations();
		String txProxyName = TxAdvice.class.getName();
		for (AnnotationInfo a : anns) {
			if (a.getAnnotationClassname().equals(txProxyName)) {
				return true;
			}
		}
		return false;
	}
}
