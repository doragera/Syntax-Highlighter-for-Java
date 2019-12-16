import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.*;
import org.jetbrains.annotations.*;

import javax.swing.*;
import java.util.Map;

public class JavaColorSettingsPage implements ColorSettingsPage {
  private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
          new AttributesDescriptor("Identifier", JavaSyntaxHighlighter.ID),
          new AttributesDescriptor("Keyword", JavaSyntaxHighlighter.KEYWORD),
          new AttributesDescriptor("Literal", JavaSyntaxHighlighter.LITERAL),
          new AttributesDescriptor("Operator", JavaSyntaxHighlighter.OPERATORS),
          new AttributesDescriptor("Line comment", JavaSyntaxHighlighter.LINE_COMMENT),
          new AttributesDescriptor("Block comment", JavaSyntaxHighlighter.BLOCK_COMMENT)

  };

  @Nullable
  @Override
  public Icon getIcon() {
    return SimpleIcons.FILE;
  }

  @NotNull
  @Override
  public SyntaxHighlighter getHighlighter() {
    return new JavaSyntaxHighlighter();
  }

  @NotNull
  @Override
  public String getDemoText() {
    return "/* Block comment */\n" +
            "import java.util.Date;\n" +
            "import static AnInterface.CONSTANT;\n" +
            "import static java.util.Date.parse;\n" +
            "import static SomeClass.staticField;\n" +
            "/**\n" +
            " * Doc comment here for <code>SomeClass</code>\n" +
            " * @param T type parameter\n" +
            " * @see Math#sin(double)\n" +
            " */\n" +
            "@Annotation (name=value)\n" +
            "public class SomeClass<T extends Runnable> { // some comment\n" +
            "  private T field = null;\n" +
            "  private double unusedField = 12345.67890;\n" +
            "  private UnknownType anotherString = \"Another\\nStrin\\g\";\n" +
            "  public static int staticField = 0;\n" +
            "  public final int instanceFinalField = 0;\n" +
            "\n" +
            "  /**\n" +
            "   * Semantic highlighting:\n" +
            "   * Generated spectrum to pick colors for local variables and parameters:\n" +
            "   *  Color#1 SC1.1 SC1.2 SC1.3 SC1.4 Color#2 SC2.1 SC2.2 SC2.3 SC2.4 Color#3\n" +
            "   *  Color#3 SC3.1 SC3.2 SC3.3 SC3.4 Color#4 SC4.1 SC4.2 SC4.3 SC4.4 Color#5\n" +
            "   * @param param1\n" +
            "   * @param reassignedParam\n" +
            "   * @param param2\n" +
            "   * @param param3\n" +
            "   */\n" +
            "  public SomeClass(AnInterface param1, int[] reassignedParam,\n" +
            "                  int param2\n" +
            "                  int param3) {\n" +
            "    int reassignedValue = this.staticField + param2 + param3;\n" +
            "    long localVar1, localVar2, localVar3, localVar4;\n" +
            "    int localVar = \"IntelliJ\"; // Error, incompatible types\n" +
            "    System.out.println(anotherString + toString() + localVar);\n" +
            "    long time = parse(\"1.2.3\"); // Method is deprecated\n" +
            "    new Thread().countStackFrames(); // Method is deprecated and marked for removal\n" +
            "    reassignedValue ++; \n" +
            "    field.run(); \n" +
            "    new SomeClass() {\n" +
            "      {\n" +
            "        int a = localVar;\n" +
            "      }\n" +
            "    };\n" +
            "    reassignedParam = new ArrayList<String>().toArray(new int[CONSTANT]);\n" +
            "  }\n" +
            "}\n" +
            "enum AnEnum { CONST1, CONST2 }\n" +
            "interface AnInterface {\n" +
            "  int CONSTANT = 2;\n" +
            "  void method();\n" +
            "}\n" +
            "abstract class SomeAbstractClass {\n" +
            "  protected int instanceField = staticField;\n" +
            "}";
  }

  @Nullable
  @Override
  public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
    return null;
  }

  @NotNull
  @Override
  public AttributesDescriptor[] getAttributeDescriptors() {
    return DESCRIPTORS;
  }

  @NotNull
  @Override
  public ColorDescriptor[] getColorDescriptors() {
    return ColorDescriptor.EMPTY_ARRAY;
  }

  @NotNull
  @Override
  public String getDisplayName() {
    return "Java additions";
  }
}