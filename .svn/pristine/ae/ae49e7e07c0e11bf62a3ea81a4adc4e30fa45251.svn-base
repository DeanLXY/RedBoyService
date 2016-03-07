package zz.itcast.ecservice.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * 全站编码过滤器
 * 
 * @author Administrator
 * 
 */
@WebFilter(urlPatterns = { "/*" }, initParams = @WebInitParam(name = "encoding", value = "utf-8"))
public class EncodeFilter implements Filter {

	String encoding = "gbk";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		encoding = filterConfig.getInitParameter("encoding");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		System.err.println("访问设备======>>"+request.getRemoteHost());
		final HttpServletRequest req = (HttpServletRequest) request;
		final HttpServletResponse resp = (HttpServletResponse) response;
		resp.setContentType("text/html;charset=" + encoding);
		chain.doFilter(new MyRequest(req), resp);
	}

	@Override
	public void destroy() {

	}

	private final class MyRequest extends HttpServletRequestWrapper {

		private boolean bEncode = true;
		HttpServletRequest request;

		public MyRequest(HttpServletRequest request) {
			super(request);
			this.request = request;
		}

		@Override
		public String getParameter(String name) {
			Map<String, String[]> map = this.getParameterMap();

			return map.get(name) == null ? null : map.get(name)[0];
		}

		@Override
		public Map<String, String[]> getParameterMap() {
			if (request.getMethod().equalsIgnoreCase("post")) {
				try {
					request.setCharacterEncoding(encoding);
					return request.getParameterMap();
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
					throw new RuntimeException();
				}
			} else if (request.getMethod().equalsIgnoreCase("get")) {
				Map<String, String[]> map = request.getParameterMap();
				for (Map.Entry<String, String[]> entry : map.entrySet()) {
					String[] values = entry.getValue();
					if (bEncode) {
						for (int i = 0; i < values.length; i++) {
							try {
								values[i] = new String(values[i].getBytes("iso8859-1"), encoding);
							} catch (UnsupportedEncodingException e) {
								e.printStackTrace();
								throw new RuntimeException();
							}
						}
						bEncode = false;
					}
				}
				return map;
			} else {
				return super.getParameterMap();
			}

		}

		@Override
		public String[] getParameterValues(String name) {
			Map<String, String[]> map = this.getParameterMap();
			return map.get(name);
		}

	}
}
