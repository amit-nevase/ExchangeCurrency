package com.amit.exchangecurrency.data.server

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Currency(
    val id: Int,
    @SerializedName("rates")
    val rates: Rate?,
    val base: String,
    val date: String
) : Parcelable

@Parcelize
data class Rate(
    val rateId: Int,
    @SerializedName("AED")
    var aED: Double? = null,
    @SerializedName("AFN")
    var aFN: Double? = null,
    @SerializedName("ALL")
    var aLL: Double? = null,
    @SerializedName("AMD")
    var aMD: Double? = null,
    @SerializedName("ANG")
    var aNG: Double? = null,
    @SerializedName("AOA")
    var aOA: Double? = null,
    @SerializedName("ARS")
    var aRS: Double? = null,
    @SerializedName("AUD")
    var aUD: Double? = null,
    @SerializedName("AWG")
    var aWG: Double? = null,
    @SerializedName("AZN")
    var aZN: Double? = null,
    @SerializedName("BAM")
    var bAM: Double? = null,
    @SerializedName("BBD")
    var bBD: Double? = null,
    @SerializedName("BDT")
    var bDT: Double? = null,
    @SerializedName("BGN")
    var bGN: Double? = null,
    @SerializedName("BHD")
    var bHD: Double? = null,
    @SerializedName("BIF")
    var bIF: Double? = null,
    @SerializedName("BMD")
    var bMD: Double? = null,
    @SerializedName("BND")
    var bND: Double? = null,
    @SerializedName("BOB")
    var bOB: Double? = null,
    @SerializedName("BRL")
    var bRL: Double? = null,
    @SerializedName("BSD")
    var bSD: Double? = null,
    @SerializedName("BTC")
    var bTC: Double? = null,
    @SerializedName("BTN")
    var bTN: Double? = null,
    @SerializedName("BWP")
    var bWP: Double? = null,
    @SerializedName("BYN")
    var bYN: Double? = null,
    @SerializedName("BYR")
    var bYR: Double? = null,
    @SerializedName("BZD")
    var bZD: Double? = null,
    @SerializedName("CAD")
    var cAD: Double? = null,
    @SerializedName("CDF")
    var cDF: Double? = null,
    @SerializedName("CHF")
    var cHF: Double? = null,
    @SerializedName("CLF")
    var cLF: Double? = null,
    @SerializedName("CLP")
    var cLP: Double? = null,
    @SerializedName("CNY")
    var cNY: Double? = null,
    @SerializedName("COP")
    var cOP: Double? = null,
    @SerializedName("CRC")
    var cRC: Double? = null,
    @SerializedName("CUC")
    var cUC: Double? = null,
    @SerializedName("CUP")
    var cUP: Double? = null,
    @SerializedName("CVE")
    var cVE: Double? = null,
    @SerializedName("CZK")
    var cZK: Double? = null,
    @SerializedName("DJF")
    var dJF: Double? = null,
    @SerializedName("DKK")
    var dKK: Double? = null,
    @SerializedName("DOP")
    var dOP: Double? = null,
    @SerializedName("DZD")
    var dZD: Double? = null,
    @SerializedName("EGP")
    var eGP: Double? = null,
    @SerializedName("ERN")
    var eRN: Double? = null,
    @SerializedName("ETB")
    var eTB: Double? = null,
    @SerializedName("EUR")
    var eUR: Double? = null,
    @SerializedName("FJD")
    var fJD: Double? = null,
    @SerializedName("FKP")
    var fKP: Double? = null,
    @SerializedName("GBP")
    var gBP: Double? = null,
    @SerializedName("GEL")
    var gEL: Double? = null,
    @SerializedName("GGP")
    var gGP: Double? = null,
    @SerializedName("GHS")
    var gHS: Double? = null,
    @SerializedName("GIP")
    var gIP: Double? = null,
    @SerializedName("GMD")
    var gMD: Double? = null,
    @SerializedName("GNF")
    var gNF: Double? = null,
    @SerializedName("GTQ")
    var gTQ: Double? = null,
    @SerializedName("GYD")
    var gYD: Double? = null,
    @SerializedName("HKD")
    var hKD: Double? = null,
    @SerializedName("HNL")
    var hNL: Double? = null,
    @SerializedName("HRK")
    var hRK: Double? = null,
    @SerializedName("HTG")
    var hTG: Double? = null,
    @SerializedName("HUF")
    var hUF: Double? = null,
    @SerializedName("IDR")
    var iDR: Double? = null,
    @SerializedName("ILS")
    var iLS: Double? = null,
    @SerializedName("IMP")
    var iMP: Double? = null,
    @SerializedName("INR")
    var iNR: Double? = null,
    @SerializedName("IQD")
    var iQD: Double? = null,
    @SerializedName("IRR")
    var iRR: Double? = null,
    @SerializedName("ISK")
    var iSK: Double? = null,
    @SerializedName("JEP")
    var jEP: Double? = null,
    @SerializedName("JMD")
    var jMD: Double? = null,
    @SerializedName("JOD")
    var jOD: Double? = null,
    @SerializedName("JPY")
    var jPY: Double? = null,
    @SerializedName("KES")
    var kES: Double? = null,
    @SerializedName("KGS")
    var kGS: Double? = null,
    @SerializedName("KHR")
    var kHR: Double? = null,
    @SerializedName("KMF")
    var kMF: Double? = null,
    @SerializedName("KPW")
    var kPW: Double? = null,
    @SerializedName("KRW")
    var kRW: Double? = null,
    @SerializedName("KWD")
    var kWD: Double? = null,
    @SerializedName("KYD")
    var kYD: Double? = null,
    @SerializedName("KZT")
    var kZT: Double? = null,
    @SerializedName("LAK")
    var lAK: Double? = null,
    @SerializedName("LBP")
    var lBP: Double? = null,
    @SerializedName("LKR")
    var lKR: Double? = null,
    @SerializedName("LRD")
    var lRD: Double? = null,
    @SerializedName("LSL")
    var lSL: Double? = null,
    @SerializedName("LTL")
    var lTL: Double? = null,
    @SerializedName("LVL")
    var lVL: Double? = null,
    @SerializedName("LYD")
    var lYD: Double? = null,
    @SerializedName("MAD")
    var mAD: Double? = null,
    @SerializedName("MDL")
    var mDL: Double? = null,
    @SerializedName("MGA")
    var mGA: Double? = null,
    @SerializedName("MKD")
    var mKD: Double? = null,
    @SerializedName("MMK")
    var mMK: Double? = null,
    @SerializedName("MNT")
    var mNT: Double? = null,
    @SerializedName("MOP")
    var mOP: Double? = null,
    @SerializedName("MRO")
    var mRO: Double? = null,
    @SerializedName("MUR")
    var mUR: Double? = null,
    @SerializedName("MVR")
    var mVR: Double? = null,
    @SerializedName("MWK")
    var mWK: Double? = null,
    @SerializedName("MXN")
    var mXN: Double? = null,
    @SerializedName("MYR")
    var mYR: Double? = null,
    @SerializedName("MZN")
    var mZN: Double? = null,
    @SerializedName("NAD")
    var nAD: Double? = null,
    @SerializedName("NGN")
    var nGN: Double? = null,
    @SerializedName("NIO")
    var nIO: Double? = null,
    @SerializedName("NOK")
    var nOK: Double? = null,
    @SerializedName("NPR")
    var nPR: Double? = null,
    @SerializedName("NZD")
    var nZD: Double? = null,
    @SerializedName("OMR")
    var oMR: Double? = null,
    @SerializedName("PAB")
    var pAB: Double? = null,
    @SerializedName("PEN")
    var pEN: Double? = null,
    @SerializedName("PGK")
    var pGK: Double? = null,
    @SerializedName("PHP")
    var pHP: Double? = null,
    @SerializedName("PKR")
    var pKR: Double? = null,
    @SerializedName("PLN")
    var pLN: Double? = null,
    @SerializedName("PYG")
    var pYG: Double? = null,
    @SerializedName("QAR")
    var qAR: Double? = null,
    @SerializedName("RON")
    var rON: Double? = null,
    @SerializedName("RSD")
    var rSD: Double? = null,
    @SerializedName("RUB")
    var rUB: Double? = null,
    @SerializedName("RWF")
    var rWF: Double? = null,
    @SerializedName("SAR")
    var sAR: Double? = null,
    @SerializedName("SBD")
    var sBD: Double? = null,
    @SerializedName("SCR")
    var sCR: Double? = null,
    @SerializedName("SDG")
    var sDG: Double? = null,
    @SerializedName("SEK")
    var sEK: Double? = null,
    @SerializedName("SGD")
    var sGD: Double? = null,
    @SerializedName("SHP")
    var sHP: Double? = null,
    @SerializedName("SLE")
    var sLE: Double? = null,
    @SerializedName("SLL")
    var sLL: Double? = null,
    @SerializedName("SOS")
    var sOS: Double? = null,
    @SerializedName("SRD")
    var sRD: Double? = null,
    @SerializedName("STD")
    var sTD: Double? = null,
    @SerializedName("SVC")
    var sVC: Double? = null,
    @SerializedName("SYP")
    var sYP: Double? = null,
    @SerializedName("SZL")
    var sZL: Double? = null,
    @SerializedName("THB")
    var tHB: Double? = null,
    @SerializedName("TJS")
    var tJS: Double? = null,
    @SerializedName("TMT")
    var tMT: Double? = null,
    @SerializedName("TND")
    var tND: Double? = null,
    @SerializedName("TOP")
    var tOP: Double? = null,
    @SerializedName("TRY")
    var tRY: Double? = null,
    @SerializedName("TTD")
    var tTD: Double? = null,
    @SerializedName("TWD")
    var tWD: Double? = null,
    @SerializedName("TZS")
    var tZS: Double? = null,
    @SerializedName("UAH")
    var uAH: Double? = null,
    @SerializedName("UGX")
    var uGX: Double? = null,
    @SerializedName("USD")
    var uSD: Double? = null,
    @SerializedName("UYU")
    var uYU: Double? = null,
    @SerializedName("UZS")
    var uZS: Double? = null,
    @SerializedName("VEF")
    var vEF: Double? = null,
    @SerializedName("VND")
    var vND: Double? = null,
    @SerializedName("VUV")
    var vUV: Double? = null,
    @SerializedName("WST")
    var wST: Double? = null,
    @SerializedName("XAF")
    var xAF: Double? = null,
    @SerializedName("XAG")
    var xAG: Double? = null,
    @SerializedName("XAU")
    var xAU: Double? = null,
    @SerializedName("XCD")
    var xCD: Double? = null,
    @SerializedName("XDR")
    var xDR: Double? = null,
    @SerializedName("XOF")
    var xOF: Double? = null,
    @SerializedName("XPF")
    var xPF: Double? = null,
    @SerializedName("YER")
    var yER: Double? = null,
    @SerializedName("ZAR")
    var zAR: Double? = null,
    @SerializedName("ZMK")
    var zMK: Double? = null,
    @SerializedName("ZMW")
    var zMW: Double? = null,
    @SerializedName("ZWL")
    var zWL: Double? = null
) : Parcelable
