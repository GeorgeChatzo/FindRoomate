package gr.aueb.mscis.roommatefinder.model;

public class CellNumber {
	
	private String phonenumber;

    /**
     * Ξ�Ξ±Ο„Ξ±ΟƒΞΊΞµΟ…Ξ±ΟƒΟ„Ξ®Ο‚ Ο€ΞΏΟ… Ξ²Ξ±ΟƒΞ―Ξ¶ΞµΟ„Ξ±ΞΉ ΟƒΞµ ΞΌΞ―Ξ± ΟƒΟ…ΞΌΞ²ΞΏΞ»ΞΏΟƒΞµΞΉΟ�Ξ¬.
     * @param phonenumber Ξ� Ξ±Ο�ΞΉΞΈΞΌΟ�Ο‚ Ο„Ξ·Ξ»ΞµΟ†Ο�Ξ½ΞΏΟ…
     */
    public CellNumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    /**
     * Ξ•Ο€ΞΉΟƒΟ„Ο�Ξ­Ο†ΞµΞΉ Ο„ΞΏΞ½ Ξ±Ο�ΞΉΞΈΞΌΟ� Ο„Ξ·Ξ»ΞµΟ†Ο�Ξ½ΞΏΟ… Ο‰Ο‚ ΟƒΟ…ΞΌΞ²ΞΏΞ»ΞΏΟƒΞµΞΉΟ�Ξ¬.
     * @return Ξ� Ξ±Ο�ΞΉΞΈΞΌΟ�Ο‚ Ο„Ξ·Ξ»ΞµΟ†Ο�Ξ½ΞΏΟ…
     */

    public String getCellNumber() {
        return phonenumber;
    }

    /**
     * Ξ•Ο€Ξ±Ξ»Ξ·ΞΈΞµΟ�ΞµΞΉ Ο„Ξ·Ξ½ ΞΏΟ�ΞΈΟ�Ο„Ξ·Ο„Ξ± Ο„ΞΏΟ… Ξ±Ο�ΞΉΞΈΞΌΞΏΟ� Ο„Ξ·Ξ»ΞµΟ†Ο�Ξ½ΞΏΟ….
     * @return {@code true} ΞµΞ¬Ξ½ ΞΏ Ξ±Ο�ΞΉΞΈΞΌΟ�Ο‚ Ο„Ξ·Ξ»ΞµΟ†Ο�Ξ½ΞΏΟ… ΞµΞ―Ξ½Ξ±ΞΉ ΞΏΟ�ΞΈΟ�Ο‚
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
