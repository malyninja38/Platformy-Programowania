package PPpac;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "DATA_REPOSITORY", schema = "dbo", catalog = "PP")
public class DataRepositoryEntity {
    private String documentName;
    private String url;

    @Id
    private int id;

    @Basic
    @Column(name = "DOCUMENT_NAME")
    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    @Basic
    @Column(name = "URL")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataRepositoryEntity that = (DataRepositoryEntity) o;
        return Objects.equals(documentName, that.documentName) &&
                Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documentName, url);
    }
}
