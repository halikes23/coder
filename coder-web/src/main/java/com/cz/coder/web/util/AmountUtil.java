package com.fq.util;

import java.math.BigDecimal;

public class AmountUtil {

	public static BigDecimal d2D(double doub) {
		BigDecimal bd = new BigDecimal(doub);
		return bd.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
}
