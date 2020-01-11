package PPpac;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "MERCH_INVENTORY", schema = "dbo", catalog = "PP")
public class MerchInventoryEntity {
    private int itemId;
    private String itemName;
    private int quan;
    private Timestamp dateVal;

    @Id
    @Column(name = "ITEM_ID")
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "ITEM_NAME")
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Basic
    @Column(name = "QUAN")
    public int getQuan() {
        return quan;
    }

    public void setQuan(int quan) {
        this.quan = quan;
    }

    @Basic
    @Column(name = "DATE_VAL")
    public Timestamp getDateVal() {
        return dateVal;
    }

    public void setDateVal(Timestamp dateVal) {
        this.dateVal = dateVal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MerchInventoryEntity that = (MerchInventoryEntity) o;
        return itemId == that.itemId &&
                quan == that.quan &&
                Objects.equals(itemName, that.itemName) &&
                Objects.equals(dateVal, that.dateVal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, itemName, quan, dateVal);
    }
}
