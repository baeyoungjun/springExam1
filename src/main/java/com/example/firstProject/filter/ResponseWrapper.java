package com.example.firstProject.filter;

import org.apache.commons.io.output.TeeOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Locale;

/**
* DL IIMP : 리스폰스 와 버퍼를 동기화해서, 리스폰스 내용(스트림) 을 수정할 수 있도록 한다. (원본은 보존)
*
* @author Choi Bo Kyung
* @version 2022-02-07 최초생성
*
* <b>History:</b>
**/


public class ResponseWrapper implements HttpServletResponse {

	HttpServletResponse original;
	ByteArrayOutputStream byteArrayOutputStream;
	BufferedServletOutputStream bufferedservletOutputStream; 

	//생성자 (original response 초기화)
	public ResponseWrapper(HttpServletResponse response) {
		original = response;
	}

	public String getContent() {
		if(byteArrayOutputStream == null) { return "{}"; }
		return byteArrayOutputStream.toString();
	}

	public PrintWriter getWriter() throws IOException {
		return original.getWriter();
	}

	public ServletOutputStream getOutputStream() throws IOException {
		if (byteArrayOutputStream == null) {
			byteArrayOutputStream = new ByteArrayOutputStream();
			bufferedservletOutputStream = new BufferedServletOutputStream(original.getOutputStream(), byteArrayOutputStream);
		}
		return bufferedservletOutputStream;
	}
	
	//inner class
	public class BufferedServletOutputStream extends ServletOutputStream {

		private final TeeOutputStream targetStream;

		//생성자 (2개의 outStream 에 같은 내용을 쓰도록 한다)
		public BufferedServletOutputStream(OutputStream one, OutputStream two) {
			targetStream = new TeeOutputStream(one, two);
		}

		@Override
		public void write(int arg0) throws IOException {
			this.targetStream.write(arg0);
		}

		public void flush() throws IOException {
			super.flush();
			this.targetStream.flush();
		}

		public void close() throws IOException {
			super.close();
			this.targetStream.close();
		}

		@Override
		public boolean isReady() {return false;}

		@Override
		public void setWriteListener(WriteListener listener) { }
	}

	@Override
	public String getCharacterEncoding() {
		return original.getCharacterEncoding();
	}

	@Override
	public String getContentType() {
		return original.getContentType();
	}

	@Override
	public void setCharacterEncoding(String charset) {
		original.setCharacterEncoding(charset);
	}

	@Override
	public void setContentLength(int len) {
		original.setContentLength(len);
	}

	@Override
	public void setContentType(String type) {
		original.setContentType(type);
	}

	@Override
	public void setBufferSize(int size) {
		original.setBufferSize(size);
	}

	@Override
	public int getBufferSize() {
		return original.getBufferSize();
	}


	@Override
	public void resetBuffer() {
		original.resetBuffer();
	}

	@Override
	public boolean isCommitted() {
		return original.isCommitted();
	}

	@Override
	public void reset() {
		original.reset();
	}

	@Override
	public void setLocale(Locale loc) {
		original.setLocale(loc);
	}

	@Override
	public Locale getLocale() {
		return original.getLocale();
	}

	@Override
	public void addCookie(Cookie cookie) {
		original.addCookie(cookie);
	}

	@Override
	public boolean containsHeader(String name) {
		return original.containsHeader(name);
	}

	@Override
	public String encodeURL(String url) {
		return original.encodeURL(url);
	}

	@Override
	public String encodeRedirectURL(String url) {
		return original.encodeRedirectURL(url);
	}

	@SuppressWarnings("deprecation")
	@Override
	public String encodeUrl(String url) {
		return original.encodeUrl(url);
	}

	@SuppressWarnings("deprecation")
	@Override
	public String encodeRedirectUrl(String url) {
		return original.encodeRedirectUrl(url);
	}

	@Override
	public void sendError(int sc, String msg) throws IOException { original.sendError(sc, msg);}

	@Override
	public void sendError(int sc) throws IOException { original.sendError(sc);}

	@Override
	public void sendRedirect(String location) throws IOException {original.sendRedirect(location);}

	@Override
	public void setDateHeader(String name, long date) {
		original.setDateHeader(name, date);
	}

	@Override
	public void addDateHeader(String name, long date) {
		original.addDateHeader(name, date);
	}

	@Override
	public void setHeader(String name, String value) {
		original.setHeader(name, value);
	}

	@Override
	public void addHeader(String name, String value) {
		original.addHeader(name, value);
	}

	@Override
	public void setIntHeader(String name, int value) {
		original.setIntHeader(name, value);
	}

	@Override
	public void addIntHeader(String name, int value) {
		original.addIntHeader(name, value);
	}

	@Override
	public void setStatus(int sc) {
		original.setStatus(sc);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void setStatus(int sc, String sm) {
		original.setStatus(sc, sm);
	}

	@Override
	public String getHeader(String arg0) {
		return original.getHeader(arg0);
	}

	@Override
	public Collection<String> getHeaderNames() {
		return original.getHeaderNames();
	}

	@Override
	public Collection<String> getHeaders(String arg0) {
		return original.getHeaders(arg0);
	}

	@Override
	public int getStatus() {
		return original.getStatus();
	}

	@Override
	public void setContentLengthLong(long length) {original.setContentLengthLong(length);}

	@Override
	public void flushBuffer() throws IOException {original.flushBuffer();}

}