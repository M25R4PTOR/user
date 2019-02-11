package com.fpdual.user.singleton;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.Before;
import org.junit.Test;

public class BitCoinCounterTest {

	private BitCoinCounter bitCoinCounter;

	@Before // Se ejecuta antes de cada test incluido en esta clase
	public void init() {
		this.bitCoinCounter = BitCoinCounter.getInstance();
	}

	@Test
	public void deberiaComprarCoins() throws InterruptedException, ExecutionException {
		this.bitCoinCounter.comprarBitCoins(100);

		CompletableFuture.runAsync(() -> this.bitCoinCounter.comprarBitCoins(30));
		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 100);
		assertThat(future.get(), is(100));
	}
}
