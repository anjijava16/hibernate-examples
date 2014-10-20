package com.hib.customtype;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.usertype.UserType;

public class MonetaryAmountType implements UserType {

	public Object assemble(Serializable arg0, Object arg1)
			throws HibernateException {
		// TODO Auto-generated method stub
		return arg0;
	}

	public Object deepCopy(Object arg0) throws HibernateException {
		// TODO Auto-generated method stub
		return arg0;
	}

	public Serializable disassemble(Object arg0) throws HibernateException {
		// TODO Auto-generated method stub
		return (Serializable) arg0;
	}

	public boolean equals(Object x, Object y) throws HibernateException {
		if (x == y)
			return true;
		if (x == null || y == null)
			return false;
		return x.equals(y);
	}

	public int hashCode(Object arg0) throws HibernateException {
		// TODO Auto-generated method stub
		return arg0.hashCode();
	}

	public boolean isMutable() {
		// TODO Auto-generated method stub
		return false;
	}

	public Object nullSafeGet(ResultSet arg0, String[] arg1,
			SessionImplementor arg2, Object arg3) throws HibernateException,
			SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void nullSafeSet(PreparedStatement arg0, Object arg1, int arg2,
			SessionImplementor arg3) throws HibernateException, SQLException {
		// TODO Auto-generated method stub

	}

	public Object replace(Object arg0, Object arg1, Object arg2)
			throws HibernateException {
		// TODO Auto-generated method stub
		return arg0;
	}

	public Class returnedClass() {
		// TODO Auto-generated method stub
		return MonetaryAmount.class;
	}

	public int[] sqlTypes() {
		// TODO Auto-generated method stub
		return new int[] { StandardBasicTypes.BIG_DECIMAL.sqlType() };
	}

}
