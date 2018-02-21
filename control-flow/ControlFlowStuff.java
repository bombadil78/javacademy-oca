public class ControlFlowStuff {

    public static void main(String[] args) {
        /*
         first part: init
         second part: condition; abort if false
         third part: executed after loop body
        */
        for (int i = 0; i < 10; i++) {

        }

        int i = 0;
        for (int j = 999;i < 10;) {
            i++;
        }

        // break - unlabelled
        for (;true;) {
            break;
        }

        do {
            break;
        } while (true);

        while (true) {
            break;
        }

        String s = "s";
        switch (s) {
            case "s":
                break;
            default:
                break;
        }

        // break - labelled
        l1:
        while (true) {
            l2:
            while (true) {
                System.out.println("i'm in second loop now");
                while (true) {
                    break l2;
                }
            }
        }
    }
}
