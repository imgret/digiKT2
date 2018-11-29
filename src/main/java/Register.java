public class Register {

    protected int value; // value stored in register (some number)
    protected int size;  // number of bits in register

    public Register(int size, int value) {
        this.size = size;
        this.value = value;
    }

    public int getBit(int position) {
        return (value >> position) & 1;
    }

    public void setBit(int position, int bit) {
        if (bit == 1) {
            value = value | (1 << position);
        }
        else if (bit == 0) {
            value = value & ~(1 << position);
        }
    }

    public void shiftLeft(int shift) {
        value = value << shift;
        // register has given size and change to 0 all bits after (size bit)
        value = value & (int) Math.pow(2, size) -1;
    }

    public void shiftRight(int shift) {
        value = value >> shift;
    }

    public Register getRegisterShiftedLeftByOne() {
        Register register = new Register(size, value << 1);
        return register;
    }

    public int getValue() {
        return value;
    }

    public String getBinaryValueAsString() {
        StringBuilder result = new StringBuilder(Integer.toBinaryString(value));
        if (result.length() > size) {
            return result.substring(result.length() - size);
        }
        while (result.length() < size) {
            result.insert(0, "0");
        }
        return result.toString();
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setValue(String value) {
        this.value = Integer.parseInt(value);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
