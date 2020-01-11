package PPpac;

import javax.persistence.*;
import java.security.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "RSS_FEEDS", schema = "dbo", catalog = "PP")
public class RssFeedsEntity {
    private String rssName;
    private Timestamp rssFeedXml;

    @Id
    @Column(name = "RSS_NAME")
    public String getRssName() {
        return rssName;
    }

    public void setRssName(String rssName) {
        this.rssName = rssName;
    }

    @Basic
    @Column(name = "RSS_FEED_XML")
    public Timestamp getRssFeedXml() {
        return rssFeedXml;
    }

    public void setRssFeedXml(Timestamp rssFeedXml) {
        this.rssFeedXml = rssFeedXml;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RssFeedsEntity that = (RssFeedsEntity) o;
        return Objects.equals(rssName, that.rssName) &&
                Objects.equals(rssFeedXml, that.rssFeedXml);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rssName, rssFeedXml);
    }
}
