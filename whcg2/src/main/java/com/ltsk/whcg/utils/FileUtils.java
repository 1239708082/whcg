package com.ltsk.whcg.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.ltsk.whcg.entity.Gps;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import sun.misc.BASE64Encoder;

import javax.xml.ws.http.HTTPException;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文件上传工具包
 */
public class FileUtils {

    /**
     *
     * @param file 文件
     * @param path 文件存放路径
     * @param fileName 源文件名
     * @return
     */
    public static boolean upload(MultipartFile file, String path, String fileName){


        // 生成新的文件名
//        String realPath = path + "/" + FileNameUtils.getFileName(fileName);
        String realPath = path + "/" + file.getOriginalFilename();
        //使用原文件名
//        String realPath = path + "/" + fileName;

        File dest = new File(realPath);

        //判断文件父目录是否存在
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }

        try {
            //保存文件
            file.transferTo(dest);
            return true;
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }

    }

    public static boolean saveImg(MultipartFile multipartFile,String path)  {
        BufferedOutputStream bos = null;
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();
            String fileName = DateTime.getUuid() + ".png";
            bos = new BufferedOutputStream(new FileOutputStream(path + File.separator + fileName));
            byte[] bs = new byte[1024];
            int len;
            while ((len = fileInputStream.read(bs)) != -1) {
                bos.write(bs, 0, len);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                bos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(bos!=null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
    /**
     * MultipartFile转base64   因为RFC 822中规定，每72个字符中加一个换行符号 使用时转换  String encoded = base64.replaceAll("[\\s*\t\n\r]", "");
     * */
    public static String base64(MultipartFile mFile){
        BASE64Encoder base64Encoder = new BASE64Encoder();
//        try{
//            System.out.println(mFile);
//            System.out.println(mFile.getOriginalFilename());
//            byte[] bytes = mFile.getBytes();
//            String encode = base64Encoder.encode(bytes);
//            return encode;
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return null;
//
        File dest = null;
        String base64=null;
        String path = "upload/";
        try {
//            f=File.createTempFile("tmp", null);
             dest = new File(new File(path).getAbsolutePath()+ "/" + mFile.getOriginalFilename());
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            mFile.transferTo(dest);
            dest.deleteOnExit();     //使用完成删除文件
        } catch (HTTPException e) {
            e.printStackTrace();
            return base64;
        } catch (IOException e) {
            e.printStackTrace();
            return base64;
        }
        try {
            FileInputStream inputFile = new FileInputStream(dest);
            byte[] buffer = new byte[(int) dest.length()];
            inputFile.read(buffer);
            inputFile.close();
            base64= base64Encoder.encode(buffer);
        }catch (IOException e ){
            e.printStackTrace();
            return null;
        }
        return base64;
    }
    /**
     * @Description: 根据图片地址转换为base64编码字符串
     * @Author:
     * @CreateTime:
     * @return
     */
    public static String getImageStr(String imgFile) {
        InputStream inputStream = null;
        byte[] data = null;
        try {
            inputStream = new FileInputStream(imgFile);
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 加密
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }
    
    public static List<List<String>> readXls(InputStream inStream) throws IOException
    {
        
        InputStream is = inStream;
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        
        
        // Read the Sheet
        HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
            
        List<List<String>> res = new ArrayList<>();
        List<String> nameList = new ArrayList<>();
        if (hssfSheet == null) {
            //continue;
            return res;
        }
        
        int lastRowNum = hssfSheet.getLastRowNum();
        
        for (int i = 0; i<hssfSheet.getRow(0).getPhysicalNumberOfCells(); i++) {
			
        	String value = getValue(hssfSheet.getRow(0).getCell(i));
        	nameList.add(value);
		}
        res.add(nameList);
        // Read the Row
        for (int rowNum = 1; rowNum <= lastRowNum; rowNum++) {
            
            HSSFRow hssfRow = hssfSheet.getRow(rowNum);
            
            if (hssfRow != null) {
            	
            	
            	List<String> obj = new ArrayList<String>();
            	for (int i = 0; i < hssfRow.getPhysicalNumberOfCells(); i++) {
            		if(i==1||i==2){
            			obj.add( hssfRow.getCell(i).getNumericCellValue()+"");
            		}else{
            			obj.add( getValue(hssfRow.getCell(i)));
            		}
				}
            	res.add(obj);
            }
        }
        return  res;
    }
	
    public static List<List<String>> readXlsx(InputStream inStream) throws IOException
    {
        //InputStream is = new FileInputStream(path);
        
        InputStream is = inStream;
        
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        
        List<List<String>> res = new ArrayList<>();
        List<String> nameList = new ArrayList<>();
        
        // Read the Sheet
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
            
        if (xssfSheet == null) {
            return res;
        }
        for (int i = 0; i<xssfSheet.getRow(0).getPhysicalNumberOfCells(); i++) {
			
        	String value = getValue1(xssfSheet.getRow(0).getCell(i));
        	nameList.add(value);
		}
        res.add(nameList);
        
        // Read the Row
        for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
            
            XSSFRow xssfRow = xssfSheet.getRow(rowNum);
            if (xssfRow != null) {
            	List<String> obj = new ArrayList<String>();
            	for (int i = 0; i < xssfRow.getPhysicalNumberOfCells(); i++) {
            		if(i==1||i==2){
            			obj.add(xssfRow.getCell(i).getNumericCellValue()+"");
            		}else{
            			obj.add( getValue1(xssfRow.getCell(i)));
            		}
    			}
            	res.add(obj);
            }
        	
        }
        
        return res;
    }
    
 private static String getValue(HSSFCell hssfCell) {
        
        if(hssfCell==null){
            return "";
        }
        
        if (hssfCell.getCellType() == CellType.BOOLEAN) {
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == CellType.NUMERIC) {
            return String.valueOf((int)hssfCell.getNumericCellValue());
        }else {
            return String.valueOf(hssfCell.getStringCellValue()==null?"":hssfCell.getStringCellValue());
        }
    }
 
 private static String getValue1(XSSFCell xssfRow) {
     if(xssfRow==null){
         return "";
     }
     if (xssfRow.getCellType() == CellType.BOOLEAN) {
         return String.valueOf(xssfRow.getBooleanCellValue());
     } else if (xssfRow.getCellType() == CellType.NUMERIC) {
         return String.valueOf((int)xssfRow.getNumericCellValue());
     }else {
         return String.valueOf(xssfRow.getStringCellValue()==null?"":xssfRow.getStringCellValue());
     }
 }

    public static void main(String[] args) {
        getImageStr("http://10.8.99.23:8080/img_mark/zdwj/2490675a38724298a56cbb657fd9f5c76.png");
    }
}
