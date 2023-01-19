package com.example.firstProject.filter;

import org.apache.commons.io.IOUtils;
import org.apache.commons.text.StringEscapeUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;

/**
* DL IIMP : 들어온 리퀘스트를 복제하여, 내용을 읽고 파라미터를 추출하여 RequestFilter 에서 로그를 남긴다
* (※리퀘스트 원본을 한번 사용해버리면 컨트롤러에서 쓸 수 없음)
*     
* @author Choi Bo Kyung
* @version 2022-02-07 최초생성
* 
* <b>History:</b>
**/

public class RequestWrapper extends HttpServletRequestWrapper {
	
	HashMap<String, Object> params;
	private ByteArrayOutputStream bytes;

	//생성자 (param 초기화)
	public RequestWrapper(HttpServletRequest servletRequest) {
		super(servletRequest);
		this.params = new HashMap<String, Object>(servletRequest.getParameterMap());
	}
	
	@Override
	public ServletInputStream getInputStream() throws IOException {
		if (bytes == null){ bufferedInputStream(); } // super 로부터 byte 복사
		return new BufferedServletInputStream(); // byte 를 input 으로 가공함
	}

	private void bufferedInputStream() throws IOException {
		bytes = new ByteArrayOutputStream();
		IOUtils.copy(super.getInputStream(), bytes);
	}

	//Inner Class
	public class BufferedServletInputStream extends ServletInputStream {

		private ByteArrayInputStream input;
		
		//생성자 (input 초기화)
		public BufferedServletInputStream() {
			input = new ByteArrayInputStream(bytes.toByteArray());
		}

		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			byte[] b = new byte[4096];

			try {
				for (int n; (n = input.read(b)) != -1;) {
					sb.append(new String(b, 0, n));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return sb.toString();
		}

		@Override
		public int read() throws IOException {
			return input.read();
		}

		@Override
		public boolean isFinished() {
			return false;
		}

		@Override
		public boolean isReady() {
			return false;
		}

		@Override
		public void setReadListener(ReadListener listener) {}
	}



	//parameter 값을 String 배열로 변환하여 반환
	//상위 클래스 override 주석 처리
	/*@Override
	public String[] getParameterValues(String parameter) {

	    String[] values = (String[])params.get(parameter);

	    if(values == null) { return null; }

	    String [] result = new String[values.length];
	    for(int i = 0; i < values.length; i++) {
	    	result[i] = xss(values[i]);
	    }
	    return result;
	}*/



	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public HashMap getParameterMap() {
		for (String key : params.keySet()) {
			params.put(key, xss(params.get(key).toString()));
		}
		return params;
	}


	@Override
	public String getParameter(String parameter) {
		String value = super.getParameter(parameter);
		return xss(value);
	}

	@Override
	public String getHeader(String name) {
		String value = super.getHeader(name);
		return xss(value);
	}

	public String getAllParameters(){
		StringBuilder paramStr = new StringBuilder();
		paramStr.append("{");

		int i=0;
		for(String key : params.keySet()) {
			if(i==1){
				paramStr.append(",");
			}

			String value = getParameter(key);
			paramStr.append(String.format("\""+key+"\":"+value));
			i=1;
		}
		paramStr.append("}");
		return paramStr.toString();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Enumeration getParameterNames() { return Collections.enumeration(params.keySet()); }


	private String xss(String value) {
		String escapedValue = StringEscapeUtils.escapeHtml3(value);
		//String escapedValue = XssPreventer.escape(value); //lucy-xss-servlet-filter
		return escapedValue;
	}

	public void setParameter(String name, String value) {
		String param = value;
		params.put(name, param);
	}
}