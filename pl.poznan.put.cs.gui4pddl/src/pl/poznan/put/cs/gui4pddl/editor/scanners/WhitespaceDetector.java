package pl.poznan.put.cs.gui4pddl.editor.scanners;

import org.eclipse.jface.text.rules.IWhitespaceDetector;

public class WhitespaceDetector implements IWhitespaceDetector {
	public boolean isWhitespace(char c) {
		return Character.isWhitespace(c);
	}
}