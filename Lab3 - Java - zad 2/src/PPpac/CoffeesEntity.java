package PPpac;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "COFFEES", schema = "dbo", catalog = "PP")
public class CoffeesEntity {
    private String cofName;
    private BigDecimal price;
    private int sales;
    private int total;
    private SuppliersEntity suppId;

    @Id
    @Column(name = "COF_NAME")
    public String getCofName() {
        return cofName;
    }

    public void setCofName(String cofName) {
        this.cofName = cofName;
    }

    @OneToOne                                                   // relacja jeden do jeden
    @JoinColumn(name = "SUP_ID")                                // ręcznie, bo nie dodało klucza obcego
    public SuppliersEntity getSuppId(){
        return suppId;
    }

    public void setSuppId(SuppliersEntity suppId) {
        this.suppId = suppId;
    }

    @Basic
    @Column(name = "PRICE")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "SALES")
    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
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
        CoffeesEntity that = (CoffeesEntity) o;
        return sales == that.sales &&
                total == that.total &&
                Objects.equals(cofName, that.cofName) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cofName, price, sales, total);
    }
}
