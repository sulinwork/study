package com.sulin.mybatis.plus;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import tk.mybatis.mapper.generator.MapperPlugin;

import java.util.List;
import java.util.Properties;

public class MyPlugin extends MapperPlugin {

    private void processEntityClass(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        topLevelClass.addImportedType("javax.persistence.*");
        String tableName = introspectedTable.getFullyQualifiedTableNameAtRuntime();
        System.out.println(tableName);
    }
}
