package PPpac;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "COFFEE_DESCRIPTIONS", schema = "dbo", catalog = "PP")
public class CoffeeDescriptionsEntity {
    private String cofName;
    private String cofDesc;

    @Id
    @Column(name = "COF_NAME")
    public String getCofName() {
        return cofName;
    }

    public void setCofName(String cofName) {
        this.cofName = cofName;
    }

    @Basic
    @Column(name = "COF_DESC")
    public String getCofDesc() {
        return cofDesc;
    }

    public void setCofDesc(String cofDesc) {
        this.cofDesc = cofDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoffeeDescriptionsEntity that = (CoffeeDescriptionsEntity) o;
        return Objects.equals(cofName, that.cofName) &&
                Objects.equals(cofDesc, that.cofDesc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cofName, cofDesc);
    }
}
