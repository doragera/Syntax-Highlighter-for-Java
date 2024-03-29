import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

public class JavaSyntaxHighlighterFactory extends SyntaxHighlighterFactory {
  @NotNull
  @Override
  public JavaSyntaxHighlighter getSyntaxHighlighter(Project project, VirtualFile virtualFile) {
    return new JavaSyntaxHighlighter();
  }
}