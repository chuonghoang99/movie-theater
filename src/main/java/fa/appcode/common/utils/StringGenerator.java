/*
 *
 * @author: ChuongHV1
 * @date: Dec 2, 2021
 */

package fa.appcode.common.utils;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class StringGenerator implements IdentifierGenerator {
	private String prefix = "G3_";

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object obj)
			throws HibernateException {
		return (prefix + RandomString.getAlphaNumericString(7));

	}
}
