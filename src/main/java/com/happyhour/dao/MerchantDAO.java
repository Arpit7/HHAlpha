package com.happyhour.dao;

import java.util.Date;
import java.util.List;

import com.happyhour.model.Merchant;

/**
 * @author arpit.bhargava
 *
 */
public interface MerchantDAO {

	public List<Merchant> getRegisteredMerchant();
	
	public Merchant getMerchantInfo(int merchantId);

	public List<Merchant> getMerchantRegisteredBefore(Date creationDate);

	public List<Merchant> getMerchantRegisteredAfter(Date creationDate);

}
