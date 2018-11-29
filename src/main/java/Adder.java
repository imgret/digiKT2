public class Adder {

    public static boolean carryOut;

    public static Register sum(Register Rg1, Register Rg3) {
        carryOut = false;

        for (int position = 0; position < Rg1.getSize(); position++) {
            if (Rg1.getBit(position) == 0 && Rg3.getBit(position) == 0) {
                if (carryOut) {
                    Rg3.setBit(position, 1);
                    carryOut = false;
                } else {
                    Rg3.setBit(position, 0);
                    carryOut = false;
                }
            }
            else if(Rg1.getBit(position) == 0 && Rg3.getBit(position) == 1) {
                if (carryOut) {
                    Rg3.setBit(position, 0);
                    carryOut = true;
                } else {
                    Rg3.setBit(position, 1);
                    carryOut = false;
                }
            }
            else if(Rg1.getBit(position) == 1 && Rg3.getBit(position) == 0) {
                if (carryOut) {
                    Rg3.setBit(position, 0);
                    carryOut = true;
                } else {
                    Rg3.setBit(position, 1);
                    carryOut = false;
                }
            }
            else if(Rg1.getBit(position) == 1 && Rg3.getBit(position) == 1) {
                if (carryOut) {
                    Rg3.setBit(position, 1);
                    carryOut = true;
                } else {
                    Rg3.setBit(position, 0);
                    carryOut = true;
                }
            }
        }

        return Rg3;
    }
}
