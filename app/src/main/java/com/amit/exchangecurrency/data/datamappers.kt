package com.amit.exchangecurrency.data

import com.amit.domain.Currency
import com.amit.exchangecurrency.data.database.Currency as DomainCurrency
import com.amit.exchangecurrency.data.server.Currency as ServerCurrency
import com.amit.exchangecurrency.data.server.Rate as ServerRate
import com.amit.domain.Rate as DomainRate

fun Currency.toRoomCurrency(): DomainCurrency =
    DomainCurrency(
        id,
        getRateData(rates),
        base,
        date
    )

fun DomainCurrency.toDomainCurrency(): Currency =
    Currency(
        id,
        getRateData(this.rates),
        base,
        date
    )

fun ServerCurrency.toDomainCurrency(): Currency =
    Currency(
        id,
        getRateData(this.rates),
        base,
        date
    )

fun DomainRate.toRoomRate(): DomainRate {
    return DomainRate(
        rateId, aED,
        aFN,
        aLL,
        aMD,
        aNG,
        aOA,
        aRS,
        aUD,
        aWG,
        aZN,
        bAM,
        bBD,
        bDT,
        bGN,
        bHD,
        bIF,
        bMD,
        bND,
        bOB,
        bRL,
        bSD,
        bTC,
        bTN,
        bWP,
        bYN,
        bYR,
        bZD,
        cAD,
        cDF,
        cHF,
        cLF,
        cLP,
        cNY,
        cOP,
        cRC,
        cUC,
        cUP,
        cVE,
        cZK,
        dJF,
        dKK,
        dOP,
        dZD,
        eGP,
        eRN,
        eTB,
        eUR,
        fJD,
        fKP,
        gBP,
        gEL,
        gGP,
        gHS,
        gIP,
        gMD,
        gNF,
        gTQ,
        gYD,
        hKD,
        hNL,
        hRK,
        hTG,
        hUF,
        iDR,
        iLS,
        iMP,
        iNR,
        iQD,
        iRR,
        iSK,
        jEP,
        jMD,
        jOD,
        jPY,
        kES,
        kGS,
        kHR,
        kMF,
        kPW,
        kRW,
        kWD,
        kYD,
        kZT,
        lAK,
        lBP,
        lKR,
        lRD,
        lSL,
        lTL,
        lVL,
        lYD,
        mAD,
        mDL,
        mGA,
        mKD,
        mMK,
        mNT,
        mOP,
        mRO,
        mUR,
        mVR,
        mWK,
        mXN,
        mYR,
        mZN,
        nAD,
        nGN,
        nIO,
        nOK,
        nPR,
        nZD,
        oMR,
        pAB,
        pEN,
        pGK,
        pHP,
        pKR,
        pLN,
        pYG,
        qAR,
        rON,
        rSD,
        rUB,
        rWF,
        sAR,
        sBD,
        sCR,
        sDG,
        sEK,
        sGD,
        sHP,
        sLE,
        sLL,
        sOS,
        sRD,
        sTD,
        sVC,
        sYP,
        sZL,
        tHB,
        tJS,
        tMT,
        tND,
        tOP,
        tRY,
        tTD,
        tWD,
        tZS,
        uAH,
        uGX,
        uSD,
        uYU,
        uZS,
        vEF,
        vND,
        vUV,
        wST,
        xAF,
        xAG,
        xAU,
        xCD,
        xDR,
        xOF,
        xPF,
        yER,
        zAR,
        zMK,
        zMW,
        zWL
    )
}

fun DomainRate.toDomainRate(): DomainRate {
    return DomainRate(
        rateId, aED,
        aFN,
        aLL,
        aMD,
        aNG,
        aOA,
        aRS,
        aUD,
        aWG,
        aZN,
        bAM,
        bBD,
        bDT,
        bGN,
        bHD,
        bIF,
        bMD,
        bND,
        bOB,
        bRL,
        bSD,
        bTC,
        bTN,
        bWP,
        bYN,
        bYR,
        bZD,
        cAD,
        cDF,
        cHF,
        cLF,
        cLP,
        cNY,
        cOP,
        cRC,
        cUC,
        cUP,
        cVE,
        cZK,
        dJF,
        dKK,
        dOP,
        dZD,
        eGP,
        eRN,
        eTB,
        eUR,
        fJD,
        fKP,
        gBP,
        gEL,
        gGP,
        gHS,
        gIP,
        gMD,
        gNF,
        gTQ,
        gYD,
        hKD,
        hNL,
        hRK,
        hTG,
        hUF,
        iDR,
        iLS,
        iMP,
        iNR,
        iQD,
        iRR,
        iSK,
        jEP,
        jMD,
        jOD,
        jPY,
        kES,
        kGS,
        kHR,
        kMF,
        kPW,
        kRW,
        kWD,
        kYD,
        kZT,
        lAK,
        lBP,
        lKR,
        lRD,
        lSL,
        lTL,
        lVL,
        lYD,
        mAD,
        mDL,
        mGA,
        mKD,
        mMK,
        mNT,
        mOP,
        mRO,
        mUR,
        mVR,
        mWK,
        mXN,
        mYR,
        mZN,
        nAD,
        nGN,
        nIO,
        nOK,
        nPR,
        nZD,
        oMR,
        pAB,
        pEN,
        pGK,
        pHP,
        pKR,
        pLN,
        pYG,
        qAR,
        rON,
        rSD,
        rUB,
        rWF,
        sAR,
        sBD,
        sCR,
        sDG,
        sEK,
        sGD,
        sHP,
        sLE,
        sLL,
        sOS,
        sRD,
        sTD,
        sVC,
        sYP,
        sZL,
        tHB,
        tJS,
        tMT,
        tND,
        tOP,
        tRY,
        tTD,
        tWD,
        tZS,
        uAH,
        uGX,
        uSD,
        uYU,
        uZS,
        vEF,
        vND,
        vUV,
        wST,
        xAF,
        xAG,
        xAU,
        xCD,
        xDR,
        xOF,
        xPF,
        yER,
        zAR,
        zMK,
        zMW,
        zWL
    )
}

fun ServerRate.toDomainRate(): DomainRate {
    return DomainRate(
        rateId, aED,
        aFN,
        aLL,
        aMD,
        aNG,
        aOA,
        aRS,
        aUD,
        aWG,
        aZN,
        bAM,
        bBD,
        bDT,
        bGN,
        bHD,
        bIF,
        bMD,
        bND,
        bOB,
        bRL,
        bSD,
        bTC,
        bTN,
        bWP,
        bYN,
        bYR,
        bZD,
        cAD,
        cDF,
        cHF,
        cLF,
        cLP,
        cNY,
        cOP,
        cRC,
        cUC,
        cUP,
        cVE,
        cZK,
        dJF,
        dKK,
        dOP,
        dZD,
        eGP,
        eRN,
        eTB,
        eUR,
        fJD,
        fKP,
        gBP,
        gEL,
        gGP,
        gHS,
        gIP,
        gMD,
        gNF,
        gTQ,
        gYD,
        hKD,
        hNL,
        hRK,
        hTG,
        hUF,
        iDR,
        iLS,
        iMP,
        iNR,
        iQD,
        iRR,
        iSK,
        jEP,
        jMD,
        jOD,
        jPY,
        kES,
        kGS,
        kHR,
        kMF,
        kPW,
        kRW,
        kWD,
        kYD,
        kZT,
        lAK,
        lBP,
        lKR,
        lRD,
        lSL,
        lTL,
        lVL,
        lYD,
        mAD,
        mDL,
        mGA,
        mKD,
        mMK,
        mNT,
        mOP,
        mRO,
        mUR,
        mVR,
        mWK,
        mXN,
        mYR,
        mZN,
        nAD,
        nGN,
        nIO,
        nOK,
        nPR,
        nZD,
        oMR,
        pAB,
        pEN,
        pGK,
        pHP,
        pKR,
        pLN,
        pYG,
        qAR,
        rON,
        rSD,
        rUB,
        rWF,
        sAR,
        sBD,
        sCR,
        sDG,
        sEK,
        sGD,
        sHP,
        sLE,
        sLL,
        sOS,
        sRD,
        sTD,
        sVC,
        sYP,
        sZL,
        tHB,
        tJS,
        tMT,
        tND,
        tOP,
        tRY,
        tTD,
        tWD,
        tZS,
        uAH,
        uGX,
        uSD,
        uYU,
        uZS,
        vEF,
        vND,
        vUV,
        wST,
        xAF,
        xAG,
        xAU,
        xCD,
        xDR,
        xOF,
        xPF,
        yER,
        zAR,
        zMK,
        zMW,
        zWL
    )
}

fun getRateData(rate: DomainRate?): DomainRate? {
    rate?.let {
        return DomainRate(
            it.rateId,
            it.aED,
            it.aFN,
            it.aLL,
            it.aMD,
            it.aNG,
            it.aOA,
            it.aRS,
            it.aUD,
            it.aWG,
            it.aZN,
            it.bAM,
            it.bBD,
            it.bDT,
            it.bGN,
            it.bHD,
            it.bIF,
            it.bMD,
            it.bND,
            it.bOB,
            it.bRL,
            it.bSD,
            it.bTC,
            it.bTN,
            it.bWP,
            it.bYN,
            it.bYR,
            it.bZD,
            it.cAD,
            it.cDF,
            it.cHF,
            it.cLF,
            it.cLP,
            it.cNY,
            it.cOP,
            it.cRC,
            it.cUC,
            it.cUP,
            it.cVE,
            it.cZK,
            it.dJF,
            it.dKK,
            it.dOP,
            it.dZD,
            it.eGP,
            it.eRN,
            it.eTB,
            it.eUR,
            it.fJD,
            it.fKP,
            it.gBP,
            it.gEL,
            it.gGP,
            it.gHS,
            it.gIP,
            it.gMD,
            it.gNF,
            it.gTQ,
            it.gYD,
            it.hKD,
            it.hNL,
            it.hRK,
            it.hTG,
            it.hUF,
            it.iDR,
            it.iLS,
            it.iMP,
            it.iNR,
            it.iQD,
            it.iRR,
            it.iSK,
            it.jEP,
            it.jMD,
            it.jOD,
            it.jPY,
            it.kES,
            it.kGS,
            it.kHR,
            it.kMF,
            it.kPW,
            it.kRW,
            it.kWD,
            it.kYD,
            it.kZT,
            it.lAK,
            it.lBP,
            it.lKR,
            it.lRD,
            it.lSL,
            it.lTL,
            it.lVL,
            it.lYD,
            it.mAD,
            it.mDL,
            it.mGA,
            it.mKD,
            it.mMK,
            it.mNT,
            it.mOP,
            it.mRO,
            it.mUR,
            it.mVR,
            it.mWK,
            it.mXN,
            it.mYR,
            it.mZN,
            it.nAD,
            it.nGN,
            it.nIO,
            it.nOK,
            it.nPR,
            it.nZD,
            it.oMR,
            it.pAB,
            it.pEN,
            it.pGK,
            it.pHP,
            it.pKR,
            it.pLN,
            it.pYG,
            it.qAR,
            it.rON,
            it.rSD,
            it.rUB,
            it.rWF,
            it.sAR,
            it.sBD,
            it.sCR,
            it.sDG,
            it.sEK,
            it.sGD,
            it.sHP,
            it.sLE,
            it.sLL,
            it.sOS,
            it.sRD,
            it.sTD,
            it.sVC,
            it.sYP,
            it.sZL,
            it.tHB,
            it.tJS,
            it.tMT,
            it.tND,
            it.tOP,
            it.tRY,
            it.tTD,
            it.tWD,
            it.tZS,
            it.uAH,
            it.uGX,
            it.uSD,
            it.uYU,
            it.uZS,
            it.vEF,
            it.vND,
            it.vUV,
            it.wST,
            it.xAF,
            it.xAG,
            it.xAU,
            it.xCD,
            it.xDR,
            it.xOF,
            it.xPF,
            it.yER,
            it.zAR,
            it.zMK,
            it.zMW,
            it.zWL
        )
    }
    return null
}

fun getRateData(rate: ServerRate?): DomainRate? {
    rate?.let {
        return DomainRate(
            it.rateId,
            it.aED,
            it.aFN,
            it.aLL,
            it.aMD,
            it.aNG,
            it.aOA,
            it.aRS,
            it.aUD,
            it.aWG,
            it.aZN,
            it.bAM,
            it.bBD,
            it.bDT,
            it.bGN,
            it.bHD,
            it.bIF,
            it.bMD,
            it.bND,
            it.bOB,
            it.bRL,
            it.bSD,
            it.bTC,
            it.bTN,
            it.bWP,
            it.bYN,
            it.bYR,
            it.bZD,
            it.cAD,
            it.cDF,
            it.cHF,
            it.cLF,
            it.cLP,
            it.cNY,
            it.cOP,
            it.cRC,
            it.cUC,
            it.cUP,
            it.cVE,
            it.cZK,
            it.dJF,
            it.dKK,
            it.dOP,
            it.dZD,
            it.eGP,
            it.eRN,
            it.eTB,
            it.eUR,
            it.fJD,
            it.fKP,
            it.gBP,
            it.gEL,
            it.gGP,
            it.gHS,
            it.gIP,
            it.gMD,
            it.gNF,
            it.gTQ,
            it.gYD,
            it.hKD,
            it.hNL,
            it.hRK,
            it.hTG,
            it.hUF,
            it.iDR,
            it.iLS,
            it.iMP,
            it.iNR,
            it.iQD,
            it.iRR,
            it.iSK,
            it.jEP,
            it.jMD,
            it.jOD,
            it.jPY,
            it.kES,
            it.kGS,
            it.kHR,
            it.kMF,
            it.kPW,
            it.kRW,
            it.kWD,
            it.kYD,
            it.kZT,
            it.lAK,
            it.lBP,
            it.lKR,
            it.lRD,
            it.lSL,
            it.lTL,
            it.lVL,
            it.lYD,
            it.mAD,
            it.mDL,
            it.mGA,
            it.mKD,
            it.mMK,
            it.mNT,
            it.mOP,
            it.mRO,
            it.mUR,
            it.mVR,
            it.mWK,
            it.mXN,
            it.mYR,
            it.mZN,
            it.nAD,
            it.nGN,
            it.nIO,
            it.nOK,
            it.nPR,
            it.nZD,
            it.oMR,
            it.pAB,
            it.pEN,
            it.pGK,
            it.pHP,
            it.pKR,
            it.pLN,
            it.pYG,
            it.qAR,
            it.rON,
            it.rSD,
            it.rUB,
            it.rWF,
            it.sAR,
            it.sBD,
            it.sCR,
            it.sDG,
            it.sEK,
            it.sGD,
            it.sHP,
            it.sLE,
            it.sLL,
            it.sOS,
            it.sRD,
            it.sTD,
            it.sVC,
            it.sYP,
            it.sZL,
            it.tHB,
            it.tJS,
            it.tMT,
            it.tND,
            it.tOP,
            it.tRY,
            it.tTD,
            it.tWD,
            it.tZS,
            it.uAH,
            it.uGX,
            it.uSD,
            it.uYU,
            it.uZS,
            it.vEF,
            it.vND,
            it.vUV,
            it.wST,
            it.xAF,
            it.xAG,
            it.xAU,
            it.xCD,
            it.xDR,
            it.xOF,
            it.xPF,
            it.yER,
            it.zAR,
            it.zMK,
            it.zMW,
            it.zWL
        )
    }
    return null
}
