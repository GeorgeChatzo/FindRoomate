package main.java.gr.aueb.mscis.roommatefinder.model;

public class CellNumber {
	
	private String phonenumber;

    
    public CellNumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

   
    public String getCellNumber() {
        return phonenumber;
    }

   
    public boolean isValid() {
        return true;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        if (this == other) {
            return true;
        }

        if (!(other instanceof CellNumber)) {
            return false;
        }

        CellNumber thePhoneNumber = (CellNumber) other;
        return phonenumber == null
            ? thePhoneNumber.getCellNumber() == null
                : phonenumber.equals(thePhoneNumber.getCellNumber());
    }


    @Override
    public int hashCode() {
        return phonenumber == null ? 0 : phonenumber.hashCode();
    }


    @Override
    public String toString() {
        return phonenumber;
    }
	

}
