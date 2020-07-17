package com.sulin.mybatis.typehandler;

import cn.hutool.core.lang.Assert;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.sulin.mybatis.entity.Good;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.OTHER)
@MappedTypes({Object.class})
public class JsonTypeHandler extends BaseTypeHandler<Object> {

    private Class<Object> type;

    public JsonTypeHandler(Class<Object> type) {
        Assert.notNull(type, "Type argument cannot be null", new Object[0]);
        this.type = type;
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Object object, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public Object getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return getJson(resultSet.getString(s));
    }

    @Override
    public Object getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return getJson(resultSet.getString(i));
    }

    @Override
    public Object getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return getJson(callableStatement.getString(i));
    }

    private Object getJson(String json) {
        if (StringUtils.isEmpty(json))
            return null;
        return JSONUtil.toBean(json, type);
    }
}
