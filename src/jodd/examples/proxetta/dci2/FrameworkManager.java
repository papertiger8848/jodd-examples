// Copyright (c) 2003-2012, Jodd Team (jodd.org). All Rights Reserved.

package jodd.examples.proxetta.dci2;

import jodd.proxetta.InvokeAspect;
import jodd.proxetta.InvokeInfo;
import jodd.proxetta.InvokeReplacer;
import jodd.proxetta.impl.InvokeProxetta;

import java.util.HashMap;
import java.util.Map;

public class FrameworkManager {

	private static Map<Object, Object> bindngs = new HashMap<Object, Object>();
	private static Map<Class, Class> proxies = new HashMap<Class, Class>();

	public static synchronized Object findRoleTarget(Object role) {
		return bindngs.get(role);
	}

	public static synchronized <T> T bind(Class<T> roleClass, Object target) {
		Class proxifiedRoleclass = proxies.get(roleClass);
		if (proxifiedRoleclass == null) {
			proxifiedRoleclass = fp.builder(roleClass).define();
			proxies.put(roleClass, proxifiedRoleclass);
		}
		try {
			Object role = proxifiedRoleclass.newInstance();
			bindngs.put(role, target);
			return (T) role;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	// ---------------------------------------------------------------- proxetta

	private static InvokeProxetta fp = InvokeProxetta.withAspects(
			new InvokeAspect() {
				@Override
				public InvokeReplacer pointcut(InvokeInfo invokeInfo) {
					if (invokeInfo.getClassName().equals(Self.class.getCanonicalName()) &&
							invokeInfo.getMethodName().equals("get")
							) {
						return InvokeReplacer.
								with(InjectUtil.class, "create").
								passThis(true);
					}
					return null;
				}
			}
	);


}
