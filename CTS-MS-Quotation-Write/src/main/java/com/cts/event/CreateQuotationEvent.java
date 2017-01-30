package com.cts.event;

import com.cts.bo.QuotaionBO;

public class CreateQuotationEvent {

	private QuotaionBO quotaionBO;

	public QuotaionBO getQuotaionBO() {
		return quotaionBO;
	}

	public void setQuotaionBO(QuotaionBO quotaionBO) {
		this.quotaionBO = quotaionBO;
	}

	public CreateQuotationEvent(QuotaionBO quotaionBO) {
		super();
		this.quotaionBO = quotaionBO;
	}
	
	
}
