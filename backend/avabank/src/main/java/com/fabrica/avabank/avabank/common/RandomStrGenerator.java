package com.avanade.avabank.avabank.common;

import java.util.UUID;

public class RandomStrGenerator {

	public String usingRandomUUID() {

		UUID randomUUID = UUID.randomUUID();

		return randomUUID.toString().replaceAll("_", "");
	}
}
