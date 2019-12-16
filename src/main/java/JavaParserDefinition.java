import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode;
import org.jetbrains.annotations.NotNull;
import parser.JavaLexer;

public class JavaParserDefinition implements ParserDefinition {
    public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
    public final IFileElementType FILE = new IFileElementType(JavaLanguage.INSTANCE);
    public static final TokenSet COMMENTS = TokenSet.create(TokenType.WHITE_SPACE);


    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        JavaLexer lexer = new JavaLexer(null);
        return new JavaAntlrLexerAdaptor(JavaLanguage.INSTANCE, lexer);
    }

    @Override
    public PsiParser createParser(Project project) {
        return new JavaAntlrParserAdaptor();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @NotNull
    public TokenSet getWhitespaceTokens() {
        return WHITE_SPACES;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        return new ANTLRPsiNode(node);
    }

    @Override
    public PsiFile createFile(FileViewProvider viewProvider) {
        return new JavaPsiFile(viewProvider);
    }

}
