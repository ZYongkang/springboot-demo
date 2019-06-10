package com.springboot.demo.view.vo;

import com.springboot.demo.view.base.AbstractModelVO;

import java.util.Objects;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc
 * @time 2019-06-06 16:52
 */
public class ArtworkVO extends AbstractModelVO {

    private String sid;
    private String title;
    private String desc;
    private Integer artistUniqueId;
    private String artistName;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getArtistUniqueId() {
        return artistUniqueId;
    }

    public void setArtistUniqueId(Integer artistUniqueId) {
        this.artistUniqueId = artistUniqueId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtworkVO artworkVO = (ArtworkVO) o;
        return Objects.equals(sid, artworkVO.sid) &&
                Objects.equals(title, artworkVO.title) &&
                Objects.equals(desc, artworkVO.desc) &&
                Objects.equals(artistUniqueId, artworkVO.artistUniqueId) &&
                Objects.equals(artistName, artworkVO.artistName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, title, desc, artistUniqueId, artistName);
    }

    @Override
    public String toString() {
        return "ArtworkVO{" +
                "sid='" + sid + '\'' +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", artistUniqueId=" + artistUniqueId +
                ", artistName='" + artistName + '\'' +
                '}';
    }
}
