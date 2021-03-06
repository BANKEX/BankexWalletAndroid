package com.bankex.pay.domain.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.math.BigInteger;

/**
 * Class for store user wallet/token data.
 */
public class WalletCardModel extends BaseBankexModel {

	private String title;
	private BigInteger value;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigInteger getValue() {
		return value;
	}

	public void setValue(BigInteger value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		WalletCardModel that = (WalletCardModel) o;
		return Objects.equal(title, that.title) &&
				Objects.equal(value, that.value);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(title, value);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("title", title)
				.add("value", value)
				.toString();
	}
}
