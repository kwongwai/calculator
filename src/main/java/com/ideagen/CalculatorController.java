package com.ideagen;

import java.text.DecimalFormat;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.Gson;
import com.ideagen.bean.CalculateBean;
import com.ideagen.bean.ResultBean;

/**
 * This is the class the handle the web request to perform the maths calculation
 * 
 * @author Michael Chan
 *
 */
@Controller
public class CalculatorController {

	/**
	 * The method to show the calcultion page
	 * 
	 * @param model
	 *            The model to set and pass the values to the frontend
	 * @return The page of the jsp
	 */
	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		return "welcome";
	}

	/**
	 * The method to do the math calculation and return result to frontend
	 * through JQuery
	 * 
	 * @param request
	 * @param model
	 *            The model to set and pass the values to the frontend
	 * @return The result to the frontend either is the calculation result or
	 *         error messages
	 * @throws Exception
	 */
	@RequestMapping(value = "/calculate", method = RequestMethod.POST)
	public @ResponseBody String calculate(MultipartHttpServletRequest request, ModelMap model) throws Exception {
		JSONObject msg = new JSONObject();
		System.out.println("Parameter:" + request.getParameter("num"));
		String value = null;
		DecimalFormat f = new DecimalFormat("##.00");
		try {
			value = f.format(Calculate.calculate(request.getParameter("num")));
		} catch (Exception e) {
			msg.put("success", "fail");
			msg.put("message", e.getMessage());
			return msg.toString();
		}

		msg.put("success", "success");
		msg.put("message", value);
		return msg.toString();
	}

	/**
	 * The method to accept the equation in the json format and return the
	 * result in the json format as well
	 * 
	 * @param request
	 * @param response
	 * @return The result in the json format with attribute of result, message
	 *         and status
	 * @throws Exception
	 */
	@RequestMapping(value = { "/submitEquation" }, method = RequestMethod.POST)
	@ResponseBody
	public String submitEquation(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Gson gson = new Gson();
		response.setContentType("application/json");
		StringBuilder sb = new StringBuilder();
		CalculateBean bean = null;
		ResultBean r = new ResultBean();
		String s;
		DecimalFormat f = new DecimalFormat("##.00");

		try {
			while ((s = request.getReader().readLine()) != null) {
				sb.append(s);
			}
			System.out.println(sb);
			bean = (CalculateBean) gson.fromJson(sb.toString(), CalculateBean.class);
			String result = f.format(Calculate.calculate(bean.getEquation()));
			r.setMessage("Success");
			r.setStatus("Success");
			r.setResult(result);
		} catch (Exception e) {
			r.setMessage(e.getMessage());
			r.setStatus("Fail");

		}
		response.getOutputStream().print(gson.toJson(r));
		response.getOutputStream().flush();

		return "";
	}

}