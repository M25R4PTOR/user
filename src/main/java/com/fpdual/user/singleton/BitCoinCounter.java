package com.fpdual.user.singleton;

public class BitCoinCounter {

	private int counter = 0;

	private static BitCoinCounter instance = null;

	private BitCoinCounter() {

	}

	public static BitCoinCounter getInstance() {
		if (instance == null) {
			synchronized (BitCoinCounter.class) {
				if (instance == null) {

					instance = new BitCoinCounter();
				}
			}
		}
		return instance;
	}

	public void comprarBitCoins(int numeroAComprar) {
		this.counter = this.counter + numeroAComprar;
	}

	public void venderBitCoins(int numeroAVender) {
		if (this.counter >= numeroAVender) {
			synchronized (BitCoinCounter.class) {
				if (this.counter >= numeroAVender) {
					this.counter = this.counter - numeroAVender;
					return;
				}
			}
		}
		throw new RuntimeException("No hay bit coins suficientes");
	}

	public int getCounter() {
		return counter;
	}

}
