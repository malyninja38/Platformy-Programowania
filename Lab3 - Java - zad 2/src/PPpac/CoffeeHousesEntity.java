package PPpac;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "COFFEE_HOUSES", schema = "dbo", catalog = "PP")
public class CoffeeHousesEntity {
    private int storeId;
    private String city;
    private int coffee;
    private int merch;
    private int total;

    @Id
    @Column(name = "STORE_ID")
    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    @Basic
    @Column(name = "CITY")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "COFFEE")
    public int getCoffee() {
        return coffee;
    }

    public void setCoffee(int coffee) {
        this.coffee = coffee;
    }

    @Basic
    @Column(name = "MERCH")
    public int getMerch() {
        return merch;
    }

    public void setMerch(int merch) {
        this.merch = merch;
    }

    @Basic
    @Column(name = "TOTAL")
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoffeeHousesEntity that = (CoffeeHousesEntity) o;
        return storeId == that.storeId &&
                coffee == that.coffee &&
                merch == that.merch &&
                total == that.total &&
                Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeId, city, coffee, merch, total);
    }
}
