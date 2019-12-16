import com.intellij.lang.Language;
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor;
import org.antlr.v4.runtime.Lexer;

public class JavaAntlrLexerAdaptor extends ANTLRLexerAdaptor {
    public JavaAntlrLexerAdaptor(Language language, Lexer lexer) {
        super(language, lexer);
    }

}
