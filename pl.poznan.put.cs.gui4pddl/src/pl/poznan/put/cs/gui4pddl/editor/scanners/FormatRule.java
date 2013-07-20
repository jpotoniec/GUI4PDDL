package pl.poznan.put.cs.gui4pddl.editor.scanners;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;

public class FormatRule implements IRule {
	private final IToken token;

	public FormatRule(IToken token) {
		this.token = token;
	}

	public IToken evaluate(ICharacterScanner scanner) {
		int c = scanner.read();
		if (c == ':') {
			do {
				c = scanner.read();
			} while (c != ICharacterScanner.EOF
					&& (Character.isLetterOrDigit((char) c) || c == '-' || c == '.'));
			scanner.unread();
			return token;
		}
		scanner.unread();
		return Token.UNDEFINED;
	}
}