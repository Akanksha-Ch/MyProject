package edu.osu.cse5234.controller;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.osu.cse5234.model.Item;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.model.PaymentInfo;
import edu.osu.cse5234.model.ShippingInfo;
@Controller
@RequestMapping("/purchase")
public class Purchase 
{ 
	@RequestMapping(method = RequestMethod.GET)
	public String viewOrderEntryForm(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{// ... instantiate and set order object with items to display
		Order order = new Order();
		Item i1 = new Item();
		i1.setName("ABC");
		i1.setPrice("$35");
		List<Item> itemlist = new ArrayList<Item>();
		itemlist.add(i1);
		order.setItemlist(itemlist);
		request.setAttribute("order", order);
		return "OrderEntryForm";
	}
	@RequestMapping(path = "/submitItems", method = RequestMethod.POST)
	public String submitItems(@ModelAttribute("order") Order order, HttpServletRequest request) 
	{
		//TODO : Write logic instead of returning a JSP
		request.getSession().setAttribute("order", order);
		return "redirect:/purchase/paymentEntry";
	}
	@RequestMapping(path = "/paymentEntry", method = RequestMethod.GET)
	public String viewPaymentEntryForm(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		request.setAttribute("paymentinfo", new PaymentInfo());
		return "PaymentEntryForm";
	}
	
	@RequestMapping(path = "/submitPayment", method = RequestMethod.POST)
	public String submitPayment(@ModelAttribute("paymentinfo") PaymentInfo paymentInfo, HttpServletRequest request)
	{
		//TODO : Write logic instead of returning a JSP
		request.getSession().setAttribute("paymentinfo", paymentInfo);
		return "redirect:/purchase/paymentEntry";
	}
	@RequestMapping(path = "/shippingEntry", method = RequestMethod.GET) 
	public String viewShippingEntryForm(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		request.setAttribute("shippingInfo", new ShippingInfo());
		return "ShippingEntryForm";
	}
	@RequestMapping(path = "/submitShipping", method = RequestMethod.POST)
	public String submitShipping(@ModelAttribute("shippinginfo") ShippingInfo shippingInfo,HttpServletRequest request) 
	{
		//TODO : Write logic instead of returning a JSP
		request.getSession().setAttribute("shippinginfo", shippingInfo);
		return "redirect:/purchase/viewOrder";
	}
	@RequestMapping(path = "/viewOrder", method = RequestMethod.GET)
	public String viewOrder(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		//request.setAttribute("order", new ShippingInfo());
		return "ViewOrder";
	}
	@RequestMapping(path = "/confirmOrder", method = RequestMethod.POST)
	public String confirmOrder(HttpServletRequest request, HttpServletResponse response) 
	{
		//TODO : Write logic instead of returning a JSP
		//request.setAttribute("payment", new PaymentInfo());
		return "redirect:/purchase/viewConfirmation";
	}
	@RequestMapping(path = "/viewConfirmation", method = RequestMethod.GET)
	public String viewConfirmation(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		//request.setAttribute("payment", new PaymentInfo());
		return "Confirmation";
	}
}