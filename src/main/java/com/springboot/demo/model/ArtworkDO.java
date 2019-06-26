package com.springboot.demo.model;

import org.apache.ibatis.javassist.SerialVersionUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc
 * @time 2019-06-06 16:24
 */
@Document
public class ArtworkDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;
    private String sid;
    private String title;
    private String titleEn;
    private String desc;
    private Integer artistUniqueId;
    private Integer artistId;
    private String artistName;
    private String artistIntro;
    private Float length;
    private Float width;
    private Integer pixelWidth;
    private Integer pixelHeight;
    private Float mountedWidth;
    private Float mountedHeight;
    private Float framedWidth;
    private Float framedHeight;
    private String size;
    private String dynasty;
    private Date date;
    private String dateStr;
    private String dateStrEn;
    private String filename;
    private String material;
    private String materialEn;
    private String location;
    private String locationEn;
    private String shape;
    private String url;
    private String hUrl;
    private String fileurl;
    private String mUrl;
    private String sUrl;
    private Integer catId;
    private Integer catParentId;
    private Integer aicatId;
    private Integer catInOrgId;
    private String cat1InOrg;
    private String cat2InOrg;
    private Integer status;
    private String stamps;
    private String remark;
    private Integer ownerId;
    private Integer orgId;
    private Integer isCollect;
    private String audioUrl;
    private Integer audioClickCount;
    private Integer audioDuration;
    private String audioAuthor;
    private String audioDesc;
    private String audioGuideCode;
    private String videoUrl;
    private Integer videoClickCount;
    private Integer videoDuration;
    private String videoAuthor;
    private String videoDesc;
    private String auction;
    private String exhibit;
    private Integer isAuction;
    private Integer publishState;
    private String origin;
    private String unearthInfo;
    private Integer securityLevel;
    private String securityDescription;
    private Integer culturalRelicLevel;
    private Date gmtCreate;
    private Date gmtModified;
    private Integer similarArtworkId;
    private String inscription;
    private String label;
    private String annotation;
    private Integer dataSource;
    private String dataUniqueCode;
    private String detUrl;
    private String allInfo;
    private Integer hasWater;
    private String editor;
    private Date editorTime;
    private Integer uucatId;
    private String weight;
    private String realQuantity;
    private String integrityDegree;
    private String collectTimeStr;
    private Integer auditState;
    private String theme;
    private String skill;
    private String signature;
    private String titleTag;
    private String writing;
    private String quote;
    private Integer classifyType;
    private Date gmtPublish;
    private Integer bannerFlag;
    private Integer imageSupplement;
    private Integer clickCount;

    public ArtworkDO() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
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

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistIntro() {
        return artistIntro;
    }

    public void setArtistIntro(String artistIntro) {
        this.artistIntro = artistIntro;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public Integer getPixelWidth() {
        return pixelWidth;
    }

    public void setPixelWidth(Integer pixelWidth) {
        this.pixelWidth = pixelWidth;
    }

    public Integer getPixelHeight() {
        return pixelHeight;
    }

    public void setPixelHeight(Integer pixelHeight) {
        this.pixelHeight = pixelHeight;
    }

    public Float getMountedWidth() {
        return mountedWidth;
    }

    public void setMountedWidth(Float mountedWidth) {
        this.mountedWidth = mountedWidth;
    }

    public Float getMountedHeight() {
        return mountedHeight;
    }

    public void setMountedHeight(Float mountedHeight) {
        this.mountedHeight = mountedHeight;
    }

    public Float getFramedWidth() {
        return framedWidth;
    }

    public void setFramedWidth(Float framedWidth) {
        this.framedWidth = framedWidth;
    }

    public Float getFramedHeight() {
        return framedHeight;
    }

    public void setFramedHeight(Float framedHeight) {
        this.framedHeight = framedHeight;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDynasty() {
        return dynasty;
    }

    public void setDynasty(String dynasty) {
        this.dynasty = dynasty;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public String getDateStrEn() {
        return dateStrEn;
    }

    public void setDateStrEn(String dateStrEn) {
        this.dateStrEn = dateStrEn;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getMaterialEn() {
        return materialEn;
    }

    public void setMaterialEn(String materialEn) {
        this.materialEn = materialEn;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocationEn() {
        return locationEn;
    }

    public void setLocationEn(String locationEn) {
        this.locationEn = locationEn;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String gethUrl() {
        return hUrl;
    }

    public void sethUrl(String hUrl) {
        this.hUrl = hUrl;
    }

    public String getFileurl() {
        return fileurl;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public String getsUrl() {
        return sUrl;
    }

    public void setsUrl(String sUrl) {
        this.sUrl = sUrl;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public Integer getCatParentId() {
        return catParentId;
    }

    public void setCatParentId(Integer catParentId) {
        this.catParentId = catParentId;
    }

    public Integer getAicatId() {
        return aicatId;
    }

    public void setAicatId(Integer aicatId) {
        this.aicatId = aicatId;
    }

    public Integer getCatInOrgId() {
        return catInOrgId;
    }

    public void setCatInOrgId(Integer catInOrgId) {
        this.catInOrgId = catInOrgId;
    }

    public String getCat1InOrg() {
        return cat1InOrg;
    }

    public void setCat1InOrg(String cat1InOrg) {
        this.cat1InOrg = cat1InOrg;
    }

    public String getCat2InOrg() {
        return cat2InOrg;
    }

    public void setCat2InOrg(String cat2InOrg) {
        this.cat2InOrg = cat2InOrg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStamps() {
        return stamps;
    }

    public void setStamps(String stamps) {
        this.stamps = stamps;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getIsCollect() {
        return isCollect;
    }

    public void setIsCollect(Integer isCollect) {
        this.isCollect = isCollect;
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public void setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
    }

    public Integer getAudioClickCount() {
        return audioClickCount;
    }

    public void setAudioClickCount(Integer audioClickCount) {
        this.audioClickCount = audioClickCount;
    }

    public Integer getAudioDuration() {
        return audioDuration;
    }

    public void setAudioDuration(Integer audioDuration) {
        this.audioDuration = audioDuration;
    }

    public String getAudioAuthor() {
        return audioAuthor;
    }

    public void setAudioAuthor(String audioAuthor) {
        this.audioAuthor = audioAuthor;
    }

    public String getAudioDesc() {
        return audioDesc;
    }

    public void setAudioDesc(String audioDesc) {
        this.audioDesc = audioDesc;
    }

    public String getAudioGuideCode() {
        return audioGuideCode;
    }

    public void setAudioGuideCode(String audioGuideCode) {
        this.audioGuideCode = audioGuideCode;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Integer getVideoClickCount() {
        return videoClickCount;
    }

    public void setVideoClickCount(Integer videoClickCount) {
        this.videoClickCount = videoClickCount;
    }

    public Integer getVideoDuration() {
        return videoDuration;
    }

    public void setVideoDuration(Integer videoDuration) {
        this.videoDuration = videoDuration;
    }

    public String getVideoAuthor() {
        return videoAuthor;
    }

    public void setVideoAuthor(String videoAuthor) {
        this.videoAuthor = videoAuthor;
    }

    public String getVideoDesc() {
        return videoDesc;
    }

    public void setVideoDesc(String videoDesc) {
        this.videoDesc = videoDesc;
    }

    public String getAuction() {
        return auction;
    }

    public void setAuction(String auction) {
        this.auction = auction;
    }

    public String getExhibit() {
        return exhibit;
    }

    public void setExhibit(String exhibit) {
        this.exhibit = exhibit;
    }

    public Integer getIsAuction() {
        return isAuction;
    }

    public void setIsAuction(Integer isAuction) {
        this.isAuction = isAuction;
    }

    public Integer getPublishState() {
        return publishState;
    }

    public void setPublishState(Integer publishState) {
        this.publishState = publishState;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getUnearthInfo() {
        return unearthInfo;
    }

    public void setUnearthInfo(String unearthInfo) {
        this.unearthInfo = unearthInfo;
    }

    public Integer getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(Integer securityLevel) {
        this.securityLevel = securityLevel;
    }

    public String getSecurityDescription() {
        return securityDescription;
    }

    public void setSecurityDescription(String securityDescription) {
        this.securityDescription = securityDescription;
    }

    public Integer getCulturalRelicLevel() {
        return culturalRelicLevel;
    }

    public void setCulturalRelicLevel(Integer culturalRelicLevel) {
        this.culturalRelicLevel = culturalRelicLevel;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getSimilarArtworkId() {
        return similarArtworkId;
    }

    public void setSimilarArtworkId(Integer similarArtworkId) {
        this.similarArtworkId = similarArtworkId;
    }

    public String getInscription() {
        return inscription;
    }

    public void setInscription(String inscription) {
        this.inscription = inscription;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public Integer getDataSource() {
        return dataSource;
    }

    public void setDataSource(Integer dataSource) {
        this.dataSource = dataSource;
    }

    public String getDataUniqueCode() {
        return dataUniqueCode;
    }

    public void setDataUniqueCode(String dataUniqueCode) {
        this.dataUniqueCode = dataUniqueCode;
    }

    public String getDetUrl() {
        return detUrl;
    }

    public void setDetUrl(String detUrl) {
        this.detUrl = detUrl;
    }

    public String getAllInfo() {
        return allInfo;
    }

    public void setAllInfo(String allInfo) {
        this.allInfo = allInfo;
    }

    public Integer getHasWater() {
        return hasWater;
    }

    public void setHasWater(Integer hasWater) {
        this.hasWater = hasWater;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public Date getEditorTime() {
        return editorTime;
    }

    public void setEditorTime(Date editorTime) {
        this.editorTime = editorTime;
    }

    public Integer getUucatId() {
        return uucatId;
    }

    public void setUucatId(Integer uucatId) {
        this.uucatId = uucatId;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getRealQuantity() {
        return realQuantity;
    }

    public void setRealQuantity(String realQuantity) {
        this.realQuantity = realQuantity;
    }

    public String getIntegrityDegree() {
        return integrityDegree;
    }

    public void setIntegrityDegree(String integrityDegree) {
        this.integrityDegree = integrityDegree;
    }

    public String getCollectTimeStr() {
        return collectTimeStr;
    }

    public void setCollectTimeStr(String collectTimeStr) {
        this.collectTimeStr = collectTimeStr;
    }

    public Integer getAuditState() {
        return auditState;
    }

    public void setAuditState(Integer auditState) {
        this.auditState = auditState;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTitleTag() {
        return titleTag;
    }

    public void setTitleTag(String titleTag) {
        this.titleTag = titleTag;
    }

    public String getWriting() {
        return writing;
    }

    public void setWriting(String writing) {
        this.writing = writing;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public Integer getClassifyType() {
        return classifyType;
    }

    public void setClassifyType(Integer classifyType) {
        this.classifyType = classifyType;
    }

    public Date getGmtPublish() {
        return gmtPublish;
    }

    public void setGmtPublish(Date gmtPublish) {
        this.gmtPublish = gmtPublish;
    }

    public Integer getBannerFlag() {
        return bannerFlag;
    }

    public void setBannerFlag(Integer bannerFlag) {
        this.bannerFlag = bannerFlag;
    }

    public Integer getImageSupplement() {
        return imageSupplement;
    }

    public void setImageSupplement(Integer imageSupplement) {
        this.imageSupplement = imageSupplement;
    }

    public Integer getClickCount() {
        return clickCount;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtworkDO artworkDO = (ArtworkDO) o;
        return Objects.equals(id, artworkDO.id) &&
                Objects.equals(sid, artworkDO.sid) &&
                Objects.equals(title, artworkDO.title) &&
                Objects.equals(titleEn, artworkDO.titleEn) &&
                Objects.equals(desc, artworkDO.desc) &&
                Objects.equals(artistUniqueId, artworkDO.artistUniqueId) &&
                Objects.equals(artistId, artworkDO.artistId) &&
                Objects.equals(artistName, artworkDO.artistName) &&
                Objects.equals(artistIntro, artworkDO.artistIntro) &&
                Objects.equals(length, artworkDO.length) &&
                Objects.equals(width, artworkDO.width) &&
                Objects.equals(pixelWidth, artworkDO.pixelWidth) &&
                Objects.equals(pixelHeight, artworkDO.pixelHeight) &&
                Objects.equals(mountedWidth, artworkDO.mountedWidth) &&
                Objects.equals(mountedHeight, artworkDO.mountedHeight) &&
                Objects.equals(framedWidth, artworkDO.framedWidth) &&
                Objects.equals(framedHeight, artworkDO.framedHeight) &&
                Objects.equals(size, artworkDO.size) &&
                Objects.equals(dynasty, artworkDO.dynasty) &&
                Objects.equals(date, artworkDO.date) &&
                Objects.equals(dateStr, artworkDO.dateStr) &&
                Objects.equals(dateStrEn, artworkDO.dateStrEn) &&
                Objects.equals(filename, artworkDO.filename) &&
                Objects.equals(material, artworkDO.material) &&
                Objects.equals(materialEn, artworkDO.materialEn) &&
                Objects.equals(location, artworkDO.location) &&
                Objects.equals(locationEn, artworkDO.locationEn) &&
                Objects.equals(shape, artworkDO.shape) &&
                Objects.equals(url, artworkDO.url) &&
                Objects.equals(hUrl, artworkDO.hUrl) &&
                Objects.equals(fileurl, artworkDO.fileurl) &&
                Objects.equals(mUrl, artworkDO.mUrl) &&
                Objects.equals(sUrl, artworkDO.sUrl) &&
                Objects.equals(catId, artworkDO.catId) &&
                Objects.equals(catParentId, artworkDO.catParentId) &&
                Objects.equals(aicatId, artworkDO.aicatId) &&
                Objects.equals(catInOrgId, artworkDO.catInOrgId) &&
                Objects.equals(cat1InOrg, artworkDO.cat1InOrg) &&
                Objects.equals(cat2InOrg, artworkDO.cat2InOrg) &&
                Objects.equals(status, artworkDO.status) &&
                Objects.equals(stamps, artworkDO.stamps) &&
                Objects.equals(remark, artworkDO.remark) &&
                Objects.equals(ownerId, artworkDO.ownerId) &&
                Objects.equals(orgId, artworkDO.orgId) &&
                Objects.equals(isCollect, artworkDO.isCollect) &&
                Objects.equals(audioUrl, artworkDO.audioUrl) &&
                Objects.equals(audioClickCount, artworkDO.audioClickCount) &&
                Objects.equals(audioDuration, artworkDO.audioDuration) &&
                Objects.equals(audioAuthor, artworkDO.audioAuthor) &&
                Objects.equals(audioDesc, artworkDO.audioDesc) &&
                Objects.equals(audioGuideCode, artworkDO.audioGuideCode) &&
                Objects.equals(videoUrl, artworkDO.videoUrl) &&
                Objects.equals(videoClickCount, artworkDO.videoClickCount) &&
                Objects.equals(videoDuration, artworkDO.videoDuration) &&
                Objects.equals(videoAuthor, artworkDO.videoAuthor) &&
                Objects.equals(videoDesc, artworkDO.videoDesc) &&
                Objects.equals(auction, artworkDO.auction) &&
                Objects.equals(exhibit, artworkDO.exhibit) &&
                Objects.equals(isAuction, artworkDO.isAuction) &&
                Objects.equals(publishState, artworkDO.publishState) &&
                Objects.equals(origin, artworkDO.origin) &&
                Objects.equals(unearthInfo, artworkDO.unearthInfo) &&
                Objects.equals(securityLevel, artworkDO.securityLevel) &&
                Objects.equals(securityDescription, artworkDO.securityDescription) &&
                Objects.equals(culturalRelicLevel, artworkDO.culturalRelicLevel) &&
                Objects.equals(gmtCreate, artworkDO.gmtCreate) &&
                Objects.equals(gmtModified, artworkDO.gmtModified) &&
                Objects.equals(similarArtworkId, artworkDO.similarArtworkId) &&
                Objects.equals(inscription, artworkDO.inscription) &&
                Objects.equals(label, artworkDO.label) &&
                Objects.equals(annotation, artworkDO.annotation) &&
                Objects.equals(dataSource, artworkDO.dataSource) &&
                Objects.equals(dataUniqueCode, artworkDO.dataUniqueCode) &&
                Objects.equals(detUrl, artworkDO.detUrl) &&
                Objects.equals(allInfo, artworkDO.allInfo) &&
                Objects.equals(hasWater, artworkDO.hasWater) &&
                Objects.equals(editor, artworkDO.editor) &&
                Objects.equals(editorTime, artworkDO.editorTime) &&
                Objects.equals(uucatId, artworkDO.uucatId) &&
                Objects.equals(weight, artworkDO.weight) &&
                Objects.equals(realQuantity, artworkDO.realQuantity) &&
                Objects.equals(integrityDegree, artworkDO.integrityDegree) &&
                Objects.equals(collectTimeStr, artworkDO.collectTimeStr) &&
                Objects.equals(auditState, artworkDO.auditState) &&
                Objects.equals(theme, artworkDO.theme) &&
                Objects.equals(skill, artworkDO.skill) &&
                Objects.equals(signature, artworkDO.signature) &&
                Objects.equals(titleTag, artworkDO.titleTag) &&
                Objects.equals(writing, artworkDO.writing) &&
                Objects.equals(quote, artworkDO.quote) &&
                Objects.equals(classifyType, artworkDO.classifyType) &&
                Objects.equals(gmtPublish, artworkDO.gmtPublish) &&
                Objects.equals(bannerFlag, artworkDO.bannerFlag) &&
                Objects.equals(imageSupplement, artworkDO.imageSupplement) &&
                Objects.equals(clickCount, artworkDO.clickCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sid, title, titleEn, desc, artistUniqueId, artistId, artistName, artistIntro, length, width, pixelWidth, pixelHeight, mountedWidth, mountedHeight, framedWidth, framedHeight, size, dynasty, date, dateStr, dateStrEn, filename, material, materialEn, location, locationEn, shape, url, hUrl, fileurl, mUrl, sUrl, catId, catParentId, aicatId, catInOrgId, cat1InOrg, cat2InOrg, status, stamps, remark, ownerId, orgId, isCollect, audioUrl, audioClickCount, audioDuration, audioAuthor, audioDesc, audioGuideCode, videoUrl, videoClickCount, videoDuration, videoAuthor, videoDesc, auction, exhibit, isAuction, publishState, origin, unearthInfo, securityLevel, securityDescription, culturalRelicLevel, gmtCreate, gmtModified, similarArtworkId, inscription, label, annotation, dataSource, dataUniqueCode, detUrl, allInfo, hasWater, editor, editorTime, uucatId, weight, realQuantity, integrityDegree, collectTimeStr, auditState, theme, skill, signature, titleTag, writing, quote, classifyType, gmtPublish, bannerFlag, imageSupplement, clickCount);
    }

    @Override
    public String toString() {
        return "ArtworkDO{" +
                "id=" + id +
                ", sid='" + sid + '\'' +
                ", title='" + title + '\'' +
                ", titleEn='" + titleEn + '\'' +
                ", desc='" + desc + '\'' +
                ", artistUniqueId=" + artistUniqueId +
                ", artistId=" + artistId +
                ", artistName='" + artistName + '\'' +
                ", artistIntro='" + artistIntro + '\'' +
                ", length=" + length +
                ", width=" + width +
                ", pixelWidth=" + pixelWidth +
                ", pixelHeight=" + pixelHeight +
                ", mountedWidth=" + mountedWidth +
                ", mountedHeight=" + mountedHeight +
                ", framedWidth=" + framedWidth +
                ", framedHeight=" + framedHeight +
                ", size='" + size + '\'' +
                ", dynasty='" + dynasty + '\'' +
                ", date=" + date +
                ", dateStr='" + dateStr + '\'' +
                ", dateStrEn='" + dateStrEn + '\'' +
                ", filename='" + filename + '\'' +
                ", material='" + material + '\'' +
                ", materialEn='" + materialEn + '\'' +
                ", location='" + location + '\'' +
                ", locationEn='" + locationEn + '\'' +
                ", shape='" + shape + '\'' +
                ", url='" + url + '\'' +
                ", hUrl='" + hUrl + '\'' +
                ", fileurl='" + fileurl + '\'' +
                ", mUrl='" + mUrl + '\'' +
                ", sUrl='" + sUrl + '\'' +
                ", catId=" + catId +
                ", catParentId=" + catParentId +
                ", aicatId=" + aicatId +
                ", catInOrgId=" + catInOrgId +
                ", cat1InOrg='" + cat1InOrg + '\'' +
                ", cat2InOrg='" + cat2InOrg + '\'' +
                ", status=" + status +
                ", stamps='" + stamps + '\'' +
                ", remark='" + remark + '\'' +
                ", ownerId=" + ownerId +
                ", orgId=" + orgId +
                ", isCollect=" + isCollect +
                ", audioUrl='" + audioUrl + '\'' +
                ", audioClickCount=" + audioClickCount +
                ", audioDuration=" + audioDuration +
                ", audioAuthor='" + audioAuthor + '\'' +
                ", audioDesc='" + audioDesc + '\'' +
                ", audioGuideCode='" + audioGuideCode + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", videoClickCount=" + videoClickCount +
                ", videoDuration=" + videoDuration +
                ", videoAuthor='" + videoAuthor + '\'' +
                ", videoDesc='" + videoDesc + '\'' +
                ", auction='" + auction + '\'' +
                ", exhibit='" + exhibit + '\'' +
                ", isAuction=" + isAuction +
                ", publishState=" + publishState +
                ", origin='" + origin + '\'' +
                ", unearthInfo='" + unearthInfo + '\'' +
                ", securityLevel=" + securityLevel +
                ", securityDescription='" + securityDescription + '\'' +
                ", culturalRelicLevel=" + culturalRelicLevel +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", similarArtworkId=" + similarArtworkId +
                ", inscription='" + inscription + '\'' +
                ", label='" + label + '\'' +
                ", annotation='" + annotation + '\'' +
                ", dataSource=" + dataSource +
                ", dataUniqueCode='" + dataUniqueCode + '\'' +
                ", detUrl='" + detUrl + '\'' +
                ", allInfo='" + allInfo + '\'' +
                ", hasWater=" + hasWater +
                ", editor='" + editor + '\'' +
                ", editorTime=" + editorTime +
                ", uucatId=" + uucatId +
                ", weight='" + weight + '\'' +
                ", realQuantity='" + realQuantity + '\'' +
                ", integrityDegree='" + integrityDegree + '\'' +
                ", collectTimeStr='" + collectTimeStr + '\'' +
                ", auditState=" + auditState +
                ", theme='" + theme + '\'' +
                ", skill='" + skill + '\'' +
                ", signature='" + signature + '\'' +
                ", titleTag='" + titleTag + '\'' +
                ", writing='" + writing + '\'' +
                ", quote='" + quote + '\'' +
                ", classifyType=" + classifyType +
                ", gmtPublish=" + gmtPublish +
                ", bannerFlag=" + bannerFlag +
                ", imageSupplement=" + imageSupplement +
                ", clickCount=" + clickCount +
                '}';
    }
}
