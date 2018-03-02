public class BreakStuff {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            l: if (true) {
                break l;
            }
            System.out.println("Come here after if breaks");
        }


        l1: while (true) {
            l2: while (true) {
                break l1;
            }
        }

        boolean x = true;
        l1: if (true) {
            l2: if (x) {
                x = !x;
                break l1;
            } else {

            }

            if (true) {
                System.out.println("never here, break l1 resumes after the block");
            }
        }
        System.out.println("At the end");

        int i = 0;
        int j = 0;
        j += i++;
        System.out.println(j);

        i = 0;
        j = 0;
        j += ++i;
        System.out.println(j);

        int foo = 0;
        do {
            System.out.println(++foo);
        } while (foo <= 10);

        char c1 = 'x', c2 = 'y';

        switch (c1) {
            case 'x': System.out.println(); System.out.println(); System.out.println();
        }
    }
}