class NumberWrapper {

    byte b = 0x0;

    public static void main(String[] args) {
	Byte b = 0b0;
	Double d = b.doubleValue();
	System.out.println(d);

	Float f = (Float) 128.0f;
	Byte bb = f.byteValue();  // will produce an overflow => -128 is assigned
	System.out.println(bb);
    }
}
