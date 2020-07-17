//package com.sulin.mybatis.typehandler;
//
//import org.apache.ibatis.type.BaseTypeHandler;
//import org.apache.ibatis.type.JdbcType;
//import org.apache.ibatis.type.MappedJdbcTypes;
//import org.apache.ibatis.type.MappedTypes;
//import org.springframework.stereotype.Component;
//
//import java.sql.CallableStatement;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//
//@MappedJdbcTypes(JdbcType.VARCHAR)
//@MappedTypes({List.class})
//@Component
//public class ListTypeHandler2 extends BaseTypeHandler<List<Integer>> {
//
//    private static final String SPLIT_CHARSET = ",";
//
////    public void regist(@Autowired TypeHandlerRegistry typeHandlerRegistry) {
////        System.out.println("==============register===================");
////        typeHandlerRegistry.register(this);
////    }
//
//    @Override
//    public void setNonNullParameter(PreparedStatement preparedStatement, int i, List<Integer> params, JdbcType jdbcType) throws SQLException {
//        //写入mysql的时候 数据处理
////        String paramStr = String.join(SPLIT_CHARSET, params);
//
//        StringBuffer sb = new StringBuffer();
//        int index = 0;
//        for (Object param : params) {
//            sb.append(param);
//            if (index != params.size()-1) {
//                sb.append(SPLIT_CHARSET);
//            }
//            index++;
//        }
//
//        preparedStatement.setString(i, sb.toString());
//    }
//
//    @Override
//    public List<Integer> getNullableResult(ResultSet resultSet, String s) throws SQLException {
//        return getArray(resultSet.getString(s));
//    }
//
//    @Override
//    public List<Integer> getNullableResult(ResultSet resultSet, int i) throws SQLException {
//        return getArray(resultSet.getString(i));
//    }
//
//    @Override
//    public List<Integer> getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
//        return getArray(callableStatement.getString(i));
//    }
//
//    private List<Integer> getArray(String array) {
//        String[] split = array.split(SPLIT_CHARSET);
//        ArrayList<Integer> ts = new ArrayList<>();
//        for (String s : split) {
//            ts.add(Integer.valueOf(s));
//        }
//        return ts;
//    }
//}
