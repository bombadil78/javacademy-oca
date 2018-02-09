class Init {

    private int i;
    private int j;
    private int k = initMe();
    private static int l;
    private int m = 99;

    public Init() {
	i = 1;
    }

    {
	j = 2;
    }

    protected final int initMe() {
	return 3;
    }

    static {
	l = 4;
    }

    public void printMe() {
	System.out.println(String.format("i=%d, j=%d, k=%d, l=%d, m=%d", i, j, k, l, m));
    }
    
    public static final void main(String[] args) {
	Init i = new Init();
	i.printMe();
    }
}
    
