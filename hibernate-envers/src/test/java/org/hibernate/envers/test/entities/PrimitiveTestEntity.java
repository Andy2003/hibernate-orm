/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * Copyright (c) 2008, Red Hat Middleware LLC or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Red Hat Middleware LLC.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.hibernate.envers.test.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.envers.Audited;

/**
 * @author Adam Warski (adam at warski dot org)
 */
@Entity
public class PrimitiveTestEntity {
	@Id
	@GeneratedValue
	private Integer id;

	@Audited
	private int numVal1;

	private int numVal2;

	public PrimitiveTestEntity() {
	}

	public PrimitiveTestEntity(int numVal1, int numVal2) {
		this.numVal1 = numVal1;
		this.numVal2 = numVal2;
	}

	public PrimitiveTestEntity(Integer id, int numVal1, int number2) {
		this.id = id;
		this.numVal1 = numVal1;
		this.numVal2 = number2;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumVal1() {
		return numVal1;
	}

	public void setNumVal1(Integer numVal1) {
		this.numVal1 = numVal1;
	}

	public int getNumVal2() {
		return numVal2;
	}

	public void setNumVal2(int numVal2) {
		this.numVal2 = numVal2;
	}

	@Override
	public boolean equals(Object o) {
		if ( this == o ) {
			return true;
		}
		if ( !(o instanceof PrimitiveTestEntity) ) {
			return false;
		}

		PrimitiveTestEntity that = (PrimitiveTestEntity) o;

		if ( numVal1 != that.numVal1 ) {
			return false;
		}
		if ( numVal2 != that.numVal2 ) {
			return false;
		}
		if ( id != null ? !id.equals( that.id ) : that.id != null ) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + numVal1;
		result = 31 * result + numVal2;
		return result;
	}

	public String toString() {
		return "PTE(id = " + id + ", numVal1 = " + numVal1 + ", numVal2 = " + numVal2 + ")";
	}
}