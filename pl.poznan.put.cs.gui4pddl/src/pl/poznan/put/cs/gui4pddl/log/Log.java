package pl.poznan.put.cs.gui4pddl.log;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import pl.poznan.put.cs.gui4pddl.Activator;

public class Log {

	/**
	 * Only applicable when plugin == null (i.e.: running tests)
	 */
	private static final int DEBUG_LEVEL = IStatus.WARNING;

	/**
	 * @param errorLevel
	 *            IStatus.[OK|INFO|WARNING|ERROR]
	 * @return CoreException that can be thrown for the given log event
	 */
	public static CoreException log(int errorLevel, String message, Throwable e) {
		Activator plugin = Activator.getDefault();
		String id;
		if (plugin == null) {
			id = "pl.poznan.put.cs.gui4pddl";
		} else {
			id = plugin.getBundle().getSymbolicName();
		}

		Status s = new Status(errorLevel, id, errorLevel, message, e);
		CoreException coreException = new CoreException(s);

		// TODO find out if we should log repetitive exceptions

		try {
			if (plugin != null) {
				plugin.getLog().log(s);
			} else {
				if (DEBUG_LEVEL <= errorLevel) {
					System.err.println(message);
					if (e != null) {
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e1) {
			// logging should not fail!
		}
		return coreException;
	}

	public static CoreException log(Throwable e) {
		return log(IStatus.ERROR, e.getMessage() != null ? e.getMessage()
				: "No message gotten (null message).", e);
	}

	public static CoreException log(String msg) {
		return log(IStatus.ERROR, msg, new RuntimeException(msg));
	}

	public static CoreException log(String msg, Throwable e) {
		return log(IStatus.ERROR, msg, e);
	}

	public static CoreException logInfo(Throwable e) {
		return log(IStatus.INFO, e.getMessage(), e);
	}

	public static CoreException logInfo(String msg) {
		return log(IStatus.INFO, msg, new RuntimeException(msg));
	}

	public static CoreException logInfo(String msg, Throwable e) {
		return log(IStatus.INFO, msg, e);
	}
	
	//TODO find out if we need log to file

}
