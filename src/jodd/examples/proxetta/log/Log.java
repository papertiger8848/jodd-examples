// Copyright (c) 2003-2012, Jodd Team (jodd.org). All Rights Reserved.

package jodd.examples.proxetta.log;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.TYPE;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value={METHOD,CONSTRUCTOR,TYPE})
public @interface Log {

	int broj() default 17;

	String value() default "xxx";

}
