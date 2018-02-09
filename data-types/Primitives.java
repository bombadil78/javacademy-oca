class Primitives {

    // 8-bit signed
    private byte b = -128;
    private byte bb = 127;
    // private byte bbb = 128; <= will not compile
    private byte bbb = 0b00000000;

    // 16-bit signed
    private short s = -32768;
    private short ss = 32767;

    // 32-bit signed
    private int i = 100000;

    public void printAll() {
	System.out.println(b);
	System.out.println(bb);
	System.out.println(bbb);

	System.out.println(s);
	System.out.println(ss);

	System.out.println(i);
    }

    public static void main(String[] args) {
	Primitives p = new Primitives();
	p.printAll();
    }
}
