package com.gorilla.sdkUI.util;

import org.apache.commons.lang.text.StrBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * copy from common-lang
 */
public class StringUtil
{
	public static final String EMPTY = "";
	public static final String YES = "Y";
	public static final String NO = "N";
	public static final String TRUE = "true";
	public static final String FALSE = "false";
	public static final String ZERO = "0";
	public static final String DEFAULT = "DEFAULT";
	public static final String[] EMPTY_STRING_ARRAY = new String[0];

	/**
	 * Represents a failed index search.
	 * @since 2.1
	 */
	public static final int INDEX_NOT_FOUND = -1;

	/**
	 * <p>The maximum size to which the padding constant(s) can expand.</p>
	 */
	private static final int PAD_LIMIT = 8192;

	// Empty checks
	//-----------------------------------------------------------------------
	/**
	 * <p>Checks if a String is empty ("") or null.</p>
	 *
	 * <pre>
	 * StringUtil.isEmpty(null)      = true
	 * StringUtil.isEmpty("")        = true
	 * StringUtil.isEmpty(" ")       = false
	 * StringUtil.isEmpty("bob")     = false
	 * StringUtil.isEmpty("  bob  ") = false
	 * </pre>
	 *
	 * <p>NOTE: This method changed in Lang version 2.0.
	 * It no longer trims the String.
	 * That functionality is available in isBlank().</p>
	 *
	 * @param str  the String to check, may be null
	 * @return <code>true</code> if the String is empty or null
	 */
	public static boolean isEmpty(String str)
	{
		return str == null || str.length() == 0;
	}

	/**
	 * <p>Checks if a String is not empty ("") and not null.</p>
	 *
	 * <pre>
	 * StringUtil.isNotEmpty(null)      = false
	 * StringUtil.isNotEmpty("")        = false
	 * StringUtil.isNotEmpty(" ")       = true
	 * StringUtil.isNotEmpty("bob")     = true
	 * StringUtil.isNotEmpty("  bob  ") = true
	 * </pre>
	 *
	 * @param str  the String to check, may be null
	 * @return <code>true</code> if the String is not empty and not null
	 */
	public static boolean isNotEmpty(String str)
	{
		return !StringUtil.isEmpty(str);
	}

	/**
	 * <p>Checks if a String is whitespace, empty ("") or null.</p>
	 *
	 * <pre>
	 * StringUtil.isBlank(null)      = true
	 * StringUtil.isBlank("")        = true
	 * StringUtil.isBlank(" ")       = true
	 * StringUtil.isBlank("bob")     = false
	 * StringUtil.isBlank("  bob  ") = false
	 * </pre>
	 *
	 * @param str  the String to check, may be null
	 * @return <code>true</code> if the String is null, empty or whitespace
	 * @since 2.0
	 */
	public static boolean isBlank(String str)
	{
		int strLen;
		if (str == null || (strLen = str.length()) == 0)
		{
			return true;
		}
		for (int i = 0; i < strLen; i++)
		{
			if ((Character.isWhitespace(str.charAt(i)) == false))
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * <p>Checks if a String is not empty (""), not null and not whitespace only.</p>
	 *
	 * <pre>
	 * StringUtil.isNotBlank(null)      = false
	 * StringUtil.isNotBlank("")        = false
	 * StringUtil.isNotBlank(" ")       = false
	 * StringUtil.isNotBlank("bob")     = true
	 * StringUtil.isNotBlank("  bob  ") = true
	 * </pre>
	 *
	 * @param str  the String to check, may be null
	 * @return <code>true</code> if the String is
	 *  not empty and not null and not whitespace
	 * @since 2.0
	 */
	public static boolean isNotBlank(String str)
	{
		return !StringUtil.isBlank(str);
	}

	// Trim
	//-----------------------------------------------------------------------
	/**
	 * <p>Removes control characters (char &lt;= 32) from both
	 * ends of this String, handling <code>null</code> by returning
	 * <code>null</code>.</p>
	 *
	 *
	 * <pre>
	 * StringUtil.trim(null)          = null
	 * StringUtil.trim("")            = ""
	 * StringUtil.trim("     ")       = ""
	 * StringUtil.trim("abc")         = "abc"
	 * StringUtil.trim("    abc    ") = "abc"
	 * </pre>
	 *
	 * @param str  the String to be trimmed, may be null
	 * @return the trimmed string, <code>null</code> if null String input
	 */
	public static String trim(String str)
	{
		return str == null ? null : str.trim();
	}

	/**
	 * <p>Removes control characters (char &lt;= 32) from both
	 * ends of this String returning <code>null</code> if the String is
	 * empty ("") after the trim or if it is <code>null</code>.
	 *
	 * <pre>
	 * StringUtil.trimToNull(null)          = null
	 * StringUtil.trimToNull("")            = null
	 * StringUtil.trimToNull("     ")       = null
	 * StringUtil.trimToNull("abc")         = "abc"
	 * StringUtil.trimToNull("    abc    ") = "abc"
	 * </pre>
	 *
	 * @param str  the String to be trimmed, may be null
	 * @return the trimmed String,
	 *  <code>null</code> if only chars &lt;= 32, empty or null String input
	 * @since 2.0
	 */
	public static String trimToNull(String str)
	{
		String ts = trim(str);
		return isEmpty(ts) ? null : ts;
	}

	/**
	 * <p>Removes control characters (char &lt;= 32) from both
	 * ends of this String returning an empty String ("") if the String
	 * is empty ("") after the trim or if it is <code>null</code>.
	 *
	 * <pre>
	 * StringUtil.trimToEmpty(null)          = ""
	 * StringUtil.trimToEmpty("")            = ""
	 * StringUtil.trimToEmpty("     ")       = ""
	 * StringUtil.trimToEmpty("abc")         = "abc"
	 * StringUtil.trimToEmpty("    abc    ") = "abc"
	 * </pre>
	 *
	 * @param str  the String to be trimmed, may be null
	 * @return the trimmed String, or an empty String if <code>null</code> input
	 * @since 2.0
	 */
	public static String trimToEmpty(String str)
	{
		return str == null ? EMPTY : str.trim();
	}

	// Equals
	//-----------------------------------------------------------------------
	/**
	 * <p>Compares two Strings, returning <code>true</code> if they are equal.</p>
	 *
	 * <p><code>null</code>s are handled without exceptions. Two <code>null</code>
	 * references are considered to be equal. The comparison is case sensitive.</p>
	 *
	 * <pre>
	 * StringUtil.equals(null, null)   = true
	 * StringUtil.equals(null, "abc")  = false
	 * StringUtil.equals("abc", null)  = false
	 * StringUtil.equals("abc", "abc") = true
	 * StringUtil.equals("abc", "ABC") = false
	 * </pre>
	 *
	 * @see String#equals(Object)
	 * @param str1  the first String, may be null
	 * @param str2  the second String, may be null
	 * @return <code>true</code> if the Strings are equal, case sensitive, or
	 *  both <code>null</code>
	 */
	public static boolean equals(String str1, String str2)
	{
		return str1 == null ? str2 == null : str1.equals(str2);
	}

	/**
	 * <p>Compares two Strings, returning <code>true</code> if they are equal ignoring
	 * the case.</p>
	 *
	 * <p><code>null</code>s are handled without exceptions. Two <code>null</code>
	 * references are considered equal. Comparison is case insensitive.</p>
	 *
	 * <pre>
	 * StringUtil.equalsIgnoreCase(null, null)   = true
	 * StringUtil.equalsIgnoreCase(null, "abc")  = false
	 * StringUtil.equalsIgnoreCase("abc", null)  = false
	 * StringUtil.equalsIgnoreCase("abc", "abc") = true
	 * StringUtil.equalsIgnoreCase("abc", "ABC") = true
	 * </pre>
	 *
	 * @see String#equalsIgnoreCase(String)
	 * @param str1  the first String, may be null
	 * @param str2  the second String, may be null
	 * @return <code>true</code> if the Strings are equal, case insensitive, or
	 *  both <code>null</code>
	 */
	public static boolean equalsIgnoreCase(String str1, String str2)
	{
		return str1 == null ? str2 == null : str1.equalsIgnoreCase(str2);
	}

	// IndexOf
	//-----------------------------------------------------------------------
	/**
	 * <p>Finds the first index within a String, handling <code>null</code>.
	 * This method uses {@link String#indexOf(String)}.</p>
	 *
	 * <p>A <code>null</code> String will return <code>-1</code>.</p>
	 *
	 * <pre>
	 * StringUtil.indexOf(null, *)          = -1
	 * StringUtil.indexOf(*, null)          = -1
	 * StringUtil.indexOf("", "")           = 0
	 * StringUtil.indexOf("aabaabaa", "a")  = 0
	 * StringUtil.indexOf("aabaabaa", "b")  = 2
	 * StringUtil.indexOf("aabaabaa", "ab") = 1
	 * StringUtil.indexOf("aabaabaa", "")   = 0
	 * </pre>
	 *
	 * @param str  the String to check, may be null
	 * @param searchStr  the String to find, may be null
	 * @return the first index of the search String,
	 *  -1 if no match or <code>null</code> string input
	 * @since 2.0
	 */
	public static int indexOf(String str, String searchStr)
	{
		if (str == null || searchStr == null)
		{
			return -1;
		}
		return str.indexOf(searchStr);
	}

	/**
	 * <p>Finds the first index within a String, handling <code>null</code>.
	 * This method uses {@link String#indexOf(String, int)}.</p>
	 *
	 * <p>A <code>null</code> String will return <code>-1</code>.
	 * A negative start position is treated as zero.
	 * An empty ("") search String always matches.
	 * A start position greater than the string length only matches
	 * an empty search String.</p>
	 *
	 * <pre>
	 * StringUtil.indexOf(null, *, *)          = -1
	 * StringUtil.indexOf(*, null, *)          = -1
	 * StringUtil.indexOf("", "", 0)           = 0
	 * StringUtil.indexOf("aabaabaa", "a", 0)  = 0
	 * StringUtil.indexOf("aabaabaa", "b", 0)  = 2
	 * StringUtil.indexOf("aabaabaa", "ab", 0) = 1
	 * StringUtil.indexOf("aabaabaa", "b", 3)  = 5
	 * StringUtil.indexOf("aabaabaa", "b", 9)  = -1
	 * StringUtil.indexOf("aabaabaa", "b", -1) = 2
	 * StringUtil.indexOf("aabaabaa", "", 2)   = 2
	 * StringUtil.indexOf("abc", "", 9)        = 3
	 * </pre>
	 *
	 * @param str  the String to check, may be null
	 * @param searchStr  the String to find, may be null
	 * @param startPos  the start position, negative treated as zero
	 * @return the first index of the search String,
	 *  -1 if no match or <code>null</code> string input
	 * @since 2.0
	 */
	public static int indexOf(String str, String searchStr, int startPos)
	{
		if (str == null || searchStr == null)
		{
			return -1;
		}
		// JDK1.2/JDK1.3 have a bug, when startPos > str.length for "", hence
		if (searchStr.length() == 0 && startPos >= str.length())
		{
			return str.length();
		}
		return str.indexOf(searchStr, startPos);
	}

	/**
	 * <p>Case in-sensitive find of the first index within a String.</p>
	 *
	 * <p>A <code>null</code> String will return <code>-1</code>.
	 * A negative start position is treated as zero.
	 * An empty ("") search String always matches.
	 * A start position greater than the string length only matches
	 * an empty search String.</p>
	 *
	 * <pre>
	 * StringUtil.indexOfIgnoreCase(null, *)          = -1
	 * StringUtil.indexOfIgnoreCase(*, null)          = -1
	 * StringUtil.indexOfIgnoreCase("", "")           = 0
	 * StringUtil.indexOfIgnoreCase("aabaabaa", "a")  = 0
	 * StringUtil.indexOfIgnoreCase("aabaabaa", "b")  = 2
	 * StringUtil.indexOfIgnoreCase("aabaabaa", "ab") = 1
	 * </pre>
	 *
	 * @param str  the String to check, may be null
	 * @param searchStr  the String to find, may be null
	 * @return the first index of the search String,
	 *  -1 if no match or <code>null</code> string input
	 * @since 2.5
	 */
	public static int indexOfIgnoreCase(String str, String searchStr)
	{
		return indexOfIgnoreCase(str, searchStr, 0);
	}

	/**
	 * <p>Case in-sensitive find of the first index within a String
	 * from the specified position.</p>
	 *
	 * <p>A <code>null</code> String will return <code>-1</code>.
	 * A negative start position is treated as zero.
	 * An empty ("") search String always matches.
	 * A start position greater than the string length only matches
	 * an empty search String.</p>
	 *
	 * <pre>
	 * StringUtil.indexOfIgnoreCase(null, *, *)          = -1
	 * StringUtil.indexOfIgnoreCase(*, null, *)          = -1
	 * StringUtil.indexOfIgnoreCase("", "", 0)           = 0
	 * StringUtil.indexOfIgnoreCase("aabaabaa", "A", 0)  = 0
	 * StringUtil.indexOfIgnoreCase("aabaabaa", "B", 0)  = 2
	 * StringUtil.indexOfIgnoreCase("aabaabaa", "AB", 0) = 1
	 * StringUtil.indexOfIgnoreCase("aabaabaa", "B", 3)  = 5
	 * StringUtil.indexOfIgnoreCase("aabaabaa", "B", 9)  = -1
	 * StringUtil.indexOfIgnoreCase("aabaabaa", "B", -1) = 2
	 * StringUtil.indexOfIgnoreCase("aabaabaa", "", 2)   = 2
	 * StringUtil.indexOfIgnoreCase("abc", "", 9)        = 3
	 * </pre>
	 *
	 * @param str  the String to check, may be null
	 * @param searchStr  the String to find, may be null
	 * @param startPos  the start position, negative treated as zero
	 * @return the first index of the search String,
	 *  -1 if no match or <code>null</code> string input
	 * @since 2.5
	 */
	public static int indexOfIgnoreCase(String str, String searchStr, int startPos)
	{
		if (str == null || searchStr == null)
		{
			return -1;
		}
		if (startPos < 0)
		{
			startPos = 0;
		}
		int endLimit = (str.length() - searchStr.length()) + 1;
		if (startPos > endLimit)
		{
			return -1;
		}
		if (searchStr.length() == 0)
		{
			return startPos;
		}
		for (int i = startPos; i < endLimit; i++)
		{
			if (str.regionMatches(true, i, searchStr, 0, searchStr.length()))
			{
				return i;
			}
		}
		return -1;
	}

	// LastIndexOf
	//-----------------------------------------------------------------------
	/**
	 * <p>Finds the last index within a String, handling <code>null</code>.
	 * This method uses {@link String#lastIndexOf(int)}.</p>
	 *
	 * <p>A <code>null</code> or empty ("") String will return <code>-1</code>.</p>
	 *
	 * <pre>
	 * StringUtil.lastIndexOf(null, *)         = -1
	 * StringUtil.lastIndexOf("", *)           = -1
	 * StringUtil.lastIndexOf("aabaabaa", 'a') = 7
	 * StringUtil.lastIndexOf("aabaabaa", 'b') = 5
	 * </pre>
	 *
	 * @param str  the String to check, may be null
	 * @param searchChar  the character to find
	 * @return the last index of the search character,
	 *  -1 if no match or <code>null</code> string input
	 * @since 2.0
	 */
	public static int lastIndexOf(String str, char searchChar)
	{
		if (isEmpty(str))
		{
			return -1;
		}
		return str.lastIndexOf(searchChar);
	}

	/**
	 * <p>Finds the last index within a String from a start position,
	 * handling <code>null</code>.
	 * This method uses {@link String#lastIndexOf(int, int)}.</p>
	 *
	 * <p>A <code>null</code> or empty ("") String will return <code>-1</code>.
	 * A negative start position returns <code>-1</code>.
	 * A start position greater than the string length searches the whole string.</p>
	 *
	 * <pre>
	 * StringUtil.lastIndexOf(null, *, *)          = -1
	 * StringUtil.lastIndexOf("", *,  *)           = -1
	 * StringUtil.lastIndexOf("aabaabaa", 'b', 8)  = 5
	 * StringUtil.lastIndexOf("aabaabaa", 'b', 4)  = 2
	 * StringUtil.lastIndexOf("aabaabaa", 'b', 0)  = -1
	 * StringUtil.lastIndexOf("aabaabaa", 'b', 9)  = 5
	 * StringUtil.lastIndexOf("aabaabaa", 'b', -1) = -1
	 * StringUtil.lastIndexOf("aabaabaa", 'a', 0)  = 0
	 * </pre>
	 *
	 * @param str  the String to check, may be null
	 * @param searchChar  the character to find
	 * @param startPos  the start position
	 * @return the last index of the search character,
	 *  -1 if no match or <code>null</code> string input
	 * @since 2.0
	 */
	public static int lastIndexOf(String str, char searchChar, int startPos)
	{
		if (isEmpty(str))
		{
			return -1;
		}
		return str.lastIndexOf(searchChar, startPos);
	}

	/**
	 * <p>Finds the last index within a String, handling <code>null</code>.
	 * This method uses {@link String#lastIndexOf(String)}.</p>
	 *
	 * <p>A <code>null</code> String will return <code>-1</code>.</p>
	 *
	 * <pre>
	 * StringUtil.lastIndexOf(null, *)          = -1
	 * StringUtil.lastIndexOf(*, null)          = -1
	 * StringUtil.lastIndexOf("", "")           = 0
	 * StringUtil.lastIndexOf("aabaabaa", "a")  = 0
	 * StringUtil.lastIndexOf("aabaabaa", "b")  = 2
	 * StringUtil.lastIndexOf("aabaabaa", "ab") = 1
	 * StringUtil.lastIndexOf("aabaabaa", "")   = 8
	 * </pre>
	 *
	 * @param str  the String to check, may be null
	 * @param searchStr  the String to find, may be null
	 * @return the last index of the search String,
	 *  -1 if no match or <code>null</code> string input
	 * @since 2.0
	 */
	public static int lastIndexOf(String str, String searchStr)
	{
		if (str == null || searchStr == null)
		{
			return -1;
		}
		return str.lastIndexOf(searchStr);
	}

	/**
	 * <p>Finds the first index within a String, handling <code>null</code>.
	 * This method uses {@link String#lastIndexOf(String, int)}.</p>
	 *
	 * <p>A <code>null</code> String will return <code>-1</code>.
	 * A negative start position returns <code>-1</code>.
	 * An empty ("") search String always matches unless the start position is negative.
	 * A start position greater than the string length searches the whole string.</p>
	 *
	 * <pre>
	 * StringUtil.lastIndexOf(null, *, *)          = -1
	 * StringUtil.lastIndexOf(*, null, *)          = -1
	 * StringUtil.lastIndexOf("aabaabaa", "a", 8)  = 7
	 * StringUtil.lastIndexOf("aabaabaa", "b", 8)  = 5
	 * StringUtil.lastIndexOf("aabaabaa", "ab", 8) = 4
	 * StringUtil.lastIndexOf("aabaabaa", "b", 9)  = 5
	 * StringUtil.lastIndexOf("aabaabaa", "b", -1) = -1
	 * StringUtil.lastIndexOf("aabaabaa", "a", 0)  = 0
	 * StringUtil.lastIndexOf("aabaabaa", "b", 0)  = -1
	 * </pre>
	 *
	 * @param str  the String to check, may be null
	 * @param searchStr  the String to find, may be null
	 * @param startPos  the start position, negative treated as zero
	 * @return the first index of the search String,
	 *  -1 if no match or <code>null</code> string input
	 * @since 2.0
	 */
	public static int lastIndexOf(String str, String searchStr, int startPos)
	{
		if (str == null || searchStr == null)
		{
			return -1;
		}
		return str.lastIndexOf(searchStr, startPos);
	}

	/**
	 * <p>Case in-sensitive find of the last index within a String.</p>
	 *
	 * <p>A <code>null</code> String will return <code>-1</code>.
	 * A negative start position returns <code>-1</code>.
	 * An empty ("") search String always matches unless the start position is negative.
	 * A start position greater than the string length searches the whole string.</p>
	 *
	 * <pre>
	 * StringUtil.lastIndexOfIgnoreCase(null, *)          = -1
	 * StringUtil.lastIndexOfIgnoreCase(*, null)          = -1
	 * StringUtil.lastIndexOfIgnoreCase("aabaabaa", "A")  = 7
	 * StringUtil.lastIndexOfIgnoreCase("aabaabaa", "B")  = 5
	 * StringUtil.lastIndexOfIgnoreCase("aabaabaa", "AB") = 4
	 * </pre>
	 *
	 * @param str  the String to check, may be null
	 * @param searchStr  the String to find, may be null
	 * @return the first index of the search String,
	 *  -1 if no match or <code>null</code> string input
	 * @since 2.5
	 */
	public static int lastIndexOfIgnoreCase(String str, String searchStr)
	{
		if (str == null || searchStr == null)
		{
			return -1;
		}
		return lastIndexOfIgnoreCase(str, searchStr, str.length());
	}

	/**
	 * <p>Case in-sensitive find of the last index within a String
	 * from the specified position.</p>
	 *
	 * <p>A <code>null</code> String will return <code>-1</code>.
	 * A negative start position returns <code>-1</code>.
	 * An empty ("") search String always matches unless the start position is negative.
	 * A start position greater than the string length searches the whole string.</p>
	 *
	 * <pre>
	 * StringUtil.lastIndexOfIgnoreCase(null, *, *)          = -1
	 * StringUtil.lastIndexOfIgnoreCase(*, null, *)          = -1
	 * StringUtil.lastIndexOfIgnoreCase("aabaabaa", "A", 8)  = 7
	 * StringUtil.lastIndexOfIgnoreCase("aabaabaa", "B", 8)  = 5
	 * StringUtil.lastIndexOfIgnoreCase("aabaabaa", "AB", 8) = 4
	 * StringUtil.lastIndexOfIgnoreCase("aabaabaa", "B", 9)  = 5
	 * StringUtil.lastIndexOfIgnoreCase("aabaabaa", "B", -1) = -1
	 * StringUtil.lastIndexOfIgnoreCase("aabaabaa", "A", 0)  = 0
	 * StringUtil.lastIndexOfIgnoreCase("aabaabaa", "B", 0)  = -1
	 * </pre>
	 *
	 * @param str  the String to check, may be null
	 * @param searchStr  the String to find, may be null
	 * @param startPos  the start position
	 * @return the first index of the search String,
	 *  -1 if no match or <code>null</code> string input
	 * @since 2.5
	 */
	public static int lastIndexOfIgnoreCase(String str, String searchStr, int startPos)
	{
		if (str == null || searchStr == null)
		{
			return -1;
		}
		if (startPos > (str.length() - searchStr.length()))
		{
			startPos = str.length() - searchStr.length();
		}
		if (startPos < 0)
		{
			return -1;
		}
		if (searchStr.length() == 0)
		{
			return startPos;
		}

		for (int i = startPos; i >= 0; i--)
		{
			if (str.regionMatches(true, i, searchStr, 0, searchStr.length()))
			{
				return i;
			}
		}
		return -1;
	}

	// Contains
	//-----------------------------------------------------------------------
	/**
	 * <p>Checks if String contains a search character, handling <code>null</code>.
	 * This method uses {@link String#indexOf(int)}.</p>
	 *
	 * <p>A <code>null</code> or empty ("") String will return <code>false</code>.</p>
	 *
	 * <pre>
	 * StringUtil.contains(null, *)    = false
	 * StringUtil.contains("", *)      = false
	 * StringUtil.contains("abc", 'a') = true
	 * StringUtil.contains("abc", 'z') = false
	 * </pre>
	 *
	 * @param str  the String to check, may be null
	 * @param searchChar  the character to find
	 * @return true if the String contains the search character,
	 *  false if not or <code>null</code> string input
	 * @since 2.0
	 */
	public static boolean contains(String str, char searchChar)
	{
		if (isEmpty(str))
		{
			return false;
		}
		return str.indexOf(searchChar) >= 0;
	}

	/**
	 * <p>Checks if String contains a search String, handling <code>null</code>.
	 * This method uses {@link String#indexOf(String)}.</p>
	 *
	 * <p>A <code>null</code> String will return <code>false</code>.</p>
	 *
	 * <pre>
	 * StringUtil.contains(null, *)     = false
	 * StringUtil.contains(*, null)     = false
	 * StringUtil.contains("", "")      = true
	 * StringUtil.contains("abc", "")   = true
	 * StringUtil.contains("abc", "a")  = true
	 * StringUtil.contains("abc", "z")  = false
	 * </pre>
	 *
	 * @param str  the String to check, may be null
	 * @param searchStr  the String to find, may be null
	 * @return true if the String contains the search String,
	 *  false if not or <code>null</code> string input
	 * @since 2.0
	 */
	public static boolean contains(String str, String searchStr)
	{
		if (str == null || searchStr == null)
		{
			return false;
		}
		return str.indexOf(searchStr) >= 0;
	}

	/**
	 * <p>Checks if String contains a search String irrespective of case,
	 * handling <code>null</code>. Case-insensitivity is defined as by
	 * {@link String#equalsIgnoreCase(String)}.
	 *
	 * <p>A <code>null</code> String will return <code>false</code>.</p>
	 *
	 * <pre>
	 * StringUtil.contains(null, *) = false
	 * StringUtil.contains(*, null) = false
	 * StringUtil.contains("", "") = true
	 * StringUtil.contains("abc", "") = true
	 * StringUtil.contains("abc", "a") = true
	 * StringUtil.contains("abc", "z") = false
	 * StringUtil.contains("abc", "A") = true
	 * StringUtil.contains("abc", "Z") = false
	 * </pre>
	 *
	 * @param str  the String to check, may be null
	 * @param searchStr  the String to find, may be null
	 * @return true if the String contains the search String irrespective of
	 * case or false if not or <code>null</code> string input
	 */
	public static boolean containsIgnoreCase(String str, String searchStr)
	{
		if (str == null || searchStr == null)
		{
			return false;
		}
		int len = searchStr.length();
		int max = str.length() - len;
		for (int i = 0; i <= max; i++)
		{
			if (str.regionMatches(true, i, searchStr, 0, len))
			{
				return true;
			}
		}
		return false;
	}

	// Substring
	//-----------------------------------------------------------------------
	/**
	 * <p>Gets a substring from the specified String avoiding exceptions.</p>
	 *
	 * <p>A negative start position can be used to start <code>n</code>
	 * characters from the end of the String.</p>
	 *
	 * <p>A <code>null</code> String will return <code>null</code>.
	 * An empty ("") String will return "".</p>
	 *
	 * <pre>
	 * StringUtil.substring(null, *)   = null
	 * StringUtil.substring("", *)     = ""
	 * StringUtil.substring("abc", 0)  = "abc"
	 * StringUtil.substring("abc", 2)  = "c"
	 * StringUtil.substring("abc", 4)  = ""
	 * StringUtil.substring("abc", -2) = "bc"
	 * StringUtil.substring("abc", -4) = "abc"
	 * </pre>
	 *
	 * @param str  the String to get the substring from, may be null
	 * @param start  the position to start from, negative means
	 *  count back from the end of the String by this many characters
	 * @return substring from start position, <code>null</code> if null String input
	 */
	public static String substring(String str, int start)
	{
		if (str == null)
		{
			return null;
		}

		// handle negatives, which means last n characters
		if (start < 0)
		{
			start = str.length() + start; // remember start is negative
		}

		if (start < 0)
		{
			start = 0;
		}
		if (start > str.length())
		{
			return EMPTY;
		}

		return str.substring(start);
	}

	/**
	 * <p>Gets a substring from the specified String avoiding exceptions.</p>
	 *
	 * <p>A negative start position can be used to start/end <code>n</code>
	 * characters from the end of the String.</p>
	 *
	 * <p>The returned substring starts with the character in the <code>start</code>
	 * position and ends before the <code>end</code> position. All position counting is
	 * zero-based -- i.e., to start at the beginning of the string use
	 * <code>start = 0</code>. Negative start and end positions can be used to
	 * specify offsets relative to the end of the String.</p>
	 *
	 * <p>If <code>start</code> is not strictly to the left of <code>end</code>, ""
	 * is returned.</p>
	 *
	 * <pre>
	 * StringUtil.substring(null, *, *)    = null
	 * StringUtil.substring("", * ,  *)    = "";
	 * StringUtil.substring("abc", 0, 2)   = "ab"
	 * StringUtil.substring("abc", 2, 0)   = ""
	 * StringUtil.substring("abc", 2, 4)   = "c"
	 * StringUtil.substring("abc", 4, 6)   = ""
	 * StringUtil.substring("abc", 2, 2)   = ""
	 * StringUtil.substring("abc", -2, -1) = "b"
	 * StringUtil.substring("abc", -4, 2)  = "ab"
	 * </pre>
	 *
	 * @param str  the String to get the substring from, may be null
	 * @param start  the position to start from, negative means
	 *  count back from the end of the String by this many characters
	 * @param end  the position to end at (exclusive), negative means
	 *  count back from the end of the String by this many characters
	 * @return substring from start position to end positon,
	 *  <code>null</code> if null String input
	 */
	public static String substring(String str, int start, int end)
	{
		if (str == null)
		{
			return null;
		}

		// handle negatives
		if (end < 0)
		{
			end = str.length() + end; // remember end is negative
		}
		if (start < 0)
		{
			start = str.length() + start; // remember start is negative
		}

		// check length next
		if (end > str.length())
		{
			end = str.length();
		}

		// if start is greater than end, return ""
		if (start > end)
		{
			return EMPTY;
		}

		if (start < 0)
		{
			start = 0;
		}
		if (end < 0)
		{
			end = 0;
		}

		return str.substring(start, end);
	}

	// Left/Right/Mid
	//-----------------------------------------------------------------------
	/**
	 * <p>Gets the leftmost <code>len</code> characters of a String.</p>
	 *
	 * <p>If <code>len</code> characters are not available, or the
	 * String is <code>null</code>, the String will be returned without
	 * an exception. An exception is thrown if len is negative.</p>
	 *
	 * <pre>
	 * StringUtil.left(null, *)    = null
	 * StringUtil.left(*, -ve)     = ""
	 * StringUtil.left("", *)      = ""
	 * StringUtil.left("abc", 0)   = ""
	 * StringUtil.left("abc", 2)   = "ab"
	 * StringUtil.left("abc", 4)   = "abc"
	 * </pre>
	 *
	 * @param str  the String to get the leftmost characters from, may be null
	 * @param len  the length of the required String, must be zero or positive
	 * @return the leftmost characters, <code>null</code> if null String input
	 */
	public static String left(String str, int len)
	{
		if (str == null)
		{
			return null;
		}
		if (len < 0)
		{
			return EMPTY;
		}
		if (str.length() <= len)
		{
			return str;
		}
		return str.substring(0, len);
	}

	/**
	 * <p>Gets the rightmost <code>len</code> characters of a String.</p>
	 *
	 * <p>If <code>len</code> characters are not available, or the String
	 * is <code>null</code>, the String will be returned without an
	 * an exception. An exception is thrown if len is negative.</p>
	 *
	 * <pre>
	 * StringUtil.right(null, *)    = null
	 * StringUtil.right(*, -ve)     = ""
	 * StringUtil.right("", *)      = ""
	 * StringUtil.right("abc", 0)   = ""
	 * StringUtil.right("abc", 2)   = "bc"
	 * StringUtil.right("abc", 4)   = "abc"
	 * </pre>
	 *
	 * @param str  the String to get the rightmost characters from, may be null
	 * @param len  the length of the required String, must be zero or positive
	 * @return the rightmost characters, <code>null</code> if null String input
	 */
	public static String right(String str, int len)
	{
		if (str == null)
		{
			return null;
		}
		if (len < 0)
		{
			return EMPTY;
		}
		if (str.length() <= len)
		{
			return str;
		}
		return str.substring(str.length() - len);
	}

	/**
	 * <p>Gets <code>len</code> characters from the middle of a String.</p>
	 *
	 * <p>If <code>len</code> characters are not available, the remainder
	 * of the String will be returned without an exception. If the
	 * String is <code>null</code>, <code>null</code> will be returned.
	 * An exception is thrown if len is negative.</p>
	 *
	 * <pre>
	 * StringUtil.mid(null, *, *)    = null
	 * StringUtil.mid(*, *, -ve)     = ""
	 * StringUtil.mid("", 0, *)      = ""
	 * StringUtil.mid("abc", 0, 2)   = "ab"
	 * StringUtil.mid("abc", 0, 4)   = "abc"
	 * StringUtil.mid("abc", 2, 4)   = "c"
	 * StringUtil.mid("abc", 4, 2)   = ""
	 * StringUtil.mid("abc", -2, 2)  = "ab"
	 * </pre>
	 *
	 * @param str  the String to get the characters from, may be null
	 * @param pos  the position to start from, negative treated as zero
	 * @param len  the length of the required String, must be zero or positive
	 * @return the middle characters, <code>null</code> if null String input
	 */
	public static String mid(String str, int pos, int len)
	{
		if (str == null)
		{
			return null;
		}
		if (len < 0 || pos > str.length())
		{
			return EMPTY;
		}
		if (pos < 0)
		{
			pos = 0;
		}
		if (str.length() <= (pos + len))
		{
			return str.substring(pos);
		}
		return str.substring(pos, pos + len);
	}

	// SubStringAfter/SubStringBefore
	//-----------------------------------------------------------------------
	/**
	 * <p>Gets the substring before the first occurrence of a separator.
	 * The separator is not returned.</p>
	 *
	 * <p>A <code>null</code> string input will return <code>null</code>.
	 * An empty ("") string input will return the empty string.
	 * A <code>null</code> separator will return the input string.</p>
	 *
	 * <p>If nothing is found, the string input is returned.</p>
	 *
	 * <pre>
	 * StringUtil.substringBefore(null, *)      = null
	 * StringUtil.substringBefore("", *)        = ""
	 * StringUtil.substringBefore("abc", "a")   = ""
	 * StringUtil.substringBefore("abcba", "b") = "a"
	 * StringUtil.substringBefore("abc", "c")   = "ab"
	 * StringUtil.substringBefore("abc", "d")   = "abc"
	 * StringUtil.substringBefore("abc", "")    = ""
	 * StringUtil.substringBefore("abc", null)  = "abc"
	 * </pre>
	 *
	 * @param str  the String to get a substring from, may be null
	 * @param separator  the String to search for, may be null
	 * @return the substring before the first occurrence of the separator,
	 *  <code>null</code> if null String input
	 * @since 2.0
	 */
	public static String substringBefore(String str, String separator)
	{
		if (isEmpty(str) || separator == null)
		{
			return str;
		}
		if (separator.length() == 0)
		{
			return EMPTY;
		}
		int pos = str.indexOf(separator);
		if (pos == -1)
		{
			return str;
		}
		return str.substring(0, pos);
	}

	/**
	 * <p>Gets the substring after the first occurrence of a separator.
	 * The separator is not returned.</p>
	 *
	 * <p>A <code>null</code> string input will return <code>null</code>.
	 * An empty ("") string input will return the empty string.
	 * A <code>null</code> separator will return the empty string if the
	 * input string is not <code>null</code>.</p>
	 *
	 * <p>If nothing is found, the empty string is returned.</p>
	 *
	 * <pre>
	 * StringUtil.substringAfter(null, *)      = null
	 * StringUtil.substringAfter("", *)        = ""
	 * StringUtil.substringAfter(*, null)      = ""
	 * StringUtil.substringAfter("abc", "a")   = "bc"
	 * StringUtil.substringAfter("abcba", "b") = "cba"
	 * StringUtil.substringAfter("abc", "c")   = ""
	 * StringUtil.substringAfter("abc", "d")   = ""
	 * StringUtil.substringAfter("abc", "")    = "abc"
	 * </pre>
	 *
	 * @param str  the String to get a substring from, may be null
	 * @param separator  the String to search for, may be null
	 * @return the substring after the first occurrence of the separator,
	 *  <code>null</code> if null String input
	 * @since 2.0
	 */
	public static String substringAfter(String str, String separator)
	{
		if (isEmpty(str))
		{
			return str;
		}
		if (separator == null)
		{
			return EMPTY;
		}
		int pos = str.indexOf(separator);
		if (pos == -1)
		{
			return EMPTY;
		}
		return str.substring(pos + separator.length());
	}

	/**
	 * <p>Gets the substring before the last occurrence of a separator.
	 * The separator is not returned.</p>
	 *
	 * <p>A <code>null</code> string input will return <code>null</code>.
	 * An empty ("") string input will return the empty string.
	 * An empty or <code>null</code> separator will return the input string.</p>
	 *
	 * <p>If nothing is found, the string input is returned.</p>
	 *
	 * <pre>
	 * StringUtil.substringBeforeLast(null, *)      = null
	 * StringUtil.substringBeforeLast("", *)        = ""
	 * StringUtil.substringBeforeLast("abcba", "b") = "abc"
	 * StringUtil.substringBeforeLast("abc", "c")   = "ab"
	 * StringUtil.substringBeforeLast("a", "a")     = ""
	 * StringUtil.substringBeforeLast("a", "z")     = "a"
	 * StringUtil.substringBeforeLast("a", null)    = "a"
	 * StringUtil.substringBeforeLast("a", "")      = "a"
	 * </pre>
	 *
	 * @param str  the String to get a substring from, may be null
	 * @param separator  the String to search for, may be null
	 * @return the substring before the last occurrence of the separator,
	 *  <code>null</code> if null String input
	 * @since 2.0
	 */
	public static String substringBeforeLast(String str, String separator)
	{
		if (isEmpty(str) || isEmpty(separator))
		{
			return str;
		}
		int pos = str.lastIndexOf(separator);
		if (pos == -1)
		{
			return str;
		}
		return str.substring(0, pos);
	}

	/**
	 * <p>Gets the substring after the last occurrence of a separator.
	 * The separator is not returned.</p>
	 *
	 * <p>A <code>null</code> string input will return <code>null</code>.
	 * An empty ("") string input will return the empty string.
	 * An empty or <code>null</code> separator will return the empty string if
	 * the input string is not <code>null</code>.</p>
	 *
	 * <p>If nothing is found, the empty string is returned.</p>
	 *
	 * <pre>
	 * StringUtil.substringAfterLast(null, *)      = null
	 * StringUtil.substringAfterLast("", *)        = ""
	 * StringUtil.substringAfterLast(*, "")        = ""
	 * StringUtil.substringAfterLast(*, null)      = ""
	 * StringUtil.substringAfterLast("abc", "a")   = "bc"
	 * StringUtil.substringAfterLast("abcba", "b") = "a"
	 * StringUtil.substringAfterLast("abc", "c")   = ""
	 * StringUtil.substringAfterLast("a", "a")     = ""
	 * StringUtil.substringAfterLast("a", "z")     = ""
	 * </pre>
	 *
	 * @param str  the String to get a substring from, may be null
	 * @param separator  the String to search for, may be null
	 * @return the substring after the last occurrence of the separator,
	 *  <code>null</code> if null String input
	 * @since 2.0
	 */
	public static String substringAfterLast(String str, String separator)
	{
		if (isEmpty(str))
		{
			return str;
		}
		if (isEmpty(separator))
		{
			return EMPTY;
		}
		int pos = str.lastIndexOf(separator);
		if (pos == -1 || pos == (str.length() - separator.length()))
		{
			return EMPTY;
		}
		return str.substring(pos + separator.length());
	}

	// Substring between
	//-----------------------------------------------------------------------
	/**
	 * <p>Gets the String that is nested in between two instances of the
	 * same String.</p>
	 *
	 * <p>A <code>null</code> input String returns <code>null</code>.
	 * A <code>null</code> tag returns <code>null</code>.</p>
	 *
	 * <pre>
	 * StringUtil.substringBetween(null, *)            = null
	 * StringUtil.substringBetween("", "")             = ""
	 * StringUtil.substringBetween("", "tag")          = null
	 * StringUtil.substringBetween("tagabctag", null)  = null
	 * StringUtil.substringBetween("tagabctag", "")    = ""
	 * StringUtil.substringBetween("tagabctag", "tag") = "abc"
	 * </pre>
	 *
	 * @param str  the String containing the substring, may be null
	 * @param tag  the String before and after the substring, may be null
	 * @return the substring, <code>null</code> if no match
	 * @since 2.0
	 */
	public static String substringBetween(String str, String tag)
	{
		return substringBetween(str, tag, tag);
	}

	/**
	 * <p>Gets the String that is nested in between two Strings.
	 * Only the first match is returned.</p>
	 *
	 * <p>A <code>null</code> input String returns <code>null</code>.
	 * A <code>null</code> open/close returns <code>null</code> (no match).
	 * An empty ("") open and close returns an empty string.</p>
	 *
	 * <pre>
	 * StringUtil.substringBetween("wx[b]yz", "[", "]") = "b"
	 * StringUtil.substringBetween(null, *, *)          = null
	 * StringUtil.substringBetween(*, null, *)          = null
	 * StringUtil.substringBetween(*, *, null)          = null
	 * StringUtil.substringBetween("", "", "")          = ""
	 * StringUtil.substringBetween("", "", "]")         = null
	 * StringUtil.substringBetween("", "[", "]")        = null
	 * StringUtil.substringBetween("yabcz", "", "")     = ""
	 * StringUtil.substringBetween("yabcz", "y", "z")   = "abc"
	 * StringUtil.substringBetween("yabczyabcz", "y", "z")   = "abc"
	 * </pre>
	 *
	 * @param str  the String containing the substring, may be null
	 * @param open  the String before the substring, may be null
	 * @param close  the String after the substring, may be null
	 * @return the substring, <code>null</code> if no match
	 * @since 2.0
	 */
	public static String substringBetween(String str, String open, String close)
	{
		if (str == null || open == null || close == null)
		{
			return null;
		}
		int start = str.indexOf(open);
		if (start != -1)
		{
			int end = str.indexOf(close, start + open.length());
			if (end != -1)
			{
				return str.substring(start + open.length(), end);
			}
		}
		return null;
	}

	/**
	 * <p>Searches a String for substrings delimited by a start and end tag,
	 * returning all matching substrings in an array.</p>
	 *
	 * <p>A <code>null</code> input String returns <code>null</code>.
	 * A <code>null</code> open/close returns <code>null</code> (no match).
	 * An empty ("") open/close returns <code>null</code> (no match).</p>
	 *
	 * <pre>
	 * StringUtil.substringsBetween("[a][b][c]", "[", "]") = ["a","b","c"]
	 * StringUtil.substringsBetween(null, *, *)            = null
	 * StringUtil.substringsBetween(*, null, *)            = null
	 * StringUtil.substringsBetween(*, *, null)            = null
	 * StringUtil.substringsBetween("", "[", "]")          = []
	 * </pre>
	 *
	 * @param str  the String containing the substrings, null returns null, empty returns empty
	 * @param open  the String identifying the start of the substring, empty returns null
	 * @param close  the String identifying the end of the substring, empty returns null
	 * @return a String Array of substrings, or <code>null</code> if no match
	 * @since 2.3
	 */
	public static String[] substringsBetween(String str, String open, String close)
	{
		if (str == null || isEmpty(open) || isEmpty(close))
		{
			return null;
		}
		int strLen = str.length();
		if (strLen == 0)
		{
			return EMPTY_STRING_ARRAY;
		}
		int closeLen = close.length();
		int openLen = open.length();
		List list = new ArrayList();
		int pos = 0;
		while (pos < (strLen - closeLen))
		{
			int start = str.indexOf(open, pos);
			if (start < 0)
			{
				break;
			}
			start += openLen;
			int end = str.indexOf(close, start);
			if (end < 0)
			{
				break;
			}
			list.add(str.substring(start, end));
			pos = end + closeLen;
		}
		if (list.isEmpty())
		{
			return null;
		}
		return (String[]) list.toArray(new String[list.size()]);
	}

	// Splitting
	//-----------------------------------------------------------------------

	/**
	 * <p>Splits the provided text into an array, separators specified.
	 * This is an alternative to using StringTokenizer.</p>
	 *
	 * <p>The separator is not included in the returned String array.
	 * Adjacent separators are treated as one separator.
	 * For more control over the split use the StrTokenizer class.</p>
	 *
	 * <p>A <code>null</code> input String returns <code>null</code>.
	 * A <code>null</code> separatorChars splits on whitespace.</p>
	 *
	 * <pre>
	 * StringUtil.split(null, *)         = null
	 * StringUtil.split("", *)           = []
	 * StringUtil.split("abc def", null) = ["abc", "def"]
	 * StringUtil.split("abc def", " ")  = ["abc", "def"]
	 * StringUtil.split("abc  def", " ") = ["abc", "def"]
	 * StringUtil.split("ab:cd:ef", ":") = ["ab", "cd", "ef"]
	 * </pre>
	 *
	 * @param str  the String to parse, may be null
	 * @param separatorChars  the characters used as the delimiters,
	 *  <code>null</code> splits on whitespace
	 * @return an array of parsed Strings, <code>null</code> if null String input
	 */
	public static String[] split(String str, String separatorChars)
	{
		return splitWorker(str, separatorChars, -1, false);
	}

	/**
	 * Performs the logic for the <code>split</code> and
	 * <code>splitPreserveAllTokens</code> methods that return a maximum array
	 * length.
	 *
	 * @param str  the String to parse, may be <code>null</code>
	 * @param separatorChars the separate character
	 * @param max  the maximum number of elements to include in the
	 *  array. A zero or negative value implies no limit.
	 * @param preserveAllTokens if <code>true</code>, adjacent separators are
	 * treated as empty token separators; if <code>false</code>, adjacent
	 * separators are treated as one separator.
	 * @return an array of parsed Strings, <code>null</code> if null String input
	 */
	private static String[] splitWorker(String str, String separatorChars, int max, boolean preserveAllTokens)
	{
		// Performance tuned for 2.0 (JDK1.4)
		// Direct code is quicker than StringTokenizer.
		// Also, StringTokenizer uses isSpace() not isWhitespace()

		if (str == null)
		{
			return null;
		}
		int len = str.length();
		if (len == 0)
		{
			return EMPTY_STRING_ARRAY;
		}
		List list = new ArrayList();
		int sizePlus1 = 1;
		int i = 0, start = 0;
		boolean match = false;
		boolean lastMatch = false;
		if (separatorChars == null)
		{
			// Null separator means use whitespace
			while (i < len)
			{
				if (Character.isWhitespace(str.charAt(i)))
				{
					if (match || preserveAllTokens)
					{
						lastMatch = true;
						if (sizePlus1++ == max)
						{
							i = len;
							lastMatch = false;
						}
						list.add(str.substring(start, i));
						match = false;
					}
					start = ++i;
					continue;
				}
				lastMatch = false;
				match = true;
				i++;
			}
		}
		else if (separatorChars.length() == 1)
		{
			// Optimise 1 character case
			char sep = separatorChars.charAt(0);
			while (i < len)
			{
				if (str.charAt(i) == sep)
				{
					if (match || preserveAllTokens)
					{
						lastMatch = true;
						if (sizePlus1++ == max)
						{
							i = len;
							lastMatch = false;
						}
						list.add(str.substring(start, i));
						match = false;
					}
					start = ++i;
					continue;
				}
				lastMatch = false;
				match = true;
				i++;
			}
		}
		else
		{
			// standard case
			while (i < len)
			{
				if (separatorChars.indexOf(str.charAt(i)) >= 0)
				{
					if (match || preserveAllTokens)
					{
						lastMatch = true;
						if (sizePlus1++ == max)
						{
							i = len;
							lastMatch = false;
						}
						list.add(str.substring(start, i));
						match = false;
					}
					start = ++i;
					continue;
				}
				lastMatch = false;
				match = true;
				i++;
			}
		}
		if (match || (preserveAllTokens && lastMatch))
		{
			list.add(str.substring(start, i));
		}
		return (String[]) list.toArray(new String[list.size()]);
	}

	// Joining
	//-----------------------------------------------------------------------
	/**
	 * <p>Joins the elements of the provided array into a single String
	 * containing the provided list of elements.</p>
	 *
	 * <p>No separator is added to the joined String.
	 * Null objects or empty strings within the array are represented by
	 * empty strings.</p>
	 *
	 * <pre>
	 * StringUtil.join(null)            = null
	 * StringUtil.join([])              = ""
	 * StringUtil.join([null])          = ""
	 * StringUtil.join(["a", "b", "c"]) = "abc"
	 * StringUtil.join([null, "", "a"]) = "a"
	 * </pre>
	 *
	 * @param array  the array of values to join together, may be null
	 * @return the joined String, <code>null</code> if null array input
	 * @since 2.0
	 */
	public static String join(Object[] array)
	{
		return join(array, null);
	}

	/**
	 * <p>Joins the elements of the provided array into a single String
	 * containing the provided list of elements.</p>
	 *
	 * <p>No delimiter is added before or after the list.
	 * A <code>null</code> separator is the same as an empty String ("").
	 * Null objects or empty strings within the array are represented by
	 * empty strings.</p>
	 *
	 * <pre>
	 * StringUtil.join(null, *)                = null
	 * StringUtil.join([], *)                  = ""
	 * StringUtil.join([null], *)              = ""
	 * StringUtil.join(["a", "b", "c"], "--")  = "a--b--c"
	 * StringUtil.join(["a", "b", "c"], null)  = "abc"
	 * StringUtil.join(["a", "b", "c"], "")    = "abc"
	 * StringUtil.join([null, "", "a"], ',')   = ",,a"
	 * </pre>
	 *
	 * @param array  the array of values to join together, may be null
	 * @param separator  the separator character to use, null treated as ""
	 * @return the joined String, <code>null</code> if null array input
	 */
	public static String join(Object[] array, String separator)
	{
		if (array == null)
		{
			return null;
		}
		return join(array, separator, 0, array.length);
	}

	/**
	 * <p>Joins the elements of the provided array into a single String
	 * containing the provided list of elements.</p>
	 *
	 * <p>No delimiter is added before or after the list.
	 * A <code>null</code> separator is the same as an empty String ("").
	 * Null objects or empty strings within the array are represented by
	 * empty strings.</p>
	 *
	 * <pre>
	 * StringUtil.join(null, *)                = null
	 * StringUtil.join([], *)                  = ""
	 * StringUtil.join([null], *)              = ""
	 * StringUtil.join(["a", "b", "c"], "--")  = "a--b--c"
	 * StringUtil.join(["a", "b", "c"], null)  = "abc"
	 * StringUtil.join(["a", "b", "c"], "")    = "abc"
	 * StringUtil.join([null, "", "a"], ',')   = ",,a"
	 * </pre>
	 *
	 * @param array  the array of values to join together, may be null
	 * @param separator  the separator character to use, null treated as ""
	 * @param startIndex the first index to start joining from.  It is
	 * an error to pass in an end index past the end of the array
	 * @param endIndex the index to stop joining from (exclusive). It is
	 * an error to pass in an end index past the end of the array
	 * @return the joined String, <code>null</code> if null array input
	 */
	public static String join(Object[] array, String separator, int startIndex, int endIndex)
	{
		if (array == null)
		{
			return null;
		}
		if (separator == null)
		{
			separator = EMPTY;
		}

		// endIndex - startIndex > 0:   Len = NofStrings *(len(firstString) + len(separator))
		//           (Assuming that all Strings are roughly equally long)
		int bufSize = (endIndex - startIndex);
		if (bufSize <= 0)
		{
			return EMPTY;
		}

		bufSize *= ((array[startIndex] == null ? 16 : array[startIndex].toString().length()) + separator.length());

		StringBuffer buf = new StringBuffer(bufSize);

		for (int i = startIndex; i < endIndex; i++)
		{
			if (i > startIndex)
			{
				buf.append(separator);
			}
			if (array[i] != null)
			{
				buf.append(array[i]);
			}
		}
		return buf.toString();
	}

	/**
	 * <p>Joins the elements of the provided <code>Iterator</code> into
	 * a single String containing the provided elements.</p>
	 *
	 * <p>No delimiter is added before or after the list.
	 * A <code>null</code> separator is the same as an empty String ("").</p>
	 *
	 * <p>See the examples here: {@link #join(Object[],String)}. </p>
	 *
	 * @param iterator  the <code>Iterator</code> of values to join together, may be null
	 * @param separator  the separator character to use, null treated as ""
	 * @return the joined String, <code>null</code> if null iterator input
	 */
	public static String join(Iterator iterator, String separator)
	{

		// handle null, zero and one elements before building a buffer
		if (iterator == null)
		{
			return null;
		}
		if (!iterator.hasNext())
		{
			return EMPTY;
		}
		Object first = iterator.next();
		if (!iterator.hasNext())
		{
			return first == null ? null : first.toString();
		}

		// two or more elements
		StringBuffer buf = new StringBuffer(256); // Java default is 16, probably too small
		if (first != null)
		{
			buf.append(first);
		}

		while (iterator.hasNext())
		{
			if (separator != null)
			{
				buf.append(separator);
			}
			Object obj = iterator.next();
			if (obj != null)
			{
				buf.append(obj);
			}
		}
		return buf.toString();
	}

	/**
	 * <p>Joins the elements of the provided <code>Collection</code> into
	 * a single String containing the provided elements.</p>
	 *
	 * <p>No delimiter is added before or after the list.
	 * A <code>null</code> separator is the same as an empty String ("").</p>
	 *
	 * <p>See the examples here: {@link #join(Object[],String)}. </p>
	 *
	 * @param collection  the <code>Collection</code> of values to join together, may be null
	 * @param separator  the separator character to use, null treated as ""
	 * @return the joined String, <code>null</code> if null iterator input
	 * @since 2.3
	 */
	public static String join(Collection collection, String separator)
	{
		if (collection == null)
		{
			return null;
		}
		return join(collection.iterator(), separator);
	}

	// Replacing
	//-----------------------------------------------------------------------
	/**
	 * <p>Replaces a String with another String inside a larger String, once.</p>
	 *
	 * <p>A <code>null</code> reference passed to this method is a no-op.</p>
	 *
	 * <pre>
	 * StringUtil.replaceOnce(null, *, *)        = null
	 * StringUtil.replaceOnce("", *, *)          = ""
	 * StringUtil.replaceOnce("any", null, *)    = "any"
	 * StringUtil.replaceOnce("any", *, null)    = "any"
	 * StringUtil.replaceOnce("any", "", *)      = "any"
	 * StringUtil.replaceOnce("aba", "a", null)  = "aba"
	 * StringUtil.replaceOnce("aba", "a", "")    = "ba"
	 * StringUtil.replaceOnce("aba", "a", "z")   = "zba"
	 * </pre>
	 *
	 * @see #replace(String text, String searchString, String replacement, int max)
	 * @param text  text to search and replace in, may be null
	 * @param searchString  the String to search for, may be null
	 * @param replacement  the String to replace with, may be null
	 * @return the text with any replacements processed,
	 *  <code>null</code> if null String input
	 */
	public static String replaceOnce(String text, String searchString, String replacement)
	{
		return replace(text, searchString, replacement, 1);
	}

	/**
	 * <p>Replaces a String with another String inside a larger String,
	 * for the first <code>max</code> values of the search String.</p>
	 *
	 * <p>A <code>null</code> reference passed to this method is a no-op.</p>
	 *
	 * <pre>
	 * StringUtil.replace(null, *, *, *)         = null
	 * StringUtil.replace("", *, *, *)           = ""
	 * StringUtil.replace("any", null, *, *)     = "any"
	 * StringUtil.replace("any", *, null, *)     = "any"
	 * StringUtil.replace("any", "", *, *)       = "any"
	 * StringUtil.replace("any", *, *, 0)        = "any"
	 * StringUtil.replace("abaa", "a", null, -1) = "abaa"
	 * StringUtil.replace("abaa", "a", "", -1)   = "b"
	 * StringUtil.replace("abaa", "a", "z", 0)   = "abaa"
	 * StringUtil.replace("abaa", "a", "z", 1)   = "zbaa"
	 * StringUtil.replace("abaa", "a", "z", 2)   = "zbza"
	 * StringUtil.replace("abaa", "a", "z", -1)  = "zbzz"
	 * </pre>
	 *
	 * @param text  text to search and replace in, may be null
	 * @param searchString  the String to search for, may be null
	 * @param replacement  the String to replace it with, may be null
	 * @param max  maximum number of values to replace, or <code>-1</code> if no maximum
	 * @return the text with any replacements processed,
	 *  <code>null</code> if null String input
	 */
	public static String replace(String text, String searchString, String replacement, int max)
	{
		if (isEmpty(text) || isEmpty(searchString) || replacement == null || max == 0)
		{
			return text;
		}
		int start = 0;
		int end = text.indexOf(searchString, start);
		if (end == -1)
		{
			return text;
		}
		int replLength = searchString.length();
		int increase = replacement.length() - replLength;
		increase = (increase < 0 ? 0 : increase);
		increase *= (max < 0 ? 16 : (max > 64 ? 64 : max));
		StringBuffer buf = new StringBuffer(text.length() + increase);
		while (end != -1)
		{
			buf.append(text.substring(start, end)).append(replacement);
			start = end + replLength;
			if (--max == 0)
			{
				break;
			}
			end = text.indexOf(searchString, start);
		}
		buf.append(text.substring(start));
		return buf.toString();
	}

	// Padding
	//-----------------------------------------------------------------------
	/**
	 * <p>Repeat a String <code>repeat</code> times to form a
	 * new String.</p>
	 *
	 * <pre>
	 * StringUtil.repeat(null, 2) = null
	 * StringUtil.repeat("", 0)   = ""
	 * StringUtil.repeat("", 2)   = ""
	 * StringUtil.repeat("a", 3)  = "aaa"
	 * StringUtil.repeat("ab", 2) = "abab"
	 * StringUtil.repeat("a", -2) = ""
	 * </pre>
	 *
	 * @param str  the String to repeat, may be null
	 * @param repeat  number of times to repeat str, negative treated as zero
	 * @return a new String consisting of the original String repeated,
	 *  <code>null</code> if null String input
	 * @since 2.5
	 */
	public static String repeat(String str, int repeat)
	{
		// Performance tuned for 2.0 (JDK1.4)

		if (str == null)
		{
			return null;
		}
		if (repeat <= 0)
		{
			return EMPTY;
		}
		int inputLength = str.length();
		if (repeat == 1 || inputLength == 0)
		{
			return str;
		}
		if (inputLength == 1 && repeat <= PAD_LIMIT)
		{
			return padding(repeat, str.charAt(0));
		}

		int outputLength = inputLength * repeat;
		switch (inputLength)
		{
			case 1:
				char ch = str.charAt(0);
				char[] output1 = new char[outputLength];
				for (int i = repeat - 1; i >= 0; i--)
				{
					output1[i] = ch;
				}
				return new String(output1);
			case 2:
				char ch0 = str.charAt(0);
				char ch1 = str.charAt(1);
				char[] output2 = new char[outputLength];
				for (int i = repeat * 2 - 2; i >= 0; i--, i--)
				{
					output2[i] = ch0;
					output2[i + 1] = ch1;
				}
				return new String(output2);
			default:
				StringBuffer buf = new StringBuffer(outputLength);
				for (int i = 0; i < repeat; i++)
				{
					buf.append(str);
				}
				return buf.toString();
		}
	}

	/**
	 * <p>Returns padding using the specified delimiter repeated
	 * to a given length.</p>
	 *
	 * <pre>
	 * StringUtil.padding(0, 'e')  = ""
	 * StringUtil.padding(3, 'e')  = "eee"
	 * StringUtil.padding(-2, 'e') = IndexOutOfBoundsException
	 * </pre>
	 *
	 * <p>Note: this method doesn't not support padding with
	 * <a href="http://www.unicode.org/glossary/#supplementary_character">Unicode Supplementary Characters</a>
	 * as they require a pair of <code>char</code>s to be represented.
	 * If you are needing to support full I18N of your applications
	 * consider using {@link #repeat(String, int)} instead.
	 * </p>
	 *
	 * @param repeat  number of times to repeat delim
	 * @param padChar  character to repeat
	 * @return String with repeated character
	 * @throws IndexOutOfBoundsException if <code>repeat &lt; 0</code>
	 * @see #repeat(String, int)
	 */
	private static String padding(int repeat, char padChar) throws IndexOutOfBoundsException
	{
		if (repeat < 0)
		{
			throw new IndexOutOfBoundsException("Cannot pad a negative amount: " + repeat);
		}
		final char[] buf = new char[repeat];
		for (int i = 0; i < buf.length; i++)
		{
			buf[i] = padChar;
		}
		return new String(buf);
	}

	/**
	 * <p>Right pad a String with spaces (' ').</p>
	 *
	 * <p>The String is padded to the size of <code>size</code>.</p>
	 *
	 * <pre>
	 * StringUtil.rightPad(null, *)   = null
	 * StringUtil.rightPad("", 3)     = "   "
	 * StringUtil.rightPad("bat", 3)  = "bat"
	 * StringUtil.rightPad("bat", 5)  = "bat  "
	 * StringUtil.rightPad("bat", 1)  = "bat"
	 * StringUtil.rightPad("bat", -1) = "bat"
	 * </pre>
	 *
	 * @param str  the String to pad out, may be null
	 * @param size  the size to pad to
	 * @return right padded String or original String if no padding is necessary,
	 *  <code>null</code> if null String input
	 */
	public static String rightPad(String str, int size)
	{
		return rightPad(str, size, ' ');
	}

	/**
	 * <p>Right pad a String with a specified character.</p>
	 *
	 * <p>The String is padded to the size of <code>size</code>.</p>
	 *
	 * <pre>
	 * StringUtil.rightPad(null, *, *)     = null
	 * StringUtil.rightPad("", 3, 'z')     = "zzz"
	 * StringUtil.rightPad("bat", 3, 'z')  = "bat"
	 * StringUtil.rightPad("bat", 5, 'z')  = "batzz"
	 * StringUtil.rightPad("bat", 1, 'z')  = "bat"
	 * StringUtil.rightPad("bat", -1, 'z') = "bat"
	 * </pre>
	 *
	 * @param str  the String to pad out, may be null
	 * @param size  the size to pad to
	 * @param padChar  the character to pad with
	 * @return right padded String or original String if no padding is necessary,
	 *  <code>null</code> if null String input
	 * @since 2.0
	 */
	public static String rightPad(String str, int size, char padChar)
	{
		if (str == null)
		{
			return null;
		}
		int pads = size - str.length();
		if (pads <= 0)
		{
			return str; // returns original String when possible
		}
		if (pads > PAD_LIMIT)
		{
			return rightPad(str, size, String.valueOf(padChar));
		}
		return str.concat(padding(pads, padChar));
	}

	/**
	 * <p>Right pad a String with a specified String.</p>
	 *
	 * <p>The String is padded to the size of <code>size</code>.</p>
	 *
	 * <pre>
	 * StringUtil.rightPad(null, *, *)      = null
	 * StringUtil.rightPad("", 3, "z")      = "zzz"
	 * StringUtil.rightPad("bat", 3, "yz")  = "bat"
	 * StringUtil.rightPad("bat", 5, "yz")  = "batyz"
	 * StringUtil.rightPad("bat", 8, "yz")  = "batyzyzy"
	 * StringUtil.rightPad("bat", 1, "yz")  = "bat"
	 * StringUtil.rightPad("bat", -1, "yz") = "bat"
	 * StringUtil.rightPad("bat", 5, null)  = "bat  "
	 * StringUtil.rightPad("bat", 5, "")    = "bat  "
	 * </pre>
	 *
	 * @param str  the String to pad out, may be null
	 * @param size  the size to pad to
	 * @param padStr  the String to pad with, null or empty treated as single space
	 * @return right padded String or original String if no padding is necessary,
	 *  <code>null</code> if null String input
	 */
	public static String rightPad(String str, int size, String padStr)
	{
		if (str == null)
		{
			return null;
		}
		if (isEmpty(padStr))
		{
			padStr = " ";
		}
		int padLen = padStr.length();
		int strLen = str.length();
		int pads = size - strLen;
		if (pads <= 0)
		{
			return str; // returns original String when possible
		}
		if (padLen == 1 && pads <= PAD_LIMIT)
		{
			return rightPad(str, size, padStr.charAt(0));
		}

		if (pads == padLen)
		{
			return str.concat(padStr);
		}
		else if (pads < padLen)
		{
			return str.concat(padStr.substring(0, pads));
		}
		else
		{
			char[] padding = new char[pads];
			char[] padChars = padStr.toCharArray();
			for (int i = 0; i < pads; i++)
			{
				padding[i] = padChars[i % padLen];
			}
			return str.concat(new String(padding));
		}
	}

	/**
	 * <p>Left pad a String with spaces (' ').</p>
	 *
	 * <p>The String is padded to the size of <code>size</code>.</p>
	 *
	 * <pre>
	 * StringUtil.leftPad(null, *)   = null
	 * StringUtil.leftPad("", 3)     = "   "
	 * StringUtil.leftPad("bat", 3)  = "bat"
	 * StringUtil.leftPad("bat", 5)  = "  bat"
	 * StringUtil.leftPad("bat", 1)  = "bat"
	 * StringUtil.leftPad("bat", -1) = "bat"
	 * </pre>
	 *
	 * @param str  the String to pad out, may be null
	 * @param size  the size to pad to
	 * @return left padded String or original String if no padding is necessary,
	 *  <code>null</code> if null String input
	 */
	public static String leftPad(String str, int size)
	{
		return leftPad(str, size, ' ');
	}

	/**
	 * <p>Left pad a String with a specified character.</p>
	 *
	 * <p>Pad to a size of <code>size</code>.</p>
	 *
	 * <pre>
	 * StringUtil.leftPad(null, *, *)     = null
	 * StringUtil.leftPad("", 3, 'z')     = "zzz"
	 * StringUtil.leftPad("bat", 3, 'z')  = "bat"
	 * StringUtil.leftPad("bat", 5, 'z')  = "zzbat"
	 * StringUtil.leftPad("bat", 1, 'z')  = "bat"
	 * StringUtil.leftPad("bat", -1, 'z') = "bat"
	 * </pre>
	 *
	 * @param str  the String to pad out, may be null
	 * @param size  the size to pad to
	 * @param padChar  the character to pad with
	 * @return left padded String or original String if no padding is necessary,
	 *  <code>null</code> if null String input
	 * @since 2.0
	 */
	public static String leftPad(String str, int size, char padChar)
	{
		if (str == null)
		{
			return null;
		}
		int pads = size - str.length();
		if (pads <= 0)
		{
			return str; // returns original String when possible
		}
		if (pads > PAD_LIMIT)
		{
			return leftPad(str, size, String.valueOf(padChar));
		}
		return padding(pads, padChar).concat(str);
	}

	/**
	 * <p>Left pad a String with a specified String.</p>
	 *
	 * <p>Pad to a size of <code>size</code>.</p>
	 *
	 * <pre>
	 * StringUtil.leftPad(null, *, *)      = null
	 * StringUtil.leftPad("", 3, "z")      = "zzz"
	 * StringUtil.leftPad("bat", 3, "yz")  = "bat"
	 * StringUtil.leftPad("bat", 5, "yz")  = "yzbat"
	 * StringUtil.leftPad("bat", 8, "yz")  = "yzyzybat"
	 * StringUtil.leftPad("bat", 1, "yz")  = "bat"
	 * StringUtil.leftPad("bat", -1, "yz") = "bat"
	 * StringUtil.leftPad("bat", 5, null)  = "  bat"
	 * StringUtil.leftPad("bat", 5, "")    = "  bat"
	 * </pre>
	 *
	 * @param str  the String to pad out, may be null
	 * @param size  the size to pad to
	 * @param padStr  the String to pad with, null or empty treated as single space
	 * @return left padded String or original String if no padding is necessary,
	 *  <code>null</code> if null String input
	 */
	public static String leftPad(String str, int size, String padStr)
	{
		if (str == null)
		{
			return null;
		}
		if (isEmpty(padStr))
		{
			padStr = " ";
		}
		int padLen = padStr.length();
		int strLen = str.length();
		int pads = size - strLen;
		if (pads <= 0)
		{
			return str; // returns original String when possible
		}
		if (padLen == 1 && pads <= PAD_LIMIT)
		{
			return leftPad(str, size, padStr.charAt(0));
		}

		if (pads == padLen)
		{
			return padStr.concat(str);
		}
		else if (pads < padLen)
		{
			return padStr.substring(0, pads).concat(str);
		}
		else
		{
			char[] padding = new char[pads];
			char[] padChars = padStr.toCharArray();
			for (int i = 0; i < pads; i++)
			{
				padding[i] = padChars[i % padLen];
			}
			return new String(padding).concat(str);
		}
	}

	/**
	 * Gets a String's length or <code>0</code> if the String is <code>null</code>.
	 *
	 * @param str
	 *            a String or <code>null</code>
	 * @return String length or <code>0</code> if the String is <code>null</code>.
	 * @since 2.4
	 */
	public static int length(String str)
	{
		return str == null ? 0 : str.length();
	}

	// Case conversion
	//-----------------------------------------------------------------------
	/**
	 * <p>Converts a String to upper case as per {@link String#toUpperCase()}.</p>
	 *
	 * <p>A <code>null</code> input String returns <code>null</code>.</p>
	 *
	 * <pre>
	 * StringUtil.upperCase(null)  = null
	 * StringUtil.upperCase("")    = ""
	 * StringUtil.upperCase("aBc") = "ABC"
	 * </pre>
	 *
	 * <p><strong>Note:</strong> As described in the documentation for {@link String#toUpperCase()},
	 * the result of this method is affected by the current locale.
	 *
	 * @param str  the String to upper case, may be null
	 * @return the upper cased String, <code>null</code> if null String input
	 */
	public static String upperCase(String str)
	{
		if (str == null)
		{
			return null;
		}
		return str.toUpperCase();
	}

	/**
	 * <p>Converts a String to lower case as per {@link String#toLowerCase()}.</p>
	 *
	 * <p>A <code>null</code> input String returns <code>null</code>.</p>
	 *
	 * <pre>
	 * StringUtil.lowerCase(null)  = null
	 * StringUtil.lowerCase("")    = ""
	 * StringUtil.lowerCase("aBc") = "abc"
	 * </pre>
	 *
	 * <p><strong>Note:</strong> As described in the documentation for {@link String#toLowerCase()},
	 * the result of this method is affected by the current locale.
	 *
	 * @param str  the String to lower case, may be null
	 * @return the lower cased String, <code>null</code> if null String input
	 */
	public static String lowerCase(String str)
	{
		if (str == null)
		{
			return null;
		}
		return str.toLowerCase();
	}

	/**
	 * <p>Capitalizes a String changing the first letter to title case as
	 * per {@link Character#toTitleCase(char)}. No other letters are changed.</p>
	 *
	 * <pre>
	 * StringUtil.capitalize(null)  = null
	 * StringUtil.capitalize("")    = ""
	 * StringUtil.capitalize("cat") = "Cat"
	 * StringUtil.capitalize("cAt") = "CAt"
	 * </pre>
	 *
	 * @param str  the String to capitalize, may be null
	 * @return the capitalized String, <code>null</code> if null String input
	 * @since 2.0
	 */
	public static String capitalize(String str)
	{
		int strLen;
		if (str == null || (strLen = str.length()) == 0)
		{
			return str;
		}
		return new StringBuffer(strLen).append(Character.toTitleCase(str.charAt(0))).append(str.substring(1))
				.toString();
	}

	// Defaults
	//-----------------------------------------------------------------------

	/**
	 * <p>Returns either the passed in String, or if the String is
	 * empty or <code>null</code>, the value of <code>defaultStr</code>.</p>
	 *
	 * <pre>
	 * StringUtil.defaultIfEmpty(null, "NULL")  = "NULL"
	 * StringUtil.defaultIfEmpty("", "NULL")    = "NULL"
	 * StringUtil.defaultIfEmpty("bat", "NULL") = "bat"
	 * StringUtil.defaultIfEmpty("", null)      = null
	 * </pre>
	 *
	 * @param str  the String to check, may be null
	 * @param defaultStr  the default String to return
	 *  if the input is empty ("") or <code>null</code>, may be null
	 * @return the passed in String, or the default
	 */
	public static String defaultIfEmpty(String str, String defaultStr)
	{
		return StringUtil.isEmpty(str) ? defaultStr : str;
	}

	// Abbreviating
	//-----------------------------------------------------------------------
	/**
	 * <p>Abbreviates a String using ellipses. This will turn
	 * "Now is the time for all good men" into "Now is the time for..."</p>
	 *
	 * <p>Specifically:
	 * <ul>
	 *   <li>If <code>str</code> is less than <code>maxWidth</code> characters
	 *       long, return it.</li>
	 *   <li>Else abbreviate it to <code>(substring(str, 0, max-3) + "...")</code>.</li>
	 *   <li>If <code>maxWidth</code> is less than <code>4</code>, throw an
	 *       <code>IllegalArgumentException</code>.</li>
	 *   <li>In no case will it return a String of length greater than
	 *       <code>maxWidth</code>.</li>
	 * </ul>
	 * </p>
	 *
	 * <pre>
	 * StringUtil.abbreviate(null, *)      = null
	 * StringUtil.abbreviate("", 4)        = ""
	 * StringUtil.abbreviate("abcdefg", 6) = "abc..."
	 * StringUtil.abbreviate("abcdefg", 7) = "abcdefg"
	 * StringUtil.abbreviate("abcdefg", 8) = "abcdefg"
	 * StringUtil.abbreviate("abcdefg", 4) = "a..."
	 * StringUtil.abbreviate("abcdefg", 3) = IllegalArgumentException
	 * </pre>
	 *
	 * @param str  the String to check, may be null
	 * @param maxWidth  maximum length of result String, must be at least 4
	 * @return abbreviated String, <code>null</code> if null String input
	 * @throws IllegalArgumentException if the width is too small
	 * @since 2.0
	 */
	public static String abbreviate(String str, int maxWidth)
	{
		return abbreviate(str, 0, maxWidth);
	}

	/**
	 * <p>Abbreviates a String using ellipses. This will turn
	 * "Now is the time for all good men" into "...is the time for..."</p>
	 *
	 * <p>Works like <code>abbreviate(String, int)</code>, but allows you to specify
	 * a "left edge" offset.  Note that this left edge is not necessarily going to
	 * be the leftmost character in the result, or the first character following the
	 * ellipses, but it will appear somewhere in the result.
	 *
	 * <p>In no case will it return a String of length greater than
	 * <code>maxWidth</code>.</p>
	 *
	 * <pre>
	 * StringUtil.abbreviate(null, *, *)                = null
	 * StringUtil.abbreviate("", 0, 4)                  = ""
	 * StringUtil.abbreviate("abcdefghijklmno", -1, 10) = "abcdefg..."
	 * StringUtil.abbreviate("abcdefghijklmno", 0, 10)  = "abcdefg..."
	 * StringUtil.abbreviate("abcdefghijklmno", 1, 10)  = "abcdefg..."
	 * StringUtil.abbreviate("abcdefghijklmno", 4, 10)  = "abcdefg..."
	 * StringUtil.abbreviate("abcdefghijklmno", 5, 10)  = "...fghi..."
	 * StringUtil.abbreviate("abcdefghijklmno", 6, 10)  = "...ghij..."
	 * StringUtil.abbreviate("abcdefghijklmno", 8, 10)  = "...ijklmno"
	 * StringUtil.abbreviate("abcdefghijklmno", 10, 10) = "...ijklmno"
	 * StringUtil.abbreviate("abcdefghijklmno", 12, 10) = "...ijklmno"
	 * StringUtil.abbreviate("abcdefghij", 0, 3)        = IllegalArgumentException
	 * StringUtil.abbreviate("abcdefghij", 5, 6)        = IllegalArgumentException
	 * </pre>
	 *
	 * @param str  the String to check, may be null
	 * @param offset  left edge of source String
	 * @param maxWidth  maximum length of result String, must be at least 4
	 * @return abbreviated String, <code>null</code> if null String input
	 * @throws IllegalArgumentException if the width is too small
	 * @since 2.0
	 */
	public static String abbreviate(String str, int offset, int maxWidth)
	{
		if (str == null)
		{
			return null;
		}
		if (maxWidth < 4)
		{
			throw new IllegalArgumentException("Minimum abbreviation width is 4");
		}
		if (str.length() <= maxWidth)
		{
			return str;
		}
		if (offset > str.length())
		{
			offset = str.length();
		}
		if ((str.length() - offset) < (maxWidth - 3))
		{
			offset = str.length() - (maxWidth - 3);
		}
		if (offset <= 4)
		{
			return str.substring(0, maxWidth - 3) + "...";
		}
		if (maxWidth < 7)
		{
			throw new IllegalArgumentException("Minimum abbreviation width with offset is 7");
		}
		if ((offset + (maxWidth - 3)) < str.length())
		{
			return "..." + abbreviate(str.substring(offset), maxWidth - 3);
		}
		return "..." + str.substring(str.length() - (maxWidth - 3));
	}

	// startsWith
	//-----------------------------------------------------------------------

	/**
	 * <p>Check if a String starts with a specified prefix.</p>
	 *
	 * <p><code>null</code>s are handled without exceptions. Two <code>null</code>
	 * references are considered to be equal. The comparison is case sensitive.</p>
	 *
	 * <pre>
	 * StringUtil.startsWith(null, null)      = true
	 * StringUtil.startsWith(null, "abc")     = false
	 * StringUtil.startsWith("abcdef", null)  = false
	 * StringUtil.startsWith("abcdef", "abc") = true
	 * StringUtil.startsWith("ABCDEF", "abc") = false
	 * </pre>
	 *
	 * @see String#startsWith(String)
	 * @param str  the String to check, may be null
	 * @param prefix the prefix to find, may be null
	 * @return <code>true</code> if the String starts with the prefix, case sensitive, or
	 *  both <code>null</code>
	 * @since 2.4
	 */
	public static boolean startsWith(String str, String prefix)
	{
		return startsWith(str, prefix, false);
	}

	/**
	 * <p>Case insensitive check if a String starts with a specified prefix.</p>
	 *
	 * <p><code>null</code>s are handled without exceptions. Two <code>null</code>
	 * references are considered to be equal. The comparison is case insensitive.</p>
	 *
	 * <pre>
	 * StringUtil.startsWithIgnoreCase(null, null)      = true
	 * StringUtil.startsWithIgnoreCase(null, "abc")     = false
	 * StringUtil.startsWithIgnoreCase("abcdef", null)  = false
	 * StringUtil.startsWithIgnoreCase("abcdef", "abc") = true
	 * StringUtil.startsWithIgnoreCase("ABCDEF", "abc") = true
	 * </pre>
	 *
	 * @see String#startsWith(String)
	 * @param str  the String to check, may be null
	 * @param prefix the prefix to find, may be null
	 * @return <code>true</code> if the String starts with the prefix, case insensitive, or
	 *  both <code>null</code>
	 * @since 2.4
	 */
	public static boolean startsWithIgnoreCase(String str, String prefix)
	{
		return startsWith(str, prefix, true);
	}

	/**
	 * <p>Check if a String starts with a specified prefix (optionally case insensitive).</p>
	 *
	 * @see String#startsWith(String)
	 * @param str  the String to check, may be null
	 * @param prefix the prefix to find, may be null
	 * @param ignoreCase inidicates whether the compare should ignore case
	 *  (case insensitive) or not.
	 * @return <code>true</code> if the String starts with the prefix or
	 *  both <code>null</code>
	 */
	private static boolean startsWith(String str, String prefix, boolean ignoreCase)
	{
		if (str == null || prefix == null)
		{
			return (str == null && prefix == null);
		}
		if (prefix.length() > str.length())
		{
			return false;
		}
		return str.regionMatches(ignoreCase, 0, prefix, 0, prefix.length());
	}

	// endsWith
	//-----------------------------------------------------------------------

	/**
	 * <p>Check if a String ends with a specified suffix.</p>
	 *
	 * <p><code>null</code>s are handled without exceptions. Two <code>null</code>
	 * references are considered to be equal. The comparison is case sensitive.</p>
	 *
	 * <pre>
	 * StringUtil.endsWith(null, null)      = true
	 * StringUtil.endsWith(null, "def")     = false
	 * StringUtil.endsWith("abcdef", null)  = false
	 * StringUtil.endsWith("abcdef", "def") = true
	 * StringUtil.endsWith("ABCDEF", "def") = false
	 * StringUtil.endsWith("ABCDEF", "cde") = false
	 * </pre>
	 *
	 * @see String#endsWith(String)
	 * @param str  the String to check, may be null
	 * @param suffix the suffix to find, may be null
	 * @return <code>true</code> if the String ends with the suffix, case sensitive, or
	 *  both <code>null</code>
	 * @since 2.4
	 */
	public static boolean endsWith(String str, String suffix)
	{
		return endsWith(str, suffix, false);
	}

	/**
	 * <p>Case insensitive check if a String ends with a specified suffix.</p>
	 *
	 * <p><code>null</code>s are handled without exceptions. Two <code>null</code>
	 * references are considered to be equal. The comparison is case insensitive.</p>
	 *
	 * <pre>
	 * StringUtil.endsWithIgnoreCase(null, null)      = true
	 * StringUtil.endsWithIgnoreCase(null, "def")     = false
	 * StringUtil.endsWithIgnoreCase("abcdef", null)  = false
	 * StringUtil.endsWithIgnoreCase("abcdef", "def") = true
	 * StringUtil.endsWithIgnoreCase("ABCDEF", "def") = true
	 * StringUtil.endsWithIgnoreCase("ABCDEF", "cde") = false
	 * </pre>
	 *
	 * @see String#endsWith(String)
	 * @param str  the String to check, may be null
	 * @param suffix the suffix to find, may be null
	 * @return <code>true</code> if the String ends with the suffix, case insensitive, or
	 *  both <code>null</code>
	 * @since 2.4
	 */
	public static boolean endsWithIgnoreCase(String str, String suffix)
	{
		return endsWith(str, suffix, true);
	}

	/**
	 * <p>Check if a String ends with a specified suffix (optionally case insensitive).</p>
	 *
	 * @see String#endsWith(String)
	 * @param str  the String to check, may be null
	 * @param suffix the suffix to find, may be null
	 * @param ignoreCase inidicates whether the compare should ignore case
	 *  (case insensitive) or not.
	 * @return <code>true</code> if the String starts with the prefix or
	 *  both <code>null</code>
	 */
	private static boolean endsWith(String str, String suffix, boolean ignoreCase)
	{
		if (str == null || suffix == null)
		{
			return (str == null && suffix == null);
		}
		if (suffix.length() > str.length())
		{
			return false;
		}
		int strOffset = str.length() - suffix.length();
		return str.regionMatches(ignoreCase, strOffset, suffix, 0, suffix.length());
	}

	// Reversing
	//-----------------------------------------------------------------------
	/**
	 * <p>Reverses a String as per {@link StrBuilder#reverse()}.</p>
	 *
	 * <p>A <code>null</code> String returns <code>null</code>.</p>
	 *
	 * <pre>
	 * StringUtils.reverse(null)  = null
	 * StringUtils.reverse("")    = ""
	 * StringUtils.reverse("bat") = "tab"
	 * </pre>
	 *
	 * @param str  the String to reverse, may be null
	 * @return the reversed String, <code>null</code> if null String input
	 */
	public static String reverse(String str)
	{
		if (str == null)
		{
			return null;
		}
		return new StrBuilder(str).reverse().toString();
	}

	public static String getValueFromInputStream(InputStream is)
	{
		return getReturnValueFromInputStream(is, null);
	}

	public static String getReturnValueFromInputStream(InputStream is, String charSet)
	{
		StringBuilder stringBuilder = new StringBuilder();

		try (BufferedReader bufferedReader = StringUtil.isBlank(charSet) ? new BufferedReader(new InputStreamReader(is))
				: new BufferedReader(new InputStreamReader(is, charSet)))
		{
			char[] temp = new char[1024];
			int charCount = 0;

			while ((charCount = bufferedReader.read(temp)) != -1)
			{
				stringBuilder.append(new String(temp, 0, charCount));
			}

			return stringBuilder.toString();
		}
		catch (Exception e)
		{
			return StringUtil.EMPTY;
		}
	}

	/**
	 * <p>Checks if the String contains only unicode digits.
	 * A decimal point is not a unicode digit and returns false.</p>
	 *
	 * <p><code>null</code> will return <code>false</code>.
	 * An empty String (length()=0) will return <code>true</code>.</p>
	 *
	 * <pre>
	 * StringUtils.isNumeric(null)   = false
	 * StringUtils.isNumeric("")     = true
	 * StringUtils.isNumeric("  ")   = false
	 * StringUtils.isNumeric("123")  = true
	 * StringUtils.isNumeric("12 3") = false
	 * StringUtils.isNumeric("ab2c") = false
	 * StringUtils.isNumeric("12-3") = false
	 * StringUtils.isNumeric("12.3") = false
	 * </pre>
	 *
	 * @param str  the String to check, may be null
	 * @return <code>true</code> if only contains digits, and is non-null
	 */
	public static boolean isNumeric(String str)
	{
		if (str == null)
		{
			return false;
		}
		int sz = str.length();
		for (int i = 0; i < sz; i++)
		{
			if (Character.isDigit(str.charAt(i)) == false)
			{
				return false;
			}
		}
		return true;
	}

	// Chopping
	//-----------------------------------------------------------------------
	/**
	 * <p>Remove the last character from a String.</p>
	 *
	 * <p>If the String ends in <code>\r\n</code>, then remove both
	 * of them.</p>
	 *
	 * <pre>
	 * StringUtils.chop(null)          = null
	 * StringUtils.chop("")            = ""
	 * StringUtils.chop("abc \r")      = "abc "
	 * StringUtils.chop("abc\n")       = "abc"
	 * StringUtils.chop("abc\r\n")     = "abc"
	 * StringUtils.chop("abc")         = "ab"
	 * StringUtils.chop("abc\nabc")    = "abc\nab"
	 * StringUtils.chop("a")           = ""
	 * StringUtils.chop("\r")          = ""
	 * StringUtils.chop("\n")          = ""
	 * StringUtils.chop("\r\n")        = ""
	 * </pre>
	 *
	 * @param str  the String to chop last character from, may be null
	 * @return String without last character, <code>null</code> if null String input
	 */
	public static String chop(String str)
	{
		if (str == null)
		{
			return null;
		}
		int strLen = str.length();
		if (strLen < 2)
		{
			return EMPTY;
		}
		int lastIdx = strLen - 1;
		String ret = str.substring(0, lastIdx);
		char last = str.charAt(lastIdx);
		if (last == '\n')
		{
			if (ret.charAt(lastIdx - 1) == '\r')
			{
				return ret.substring(0, lastIdx - 1);
			}
		}
		return ret;
	}

	/**
	 * 判断字符串是否在数组中
	 * @param array 为null时，固定返回false
	 * @param target 目标字符串
	 * @return 如果array中存在null,target也为null时，返回true
	 */
	public static boolean isStringInArray(String[] array, String target)
	{
		if (array == null)
		{
			return false;
		}
		for (String strInArray : array)
		{
			if (equals(strInArray, target))
			{
				return true;
			}
		}
		return false;
	}

	public static byte[] leftPad(byte[] source, int length, byte padding)
	{
		if (source == null || source.length >= length)
		{
			return source;
		}
		ByteBuffer buffer = ByteBuffer.allocate(length);
		for (int i = 0; i < length - source.length; i++)
		{
			buffer.put(padding);
		}
		buffer.put(source);
		byte[] result = new byte[length];
		buffer.flip();
		buffer.get(result);
		return result;
	}

	public static byte[] rightPad(byte[] source, int length, byte padding)
	{
		if (source == null || source.length >= length)
		{
			return source;
		}
		ByteBuffer buffer = ByteBuffer.allocate(length);
		buffer.put(source);
		for (int i = 0; i < length - source.length; i++)
		{
			buffer.put(padding);
		}
		byte[] result = new byte[length];
		buffer.flip();
		buffer.get(result);
		return result;
	}

	public static boolean isJSONValid(String test) {
		try {
			new JSONObject(test);
		} catch (JSONException ex) {
			// edited, to include @Arthur's comment
			// e.g. in case JSONArray is valid as well...
			try {
				new JSONArray(test);
			} catch (JSONException ex1) {
				return false;
			}
		}
		return true;
	}

}
