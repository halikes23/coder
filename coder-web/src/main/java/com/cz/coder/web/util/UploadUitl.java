package com.fq.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
/**
 * 文件上传工具类
 * @author lp
 *
 */
public class UploadUitl {
	

	/**
	 * 上传文件
	 * @param file
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static String upload (MultipartFile file,HttpServletRequest request,String path)throws Exception{
			String filename = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
			Random r = new Random();
			filename = r.nextInt(20)+filename;
			if(file.isEmpty())
				return "";
			String realPath = request.getSession().getServletContext().getRealPath(path);
			String nowFile =new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			realPath = realPath+"/"+nowFile;
			filename = filename+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."), file.getOriginalFilename().length());
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(realPath,filename));
			return path+"/"+nowFile+"/"+filename;
	}
	/**
	 * 删除文件
	 * @param session
	 * @param filename
	 */
	public static void delPic (String realPath,String filename ){
		if(filename != null ){
			if(filename.endsWith("/"))
				return ;
			if(!filename.equals("")){
				if(filename != null){
					filename = filename.trim().replace("/", "\\");
					File file = new File(realPath,filename);
					if(file.exists()){
						file.delete();
					}
				}
			}
		}
	}
	/**
	 * office 转换 pdf
	 * @param realPath
	 * @param filename
	 * @return
	 */
	public static int office2Pdf (String realPath,String filename)throws Exception{
		File inFile = new File (realPath,filename);
		if(!inFile.exists()){
			return -1;
		}
		String outName = filename.substring(0, filename.lastIndexOf("."))+".pdf";
		File outFile = new File(realPath,outName);
		String  offpath = "E:\\Program Files (x86)\\OpenOffice 4";
		 if (offpath.charAt(offpath.length() - 1) != '\\') {  
			 offpath += "\\";  
         }  
		 String command = offpath+ "program\\soffice.exe -headless -accept=\"socket,host=127.0.0.1,port=8100;urp;\"";  
		 Process pro = Runtime.getRuntime().exec(command);
		 OpenOfficeConnection ooc = new SocketOpenOfficeConnection("127.0.0.1", 8100);
		 ooc.connect();
		 DocumentConverter dc = new OpenOfficeDocumentConverter(ooc);
		 dc.convert(inFile, outFile);
		 ooc.disconnect();
		 pro.destroy();
		return 0;
	} 
	
	public static List<List<String>> uploadExcel07(MultipartFile file)throws Exception {
		List<List<String>>  data = new ArrayList<List<String>> ();
		InputStream in = file.getInputStream();
		XSSFWorkbook workBoox = new XSSFWorkbook(in);
		for(int k = 0 ; k < workBoox.getNumberOfSheets() ; k ++ ){
			XSSFSheet sheet = workBoox.getSheetAt(k);
			if(sheet != null ){
				for(int i = 0 ; i < sheet.getPhysicalNumberOfRows() ; i ++ ){
					XSSFRow row = sheet.getRow(i);
					List<String> list = new ArrayList<String> ();
					for (int j = 0 ; j < row.getPhysicalNumberOfCells() ; j ++ ){
						XSSFCell cell = row.getCell(j);
						if(cell!=null)
							list.add(cell.toString());
					}
					data.add(list);
				}
			}
		}
		return data;
	}
	
	
	public static List<List<String>> uploadExcel03(MultipartFile file)throws Exception {
		List<List<String>>  data = new ArrayList<List<String>> ();
		InputStream in = file.getInputStream();
		HSSFWorkbook workBoox = new HSSFWorkbook(in);
		for(int k = 0 ;  k < workBoox.getNumberOfSheets() ; k ++ ){
			HSSFSheet sheet = workBoox.getSheetAt(k);
			if(sheet != null ){
				for(int i = 0 ; i < sheet.getPhysicalNumberOfRows() ; i ++ ){
					HSSFRow row = sheet.getRow(i);
					List<String> list = new ArrayList<String> ();
					for (int j = 0 ; j < row.getPhysicalNumberOfCells() ; j ++ ){
						HSSFCell cell = row.getCell(j);
						list.add(cell.toString());
					}
					data.add(list);
				}
			}
		}
		return data;
		
	}
	//图片压缩
//	public static String imgUpload ()throws Exception{
//		File file  = new File("E:\\微笑.jpg");
//		Image img = ImageIO.read(file); 
//		int width = img.getWidth(null);
//		int heigth = img.getHeight(null);
//		BufferedImage bi = new BufferedImage(width, heigth, BufferedImage.TYPE_INT_RGB);
//		bi.getGraphics().drawImage(img, 0,0,width, heigth,null);
//		File outFile = new File("e:\\微笑bak.jpg");
//		FileOutputStream out = new FileOutputStream(outFile);
//		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
//		encoder.encode(bi);
//		return "";
//	}
	
	
}
