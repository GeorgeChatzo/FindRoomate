package main.java.gr.aueb.mscis.roommatefinder.model;

public class EmailAddress {
	
	 private String value;
	   /**
	    * Custom constructor for email
	    * @param email
	    */
	    public EmailAddress(String email) {
	        this.value = email;
	    }
	   /**
	    * Returns mail address
	    * @return
	    */
	    public String getAddress() {
	        return value;
	    }

	    /**
	     * Returns {@code true} if mail address is valid
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

	        if (!(other instanceof EmailAddress)) {
	            return false;
	        }

	        EmailAddress theEmail = (EmailAddress) other;
	        return value == null ? theEmail.getAddress() == null
	                : value.equals(theEmail.getAddress());
	    }

	    @Override
	    public int hashCode() {
	        return value == null ? 0 : value.hashCode();
	    }

	    @Override
	    public String toString() {
	        return value;
	    }
	
	

}