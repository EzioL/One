package com.ezio.one.main.bean;

import com.ezio.one.base.BaseBean;

import java.util.Date;

/**
 * Created by Ezio on 2016/11/20.
 */

public class MovieBean extends BaseBean{

    /**
     * id : 157
     * title : 我不是潘金莲
     * verse :
     * verse_en :
     * score : 76
     * revisedscore : 0
     * releasetime : 2016-11-18 00:00:00
     * scoretime : 2016-11-19 00:00:00
     * cover : http://image.wufazhuce.com/FtNgzTAmSrxUQLeYmym26mN-i5uN
     * servertime : 1479646597
     */

    private String title;
    private String verse;
    private String verse_en;
    private String score;
    private String revisedscore;
    private Date releasetime;
    private Date scoretime;
    private String cover;
    private int servertime;




    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVerse() {
        return verse;
    }

    public void setVerse(String verse) {
        this.verse = verse;
    }

    public String getVerse_en() {
        return verse_en;
    }

    public void setVerse_en(String verse_en) {
        this.verse_en = verse_en;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getRevisedscore() {
        return revisedscore;
    }

    public void setRevisedscore(String revisedscore) {
        this.revisedscore = revisedscore;
    }

    public Date getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(Date releasetime) {
        this.releasetime = releasetime;
    }

    public Date getScoretime() {
        return scoretime;
    }

    public void setScoretime(Date scoretime) {
        this.scoretime = scoretime;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getServertime() {
        return servertime;
    }

    public void setServertime(int servertime) {
        this.servertime = servertime;
    }


}
