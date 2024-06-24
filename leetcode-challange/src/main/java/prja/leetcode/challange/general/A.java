package prja.leetcode.challange.general;

class A {
	A() {
		greeting();
		prints();
	}

	void greeting() {
		System.out.println("instance method from A");
	}

	static void prints() {
		System.out.println("Static method from A");
	}

	public static void main(String[] args) {
		new B();
	}
}

class B extends A {
	B() {
		/*
		 * Compiler will automatically insert calls to no-args A's constructor using
		 * super();
		 */
		greeting();
		prints();
	}

	void greeting() {
		System.out.println("instance method from B");
	}

	static void prints() {
		System.out.println("Static method from B");
	}
}
