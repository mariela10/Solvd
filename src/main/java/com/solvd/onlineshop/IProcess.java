package com.solvd.onlineshop;


@FunctionalInterface
		public interface IProcess {
			
			public default void order() {
			}
			String validateOrder(String cname, boolean validpayment);

	}


