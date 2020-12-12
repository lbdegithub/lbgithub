package my.run;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.Properties;

/**
 * @author LiBin
 * @email 22755@etransfa.com
 * @date 2019-07-31 15:14
 **/
public class CommentGenerator extends DefaultCommentGenerator {

    private Properties properties;
    private boolean swaggerApi;
    private boolean comment;

    public CommentGenerator() {
        this.properties = new Properties();
        this.swaggerApi = false;
        this.comment = false;
    }

    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {
        //compilationUnit.addFileCommentLine("/*** copyright (c) 2019 Marvis  ***/");
    }

    @Override
    public void addConfigurationProperties(Properties properties) {
        this.properties.putAll(properties);

        this.swaggerApi = StringUtility.isTrue(properties.getProperty("swaggerApi"));
        this.comment = StringUtility.isTrue(properties.getProperty("comment"));
        super.addConfigurationProperties(properties);
    }

    /**
     * entity filed Comment
     */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable,
                                IntrospectedColumn introspectedColumn) {
        if (this.comment) {

            field.addJavaDocLine("/**");
            field.addJavaDocLine(" * " + introspectedColumn.getRemarks());
            field.addJavaDocLine(" */");
        }
        if (this.swaggerApi) {
            field.addJavaDocLine("@ApiModelProperty(value =\" " + introspectedColumn.getRemarks() + "\", example = \"1\")");
        }
    }


}
