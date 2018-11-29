public class BinaryMultiplier {

    public Counter counter;
    public Register Rg1;
    public Register Rg2;
    public Register Rg3;

    public BinaryMultiplier(int counterSize, int Rg1Size, int Rg2Size, int Rg3Size) {
        counter = new Counter(counterSize, 0);
        Rg1 = new Register(Rg1Size, 0);
        Rg2 = new Register(Rg2Size, 0);
        Rg3 = new Register(Rg3Size, 0);
    }

    public void multiply() throws Exception {

        System.out.println("---------Initializing---------");
        System.out.printf("Loendur: %s (%d) \nRg1: %s (%d) \nRg2: %s (%d) \nRg3: %s (%d) \n",
                counter.getBinaryValueAsString(), counter.value,
                Rg1.getBinaryValueAsString(), Rg1.value,
                Rg2.getBinaryValueAsString(), Rg2.value,
                Rg3.getBinaryValueAsString(), Rg3.value);
        System.out.println("\n-----------Process------------");

        while (counter.isZero() != 1) {

            if (Rg2.getBit(1) == 0) {
                if (Rg2.getBit(0) == 0) {
                    // nothing to do (go to next pair of bits)
                }
                else if (Rg2.getBit(0) == 1) {
                    Rg3 = Adder.sum(Rg1, Rg3);
                    Rg3.setBit(Rg3.size - 1, Adder.carryOut ? 1 : 0);  // pane CarryOut Rg3 vanemasse bitisse
                    if (Rg3.getBit(Rg3.size - 1) == 1) throw new Exception("Overflow (Ületäitumine) ");
                }
            } else if (Rg2.getBit(1) == 1) {
                if (Rg2.getBit(0) == 0) {
                    if (Rg1.getBit(Rg1.size - 1) == 1) throw new Exception("Overflow (Ületäitumine) ");
                    Rg3 = Adder.sum(Rg1.getRegisterShiftedLeftByOne(), Rg3);
                    Rg3.setBit(Rg3.size - 1, Adder.carryOut ? 1 : 0);  // pane CarryOut Rg3 vanemasse bitisse
                    if (Rg3.getBit(Rg3.size - 1) == 1) throw new Exception("Overflow (Ületäitumine) ");
                }
                else if (Rg2.getBit(0) == 1) {
                    // Rg3 + Rg1
                    Rg3 = Adder.sum(Rg1, Rg3);
                    Rg3.setBit(Rg3.size - 1, Adder.carryOut ? 1 : 0);  // pane CarryOut Rg3 vanemasse bitisse
                    if (Rg3.getBit(Rg3.size - 1) == 1) throw new Exception("Overflow (Ületäitumine) ");
                    // Rg3 + 2 * Rg1
                    if (Rg1.getBit(Rg1.size - 1) == 1) throw new Exception("Overflow (Ületäitumine) ");
                    Rg3 = Adder.sum(Rg1.getRegisterShiftedLeftByOne(), Rg3);
                    Rg3.setBit(Rg3.size - 1, Adder.carryOut ? 1 : 0);  // pane CarryOut Rg3 vanemasse bitisse
                    if (Rg3.getBit(Rg3.size - 1) == 1) throw new Exception("Overflow (Ületäitumine) ");
                }
            }

            System.out.printf("Loendur: %s (%d) \nRg1: %s (%d) \nRg2: %s (%d) \nRg3: %s (%d) \n",
                    counter.getBinaryValueAsString(), counter.value,
                    Rg1.getBinaryValueAsString(), Rg1.value,
                    Rg2.getBinaryValueAsString(), Rg2.value,
                    Rg3.getBinaryValueAsString(), Rg3.value);
            System.out.println("-------------------------");

            counter.reduceByOne();
            Rg1.shiftLeft(2);
            Rg2.shiftRight(2);

        }

        System.out.println("");
        System.out.println("---------Result----------");
        System.out.printf("Loendur: %s (%d) \nRg1: %s (%d) \nRg2: %s (%d) \nRg3: %s (%d) \n",
                counter.getBinaryValueAsString(), counter.value,
                Rg1.getBinaryValueAsString(), Rg1.value,
                Rg2.getBinaryValueAsString(), Rg2.value,
                Rg3.getBinaryValueAsString().substring(1), Rg3.value);
        // System.out.printf("Rg3: %s (%d) \n\n", Rg3.getBinaryValueAsString().substring(1), Rg3.value);
        // Rg3.getBinaryValueAsString().substring(1) because actual number size is 10 bits, so we eliminate 11-th bit
    }

}
