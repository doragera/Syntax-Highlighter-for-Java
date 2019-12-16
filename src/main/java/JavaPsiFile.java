import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class JavaPsiFile extends PsiFileBase {
    public JavaPsiFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, JavaLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return JavaFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Java File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}
