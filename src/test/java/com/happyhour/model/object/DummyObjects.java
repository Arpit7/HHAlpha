package com.happyhour.model.object;

import java.util.Date;

import com.happyhour.model.Customer;
import com.happyhour.model.Merchant;
import com.happyhour.model.MerchantResturant;
import com.happyhour.model.OrderTable;
import com.happyhour.model.RestCategory;
import com.happyhour.model.RestOffer;
import com.happyhour.model.Resturant;

public class DummyObjects {

	public static Customer getCustomerObject() {
		Customer customer = new Customer();
		customer.setAddress("House No: xyz,Sector :zx,Gurgaon");
		customer.setCreatedDate(new Date());
		customer.setEmail("abc.xyz@gmail.com");
		customer.setPassword("abcdefgxz");
		customer.setPhoneNum(999999999);
		customer.setPincode(122001);
		customer.setUserId("cutomer1");
		customer.setUserName("Cutomer");
		return customer;
	}

	public static Merchant getMerchant() {

		Merchant m = new Merchant();

		m.setMerchantId(100001);
		m.setMerchantName("HALDIRAM");
		m.setPassword("haldiram");
		m.setPhoneNumber(988888888);
		m.setEmailId("abc.xyz@haldiram.com");
		m.setCreatedDate(new Date());

		return m;

	}

	public static MerchantResturant getMerchantResturant() {

		MerchantResturant mr = new MerchantResturant();

		mr.setMerchantId(getMerchant().getMerchantId());
		mr.setRestId(getResturant().getId());

		return mr;

	}

	public static OrderTable getOrderTable() {

		OrderTable ot = new OrderTable();

		ot.setOrderId(12345678);
		ot.setRestId(getResturant().getId());
		ot.setCustId(getCustomerObject().getId());
		ot.setOfferId(getRestOffer().getId());
		ot.setLocation("McD,Saket");
		ot.setDiscountTaken(getRestOffer().getDiscount());

		return ot;

	}

	public static RestCategory getRestCategory() {

		RestCategory rc = new RestCategory();

		rc.setCategory("Veg");
		rc.setRestId(getResturant().getId());

		return rc;

	}

	public static RestOffer getRestOffer() {

		RestOffer ro = new RestOffer();
		ro.setMerchantId(getMerchant().getMerchantId());
		ro.setRestid(getResturant().getId());
		ro.setCreationDate(new Date());
		ro.setStartTime(10000.000);
		ro.setEndTime(2000.00);
		ro.setDiscount(20.0);
		ro.setOfferId(200000111);
		ro.setOfferCount(100);

		return ro;

	}

	public static Resturant getResturant() {

		Resturant r = new Resturant();

		r.setRestName("Haldiram Saket Branch");
		r.setRestAddress("Saket");
		r.setRestPincode(122005);
		r.setRestPhoneNum(898888888);
		r.setRestEmail("saket-haldirambranch@haldiram.com");
		r.setRestLoginId("haldiram01");
		r.setRestPassword("haldiram01");
		r.setRestTypeId(01);
		r.setCreatedDate(new Date());

		return r;

	}

}
