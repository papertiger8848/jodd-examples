// Copyright (c) 2003-2012, Jodd Team (jodd.org). All Rights Reserved.

package jodd.examples.proxetta.dci2;

public class InjectUtil {

	public static Object create(Object role) {
		return FrameworkManager.findRoleTarget(role);
	}
}
