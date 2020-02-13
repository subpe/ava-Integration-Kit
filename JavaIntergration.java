import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import com.subpe.commons.crypto.ChecksumUtils;

public class JavaIntergration {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("AMOUNT", "1.00");
		map.put("CURRENCY_CODE", "356");
		map.put("CUST_EMAIL", "neeraj.kumar@subpe.com");
		map.put("CUST_NAME", "SUBPE DEMO");
		map.put("CUST_PHONE", "8860705801");
		map.put("CUST_STREET_ADDRESS1", "Gurgaon");
		map.put("CUST_ZIP", "122016");
		map.put("MERCHANTNAME", "SUBPE Demo");
		map.put("ORDER_ID", "BHARTI00001");
		map.put("PAY_ID", "1804100638381010");

		map.put("PRODUCT_DESC", "SUBPE Demo Transaction");
		map.put("RETURN_URL", "http://uat.subpe.in/crm/jsp/response.jsp");
		map.put("TXNTYPE", "SALE");

		// Secret Key eec2fd91c96b4ebb
		String hash = ChecksumUtils.generateCheckSum(map, "eec2fd91c96b4ebb");
		StringBuilder httpRequest = new StringBuilder();

		httpRequest.append("<HTML>");
		httpRequest.append("<BODY OnLoad=\"OnLoadEvent();\" >");
		httpRequest.append("<form name=\"form1\" action=\"");
		httpRequest.append("http://uat.subpe.in/crm/jsp/paymentrequest");
		httpRequest.append("\" method=\"post\">");

		httpRequest.append("<input type=\"hidden\" name=\"PAY_ID\" value=\"");
		httpRequest.append("1804100638381010");
		httpRequest.append("\">");

		httpRequest.append("<input type=\"hidden\" name=\"MERCHANTNAME\" value=\"");
		httpRequest.append("SUBPE Demo");
		httpRequest.append("\">");

		httpRequest.append("<input type=\"hidden\" name=\"ORDER_ID\" value=\"");
		httpRequest.append("BHARTI00001");
		httpRequest.append("\">");

		httpRequest.append("<input type=\"hidden\" name=\"AMOUNT\" value=\"");
		httpRequest.append("100");
		httpRequest.append("\">");

		httpRequest.append("<input type=\"hidden\" name=\"TXNTYPE\" value=\"");
		httpRequest.append("SALE");
		httpRequest.append("\">");

		httpRequest.append("<input type=\"hidden\" name=\"CUST_NAME\" value=\"");
		httpRequest.append("BPAY");
		httpRequest.append("\">");

		httpRequest.append("<input type=\"hidden\" name=\"CUST_STREET_ADDRESS1\" value=\"");
		httpRequest.append("Gurgoan");
		httpRequest.append("\">");

		httpRequest.append("<input type=\"hidden\" name=\"CUST_ZIP\" value=\"");
		httpRequest.append("122016");
		httpRequest.append("\">");

		httpRequest.append("<input type=\"hidden\" name=\"CUST_PHONE\" value=\"");
		httpRequest.append("8860705801");
		httpRequest.append("\">");

		httpRequest.append("<input type=\"hidden\" name=\"CUST_EMAIL\" value=\"");
		httpRequest.append("neeraj.kumar@subpe.com");
		httpRequest.append("\">");

		httpRequest.append("<input type=\"hidden\" name=\"PRODUCT_DESC\" value=\"");
		httpRequest.append("Subpe Pay Product");
		httpRequest.append("\">");

		httpRequest.append("<input type=\"hidden\" name=\"CURRENCY_CODE\" value=\"");
		httpRequest.append("356");
		httpRequest.append("\">");

		httpRequest.append("<input type=\"hidden\" name=\"RETURN_URL\" value=\"");
		httpRequest.append("http://domain.com/response.jsp");
		httpRequest.append("\">");

		httpRequest.append("<input type=\"hidden\" name=\"HASH\" value=\"");
		httpRequest.append(hash);
		httpRequest.append("\">");

		httpRequest.append("</form>");
		httpRequest.append("<script language=\"JavaScript\">");
		httpRequest.append("function OnLoadEvent()");
		httpRequest.append("{document.form1.submit();}");
		httpRequest.append("</script>");
		httpRequest.append("</BODY>");
		httpRequest.append("</HTML>");

		httpRequest.toString();

	}

}
