package mye.tools;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author xwsoft 常用工具类，包函温度转换，Terminate ID等转换方法
 */
public class Util {
    public static String byte2BinaryString(byte b) {
        int desn = (int) b;
        desn |= 256;          //mark the 9th digit as 1 to make sure the string has at least 8 digits
        String str = Integer.toBinaryString(desn);
        int len = str.length();
        return str.substring(len - 8, len);
    }

    public static String byte2HexString(byte b) {
        int desn = (int) b;
        desn |= 256;          //mark the 9th digit as 1 to make sure the string has at least 8 digits
        String str = Integer.toHexString(desn);
        int len = str.length();
        return str.substring(len - 2, len);

    }
    public static byte hexStr2Byte(String src) {
        int ss = Integer.parseInt(src, 16);
        if (ss <= 127) {
            return (byte) ss;
        } else {
            ss = ss - 1;
            ss = (byte) ~ss;
            ss = ss * -1;
            return (byte) ss;
        }
    }
    public static byte str2Byte(String src) {
        int ss = Integer.parseInt(src, 2);
        if (ss <= 127) {
            return (byte) ss;
        } else {
            ss = ss - 1;
            ss = (byte) ~ss;
            ss = ss * -1;
            return (byte) ss;
        }
    }
    public static byte decStr2Byte(String src) {
        int ss = Integer.parseInt(src);
        if (ss <= 127) {
            return (byte) ss;
        } else {
            ss = ss - 1;
            ss = (byte) ~ss;
            ss = ss * -1;
            return (byte) ss;
        }
    }
    
    
public void PrintByte(byte[] byteStr) {
		if (byteStr != null) {
			System.out.print("Len:" + byteStr.length + "	value:");
			for (int i = 0; i < byteStr.length; i++) {
				System.out.print(byteStr[i]);
				System.out.print(" ");
			}
			System.out.println("");
		} else {
			System.out.println("is null");
		}
	}

	public byte[] intToByte(int i) {
		byte[] abyte0 = new byte[4];
		abyte0[0] = (byte) (0xff & i);
		abyte0[1] = (byte) ((0xff00 & i) >> 8);
		abyte0[2] = (byte) ((0xff0000 & i) >> 16);
		abyte0[3] = (byte) ((0xff000000 & i) >> 24);
		return abyte0;
	}

	public static int bytesToInt(byte[] bytes) {
		int addr = bytes[0] & 0xFF;
		addr |= ((bytes[1] << 8) & 0xFF00);
		addr |= ((bytes[2] << 16) & 0xFF0000);
		addr |= ((bytes[3] << 24) & 0xFF000000);
		return addr;
	}

	/**
	 * @param terminalId
	 * @return byte[] 十六进制的TerminalId
	 */
	public byte[] TerminalIdToByte(String terminalId) {
		terminalId = terminalId.replace("-", "");
		byte[] datas = new byte[8];
		if (terminalId == null || terminalId.trim().equals("")
				|| terminalId.length() != 16) {
		} else {
			for (int i = 0; i < 8; i++) {
				datas[i] = hexStr2Byte(terminalId.substring(i * 2,
						i * 2 + 2));
			}
		}
		return datas;
	}

	public String getByteArrayString(byte[] array, String delimiter) {
		// String[] mediator_id_data = new String[array.length];
		String strID = "";
		for (int i = 0; i < array.length; i++) {
			String val = Integer.toHexString(array[i] & 0xFF);
			if (val.length() == 1) {
				val = "0" + val;
			}
			strID += delimiter + val.toUpperCase();
		}
		return strID.substring(1);
	}

	/**
	 * @param mediatorId
	 * @return byte[] 十六进制的MediatorID
	 */
	public byte[] MediatorIdToByte(String mediatorId) {
		byte[] byteMediatorId = new byte[] { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 };
		if (mediatorId == null || mediatorId.trim().equals("")
				|| mediatorId.length() != 17) {
		} else {
			String[] temp_ap_id_list = mediatorId.split("-");
			for (int n = 0; n < 6; n++) {
				byteMediatorId[n] = hexStr2Byte((temp_ap_id_list[n]));
			}
		}
		return byteMediatorId;
	}

	/**
	 * 拆分TerminalID 如注册贞数据内容会带0或多个TerminalID串.
	 * 
	 * @param data_length
	 * @param datas
	 * @return
	 */
	public List terminalList(byte[] datas) {
		int data_length = datas.length;
		List terminalList = new ArrayList();
		if ((data_length % 8) == 0) {
			String terminal_id = "";
			int n = data_length / 8;
			for (int i = 0; i < n; i++) {
				for (int m = 0; m < 8; m++) {
					String temp_id = Integer
							.toHexString(datas[i * 8 + m] & 0xFF);
					if (temp_id.length() < 2) {
						terminal_id += "0" + temp_id.toUpperCase();
					} else {
						terminal_id += temp_id.toUpperCase();
					}
					terminal_id += "-";
				}
				terminal_id = terminal_id.substring(0, terminal_id.length() - 1);
				terminalList.add(i, terminal_id);
				terminal_id = "";
			}
		}
		return terminalList;
	}

	/**
	 * 将温度转成byte[]
	 * 
	 * @param strTemprature
	 * @return
	 */
	public byte[] TempratureToByte(String strTemprature) {
		byte[] ret = new byte[1];
		if (strTemprature == null || strTemprature.length() < 1) {
			return ret;
		}
		String flag = strTemprature.substring(0, 1);
		String tempInt = "";
		if (flag.equals("-")) {
			flag = "1";
			tempInt = strTemprature.substring(1);
		} else {
			tempInt = strTemprature;
			flag = "0";
		}
		tempInt = flag
				+ byte2BinaryString(Byte.parseByte(tempInt))
						.substring(1);
		ret[0] = str2Byte(tempInt);
		return ret;
	}

	/**
	 * 8位的二进制字符串，不带小数
	 * 
	 * @param inTempStr
	 * @return
	 */
	public String getTemprature(String inTempStr) {
		System.out.println("  getTemprature :" + inTempStr);
		String tempStr = "";
		String flag = inTempStr.substring(0, 1);
		System.out.println("flag:" + flag);
		String tempInt = inTempStr.substring(1, 8);
		System.out.println("tempInt bin:" + tempInt);

		int temp = Integer.valueOf(tempInt, 2);

		if (flag.trim().equals("1")) {
			flag = "-";
		} else {
			flag = "";
		}
		tempStr = flag + temp;

		return tempStr;
	}

	/**
	 * 0005 和 000B指令用到 将16个字节的温度字符串转成实际的温度数表示
	 * 
	 * @param inTempStr
	 * @return 如-45.4
	 */
	public String getTemprature2B(String inTempStr) {
		System.out.println("inTempStr:" + inTempStr);
		if (inTempStr.length() != 16) {
			return "0";
		}
		String tempStr = "";
		String flag = inTempStr.substring(0, 1);
		System.out.println("flag:" + flag);
		String tempInt = inTempStr.substring(1, 8);
		System.out.println("tempInt bin:" + tempInt);
		String tempDecm = inTempStr.substring(8);
		System.out.println("tempInt bin:" + tempDecm);
		int temp = Integer.valueOf(tempInt, 2);

		int decm = Integer.valueOf(tempDecm, 2);
		if (flag.trim().equals("1")) {
			flag = "-";
		} else {
			flag = "";
		}
		tempStr = flag + temp;
		if (decm != 0) {
			tempStr += "." + decm;
		}
		return tempStr;
	}

	/**
	 * 将new byte[]{0x00,0x10}形式的十六进制转换成0010字符串
	 * 
	 * @param type
	 * @return
	 */
	public String convertTypeString(byte[] type) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < type.length; i++) {
			String val = Integer.toHexString(type[i] & 0xFF);
			if (val.length() == 1) {
				buffer.append("0");
			}
			buffer.append(val.toUpperCase());
		}
		return buffer.toString();
	}

	/**
	 * 将字符串转换成十六进制的byte[]
	 * 
	 * @param strTmp
	 * @return
	 */
	public byte[] StringToHexByte(String strTmp) {
		int iLen = strTmp.length();
		byte[] byteResult = new byte[iLen / 2];
		for (int i = 0; i < iLen / 2; i++) {
			byteResult[i] = hexStr2Byte(strTmp.substring(i * 2,
					i * 2 + 2));
		}
		return byteResult;
	}

	/**
	 * 将字符串转换成十进制的byte[]
	 * 
	 * @param strTmp
	 * @return
	 */
	public byte[] StringToByte(String strTmp) {
		int iLen = strTmp.length();
		byte[] byteResult = new byte[iLen / 2];
		for (int i = 0; i < iLen / 2; i++) {
			byteResult[i] = Byte.parseByte(strTmp.substring(i * 2, i * 2 + 2));
		}
		return byteResult;
	}

	public String getWeekDay(String strWeekDay) {
		if (strWeekDay.equals("1")) {
			strWeekDay = "Monday";
		}
		if (strWeekDay.equals("2")) {
			strWeekDay = "Tuesday";
		}
		if (strWeekDay.equals("3")) {
			strWeekDay = "Wednesday";
		}
		if (strWeekDay.equals("4")) {
			strWeekDay = "Thursday";
		}
		if (strWeekDay.equals("5")) {
			strWeekDay = "Friday";
		}
		if (strWeekDay.equals("6")) {
			strWeekDay = "Saturday";
		}
		if (strWeekDay.equals("7")) {
			strWeekDay = "Sunday";
		}
		return strWeekDay;
	}

	public String getWeekDayNum(String strWeekDay) {
		if (strWeekDay.equals("Monday")) {
			strWeekDay = "01";
		}
		if (strWeekDay.equals("Tuesday")) {
			strWeekDay = "02";
		}
		if (strWeekDay.equals("Wednesday")) {
			strWeekDay = "03";
		}
		if (strWeekDay.equals("Thursday")) {
			strWeekDay = "04";
		}
		if (strWeekDay.equals("Friday")) {
			strWeekDay = "05";
		}
		if (strWeekDay.equals("Saturday")) {
			strWeekDay = "06";
		}
		if (strWeekDay.equals("Sunday")) {
			strWeekDay = "07";
		}
		return strWeekDay;
	}

	/**
	 * 将二进的字符串转换成10:Sunday字符串
	 * 
	 * @param strTmp
	 * @return
	 */
	public String MthWeekTostr(String strMW) {
		String strM = "0000" + strMW.substring(0, 4);
		String strW = "0000" + strMW.substring(4);
		int iM = Integer.valueOf(strM, 2) + 1;
		int iW = Integer.valueOf(strW, 2);
		String strResult = "";
		strResult += iM;
		strResult += ":" + getWeekDay(String.valueOf(iW));
		return strResult;
	}

	/**
	 * 将Month或Day字符串转换成2bit十六进制的byte[]
	 * 
	 * @param strTmp
	 * @return
	 */
	public byte MthWeek2Byte(String strMonth, String strWeekDay) {
		String strmw = "";
		if (strMonth != null && strWeekDay != null && strMonth.length() > 0
				&& strWeekDay.length() > 0) {
			String strBMon = "0000"
					+ Integer.toBinaryString(Integer.valueOf(strMonth) - 1);
			String strBWeek = "0000"
					+ Integer.toBinaryString(Integer
							.valueOf(getWeekDayNum(strWeekDay)));
			strmw = strBMon.substring(strBMon.length() - 4, strBMon.length())
					+ strBWeek.substring(strBWeek.length() - 4,
							strBWeek.length());
		}
		return str2Byte(strmw);
	}

	/**
	 * 二进制转换成 AM:09字符串
	 * 
	 * @param bHour
	 * @return 返回格式为： AM:09
	 */
	public String getHourToStr(String strHour) {
		String ret = "";
		if (strHour.substring(0, 1).equals("0")) {
			ret += "AM:";
		} else {
			ret += "PM:";
		}
		int ih = Integer.valueOf("0" + strHour.substring(1), 2);
		if (ih < 10) {
			ret += "0";
		}
		ret += ih;
		return ret;
	}

	/**
	 * AM:09字符串转换成byte
	 * 
	 * @param strHour
	 *            AM:09
	 * @return 十六进制 byte
	 */
	public byte getHourToByte(String strHour) {
		String[] arrH = strHour.split(":");
		String strTmp = "";
		if (arrH[0].toUpperCase().equals("AM")) {
			strTmp = "0";
		} else {
			strTmp = "1";
		}
		if (arrH[1].equals("12")) {
			arrH[1] = "00";
		}
		byte bTmp = decStr2Byte(arrH[1]);
		String strHourTmp = byte2BinaryString(bTmp);
		if (strHourTmp.length() == 4) {
			strHourTmp = "0000" + strHourTmp;
		}
		strTmp += strHourTmp.substring(1);
		return str2Byte(strTmp);
	}

	/**
	 * 年格式化成byte类型，2010只取10 将第一位的年去除取后三位
	 * 
	 * @param strYear
	 * @return
	 */
	public byte getYearToByte(String strYear) {

		if (strYear.length() > 3) {
			strYear = strYear.substring(strYear.length() - 3, strYear.length());
		}
		return decStr2Byte(strYear);
	}

	/**
	 * 将byte类型年转成2010格式字符串
	 * 
	 * @param strYear
	 * @return
	 */
	public String getYearToStr(byte bYear) {
		String strYear = "";
		int iYear = Integer.valueOf(byte2BinaryString(bYear), 2);
		if (iYear < 100) {
			strYear = "000" + iYear;
		}
		strYear = "2" + strYear.substring(strYear.length() - 3);
		return strYear;
	}

	/**
	 * 将byte[]日期星期转成字符串 2010:10:11:Monday
	 * 
	 * @param byteDate
	 *            byte[]日期星期 32 16 16 1 17 9 88
	 * @return 2010:10:11:Monday
	 */
	public String ShortDateToString(byte[] byteDate) {
		String strDate = "";
		if (byteDate.length == 3) {
			String strYear = getYearToStr(byteDate[0]);
			String strMW = MthWeekTostr(byte2BinaryString(byteDate[1]));
			String[] arrMW = strMW.split(":");
			String strDay = Integer.valueOf(byteDate[2]).toString();
			strDate += strYear + ":";
			strDate += arrMW[0] + ":";
			strDate += strDay + ":";
			strDate += arrMW[1] + ":";
		}
		return strDate;
	}

	/**
	 * 将十六进制的byte[]日期时间转成字符串
	 * 
	 * @param byte[]日期时间 32 16 16 1 17 9 88
	 * @return WEB存到数据数的日期时间字符串
	 */
	public String DateToString(byte[] byteDate) {
		String strDate = "";
		if (byteDate.length == 5) {
			String strYear = getYearToStr(byteDate[0]);
			String strMW = MthWeekTostr(byte2BinaryString(byteDate[1]));
			String[] arrMW = strMW.split(":");
			String strDay = Integer.valueOf(byteDate[2]).toString();
			if (strDay.length() == 1) {
				strDay = "0" + strDay;
			}
			String strHour = getHourToStr(byte2BinaryString(byteDate[3]));
			String strMinute = Integer.valueOf(byteDate[4]).toString();
			strDate += strYear + ":";
			String strM = arrMW[0];
			if (strM.length() == 1) {
				strM = "0" + strM;
			}
			if (strMinute.length() == 1) {
				strMinute = "0" + strMinute;
			}
			strDate += strM + ":";
			strDate += strDay + ":";
			strDate += arrMW[1] + ":";
			strDate += strHour + ":";
			strDate += strMinute;
		}
		return strDate;
	}




	/**
	 * 取当前时间字符串2010:10:12:Tuesday:pm:8:41
	 * 
	 * @return 2010:10:12:Tuesday:pm:8:41
	 */
	public String getDates() {
		String strDates = "";
		Date c_d = Calendar.getInstance().getTime();
		String time = String.format(Locale.US, "%tA", c_d) + ":"
				+ String.format(Locale.US, "%tp", c_d).toUpperCase() + ":";
		String strHour = String.format(Locale.US, "%tl", c_d);
		if (strHour.equals("12")) {
			strHour = "0";
		}
		if (strHour.length() == 1) {
			strHour = "0" + strHour;
		}
		String StrMin = String.format(Locale.US, "%tM", c_d);
		if (StrMin.length() == 1) {
			StrMin = "0" + StrMin;
		}
		time += strHour + ":" + StrMin;
		strDates += String.format(Locale.US, "%tY", c_d) + ":"
				+ String.format(Locale.US, "%tm", c_d) + ":"
				+ String.format(Locale.US, "%td", c_d) + ":";
		strDates += time;
		return strDates;
	}

	/**
	 * 比较两个时间串2010:10:12:Tuesday:pm:8:41分钟相差多少 如果返回60表示他们的差异大于1小时
	 * 
	 * @param strDate1
	 * @param strDate2
	 * @return 相隔时间的分钟数。如果返回60表明差异大于1小时
	 */
	public int CompareDates(String strDate1, String strDate2) {
		int diffMinute = 60;
		strDate1 = strDate1.toUpperCase();
		strDate2 = strDate2.toUpperCase();
		String[] arrDate1 = strDate1.split(":");
		String[] arrDate2 = strDate2.split(":");
		if (arrDate1.length == arrDate2.length) {
			boolean flag1 = true;
			for (int i = 0; i < arrDate1.length - 1; i++) {
				if (!arrDate1[i].equals(arrDate2[i])) {
					flag1 = false;
				}
			}
			if (flag1) {
				diffMinute = Math.abs(Integer.parseInt(arrDate1[6])
						- Integer.parseInt(arrDate2[6]));
			}
		}
		return diffMinute;
	}

	/**
	 * 指令序列整数值转成2byte类型
	 * 
	 * @param iSeqNum
	 * @return
	 */
	public byte[] getCmdSeqNum(int iSeqNum) {
		byte[] byteResult = new byte[] { 0, 0 };
		String strSeqB = "0000000000000000" + Integer.toBinaryString(iSeqNum);
		byte b1 = str2Byte(strSeqB.substring(strSeqB.length() - 8,
				strSeqB.length()));
		byte b2 = str2Byte(strSeqB.substring(strSeqB.length() - 16,
				strSeqB.length() - 8));
		byteResult[0] = b1;
		byteResult[1] = b2;
		return byteResult;
	}

	/**
	 * 将指令二进制字符串转成int
	 * 
	 * @param strSeq
	 * @return
	 */
	public int convertCmdSeqNum(String strSeq) {
		String strSeqB = "0000000000000000" + strSeq;
		String b1 = strSeqB.substring(strSeqB.length() - 8, strSeqB.length());
		String b2 = strSeqB.substring(strSeqB.length() - 16,
				strSeqB.length() - 8);
		strSeqB = b2 + b1;
		int iSeq = Integer.valueOf(strSeqB, 2);
		return iSeq;
	}

	/**
	 * 将 byte[] 串转成int
	 * 
	 * @param strSeq
	 * @return
	 */
	public int convertCmdSeqNum(byte[] bSeq) {
		String strSeq = "";
		if (bSeq != null) {
			if (bSeq.length == 2) {
				strSeq = byte2BinaryString(bSeq[1]);
				strSeq += byte2BinaryString(bSeq[0]);
			}
			int iSeq = Integer.valueOf(strSeq, 2);
			return iSeq;
		} else {
			return 0;
		}
	}

	public static String toHexString(String s) {
		String str = "";
		for (int i = 0; i < s.length(); i++) {
			int ch = (int) s.charAt(i);
			String s4 = Integer.toHexString(ch);
			str = str + s4;
		}
		return "0x" + str;// 0x表示十六进制
	}


	// 当前系统类型
	public static boolean isWindows() {
		boolean iswin = false;
		String strOSType = System.getProperty("os.name").toLowerCase();
		if (strOSType.indexOf("win") > -1) {
			iswin = true;
		}
		return iswin;
	}

	/**
	 * 将String转换为Date类型
	 * 
	 * @param date
	 * @return
	 */
	public static Date convertDate(String strDate) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			String temp = sdf.format(strDate);
			date = sdf.parse(temp);
		} catch (ParseException e) {
			// e.printStackTrace();
			System.out.println("error: " + e);
		}
		return date;
	}

	// 2010:10:11:Monday:AM:09:58
	public String AddHour4Date(String strDate, int iHour) {
		String[] arrTmpDate = strDate.split(":");
		String strTmp = "";
		if (arrTmpDate.length == 7) {
			strTmp = arrTmpDate[0] + "-" + arrTmpDate[1] + "-" + arrTmpDate[2]
					+ " ";
			if (arrTmpDate[4].toUpperCase().equals("PM")) {
				strTmp += (Integer.parseInt(arrTmpDate[5]) + 12);
			} else {
				strTmp += arrTmpDate[5];
			}
			strTmp += ":" + arrTmpDate[6] + ":00";
		}
		String strDates = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date c_d;
		try {
			c_d = sdf.parse(strTmp);
			long Time = (c_d.getTime() / 1000) + 60 * 60 * iHour;
			c_d.setTime(Time * 1000);
			String time = String.format(Locale.US, "%tA", c_d) + ":"
					+ String.format(Locale.US, "%tp", c_d).toUpperCase() + ":";
			String strHour = String.format(Locale.US, "%tl", c_d);
			if (strHour.equals("12")) {
				strHour = "0";
			}
			if (strHour.length() == 1) {
				strHour = "0" + strHour;
			}
			String StrMin = String.format(Locale.US, "%tM", c_d);
			if (StrMin.length() == 1) {
				StrMin = "0" + StrMin;
			}
			time += strHour + ":" + StrMin;
			strDates += String.format(Locale.US, "%tY", c_d) + ":"
					+ String.format(Locale.US, "%tm", c_d) + ":"
					+ String.format(Locale.US, "%td", c_d) + ":";
			strDates += time;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return strDates;
	}

	public static void printHexString(byte[] b) {
		for (int i = 0; i < b.length; i++) {
			String hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			System.out.print(hex.toUpperCase() + " ");
		}

	}
	
	/**
	 * 用于将字符串（字符串必须为可转int）转为byte，如果为负将最高位标为1以配合硬件使用
	 * @param str
	 * @return
	 */
	public static byte strToByte(String str){
		byte bResult = 0;
		int i = Integer.parseInt(str);
	
		if(i>=0){
			bResult = (byte)i;
		}else{
			i = Math.abs(i);
			String strTest = Integer.toBinaryString(i);
			if(strTest.length()<8){
				strTest = "00000000"+strTest;
				strTest = "1"+strTest.substring(strTest.length()-7);
				int iend = Integer.valueOf(strTest,2);
				bResult = (byte)iend;
			}
		}
		return bResult;

	}
        
        public static boolean compareHead(byte[] datas){
            boolean flag = true;
            if(datas.length>Constants.HEAD.length){
                for(int i=0;i<Constants.HEAD.length;i++){
                    if(datas[i]!=Constants.HEAD[i]){
                        flag = false;
                        break;
                    }
                }
            }
            return flag;
        }
        

               
       public static String desIP(byte[] datas){
           String ip = null;
           if(datas.length==4){
               ip = Integer.parseInt(byte2BinaryString(datas[0]),2)+"."+Integer.parseInt(byte2BinaryString(datas[1]),2)+"."+Integer.parseInt(byte2BinaryString(datas[2]),2)+"."+Integer.parseInt(byte2BinaryString(datas[3]),2);
           }
           return ip;
       }
       
       public static byte[] strToByte(String strVal,String delimiter){
           String[] arrVal = strVal.split(delimiter);
            int bSize = arrVal.length;
            byte[] datas = new byte[bSize];
            for (int i = 0; i < bSize; i++) {
                datas[i] = (byte)Integer.parseInt(arrVal[i]);
            }
            return datas;
       }
       
      public static int desPort(byte[] datas){
           int iPort = 0;
           if(datas.length==2){
               iPort = Integer.parseInt(byte2BinaryString(datas[0])+byte2BinaryString(datas[1]),2);
           }
           return iPort;
       }
      
      public static byte[] encPort(int port){
          byte[] bPort = new byte[2];
          String strVal = Integer.toBinaryString(port);
          if(strVal.length()>8){
              bPort[0] = (byte)Integer.parseInt(strVal.substring(0,strVal.length()-8),2);
              bPort[1] = (byte)Integer.parseInt(strVal.substring(strVal.length()-8),2);
          }else{
              bPort[1] = (byte)Integer.parseInt(strVal,2);
          }
       
           return bPort;
       }
      
      	public byte[] hexStrToByte(String strVal,String delimiter) {
            String[] arrVal = strVal.split(delimiter);
            int bSize = arrVal.length;
            byte[] datas = new byte[bSize];
            for (int i = 0; i < bSize; i++) {
                datas[i] = hexStr2Byte(arrVal[i]);
            }
            return datas;
	}
        
        public static String validIP(String strIP){
            String strResult = null;
            String[] arrIP = strIP.split("\\.");
            boolean flag = true;
            if(arrIP.length==4){
                for(int i=0;i<arrIP.length;i++){
                    try{
                        int iIP = Integer.parseInt(arrIP[i]);
                        if(iIP>255){
                            flag = false;
                        }
                    }catch(Exception ex){
                        flag = false;
                    } 
                }
                if(flag && Integer.parseInt(arrIP[0])>0){
                    strResult = Integer.parseInt(arrIP[0]) +"."+ Integer.parseInt(arrIP[1]) +"."+ Integer.parseInt(arrIP[2]) +"."+ Integer.parseInt(arrIP[3]);
                }
            }
            return strResult;
        }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
              String[] arrStr = "192.168.0.43".split("\\.");
              System.out.println(arrStr.length);
	}
}
