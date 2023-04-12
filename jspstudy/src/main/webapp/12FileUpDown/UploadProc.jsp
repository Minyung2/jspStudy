<%@page import="fileUpDown.MyFileDao"%>
<%@page import="fileUpDown.MyFileDto"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String saveDirectory = application.getRealPath("/Storage");
System.out.println(saveDirectory);
int maxPostSize = 1024 * 1000;
String encoding = "UTF-8";

try{
	// 1. MultipartRequest 객체 생성
	MultipartRequest mr = new MultipartRequest(request,saveDirectory,maxPostSize,encoding);
	// FileUploadMain.jsp -> request : 생성자 -> request 받고 , 저장경로 saveDirectory, 최대 저장 용량 maxPostSize, 인코딩방식 (UTF-8)

	// 2. 새로운 파일명 생성
	String fileName=mr.getFilesystemName("attachedFile");	// FileUploadMain 에서 받은 파일명(현재 파일명)
	String ext = fileName.substring(fileName.lastIndexOf(".")); 	// 파일 확장자(파일명 맨 뒤 .뒤로 파일 확장자니까 lastIndexOf로 substring)
	String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
	String newFileName = now+ext;	// 새로운 파일명->("업로드일시.확장자")
	
	// 3. 파일명 변경
	File oldFile = new File(saveDirectory+File.separator+fileName);
	File newFile = new File(saveDirectory+File.separator+newFileName);
	oldFile.renameTo(newFile);
	
	// 4. 다른 폼 값 받기
	String name = mr.getParameter("name");
	String title = mr.getParameter("title");
	String[] cateArray = mr.getParameterValues("cate");
	StringBuffer cateBuf = new StringBuffer();
	if(cateArray==null){
		cateBuf.append("선택없음");
	}else{
		for(String s : cateArray){
			cateBuf.append(s+", ");
		}
	}
	
	// 5. DTO 생성
	MyFileDto dto = new MyFileDto();
	dto.setName(name);
	dto.setTitle(title);
	dto.setCate(cateBuf.toString());
	dto.setOfile(fileName);
	dto.setNfile(newFileName);
	// 6. DAO를 통해 데이터 베이스에 반영
	MyFileDao dao = new MyFileDao();
	dao.insertFile(dto);
	dao.close();
	// 7. 파일 목록 jsp로 리디렉션
	response.sendRedirect("FileList.jsp");
}catch(Exception e){
	e.printStackTrace();
	request.setAttribute("errMsg", "업로드 오류");
	request.getRequestDispatcher("FileUploadMain.jsp").forward(request,response);
}
%>


