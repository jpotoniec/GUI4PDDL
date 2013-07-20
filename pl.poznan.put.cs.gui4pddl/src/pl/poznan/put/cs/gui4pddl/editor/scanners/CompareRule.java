package pl.poznan.put.cs.gui4pddl.editor.scanners;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;

public class CompareRule implements IRule {
	private final IToken token;

	public CompareRule(IToken token) {
		this.token = token;
	}

	public IToken evaluate(ICharacterScanner scanner) {
		int c = scanner.read();
		if (c == '(') {
			do {
				c = scanner.read();
			} while (c != ICharacterScanner.EOF);
			scanner.unread();
			return token;
		}
		scanner.unread();
		return Token.UNDEFINED;
	}
}