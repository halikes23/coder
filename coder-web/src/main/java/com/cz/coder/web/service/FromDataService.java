package com.cz.coder.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cz.coder.common.entity.vo.ColumnVO;
import com.cz.coder.web.dao.dao.FromDataDao;


@Service
public class FromDataService {

	private final static Logger logger = LoggerFactory.getLogger(FromDataService.class) ;
	
	private final static Map<String,String> db2jMapper = new HashMap<String,String>() ;
	
	public FromDataService(){
		db2jMapper.put("varchar", "String") ;
		db2jMapper.put("int", "Integer") ;
	}
	
	@Autowired
	private FromDataDao fromDataDao ;
	
	public List<String> queryAllDatabases() {
		return this.fromDataDao.selectAllDatabases();
	}

	public List<String> queryTablesBySchema(String schema) {
		return this.fromDataDao.selectTablesBySchema(schema);
	}

	public List<ColumnVO> queryColumnsByTable(String schema , String table) {
		return this.fromDataDao.selectColumnsByTable(schema,table);
	}

	public Map<String, Object> buildCode(String pkg , String schema, String table) {
		
		Map<String,Object> codes = new HashMap<String,Object>() ;
		
		List<ColumnVO> columns =this.fromDataDao.selectColumnsByTable(schema,table);
		
		String beanScript = buildBeanScript(pkg,table,columns) ;
		String resultMap = buildIBatisResultMap(pkg,table,columns) ;
		String insertScript = buildIBatisInsert(pkg,table,columns) ;
		
		logger.info(beanScript);
		
		codes.put("beanScript", beanScript) ;
		codes.put("resultMap", resultMap) ;
		codes.put("insertScript", insertScript) ;
		return codes;
	}
	
	
	private String buildBeanScript(String pkg ,String table ,List<ColumnVO> columns){
		StringBuilder code = new StringBuilder() ;
		
		// add package
		if( StringUtils.isNotEmpty(pkg) ){
			code.append("import").append(pkg).append("\r\n") ;
		}
		// add class name
		code.append("public class ") ;
		String[] arr = table.split("_") ;
		for( int i = 0 ; i < arr.length ; i ++ ){
			if( i == 0 ){
				code.append(arr[i]);
			}else{
				code.append(arr[i].substring(0, 1).toUpperCase()).append(arr[i].substring(1)) ;
			}
		}
		code.append("{").append("\r\n\r\n");
		
		for( ColumnVO column : columns ){
			code.append("\t").append("private ").append(db2jMapper.get(column.getDataType())).append( " " );
			arr = column.getColumnName().split("_") ;
			
			for( int i = 0 ; i < arr.length ; i ++ ){
				if( i == 0 ){
					code.append(arr[i]);
				}else{
					code.append(arr[i].substring(0, 1).toUpperCase()).append(arr[i].substring(1)) ;
				}
			}
			code.append(";\r\n") ;
			
		}
		
		code.append("\r\n").append("}") ;
		
		return code.toString() ;
		
	}
	
//	<resultMap id="mobileCodeResult" class="com.cz.coder.web.dao.entity.vo.MobileCodeVO">
//	<result property="userName" column="user_name"/>
//	<result property="userMobile" column="user_mobile"/>
//	<result property="mobileCode" column="mobile_code"/>
//	<result property="sendDate" column="send_date"/>
//</resultMap>
	private String buildIBatisResultMap(String pkg ,String table ,List<ColumnVO> columns){
		StringBuilder code = new StringBuilder() ;
		
		StringBuilder className = new StringBuilder() ;
		
		code.append("<resultMap id=\"");
		String[] arr = table.split("_") ;
		for( int i = 0 ; i < arr.length ; i ++ ){
			if( i == 0 ){
				className.append(arr[i]);
			}else{
				className.append(arr[i].substring(0, 1).toUpperCase()).append(arr[i].substring(1)) ;
			}
		}
		code.append(className).append("\" class=\"").append( StringUtils.isEmpty(pkg) ? "": (pkg+".") ).append(className).append("\">\r\n");
		
		for( ColumnVO column : columns ){
			code.append("\t").append("<result column=\"").append(column.getColumnName()).append("\" property=\"") ;
			arr = column.getColumnName().split("_") ;
			for( int i = 0 ; i < arr.length ; i ++ ){
				if( i == 0 ){
					code.append(arr[i]);
				}else{
					code.append(arr[i].substring(0, 1).toUpperCase()).append(arr[i].substring(1)) ;
				}
			}
			code.append("\"/>\r\n") ;
		}
		
		code.append("</resultMap>") ;
		
		return code.toString() ;
		
	}
	
	
//	<insert id="insertMobileCode"  parameterClass="com.cz.coder.web.dao.entity.po.MobileCodePO"  >
//	insert 			into  			bp_console_login_mobile_code    
//					(     	user_name   ,   			user_mobile   ,    			mobile_code   ,  		send_date   )
//					values			
//					(		#userName#  ,				#userMobile#,				#mobileCode#,			#sendDate# )
//
//	</insert>
	private String buildIBatisInsert(String pkg ,String table ,List<ColumnVO> columns){
		StringBuilder code = new StringBuilder() ;
		
		StringBuilder className = new StringBuilder() ;
		String[] arr = table.split("_") ;
		for( int i = 0 ; i < arr.length ; i ++ ){
			if( i == 0 ){
				className.append(arr[i]);
			}else{
				className.append(arr[i].substring(0, 1).toUpperCase()).append(arr[i].substring(1)) ;
			}
		}
		
		code.append("<insert id=\"insert").append(className).append("\" parameterClass=\"").append(StringUtils.isEmpty(pkg) ? "": (pkg+".")).append(className).append("\" >\r\n");
		code.append("\tinsert into ").append(table) ;
		code.append("\t(\r\n");
			for(int i = 0 ; i < columns.size() ; i ++ ){
				ColumnVO column = columns.get(i) ;
				code.append("\t\t").append(column.getColumnName()).append(i == columns.size() - 1 ? "" : ",") ;
				if(  ( i + 1 )%3==0 ){
					code.append("\r\n");
				}
				
			}
		code.append("\r\n\t)\r\n\tvalues\t(\r\n") ;	
		for(int i = 0 ; i < columns.size() ; i ++ ){
			ColumnVO column = columns.get(i) ;
			arr = column.getColumnName().split("_") ;
			code.append("\t\t#") ;
			for( int j = 0 ; j < arr.length ; j ++ ){
				if( j == 0 ){
					code.append(arr[j]);
				}else{
					code.append(arr[j].substring(0, 1).toUpperCase()).append(arr[j].substring(1)) ;
				}
			}
			code.append("#").append(i == columns.size() - 1 ? "" : ",") ;
			if( ( i + 1 ) %3==0 ){
				code.append("\r\n");
			}
		}
		code.append("\r\n\t)\r\n") ;
		code.append("</insert>") ;
		
		return code.toString() ;
		
	}
	
//	<select id="selectMobileCodePo" parameterClass="java.util.Map"  resultMap="mobileCodeResult" >
//		select 		*  
//		from  		bp_console_login_mobile_code   cmc    
//		where 		cmc.user_name = #userName#   
//					and 		timestampdiff( second,cmc.send_date,now() )  &lt; #validityOfMobileCode#
//	</select>
	
	public static void main(String[] args) {
		String table = "admin" ;
		List<ColumnVO> columns = new ArrayList<ColumnVO>() ;
		
		ColumnVO columnVO1 = new ColumnVO() ;
		columnVO1.setColumnName("column_one");
		columnVO1.setDataType("varchar");
		columns.add(columnVO1) ;
		
		ColumnVO columnVO2 = new ColumnVO() ;
		columnVO2.setColumnName("column_two");
		columnVO2.setDataType("int");
		columns.add(columnVO2) ;
		
		FromDataService service = new FromDataService() ;
		String script = service.buildBeanScript(null, table, columns) ;
		System.out.println(script);
		
		script = service.buildIBatisResultMap(null, table, columns) ;
		System.out.println(script);
		
		script = service.buildIBatisInsert(null, table, columns) ;
		System.out.println(script);
		
	}

}
