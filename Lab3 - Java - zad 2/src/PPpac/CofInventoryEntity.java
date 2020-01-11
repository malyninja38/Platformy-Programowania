package PPpac;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "COF_INVENTORY", schema = "dbo", catalog = "PP")
public class CofInventoryEntity {
    private int warehouseId;
    private int quan;
    private Timestamp dateVal;

    @Id
    private int id;

    @Basic
    @Column(name = "WAREHOUSE_ID")
    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
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
        CofInventoryEntity that = (CofInventoryEntity) o;
        return warehouseId == that.warehouseId &&
                quan == that.quan &&
                Objects.equals(dateVal, that.dateVal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(warehouseId, quan, dateVal);
    }
}
