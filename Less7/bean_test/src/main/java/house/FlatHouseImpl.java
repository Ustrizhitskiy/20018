import house.InjectInt;

public class FlatHouseImpl implements House {
    @InjectInt(repeat = 3)
    private int repeat;

    private int flatNumber;

    public void setFlatNumber(int number) {
        this.flatNumber = number;
    }

    @Override
    public void outFlatNumber() {
        for (int i = 0; i< repeat; i++) {
            System.out.println("Flat number is: " + flatNumber);
        }
    }
}
