/*
 *
 * @author: ChuongHV1
 * @date: Dec 2, 2021
 */

package fa.appcode.common.utils;

public class RandomString {
	public static String getAlphaNumericString(int n) {
		String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz_";
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			int index = (int) (alphaNumericString.length() * Math.random());
			sb.append(alphaNumericString.charAt(index));
		}
		return sb.toString();
	}
}
