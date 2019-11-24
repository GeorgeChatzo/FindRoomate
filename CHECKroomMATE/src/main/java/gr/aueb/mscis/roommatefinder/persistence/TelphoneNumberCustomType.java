package main.java.gr.aueb.mscis.roommatefinder.persistence;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import main.java.gr.aueb.mscis.roommatefinder.model.CellNumber;



public class TelphoneNumberCustomType implements UserType{

	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		return cached;
	}

	public Object deepCopy(Object value) throws HibernateException {
		return value;
	}

	public Serializable disassemble(Object value) throws HibernateException {
		return (Serializable) value;
	}

	public boolean equals(Object x, Object y) throws HibernateException {
		if ( x == y) return true;
		if ( x== null || y==null) return false;
		return x.equals(y);
	}

	public int hashCode(Object value) throws HibernateException {
		return value.hashCode();
	}

	public boolean isMutable() {
		return false;
	}

	public Object nullSafeGet(ResultSet resultSet, String[] names, Object owner) throws HibernateException, SQLException {
		String stringValue = resultSet.getString(names[0]);
		if ( resultSet.wasNull()) {
			return null;
		}
		CellNumber telephone = new CellNumber(stringValue);
		return telephone;
	}

	public void nullSafeSet(PreparedStatement statement, Object value, int index) throws HibernateException, SQLException {
		if (value == null) {
		    statement.setNull(index, java.sql.Types.VARCHAR);
		}
		else {
			CellNumber telephone= (CellNumber) value;
			if (telephone.getCellNumber() == null ) {
			    statement.setNull(index, java.sql.Types.VARCHAR);  
			} else {
	            statement.setString(index, telephone.getCellNumber());			    
			}
		}		
	}

	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		return original;
	}


	@SuppressWarnings("rawtypes")
	public Class returnedClass() {
		return CellNumber.class;
	}

	public int[] sqlTypes() {
		return new int [] {java.sql.Types.VARCHAR};
	}

	@Override
	public Object nullSafeGet(ResultSet resultSet, String[] names, SharedSessionContractImplementor arg2, Object arg3)
			throws HibernateException, SQLException {
		return nullSafeGet(resultSet, names, arg3);
	}

	@Override
	public void nullSafeSet(PreparedStatement statement, Object value, int index, SharedSessionContractImplementor arg3)
			throws HibernateException, SQLException {
		nullSafeSet(statement, value, index);
	}

}
