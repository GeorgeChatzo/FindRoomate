package main.java.gr.aueb.mscis.roommatefinder.model;

public class CellNumber {
	
	private String phonenumber;

    /*
     * Custom Constructor. Initializes cell number element
     * @param phonenumber
     */
    public CellNumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    /**
     * Returns the phone number
     * @return
     */
    public String getCellNumber() {
        return phonenumber;
    }

   /**
    * Return {@code true} if phone number is valid
    */
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
