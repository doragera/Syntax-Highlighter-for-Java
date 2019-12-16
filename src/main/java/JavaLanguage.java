import com.intellij.lang.Language;

public class JavaLanguage extends Language {
  public static final JavaLanguage INSTANCE = new JavaLanguage();

  public JavaLanguage() {
    super("MyJava");
  }
}