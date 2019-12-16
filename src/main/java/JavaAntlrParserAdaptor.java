import com.intellij.psi.tree.IElementType;
import org.antlr.intellij.adaptor.parser.ANTLRParserAdaptor;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.JavaParser;

public class JavaAntlrParserAdaptor extends ANTLRParserAdaptor {

    public JavaAntlrParserAdaptor() {
        super(JavaLanguage.INSTANCE, new JavaParser(null));
    }

    @Override
    protected ParseTree parse(Parser parser, IElementType root) {
        return ((JavaParser) parser).primary();
    }

}
