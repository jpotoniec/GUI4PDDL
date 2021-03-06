/*******************************************************************************
 * Copyright (c) 2014 Poznan University of Technology.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Poznan University of Technology - initial API and implementation
 ******************************************************************************/
package pl.poznan.put.cs.gui4pddl.runners;

import java.io.IOException;
import java.lang.reflect.Field;

import org.eclipse.core.runtime.IStatus;

import pl.poznan.put.cs.gui4pddl.log.Log;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

/**
 * Kills the whole process tree on linux or windows
 *
 */
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
	
	private static String[] getKillCmd(int pid) {
		if (Platform.isWindows())
			return new String[]{"cmd.exe" , "/c", "taskkill /t /f /pid " + pid};
		else if (Platform.isLinux())
			return new String[]{ "/bin/sh", "-c", "pstree -p " + pid + " | grep -o '([0-9]*)' | grep -o '[0-9]*' | xargs kill;"};
		return null;
	}

	
	public static void terminateProcessTree(Process p) {
		int pid = getPid(p);	
		String[] cmdLine = getKillCmd(pid);		
		try {
			Process pr = Runtime.getRuntime()
					.exec(cmdLine);
			try {
				pr.waitFor();
			} catch (InterruptedException e) {
				Log.log(e);
				e.printStackTrace();
			}
		} catch (IOException e) {
			Log.log(e);
			e.printStackTrace();
		}

	}
}
