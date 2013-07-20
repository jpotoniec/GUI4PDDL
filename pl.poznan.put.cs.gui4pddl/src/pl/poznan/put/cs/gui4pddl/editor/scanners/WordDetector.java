package pl.poznan.put.cs.gui4pddl.editor.scanners;

import org.eclipse.jface.text.rules.IWordDetector;

public class WordDetector implements IWordDetector {
	public boolean isWordStart(char c) {
		return Character.isLetter(c);
	}

	public boolean isWordPart(char c) {
		return Character.isLetterOrDigit(c);
	}
}