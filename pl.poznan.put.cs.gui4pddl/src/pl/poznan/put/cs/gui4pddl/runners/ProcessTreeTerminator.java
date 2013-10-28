package pl.poznan.put.cs.gui4pddl.runners;

import java.io.IOException;
import java.lang.reflect.Field;

import org.eclipse.core.runtime.IStatus;

import pl.poznan.put.cs.gui4pddl.log.Log;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

public class ProcessTreeTerminator {

	static interface Kernel32 extends Library {

		public static Kernel32 INSTANCE = (Kernel32) Native.loadLibrary(
				"kernel32", Kernel32.class);

		public int GetProcessId(Long hProcess);
	}

	private static int getPid(Process p) {
		Field f;

		if (Platform.isWindows()) {
			try {
				f = p.getClass().getDeclaredField("handle");
				f.setAccessible(true);
				int pid = Kernel32.INSTANCE.GetProcessId((Long) f.get(p));
				return pid;
			} catch (Exception ex) {
				Log.log(IStatus.WARNING, "Error while process PID reading", ex);
			}

		} else if (Platform.isLinux()) {
			try {
				f = p.getClass().getDeclaredField("pid");
				f.setAccessible(true);
				int pid = (Integer) f.get(p);
				return pid;
			} catch (Exception ex) {
				Log.log(IStatus.WARNING, "Error while process PID reading", ex);
			}
		}

		else {
		}
		return 0;
	}
	
	private static String getKillCmd() {
		if (Platform.isWindows())
			return "taskkill /t /f /pid ";
		return null;
	}

	
	public static void terminateProcessTree(Process p) {
		int pid = getPid(p);		
		String cmdLine = getKillCmd();		
		try {

			Process pr = Runtime.getRuntime()
					.exec(cmdLine + pid);
			try {
				pr.waitFor();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
