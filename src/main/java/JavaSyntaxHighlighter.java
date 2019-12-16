import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor;
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory;
import org.antlr.intellij.adaptor.lexer.TokenIElementType;
import org.jetbrains.annotations.NotNull;
import parser.JavaLexer;
import parser.JavaParser;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class JavaSyntaxHighlighter extends SyntaxHighlighterBase {

    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];
    public static final TextAttributesKey ID =
            createTextAttributesKey("ID", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey KEYWORD =
            createTextAttributesKey("KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey LITERAL =
            createTextAttributesKey("LITERAL", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey OPERATORS =
            createTextAttributesKey("OPERATORS", DefaultLanguageHighlighterColors.BRACES);
    public static final TextAttributesKey LINE_COMMENT =
            createTextAttributesKey("LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BLOCK_COMMENT =
            createTextAttributesKey("BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT);

    static {
        PSIElementTypeFactory.defineLanguageIElementTypes(JavaLanguage.INSTANCE,
                JavaParser.tokenNames,
                JavaParser.ruleNames);
    }

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        JavaLexer lexer = new JavaLexer(null);
        return new ANTLRLexerAdaptor(JavaLanguage.INSTANCE, lexer);
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if ( !(tokenType instanceof TokenIElementType) ) return EMPTY_KEYS;
        TokenIElementType myType = (TokenIElementType)tokenType;
        int ttype = myType.getANTLRTokenType();
        TextAttributesKey attrKey;
        if (ttype == JavaLexer.IDENTIFIER)
            attrKey = ID;
        else if (1 <= ttype && ttype <= 50)
            attrKey = KEYWORD;
        else if (50 <= ttype && ttype <= 60)
            attrKey = LITERAL;
        else if (61 <= ttype && ttype <= 107)
            attrKey = OPERATORS;
        else if (ttype == JavaLexer.COMMENT)
            attrKey = BLOCK_COMMENT;
        else if (ttype == JavaLexer.LINE_COMMENT)
            attrKey = LINE_COMMENT;
        else
            return EMPTY_KEYS;

        return new TextAttributesKey[] {attrKey};
    }

}
